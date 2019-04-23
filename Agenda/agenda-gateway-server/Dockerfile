FROM java:8-jdk
RUN mkdir /app
WORKDIR /app
COPY target/agenda-gateway-server-0.0.1-SNAPSHOT.jar /app/agenda-gateway.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/agenda-gateway.jar"]
EXPOSE 9094