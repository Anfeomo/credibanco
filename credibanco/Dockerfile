FROM openjdk:17-jdk-alpine3.14
ARG JAR_FILE=target/credibanco-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} credibanco.jar
ENTRYPOINT ["java","-jar","/credibanco.jar"]