FROM maven:3.6.0-jdk-8-alpine AS build_gt
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package -DskipTests

FROM java:8-jdk
RUN mkdir /app
WORKDIR /app
COPY --from=build_gt /usr/src/app/target/agenda-gateway-server-0.0.1-SNAPSHOT.jar /app/agenda-gateway.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/agenda-gateway.jar"]
EXPOSE 9094