# mac-service-discovery

## mac-service-registry

```
mvn clean install 
docker build -t mac-service-registry .
docker run -d -p 8761:8761 mac-service-registry
```
