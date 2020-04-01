#!/usr/bin/bash groovy
def call(Map sonar) { 
    def workspace = get-env.WORKSPACE
    def properties = ${workspace}'/'${sonar.file}
    withSonarQubeEnv('T2P-SonarQube') {
        sh "${sonar.home}/bin/sonar-scanner -Dproject.settings=${properties}"
    } // submitted SonarQube taskId is automatically attached to the pipeline context
    timeout(time: 10, unit: 'MINUTES') {
        waitForQualityGate abortPipeline: true
    }
}

