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
         stage ('SonarQube Analysis') {
        steps{
            script{
                withSonarQubeEnv('sonarqube-8.9.2') {
                    sonarCredentials = credentials('sqp_d6070991b3dc34365964f6afc7bff12d4f853755')
                             withCredentials([string(credentialsId: 'sonarqube', variable: 'sonarqube')]) {
                                 bat 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=root'
                             }
                }
            }
        }
        }

        
}
    }
   
