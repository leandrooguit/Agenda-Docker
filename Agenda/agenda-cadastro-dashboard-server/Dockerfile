FROM java:8-jdk
RUN mkdir /app
WORKDIR /app
COPY target/agenda-cadastro-dashboard-server-0.0.1-SNAPSHOT.jar /app/agenda-dashboard.jar
ENV JAVA_OPTS="-Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=9093,suspend=n"
#ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /agenda-dashboard.jar" ]
ENTRYPOINT ["java", "-Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=9093,suspend=n -Djava.security.egd=file:/dev/./urandom", "-jar", "/app/agenda-dashboard.jar"]
EXPOSE 9093