FROM java:8-jdk
RUN mkdir /app
WORKDIR /app
COPY target/agenda-cadastro-server-0.0.1-SNAPSHOT.jar /app/agenda-cadastro.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/agenda-cadastro.jar"]
EXPOSE 9092