# Simple Docker Demo

## Build Jar out of Spring Boot App and get it inside your EC2

- In source folder of spring boot application, build a jar using maven:

  > mvn clean package

- `clean` tells maven to clear out the contents of the `target` directory
- `package` will build as a jar and deposit it inside of the `target` directory
- from within the target folder, make sure that you can run your jar:
  > java -jar name-of-jar.jar
- spin up an ec2 (preferably with a Linux image)
- configure security groups to allow access to desired port
- place jar in same folder as pem key and copy it into ec2 using scp:
  > scp -i name-of-key.pem name-of-jar.jar ec2-user@ip-address:~
- ssh into ec2:
  > ssh -i name-of-key.pem ec2-user@ip-address

## Setup EC2

- update ec2
  > sudo yum update -y
- install java so that we can see that our spring boot app works. This is just to prove a point; later we will uninstall java
  > sudo yum install -y java-1.8.0-openjdk-devel
- run spring boot app just to make sure it works
  > java -jar name-of-jar.jar
- uninstall java. We don't need it anymore since we will be running our app in a container
  > sudo yum remove -y java*
- install docker:
  > sudo yum install docker -y
- start docker:
	> sudo service docker start
- add ec2-user to docker group (so that you don't have to prefix every docker command with sudo)
  > sudo usermod -a -G docker ec2-user
- log out and then back in to your ec2
- check to see if docker is installed properly and the docker daemon is running (if you don't get an error it means that it is working):
  > docker info

## Docker Workflow
- create Dockerfile:
```
	FROM java:8
	ADD <name-of-jar-file> <name-of-jar-file>
	EXPOSE 8080
	ENTRYPOINT ["java","-jar","<name-of-jar-file>"]
```
- build image with Dockerfile:
	> docker build -t name-of-new-image .
  - the -t flag specifies a tag
  - the . specifies the location of the Dockerfile (Don't forget the `.` at the end of the command)
- check the images that you now have:
  > docker images
- run the image to create a container (change 8080:8080 to whichever desired port numbers):
  >	docker run -t -i -p 8080:8080 name-of-image
    - `-t` will stands for tty, it refers to the pseudo-terminal or "teletypewriter"
    - `-i` allows for STDIN
    - `-p` publishes a containers port to the host (the first port is the host port, the second port is the docker container port)
- try hitting the endpoint with postman or your browser to make sure that it works

## DockerHub
- login to account
  > docker login
- push image to DockerHub:
  > docker push user-name/repo-name:tag-name
- docker pull
  > docker pull user-name/repo-name:tag-name

## Extra docker commands:
- list images
  > docker images
- remove an image
  > docker rmi name-of-image:tag-name
- list containers
  > docker ps
- stop container
  > docker stop name-of-container
- start a container
  > docker start name-of-container
- remove container
  > docker rm name-of-container