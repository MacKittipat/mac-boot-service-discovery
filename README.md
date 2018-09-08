# mac-service-discovery

## Create network

```
 docker network create mac-net
```

## Run mac-service-registry

```
mvn clean install 
docker build -t mac-service-registry .
docker run -d -p 8761:8761 --network mac-net --name service-registry mac-service-registry
```

## Run mac-user-service

```
mvn clean install 
docker build -t mac-user-service .
docker run -d -p 9001:9001 -e serverPort=9001 -e eurekaServiceUrl=http://service-registry:8761/eureka/ --network mac-net --name user-service mac-user-service 
docker run -d -p 9002:9001 -e serverPort=9001 -e eurekaServiceUrl=http://service-registry:8761/eureka/ --network mac-net --name user-service2 mac-user-service
```

## Run mac-service-client

```
mvn clean install 
docker build -t mac-service-client .
docker run -d -e eurekaServiceUrl=http://service-registry:8761/eureka/ --network mac-net mac-service-client
```
