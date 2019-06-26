FROM maven:3.6.0-jdk-8-alpine AS build_co
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package -DskipTests

FROM java:8-jdk
RUN mkdir /app
WORKDIR /app
COPY --from=build_co /usr/src/app/target/config-server.jar /app/config-server.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/config-server.jar"]
EXPOSE 9090