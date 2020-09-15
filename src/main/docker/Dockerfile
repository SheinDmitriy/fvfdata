FROM openjdk:8-jdk-alpine

EXPOSE 8090

ENV TZ Asia/Yekaterinburg

ARG JAR_FILE=//d/java/fvf/target/*.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]

