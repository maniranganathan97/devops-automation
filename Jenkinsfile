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
                    bat 'docker build -t manir1389/devops-integration .'
                }
            }
        }
           stage('Push image to Hub'){
            steps{
                script{
                  withCredentials([string(credentialsId: 'DockerId', variable: 'DockerId')]) {
                   bat 'docker login -u manir1389 -p Indhumathi@123'

                   }
                   bat 'docker push manir1389/devops-integration:latest'
                }
            }
        }
    }
}
