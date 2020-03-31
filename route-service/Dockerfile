FROM adoptopenjdk/openjdk11:ubi
VOLUME /tmp
ARG JAR_FILE=target/route-service-1.0.jar
ADD ${JAR_FILE} route-service.jar
ENTRYPOINT ["java","-jar", "-Dspring.profiles.active=docker", "/route-service.jar"]