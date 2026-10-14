pipeline {
 agent any
 tools { jdk 'jdk17'; maven 'maven3' }
 stages {
  stage('Checkout') { steps { checkout scm } }
  stage('Test') { steps { sh 'mvn -B clean test' } }
  stage('Package') { steps { sh 'mvn -B -DskipTests package' } }
  stage('Archive') { steps { archiveArtifacts artifacts: 'target/*.jar', fingerprint: true } }
 }
 post { always { junit testResults: 'target/surefire-reports/*.xml', allowEmptyResults: true } }
}