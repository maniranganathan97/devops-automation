pipeline {
    agent any
    tools{
        maven 'Maven 3.5.0'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/maniranganathan97/devops-automation']]])
                sh 'mvn clean install'
            }
        }
        stage('Build docker image'){
            steps{
                script{
                    sh 'docker build -t mani/devops-integration .'
                }
            }
        }
           stage('Push image to Hub'){
            steps{
                script{
                  withCredentials([string(credentialsId: 'DockerId', variable: 'DockerId')]) {
                   sh 'docker login -u manir1389 -p ${DockerId}'

                   }
                   sh 'docker push mani/devops-integration'
                }
            }
        }
    }
}
