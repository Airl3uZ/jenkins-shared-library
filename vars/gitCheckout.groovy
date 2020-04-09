#!/usr/bin/env groovy
def call(Map stageParams) {

    checkout([
        $class: 'GitSCM',
        branches: [[name:  stageParams.branch ]],
        extensions: [[$class: 'RelativeTargetDirectory', relativeTargetDir: stageParams.path ]],
        userRemoteConfigs: [[ url:  stageParams.url+":"+stageParams.repo ,
            credentialsId: '75aa10b1-d3c0-4675-818f-73b572b08684']]
    ])
}