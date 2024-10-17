#Build
FROM gradle:jdk21-alpine AS builder
LABEL authors="Seweryn"
WORKDIR /builder
COPY --chown=gradle:gradle . /builder
RUN ./gradlew clean build --no-daemon -x test

#Runtime stage
FROM amazoncorretto:21 AS final
WORKDIR /app
ARG PROFILE=ACTIVE
ARG APP_VERSION=1.0.0
ENV JAR_VERSION=${APP_VERSION}
ENV ACRIVE_PROFILE=${PROFILE}
EXPOSE 8888
COPY --from=builder builder/build/libs/config-server-*.jar /app/
CMD java -jar config-server-${JAR_VERSION}.jar
#UN java -jar -Dspring.profiles.active=${ACRIVE_PROFILE} config-server/build/libs/config-server-${JAR_VERSION}.jar
#RUN java -jar config-server/build/libs/config-server-1.0.0.jar
#RUN java -jar discovery/build/libs/discovery-${JAR_VERSION}.jar
#RUN java -jar -Dspring.datasource.url=${DB_URL} pubs-data-service/build/libs/pubs-data-service-${JAR_VERSION}.jar
#RUN java -jar pubs-routes-service/build/libs/cpubs-routes-service-${JAR_VERSION}.jar