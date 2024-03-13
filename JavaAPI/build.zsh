#!/bin/zsh

PROJECT_NAME="JavaAPI"
OUTPUT_DIR="target"
JAR_NAME="JavaAPI-1.0-SNAPSHOT.jar"

function buildJar(){
  mvn clean install
  mvn clean package

  echo "Build complete. JAR file: $OUTPUT_DIR/$JAR_NAME"
}

buildJar