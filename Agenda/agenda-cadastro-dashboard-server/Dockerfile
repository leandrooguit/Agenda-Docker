FROM java:8-jdk
RUN mkdir /app
WORKDIR /app
COPY target/agenda-cadastro-dashboard-server-0.0.1-SNAPSHOT.jar /app/agenda-dashboard.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/agenda-dashboard.jar"]
EXPOSE 9093