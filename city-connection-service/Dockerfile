FROM java:8
VOLUME /tmp
ARG JAR_FILE=target/city-connection-service-1.0.jar
ADD ${JAR_FILE} city-connection-service.jar
ENTRYPOINT ["java","-jar", "-Dspring.profiles.active=docker", "/city-connection-service.jar"]