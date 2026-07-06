def call(String project, String imageTag, String dockerHubUserName) {

    withCredentials([
        usernamePassword(
            credentialsId: 'docker',
            usernameVariable: 'dockerHubUser',
            passwordVariable: 'dockerHubPass'
        )
    ]) {

        sh "echo ${dockerHubPass} | docker login -u ${dockerHubUser} --password-stdin"
    }

    sh "docker push ${dockerHubUserName}/${project}:${imageTag}"
}
