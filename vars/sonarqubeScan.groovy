pipeline {
    agent any
    stages {
        stage('SonarQube code analysis and Quality Gate') {
            environment {
                scannerHome = tool name: 'sonar-scanner'
            }
            steps {
                // sh "printenv"
                echo "Do Static code analysis with SonarQube"
                withSonarQubeEnv('T2P-SonarQube') { 
                    // echo "${env.WORKSPACE}"
                    // sh "pwd && ls -altr"  
                    sh "${scannerHome}/bin/sonar-scanner -Dproject.settings=data/sonar-project.properties"
                }
                // timeout(time: 10, unit: 'MINUTES') {
                //     waitForQualityGate abortPipeline: true
                // }
                timeout(time: 1, unit: 'HOURS') { 
                    script {
                        def qg = waitForQualityGate()
                        println("${qg}")
                        if (qg.status != 'OK') {
                            error "Pipeline aborted due to quality gate failure: ${qg.status}"
                        }
                        else {
                            echo "${qg.status}"
                        }
                    }
                }
            }
        }
    }
}