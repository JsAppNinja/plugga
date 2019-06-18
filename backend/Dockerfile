# Start with a base image containing Java runtime
FROM openjdk:8

# Add Maintainer Info
LABEL maintainer="juncheong1@gmail.com"

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8080

# The application's jar file
ARG JAR_FILE=target/plugga-rest-api-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} plugga-rest-api.jar

# Run the jar file
ENTRYPOINT ["./wait-for-it.sh", "db:3306", "--", "java","-Djava.security.egd=file:/dev/./urandom","-jar","/plugga-rest-api.jar"]