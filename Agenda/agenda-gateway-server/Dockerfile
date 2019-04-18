FROM java:8-jdk
RUN mkdir /app
WORKDIR /app
COPY target/agenda-gateway-server-0.0.1-SNAPSHOT.jar /app/agenda-gateway.jar
ENV JAVA_OPTS="-Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=9094,suspend=n"
#ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=fil/e:/dev/./urandom -Dspring.profiles.active=docker -jar /agenda-gateway.jar" ]
ENTRYPOINT ["java", "-Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=9094,suspend=n -Djava.security.egd=file:/dev/./urandom", "-jar", "/app/agenda-gateway.jar"]
EXPOSE 9094