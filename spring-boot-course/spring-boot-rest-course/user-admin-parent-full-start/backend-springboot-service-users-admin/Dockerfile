# Multi Stage build
#################################################
### Base Image and name 1. stage as "builder" ###
#################################################
FROM maven:3-openjdk-17 AS builder

# Create App Directory inside our container
WORKDIR /Users/ryanezv/app/src/

# Copy files
COPY src ./
COPY pom.xml ../

RUN mvn -f /Users/ryanezv/app/pom.xml clean package

###################
#### 2nd Stage ####
###################
FROM openjdk:17.0.2-slim-buster

# Set working directory
WORKDIR /Users/ryanezv/lib/

# Copy the Jar from the first Stage (builder) to the 2nd stage working directory
COPY --from=builder /Users/ryanezv/app/target/users-teams-management-0.0.1-SNAPSHOT.jar ./sb-dockerized.jar

# Expose the port to the inner container communication network
EXPOSE 8080

# Run the Java Application
ENTRYPOINT [ "java","-jar","/Users/ryanezv/lib/sb-dockerized.jar"]