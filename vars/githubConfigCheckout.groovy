#!/usr/bin/env groovy
def call(Map stageParams) {
    def scmExtension = [[$class: 'SparseCheckoutPaths', sparseCheckoutPaths: [[path: 'ci']]], [$class: 'RelativeTargetDirectory', relativeTargetDir: 'ci' ]]
    checkout([
        $class: 'GitSCM',
        branches: [[name:  stageParams.branch ]],
        extensions: scmExtension,
        userRemoteConfigs: [[ url:  "https://github.com/"+stageParams.user+"/"+stageParams.repo ]]
    ])
}