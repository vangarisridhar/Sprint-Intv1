pipeline {
    agent any

    stages {
        stage('Clone') {
            steps {
                   git branch: 'continuousIntegration', credentialsId: '34f3c7a9-a9d2-493c-bf71-287d2748d05a', url: 'https://github.com/vangarisridhar/Sprint-Intv1.git'

            }
        }
        stage('clean') {
            steps {
                bat 'mvn clean'
            }
        }
        stage('compile') {
            steps {
                 bat 'mvn compile'

            }
        }  stage('test') {
            steps {
                bat 'mvn test'

            }
        }

  stage('notify') {
            steps {
               mail bcc: '', body: 'jenkins scripted pipeline workflow', cc: 'vangarisridhar@gmail.com', from: '', replyTo: '', subject: 'jenkins report', to: 'vangarisridhar@gmail.com'
            }
        }
    

}
}