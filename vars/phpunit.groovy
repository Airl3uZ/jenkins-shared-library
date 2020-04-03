#!/usr/bin/env groovy
// Properties properties = new Properties()
// File propertiesFile = new File('project.properties')
// propertiesFile.withInputStream {
//     properties.load(it)
// }

// def runtimeString = 'a'
// assert properties."$runtimeString" == '1'
// assert properties.b == '2'

node {
    docker.image('mysql:5').withRun('-e "MYSQL_ROOT_PASSWORD=my-secret-pw"') { c ->
        docker.image('mysql:5').inside("--link ${c.id}:db")
    docker.image('phpunit/phpunit').inside() {
        stage('UnitTest') {
            echo "Composer Update"
            // sh 'composer update'
            // sh 'ls'
            // sh './vendor/bin/phpunit'            
        }
    }
    // stage("deployDocker") {
    //         docker {
    //             args "-v app:/app -p 9000:9000"
    //             image 'webdevops/php:latest'
    //             customWorkspace "php"
    //             reuseNode true
    //         }
    //     }
    //     steps {
    //             dir('app') {
    //                 echo "Composer Update"
    //                 sh 'composer update'
    //                 sh 'ls'
    //                 sh './vendor/bin/phpunit'
    //             }
    //         }
}
