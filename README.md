# Bangla Shashya Bima Automation

## Local setup

1. Install Java 17
2. Install Maven
3. Add to PATH:
   - `C:\Program Files\Eclipse Adoptium\jdk-17.0.19.10-hotspot\bin`
   - `C:\Users\Sagnik\tools\apache-maven-3.9.16\bin`
4. Set env vars:
   - `JAVA_HOME=C:\Program Files\Eclipse Adoptium\jdk-17.0.19.10-hotspot`
   - `M2_HOME=%USERPROFILE%\tools\apache-maven-3.9.16`

## Build and run

```powershell
cd "d:\Programming\Java\Selenium testing workspace\Freelance\Bangla_Shashya_Bima_v1.1.0.1"
mvn -f pom.xml -U -DskipTests package
mvn -f pom.xml -Dsurefire.suiteXmlFiles=testng.xml test
```

## Docker build

```powershell
docker build -t bangla-shashya-bima:latest .
```

## GitHub Actions

The workflow is defined in `.github/workflows/ci.yml` and runs on push / pull request to `main` or `master`. It:
- checks out the repo
- sets up JDK 17
- caches Maven deps
- packages the project
- runs the TestNG suite
