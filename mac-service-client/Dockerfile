FROM openjdk:8

WORKDIR /app

ADD target/mac-service-client-1.0-SNAPSHOT.jar /app/mac-service-client.jar

CMD ["java", "-jar", "-Deureka.client.serviceUrl.defaultZone=${eurekaServiceUrl}", "mac-service-client.jar"]