pipeline {
    agent any
    tools {
        gradle "Gradle-8"
    }
    environment {
        MOD2_AUTH0_CLIENT_ID = credentials("MOD2_AUTH0_CLIENT_ID")
        MOD2_AUTH0_CLIENT_SECRET = credentials("MOD2_AUTH0_CLIENT_SECRET")
        MOD2_AUTH0_ISSUER = credentials("MOD2_AUTH0_ISSUER")
        DOCKER_CREDENTIALS = credentials("Docker")
    }
    stages {
        stage("Which Versions") {
            steps {
                sh "java --version"
                sh "gradle --version"
            }
        }
        stage("Test") {
            steps {
                sh "gradle clean test"
            }
        }
        stage("Gradle build") {
            steps {
                sh "gradle bootJar"
                stash includes: "build/libs/*.jar", name: "moodtracker_app"
            }
        }
        stage("Docker Auth") {
            steps {
                sh 'echo $DOCKER_CREDENTIALS_PSW | sudo docker login -u $DOCKER_CREDENTIALS_USR --password-stdin'
                echo "docker login"
            }
        }
        stage("Dockerise") {
            steps {
                sh "docker build -t bmordan/moodtracker ."
                sh "docker push bmordan/moodtracker"
            }
        }
    }
}