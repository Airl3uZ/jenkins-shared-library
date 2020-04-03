#!/usr/bin/env groovy
def call(Map stageParams) {
    def url = "git@" + stageParams.appenv + "-www.ibaht.com:" + stageParams.repo + ".git"
    checkout([
        $class: 'GitSCM',
        branches: [[name:  stageParams.branch ]],
        userRemoteConfigs: [
            [ url: url ],
            [credentialsId: 75aa10b1-d3c0-4675-818f-73b572b08684]
        ]
    ])
}