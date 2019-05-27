FROM openjdk:8-jdk-alpine

COPY config.json /config.json
COPY build/take-backend.jar /app/take-backend.jar

RUN echo "ipv6" >> /etc/modules
RUN apk --update add --no-cache bash vim

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/take-backend.jar"]