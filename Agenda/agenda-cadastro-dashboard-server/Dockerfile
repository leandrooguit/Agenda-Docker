FROM maven:3.6.0-jdk-8-alpine AS build_ac
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package -DskipTests

FROM java:8-jdk
RUN mkdir /app
WORKDIR /app
COPY --from=build_ac /usr/src/app/target/agenda-cadastro-dashboard-server-0.0.1-SNAPSHOT.jar /app/agenda-dashboard.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/agenda-dashboard.jar"]
EXPOSE 9093