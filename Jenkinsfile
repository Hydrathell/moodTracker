pipeline {
    agent any
    tools {
        gradle "Gradle"
        jdk "17"
    }
    stages {
        stage("Which Java") {
            steps {
                sh "java --version"
            }
        }
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