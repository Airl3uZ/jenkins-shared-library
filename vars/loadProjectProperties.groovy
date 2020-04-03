#!/usr/bin/env groovy
def call() {
    loadProperties() {
    def env[] = System.getenv()
    String workspace = env.WORKSPACE
        node {
            stage('Read Properties') {
                properties = readProperties file: 'project.properties'
            }
        }
    }
}
return this;