param(
    [string]$ExcelHostDir = "D:\Freelancing\BSB\BSB\Data\MEMARI-I\MEMARI-I",
    [string]$Email = "test@example.com",
    [string]$Password = "secret"
)

# Ensure the host excel dir exists
if (-not (Test-Path -Path $ExcelHostDir)) {
    Write-Error "Excel host directory not found: $ExcelHostDir"
    exit 1
}

# Run the container mapping the Excel host dir to /data and project dir to /workspace
docker run --rm `
  -v "${ExcelHostDir}:/data" `
  -v "${PWD}:/workspace" `
  -v "${PWD}\target:/workspace/target" `
  -w /workspace `
  maven:3.9.16-eclipse-temurin-17 `
  mvn -Ddata.dir=/data -Dbsb.email=${Email} -Dbsb.password=${Password} test

# After run, target/surefire-reports will be available on host under ./target/surefire-reports
if (Test-Path -Path "./target/surefire-reports") {
    Write-Host "Test reports available: ./target/surefire-reports"
} else {
    Write-Warning "No test reports found in ./target/surefire-reports"
}
