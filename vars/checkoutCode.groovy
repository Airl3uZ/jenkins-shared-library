#!/usr/bin/env groovy
def call(Map stageParams) {
    def url = "git@" + stageParams.appenv + "-www.ibaht.com:" + stageParams.repo + ".git"
    checkout([
        $class: 'GitSCM',
        branches: [[name:  stageParams.branch ]],
        userRemoteConfigs: [
            [ url: url ],
            [credentialsId: stageParams.credentialsId]
        ]
    ])
}