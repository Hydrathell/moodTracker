pipeline {
    agent any
    tools {
        gradle "Gradle"
    }
    stages {
        stage("Test") {
            steps {
                sh "gradle --version"
                sh "gradle clean test"
            }
        }
        stage("Build") {
            steps {
                sh "gradle build"
                stash includes: "build/libs/*.jar", name: "moodtracker_app"
            }
        }
    }
}