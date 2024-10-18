#Build
FROM gradle:jdk21-alpine AS builder
LABEL authors="Seweryn"
WORKDIR /builder
RUN chmod +x ./gradlew
COPY --chown=gradle:gradle . /builder
RUN ./gradlew clean build --no-daemon  -x test

#Runtime stage
FROM amazoncorretto:21 AS final
WORKDIR /app
ARG PROFILE=ACTIVE
ARG APP_VERSION=1.0.0
ENV JAR_VERSION=${APP_VERSION}
ENV ACRIVE_PROFILE=${PROFILE}
EXPOSE 8444
COPY --from=builder builder/build/libs/pubs-routes-service-*.jar /app/
CMD java -jar pubs-routes-service-${JAR_VERSION}.jar