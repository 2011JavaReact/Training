# Overview

This project was built using servlets and is meant to be run on a `Tomcat 8.5` server. The instructions below will guide you on how to deploy this project to an AWS EC2 that you have already provisioned.

The application accepts `GET` and `POST` requests to `http://{ip-address}/PirateServer/HelloServlet`

# Package Servlet App locally

Navigate to the root project folder of your servlet app and use the following command to package it as a war:

> mvn clean package

You should then copy your **local** war file to your **remote** server:

> scp -i {pem-file} {war-file} ec2-user@{ip-address}:~

# EC2 setup

The following instructions are for setting up the EC2 environment and is used to setup:
Java, Tomcat, Git, Maven and Jenkins on the **remote ec2 server**.

## Log in to EC2

- ssh -i {pem-file} ec2-user@{ip-address}

## Install Java

1. Update EC2

> sudo yum -y update

2. Uninstall Java if it is installed

> sudo yum remove -y java

3. Install Java

> sudo yum install -y java-1.8.0-openjdk-devel

4. Check the version of Java to make sure it installed properly

> java -version

5. Check to see if JAVA_HOME environment variable was configured

> echo \$JAVA_HOME

## Install Tomcat

In the home directory, enter the following:

1. Download Tomcat

> wget {link-to-tomcat-download}

2. Decompress the files

> tar -zxvf {tomcat-tar-file}

### Make Environment Variable called CATALINA_HOME

3. Navigate to profile.d driectory

> cd /etc/profile.d

4. Create an environment variable called CATALINA_HOME

> sudo vim catalinahome.sh

> export CATALINA_HOME=path-to-tomcat-folder

5. optional: configure Tomcat users in (tomcat-users.xml)

6. optional: copy war of servlet app to `webapps` folder in tomcat directory and navigate to

   `{ip-address}:{port-number}/{name-of-war}/{path}`

## Install Git

1. sudo yum -y install git
2. whereis git

## Install Maven

> sudo wget http://repos.fedorapeople.org/repos/dchen/apache-maven/epel-apache-maven.repo -O /etc/yum.repos.d/epel-apache-maven.repo

> sudo sed -i s/\\\$releasever/6/g /etc/yum.repos.d/epel-apache-maven.repo

> sudo yum install -y apache-maven

> mvn --version

# Jenkins

1. Download Jenkins war

> wget https://updates.jenkins-ci.org/stable/latest/jenkins.war

2. move `jenkins.war` to `webapps` folder in tomcat folder

> mv ~/jenkins.war /home/ec2-user/apache-tomcat-8.5.58/webapps

3. Start tomcat server

> sh {path-to-tomcat-folder}/bin/startup.sh

4. navigate to {ec2-public-ip-address}:{tomcat-port-number}/jenkins in a browser

5. Setup user account

6. Install Plugins

7. Create a new Pipeline

8. Connect to GitHub Repo

9. Create Jenkinsfile:

```groovy
pipeline {
    agent any

    stages {
        stage('clean') {
            steps {
                sh 'mvn clean'
            }
        }
        stage('package') {
            steps {
                sh 'mvn package'
            }
        }
        stage('deploy'){
        	steps{
        		sh 'cp /home/ec2-user/.jenkins/workspace/{name-of-pipeline}/target/{name-of-war}.war /home/ec2-user/apache-tomcat-8.5.51/webapps'
        	}
        }
    }
}

```

10. Click on build project button

# Add webhook to GitHub

webhook syntax:

`http://{ip-address}:{port-humber}/jenkins/github-webhook/`