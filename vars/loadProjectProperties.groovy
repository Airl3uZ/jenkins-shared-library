#!/usr/bin/env groovy
def call() {
    String workspace = pwd()
    echo workspace
    properties = readProperties file: "${workspace}/project.properties"
}
return this;