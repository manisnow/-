#!groovy

node {
    stage 'checkout'
    checkout scm

    stage 'build'
    if (isUnix()) {
        sh './gradlew clean build'
    } else {
        bat './gradlew.bat clean build'
    }

    stage 'package'
    if (isUnix()) {
        sh './gradlew bootRepackage'
    } else {
        bat './gradlew.bat bootRepackage'
    }
    step([$class: 'ArtifactArchiver', artifacts: '**/build/libs/*.war', fingerprint: true])
        
    stage 'postbuild'
    if (isUnix()) {
        sh 'ls -la'
    } else {
        bat 'dir'
    }
    
    stage 'deploy'
    if (isUnix()) {
        echo 'Unix'   
    } else {
        bat jboss-cli --connect --controller=${controller} --user=${as_user} --password=${as_password} --command="deploy ./build/libs/${artifact}-${version}.${packaging} --server-groups=${server_group}"
    }
}
