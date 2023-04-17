FROM gradle:7.1.1-jdk11 AS build
COPY --chown=gradle:gradle . /home/gradle/src/
WORKDIR /home/gradle/src
RUN gradle :build --no-daemon

FROM openjdk:11
COPY --from=build /home/gradle/src/build/libs/ingestion-service-0.1.0.jar spm-ingestion-service.jar

CMD ["java","-jar","spm-ingestion-service.jar"]
