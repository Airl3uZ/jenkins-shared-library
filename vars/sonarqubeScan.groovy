#!/usr/bin/bash groovy
def call() {
    environment {
    scannerHome = tool 'SonarQubeScanner'
    }
    steps {
        withSonarQubeEnv('T2P-SonarQube') {
            sh "${sonar}/bin/sonar-scanner"
        } // submitted SonarQube taskId is automatically attached to the pipeline context
        timeout(time: 10, unit: 'MINUTES') {
            waitForQualityGate abortPipeline: true
        }
    }
}

