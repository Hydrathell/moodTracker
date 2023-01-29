pipeline {
    agent any
    tools {
        gradle "Gradle 8"
        jdk "JDK 17"
    }
    stages {
        stage("Which Versions") {
            steps {
                sh "export JAVA_HOME=/var/jenkins_home/tools/hudson.model.JDK/JDK_17/jdk-17.0.6/bin/java"
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