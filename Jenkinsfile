node {
    stage 'Test' {
        sh 'gradle clean test'
    }
    stage 'Build' {
        sh 'gradle build'
        stash includes: '**/build/libs/*.jar', name: 'moodtracker'
    }
    stage 'Deploy' {
        unstash 'moodtracker'
    }
}