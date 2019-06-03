FROM maven:3.6.0-jdk-8-alpine AS build_co
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package -DskipTests

FROM java:8-jdk
RUN mkdir /app
WORKDIR /app
COPY --from=build_co /usr/src/app/target/agenda-config-server-0.0.1-SNAPSHOT.jar /app/agenda-config.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/agenda-config.jar"]
EXPOSE 9090
