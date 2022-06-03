FROM openjdk:17-alpine

ADD ./target/*.jar /app/

WORKDIR /app

ENTRYPOINT java -jar ./*.jar