node {
    stage 'test' {
        sh 'gradle clean test'
    }
    stage 'build' {
        sh 'gradle build'
        stash includes: '**/build/libs/*.jar', name: 'moodtracker'
    }
    stage 'deploy' {
        unstash 'moodtracker'
    }
}