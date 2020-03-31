pipeline{
    agent {
        docker {
            args '-v ./app:/app -p 9000:9000'
            customWorkspace 'php'
            image 'webdevops/php:latest'
            label 'phpDocker'
            reuseNode true
        }
    }
}