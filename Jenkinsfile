pipeline {
    agent none
    environment {
        MOD2_AUTH0_CLIENT_ID = credentials("MOD2_AUTH0_CLIENT_ID")
        MOD2_AUTH0_CLIENT_SECRET = credentials("MOD2_AUTH0_CLIENT_SECRET")
        MOD2_AUTH0_ISSUER = credentials("MOD2_AUTH0_ISSUER")
        DOCKER_CREDENTIALS = credentials("DOCKER_CREDENTIALS")
    }
    stages {
        stage("Test and Build") {
            agent {
                docker {
                    image 'gradle:7.2.0-jdk17'
                }
            }
            steps {
                sh "gradle clean test"
                sh "gradle bootJar"
            }
        }
        stage("Docker Auth Build and Push") {
            agent {
                docker {
                    image 'docker:dind'
                }
            }
            steps {
                sh 'echo $DOCKER_CREDENTIALS_PSW | docker login -u $DOCKER_CREDENTIALS_USR --password-stdin'
                echo 'docker login as $DOCKER_CREDENTIALS_USR'
                sh 'docker build -t $DOCKER_CREDENTIALS/moodtracker:${env.BUILD_ID} .'
                sh 'docker push $DOCKER_CREDENTIALS/moodtracker:${env.BUILD_ID}'
            }
        }
    }
}

