FROM openjdk:24
WORKDIR /app
COPY ./target/StoryGenAIApp-0.0.1-SNAPSHOT.jar /app
EXPOSE 8080
CMD ["java", "-jar", "StoryGenAIApp-0.0.1-SNAPSHOT.jar"]