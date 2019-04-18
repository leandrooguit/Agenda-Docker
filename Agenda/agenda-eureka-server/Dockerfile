FROM java:8-jdk
RUN mkdir /app
WORKDIR /app
COPY target/agenda-eureka-server-0.0.1-SNAPSHOT.jar /app/agenda-eureka.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/agenda-eureka.jar"]
EXPOSE 9091