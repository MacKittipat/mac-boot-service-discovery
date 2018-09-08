FROM openjdk:8

WORKDIR /app

ADD target/mac-service-registry-1.0-SNAPSHOT.jar /app/mac-service-registry.jar

EXPOSE 8761

CMD ["java", "-jar", "-Deureka.client.serviceUrl.defaultZone=${eurekaServiceUrl}", "mac-service-registry.jar"]