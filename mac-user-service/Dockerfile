FROM openjdk:8

WORKDIR /app

ADD target/mac-user-service-1.0-SNAPSHOT.jar /app/mac-user-service.jar

CMD ["java", "-jar", "-Dserver.port=${serverPort}", "-Deureka.client.serviceUrl.defaultZone=${eurekaServiceUrl}", "mac-user-service.jar"]