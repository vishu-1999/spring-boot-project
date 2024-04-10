pipeline{
    agent any

    tools {
         maven 'maven'
         jdk 'JDK_1.8'
    }

    stages{
        stage('checkout'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: 'github access', url: 'https://github.com/vishu-1999/spring-boot-project.git']]])
            }
        }
        stage('build'){
            steps{
               bat 'mvn package'
            }
        }
        
}
    }
   
