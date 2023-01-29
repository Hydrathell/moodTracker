pipeline {
    agent any
    tools {
        gradle "Gradle 8"
        jdk "JDK 17"
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
                stash includes: "build/libs/*.jar", name: "moodtracker_app"
            }
        }
    }
}