# Build image for the Selenium Maven project
# This image builds the project and runs the test suite.
FROM maven:3.9.16-eclipse-temurin-17

WORKDIR /workspace

# Install Chromium browser (simpler than Chrome) and dependencies
RUN apt-get update && apt-get install -y \
    chromium-browser \
    chromium-driver \
    fonts-liberation \
    libappindicator3-1 \
    libatk-bridge2.0-0 \
    libatk1.0-0 \
    libcups2 \
    libdbus-1-3 \
    libexpat1 \
    libgbm1 \
    libglib2.0-0 \
    libnspr4 \
    libnss3 \
    libpango-1.0-0 \
    libpangocairo-1.0-0 \
    libx11-6 \
    libx11-xcb1 \
    libxcb1 \
    libxcb-dri3-0 \
    libxcomposite1 \
    libxcursor1 \
    libxdamage1 \
    libxext6 \
    libxfixes3 \
    libxi6 \
    libxinerama1 \
    libxrandr2 \
    libxrender1 \
    libxss1 \
    libxtst6 \
    xdg-utils \
    && rm -rf /var/lib/apt/lists/*

# Copy pom.xml first to cache dependencies
COPY pom.xml .

# Download Maven dependencies
RUN mvn dependency:resolve dependency:resolve-plugins

# Copy source files
COPY src ./src
COPY drivers ./drivers

# Build the project (skip tests in build stage)
RUN mvn clean package -DskipTests

# Default command runs tests with Chromium in headless mode
CMD ["mvn", "test", "-Dbrowser=chromium-headless", "-Ddata.dir=/data"]
