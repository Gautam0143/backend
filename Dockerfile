FROM eclipse-temurin:17-jdk-alpine
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
COPY --chown=root:root target/*.jar /app/target/app.jar


ENTRYPOINT ["java", "-jar", "/app.jar"]

EXPOSE 8080
