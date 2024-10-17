#Build
FROM gradle:jdk21-alpine AS builder
LABEL authors="Seweryn"
WORKDIR /builder
COPY --chown=gradle:gradle . /builder
RUN ./gradlew clean build --no-daemon --debug -x test

#Runtime stage
FROM amazoncorretto:21 AS final
WORKDIR /app
ARG PROFILE=dev
ARG APP_VERSION=1.0.0
ENV JAR_VERSION=${APP_VERSION}
ENV DB_URL=jdbc:mysql://db-pubs-container:5432/pubber_pubs
ENV ACRIVE_PROFILE=${PROFILE}
EXPOSE 8543
COPY --from=builder builder/build/libs/pubs-data-service-*.jar /app/
CMD java -jar  -Dspring.profiles.active=${ACRIVE_PROFILE}  pubs-data-service-${JAR_VERSION}.jar
