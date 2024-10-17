#Build
FROM gradle:jdk21-alpine AS builder
LABEL authors="Seweryn"
WORKDIR /builder
COPY --chown=gradle:gradle . /builder
RUN ./gradlew clean build --no-daemon  -x test

#Runtime stage
FROM amazoncorretto:21 AS final
WORKDIR /app
ARG PROFILE=ACTIVE
ARG APP_VERSION=1.0.0
ENV JAR_VERSION=${APP_VERSION}
ENV ACRIVE_PROFILE=${PROFILE}
COPY --from=builder builder/build/libs/discovery-*.jar /app/
EXPOSE 8761
CMD java -jar discovery-${JAR_VERSION}.jar