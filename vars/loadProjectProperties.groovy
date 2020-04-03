#!/usr/bin/env groovy
def call() {
    def env[] = System.getenv()
    String workspace = env.WORKSPACE
    properties = readProperties file: "${workspace}/project.properties"
}
return this;