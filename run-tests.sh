#!/usr/bin/env bash
EXCEL_HOST_DIR=${1:-/mnt/d/excel-data}
EMAIL=${2:-test@example.com}
PASSWORD=${3:-secret}

if [ ! -d "$EXCEL_HOST_DIR" ]; then
  echo "Excel host directory not found: $EXCEL_HOST_DIR"
  exit 1
fi

docker run --rm \
  -v "$EXCEL_HOST_DIR:/data" \
  -v "$(pwd):/workspace" \
  -v "$(pwd)/target:/workspace/target" \
  -w /workspace \
  maven:3.9.16-eclipse-temurin-17 \
  mvn -Ddata.dir=/data -Dbsb.email=${EMAIL} -Dbsb.password=${PASSWORD} test

if [ -d "./target/surefire-reports" ]; then
  echo "Test reports available: ./target/surefire-reports"
else
  echo "No test reports found in ./target/surefire-reports"
fi
