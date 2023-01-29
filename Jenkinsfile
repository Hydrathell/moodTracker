pipeline {
    agent any
    tools {
        gradle "Gradle 8.*"
    }
    stages {
        stage('Test') {
            steps {
                sh 'gradle --version'
            }
        }
    }
}