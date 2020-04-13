#!groovy
// @Library('SharedLibrary')_
// pipeline {
//     agent {
//         docker {
//             args "-v ///${pwd}/data/app:/app:rw"
//             image 'phpunit/phpunit:latest'
//             reuseNode true
//         }
//     }
//     stages {
        stage('UnitTest') {
            agent {
                docker {
                    args "-v ///${pwd}/data/app:/app:rw"
                    image 'phpunit/phpunit:latest'
                    reuseNode true
                }
            }
            options {
                timeout(time: 10, unit: "MINUTES")
            }
            steps {
                dir('data/app') {
                    echo "check environment"
                    sh "pwd ls -altr && whoami && hostname"
                    echo "Composer Update"
                    sh 'composer update'
                    sh 'ls'
                    echo "Unit Test"
                    sh 'phpunit'
                }
            }
        }
    // }
    post {
        success {
            notifyLine("Success")
        }
        unsuccessful {
            notifyLine("failed")
        }
        failure {
            notifyLine("failure")
        }
    }
// }