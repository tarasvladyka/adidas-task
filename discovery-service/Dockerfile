FROM adoptopenjdk/openjdk11:ubi
VOLUME /tmp
ARG JAR_FILE=target/discovery-service-1.0.jar
ADD ${JAR_FILE} discovery-service.jar
ENTRYPOINT ["java","-jar", "-Dspring.profiles.active=docker", "/discovery-service.jar"]