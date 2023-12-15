pipeline {
    agent any
    tools{
        maven 'Maven 3.5.0'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/maniranganathan97/devops-automation']]])
                bat 'mvn clean install'
            }
        }
        stage('Build docker image'){
            steps{
                script{
                    bat 'docker build -t mani/devops-integration .'
                }
            }
        }
           stage('Push image to Hub'){
            steps{
                script{
                   withCredentials([string(credentialsId: 'dockerPwd', variable: 'dockerPwd')]) {
                   sh 'docker login -u mani -p ${dockerPwd}'

                   }
                   sh 'docker push mani/devops-integration'
                }
            }
        }
    }
}
