FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
WORKDIR /app

# Install Maven
RUN apk --no-cache add maven

# Debugging statement
RUN ls -l /app

# Copy the source code
COPY . .

# Build the project
RUN mvn package -DskipTests


# Copy the JAR file
COPY target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
EXPOSE 8080
