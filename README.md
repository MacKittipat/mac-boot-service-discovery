# mac-service-discovery

## Create network

```
docker network create mac-net
```

## Run mac-service-registry

```
mvn clean install 
docker build -t mac-service-registry .
docker run -d -p 8761:8761 -e eurekaServiceUrl=http://service-registry:8761/eureka/,http://service-registry2:8761/eureka/ --network mac-net --name service-registry mac-service-registry
docker run -d -p 8762:8761 -e eurekaServiceUrl=http://service-registry:8761/eureka/,http://service-registry2:8761/eureka/ --network mac-net --name service-registry2 mac-service-registry
```

## Run mac-address-service

```
mvn clean install 
docker build -t mac-address-service .
docker run -d -p 8001:8001 -e eurekaServiceUrl=http://service-registry:8761/eureka/,http://service-registry2:8761/eureka/ --network mac-net --name address-service mac-address-service 
docker run -d -p 8002:8001 -e eurekaServiceUrl=http://service-registry:8761/eureka/,http://service-registry2:8761/eureka/ --network mac-net --name address-service2 mac-address-service
```

## Run mac-user-service

```
mvn clean install 
docker build -t mac-user-service .
docker run -d -p 9001:9001 -e eurekaServiceUrl=http://service-registry:8761/eureka/,http://service-registry2:8761/eureka/ --network mac-net --name user-service mac-user-service 
docker run -d -p 9002:9001 -e eurekaServiceUrl=http://service-registry:8761/eureka/,http://service-registry2:8761/eureka/ --network mac-net --name user-service2 mac-user-service
```

## Run mac-service-client

```
mvn clean install 
docker build -t mac-service-client .
docker run -d -e eurekaServiceUrl=http://service-registry:8761/eureka/,http://service-registry2:8761/eureka/ --network mac-net mac-service-client
```
