properties = null

def loadProperties() {
    node {
        checkout scm
        properties = readProperties file: 'pipeline.properties'
        echo "Immediate one ${properties.repo}"
    }
}

pipeline {
    agent none

    stages {           
        stage ('prepare') {
            agent any

            steps {
                script {
                    loadProperties()
                    echo "Later one ${properties.ansible}"
                }
            }
        }
    }
}