FROM java:8-jdk
RUN mkdir /app
WORKDIR /app
COPY target/agenda-config-server-0.0.1-SNAPSHOT.jar /app/agenda-config.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/agenda-config.jar"]
EXPOSE 9090
