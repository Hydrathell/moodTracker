pipeline {
    agent any
    tools {
        gradle "Gradle"
    }
    stages {
        stage('Test') {
            steps {
                sh 'gradle --version'
            }
        }
    }
}