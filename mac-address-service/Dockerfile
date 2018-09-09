FROM openjdk:8

WORKDIR /app

ADD target/mac-address-service-1.0-SNAPSHOT.jar /app/mac-address-service.jar

CMD ["java", "-jar", "-Deureka.client.serviceUrl.defaultZone=${eurekaServiceUrl}", "mac-address-service.jar"]