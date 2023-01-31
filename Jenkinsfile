pipeline {
    agent {
        docker {
            image 'gradle:7.2.0-jdk17'
        }
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
        // stage("Docker Auth") {
        //     steps {
        //         sh 'echo $DOCKER_CREDENTIALS_PSW | docker login -u $DOCKER_CREDENTIALS_USR --password-stdin'
        //         sh "docker --version"
        //     }
        // }
        stage("Dockerise") {
            steps {
                sh 'pwd'
                sh 'docker --version'
                unstash "moodtracker_app"
                // sh 'docker build -t $DOCKER_CREDENTIALS_USR/moodtracker .'
                // sh 'docker push $DOCKER_CREDENTIALS_USR/moodtracker'
            }
        }
    }
}