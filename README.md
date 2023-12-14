# Deploy Spring Boot application with MySql database in Kubernetes cluster (minikube) 

## [Click here to watch the video for demonstration.](https://youtu.be/yet0-x8Ab6c)

In this project, I have demonstrated how to deploy and run Springboot application with Mysql database in Kubernetes cluster. Here I have created REST API's to add and retrieve ExchangeRate in the MySql database.

### Prerequisites:
 - [Docker](https://docs.docker.com/engine/install/) or [Docker alternative - Colima](https://github.com/abiosoft/colima)
 - [Minikube](https://minikube.sigs.k8s.io/docs/start/)
 - [Helm](https://helm.sh/docs/intro/install/)
 - [kubectl](https://kubernetes.io/docs/tasks/tools/)
 - IDE and JDK
 - MySql Client: [DBeaver](https://dbeaver.io/download/)

## Perform the following steps to deploy spring boot app on Minikube :

1. Clone this repository
2. From the terminal cd into your project directory and build project using ``` ./gradlew clean build ``` or ``` ./gradlew clean assemble ```
3. Start docker on the system
4. Start minikube using ``` minikube start --driver=docker ```
5. Enable docker env using command :  ``` eval $(minikube docker-env)  ```  [Command Reference](https://minikube.sigs.k8s.io/docs/commands/docker-env/)
6. Build docker image in minikube : ``` docker build -t spring-mysql-demo:latest . ```
7. To see the created image run command : ``` minikube image ls ```
8. To deploy on kubernetes cluster run command : ``` helm install mychart ytchart ```
9. To see deployed helm chart : ``` helm ls ```
10. Check deployments : ``` kubectl get all ```
11. To connect the database run ``` kubectl get services ``` and copy my-sql service name. Then run command like this : ``` minikube service mychart-mysql-service --url ```
12. Then connect the database using the IP address and port returned by Step 10.  (If you get error while connecting database, then watch the video for more information)
13. To call Rest api's, open a new Terminal, and run command : ``` minikube tunnel ``` and call api from the Postman or any of your favourite tool.
14. Remove or delete deployed setup from kubernetes cluster : ``` helm uninstall mychart ```
15. Stop minikube using : ``` minikube stop ```

### Sample JSON Request for the API :
```
{
  "sourceCurrency" : "USD",
  "targetCurrency" : "AUD",
  "amount": 1.50,
  "lastUpdated" : "2023-11-29"
}

```

### Following is list of api created in this project:

#### To add ExchangeRate in database :
```
curl -X POST http://localhost:8080/addExchangeRate \
-d '{ "sourceCurrency" : "USD", "targetCurrency" : "AUD", "amount": 1.52, "lastUpdated" : "2023-11-22" }' \
-H 'Content-Type: application/json'
```

#### To get exchange rate based on SourceCurrency and TargetCurrency :
```
curl -X GET 'http://localhost:8080/getAmount?sourceCurrency=USD&targetCurrency=AUD'
```

### Note : On the actual production environment, do not commit file with credentials like we have mentioned in .env, application.properties and secrets.yaml file.
