#!/usr/bin/env groovy
def call(Map stageParams) {

    checkout([
        $class: 'GitSCM',
        branches: [[name:  stageParams.branch ]],
        extensions: [[stageParams.extensions ]],
        extensions: [[$class: 'RelativeTargetDirectory', relativeTargetDir: stageParams.path ]],
        userRemoteConfigs: [[ url:  "https://github.com/"+stageParams.user+"/"+stageParams.repo ]]
    ])
}