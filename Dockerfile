FROM java:8-jdk-alpine
COPY ./target/medium-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
LABEL maintainer="ade.enhaa@gmail.com"
ENTRYPOINT ["java","-jar","medium-0.0.1-SNAPSHOT.jar"]