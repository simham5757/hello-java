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
  stage('Docker Build and Push') {
    steps {
        script {
            dockerImage = docker.build("mytub/ganta:${BUILD_NUMBER}")
            withDockerRegistry(credentialsId: 'dockerhub_creds', url: 'https://index.docker.io/v1/') {
                dockerImage.push()
            }
        }
    }
  }

  stage('Deploy to K3s') {
    steps {
        sh """
        export KUBECONFIG=/var/lib/jenkins/.kube/config
        sed -i "s#image:.*#image: mytub/ganta:${BUILD_NUMBER}#g" deployment-java.yaml
        kubectl apply -f deployment-java.yaml
        kubectl rollout status deployment/hello-java
        """
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

