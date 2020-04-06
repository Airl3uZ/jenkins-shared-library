#!/usr/bin/bash groovy
def call(Map sonar) {
    withSonarQubeEnv('T2P-SonarQube') {
        sh "${sonar.home}/bin/sonar-scanner -Dproject.settings=${sonar.projectFile}"
    } // submitted SonarQube taskId is automatically attached to the pipeline context
    timeout(time: 10, unit: 'MINUTES') {
        waitForQualityGate abortPipeline: true
    }
}