# Use an official Maven image to build the project
FROM maven:3.9.4-eclipse-temurin-17 as builder

# Set the working directory
WORKDIR /app

# Copy the project files
COPY . .

# Force Maven to build the WAR file (without skipping tests for debugging)
RUN mvn clean package

# Check if the WAR file is generated
RUN ls /app/target

# Use a lightweight Tomcat image
FROM tomcat:10.1-jdk17

# Set the working directory
WORKDIR /usr/local/tomcat/webapps

# Copy the generated WAR file to Tomcat's webapps directory
COPY --from=builder /app/target/*.war ./JFSDProject.war

# Expose the default Tomcat port
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]
