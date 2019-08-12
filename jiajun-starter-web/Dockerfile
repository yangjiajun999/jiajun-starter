FROM anapsix/alpine-java:8_server-jre
VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS="-server -Xms2048m -Xmx2048m"
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar " ]
EXPOSE 8080
