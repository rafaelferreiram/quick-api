FROM openjdk:8-jre
RUN mkdir app
ARG JAR_FILE
ADD /target/${JAR_FILE} /app/com.api-0.0.1-SNAPSHOT.jar
WORKDIR /app
ENTRYPOINT java -jar com.api-0.0.1-SNAPSHOT.jar