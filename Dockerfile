# Build image for the Selenium Maven project
# This image builds the project and produces a packaged jar.
FROM maven:3.9.16-eclipse-temurin-17 AS build

WORKDIR /workspace

# Install Google Chrome stable for headless execution
RUN apt-get update && apt-get install -y wget gnupg curl \
    && curl -sSL https://dl.google.com/linux/linux_signing_key.pub | apt-key add - \
    && echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" > /etc/apt/sources.list.d/google-chrome.list \
    && apt-get update && apt-get install -y google-chrome-stable \
    && rm -rf /var/lib/apt/lists/*

# Copy only the pom first to cache dependency download
COPY pom.xml .
RUN mvn -B dependency:go-offline

# Copy source files and build package
COPY src ./src
RUN mvn -B -DskipTests package

# The project is a Maven test automation project.
# The built jar artifact will be located in /workspace/target.

# Default command to run the test suite in headless mode with the container data directory
CMD ["mvn", "test", "-Dbrowser=chrome-headless", "-Ddata.dir=/workspace/data"]
