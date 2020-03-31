pipeline {

  environment {
      dockerfile = "webdevops/php-nginx"
      
  }
  agent any
  stages {
    stage('checkout git'){
      // git url: https://github.com/Airl3uZ/demo-php-ci.git
      steps {
          checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/Airl3uZ/demo-php-ci.git']]])
      }    
    }

}
