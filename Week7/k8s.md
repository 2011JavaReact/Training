# Kubernetes
```
Kubernetes is an open source container orchestration engine for automating deployment, scaling, and management of containerized applications. The open source project is hosted by the Cloud Native Computing Foundation (CNCF).

- K8s Docs
```
- [Kubernetes Documentation](https://kubernetes.io/docs/home/)

For this example we will simply take the Docker container that we have already have pushed to DockerHub and we will deploy it to a kubernetes cluster.

Key terms:
- **Cluster**: a collection of worker machines called **nodes** that run containerized application.
- **Node**: a worker machine in kubernetes (either virtual or physical)
- **Pod**: The basic building block of Kubernetes. A pod consists of a set of running containers
- **Control Plane**: container orchestration layer that exposes API and manages workers

Note that Kubernetes is much more complicated than this and will take a lot of work to fully understand.

## Quick Demo
### Set up cluster

There are many options that you can use to set up a Kubernetes cluster. Which one you would choose might depend of the type of OS you have or the cloud provider that you are used to using. Here are some options that you have (non-exhaustive list):

- [Documentation Recommendations](https://kubernetes.io/docs/setup/#learning-environment)
- [Google Kubernetes Engine(GKE)](https://cloud.google.com/kubernetes-engine/docs/quickstart)
- [AWS Elastic Kubernetes Service (EKS)](https://docs.aws.amazon.com/eks/latest/userguide/getting-started.html)
- [Minikube](https://v1-18.docs.kubernetes.io/docs/tasks/tools/install-minikube/)
- [Play with Kubernetes](https://labs.play-with-k8s.com/)

Once you have access to a cluster, go to the next section.

### Deploy your container

Once you have your cluster set up, enter the following command in the cluster to make sure that you have Kubernetes installed properly:

>kubectl version

If it works go ahead and deploy your application. In general, it is best to do this declaratively with yaml files rather than imperatively with commands that directly set up the cluster. This is going be a big oversimplification, but here is an example of a configuration file that you can use to set up your application:

`deployment.yaml`

```yml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: simple-web
  labels:
    customer: revature
spec:
  selector:
    matchLabels:
      app: web
  replicas: 3
  strategy:
    type: RollingUpdate
  template:
    metadata:
      labels:
        app: web
    spec:
      containers:
      - image: dockerhub-repo/name-of-image #change this
        name: name-of-container #change this
        ports:
        - containerPort: port-number #change this
---
apiVersion: v1
kind: Service
metadata:
  name: web-nodeport
  labels:
    app: web
spec:
  type: NodePort
  ports:
    - port: port-number #change this
      nodePort: 31000
  selector:
    app: web
```

The yaml file above specifies information about the container that will be running inside of a Kubernetes pod. In the second section it specifies a service (an abstraction of pods) that we use to map which port in the node is connected to which port in the container.

Now all we have to do is apply the configuration:
> kubectl apply -f deployment.yaml

Kubernetes will now pull the container from DockerHub, throw it in a pod, and deploy it in the appropriate node(s).

You can check on the deployment and the serve that were created using the following commands:

>kubectl get deployments

>kubectl get svc

Now you can try using your browser to go to `ip-address:31000` to view the deployed application
### More Kubernetes stuff
Notice that you can view the running instances of your containers using:
>docker ps

try killing one of these instances using:
> docker stop container-name

check your instances again and you should see that one of them is down. Check again in a short while and you should see that kubernetes has spun one up again to adhere to the number of replicas that you specified in the yaml file.

### Deploy to Cloud platform
IF you want to use kubernetes in the cloud, you will need to apply a load balancer:
`lb.yaml`
```yaml
apiVersion: v1
kind: Service
metadata:
  name: web-svc
  labels:
    app: web
spec:
  type: LoadBalancer
  ports:
  - port: 80
    targetPort: 8080 # change this
  selector:
    app: web
```

run it:
> kubectl apply -f lb.yaml

When the service is ready, you should be able to access your app