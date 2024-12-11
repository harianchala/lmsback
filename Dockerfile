# Use an official Maven image to build the project
FROM maven:3.9.4-eclipse-temurin-17 as builder

# Set the working directory
WORKDIR /app

# Copy the project files
COPY . .

# Build the WAR file
RUN mvn clean package -DskipTests

# Use a lightweight Tomcat image
FROM tomcat:10.1-jdk17

# Set the working directory
WORKDIR /usr/local/tomcat/webapps

# Copy the generated WAR file to Tomcat's webapps directory
COPY --from=builder /app/target/JFSDProject.war ./

# Expose the default Tomcat port
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]
