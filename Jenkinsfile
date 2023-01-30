pipeline {
    agent any
    tools {
        gradle "Gradle-8"
    }
    environment {
        MOD2_AUTH0_CLIENT_ID = credentials("MOD2_AUTH0_CLIENT_ID")
        MOD2_AUTH0_CLIENT_SECRET = credentials("MOD2_AUTH0_CLIENT_SECRET")
        MOD2_AUTH0_ISSUER = credentials("MOD2_AUTH0_ISSUER")
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
        stage("Build") {
            steps {
                sh "gradle build"
                // stash includes: "build/libs/*.jar", name: "moodtracker_app"
            }
        }
    }
}