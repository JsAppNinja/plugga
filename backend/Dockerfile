FROM openjdk:8
COPY ./target/backend-0.0.1-SNAPSHOT.jar /usr/src/backend/
WORKDIR /usr/src/backend
EXPOSE 5000
CMD ["java", "-jar", "backend-0.0.1-SNAPSHOT.jar"]