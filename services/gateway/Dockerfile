#Build
FROM gradle:jdk21-alpine AS builder
LABEL authors="Seweryn"
WORKDIR /builder
COPY --chown=gradle:gradle . /builder
RUN chmod +x ./gradlew
RUN ./gradlew clean build  -x test

#Runtime stage
FROM amazoncorretto:21 AS final
WORKDIR /app
ARG PROFILE=ACTIVE
ARG APP_VERSION=1.0.0
ENV JAR_VERSION=${APP_VERSION}
ENV ACRIVE_PROFILE=${PROFILE}
COPY --from=builder builder/build/libs/gateway-*.jar /app/
EXPOSE 8322
CMD java -jar gateway-${JAR_VERSION}.jar