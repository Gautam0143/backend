FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
WORKDIR /app
RUN ls -l /app   # Debugging statement
COPY . .
RUN mvn package  # Assuming you are using Maven, adjust for other build tools
COPY target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
EXPOSE 8080
