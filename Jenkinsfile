pipeline { 
 agent any
 stages{
   stage('fetch code') {
     steps {
      git 'https://github.com/simham5757/hello-java.git'
     }
   }
   stage('build artifact') {
     steps { 
       sh 'mvn clean package'
      }
    }
  stage('Build Test') {
    steps {
       sh 'mvn test'
    }
  }
  stage('ArchiveArtifact') {
     steps {
       archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
     }
  }
 }
 post {
   success
   {
     echo "sucesse"
   }
   failure
   {
    echo "pipeline is failed"
   }
   always
   {
     echo "always fire this"
   }

 }
}

