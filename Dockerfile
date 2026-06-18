# Build image for the Selenium Maven project
# This image builds the project and produces a packaged jar.
FROM maven:3.9.16-jdk-17 AS build

WORKDIR /workspace

# Copy only the pom first to cache dependency download
COPY pom.xml .
RUN mvn -B dependency:go-offline

# Copy source files and build package
COPY src ./src
RUN mvn -B -DskipTests package

# The project is a Maven test automation project.
# The built jar artifact will be located in /workspace/target.
