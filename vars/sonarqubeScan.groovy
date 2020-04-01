#!/usr/bin/bash groovy
def call(Map sonar) { 
    def sonar.workspace = get-env.WORKSPACE
    def sonar.properties = ${sonar.workspace}'/'${sonar.file}
    withSonarQubeEnv('T2P-SonarQube') {
        sh "${sonar.home}/bin/sonar-scanner -Dproject.settings=${sonar.properties}"
    } // submitted SonarQube taskId is automatically attached to the pipeline context
    timeout(time: 10, unit: 'MINUTES') {
        waitForQualityGate abortPipeline: true
    }
}

