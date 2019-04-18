FROM java:8-jdk
RUN mkdir /app
WORKDIR /app
COPY target/agenda-cadastro-server-0.0.1-SNAPSHOT.jar /app/agenda-cadastro.jar
ENV JAVA_OPTS="-Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=9092,suspend=n"
RUN sh -c 'touch /app.jar'
#ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=docker -jar /agenda-cadastro.jar" ]
ENTRYPOINT ["java", "-Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=9092,suspend=n -Djava.security.egd=file:/dev/./urandom", "-jar", "/app/agenda-cadastro.jar"]
EXPOSE 9092