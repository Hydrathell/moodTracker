pipeline {
    agent any
    tools {
        gradle "GRADLE_LATEST"
    }
    stages {
        stage('Test') {
            steps {
                sh 'gradle --version'
            }
        }
    }
}