# Build the WAR file and specify the output directory
RUN mvn clean package -DskipTests -Dmaven.war.outputDirectory=/app/target

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
