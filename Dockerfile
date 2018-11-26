FROM openjdk:8u151-jre-alpine

WORKDIR /etc

COPY target/*-exec.jar api.jar
EXPOSE 8080
ENTRYPOINT exec java $JAVA_OPTS -jar api.jar
