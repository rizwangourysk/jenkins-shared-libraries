def call(String projectName, String imageTag, String dockerHubUserName) {

    withCredentials([
        usernamePassword(
            credentialsId: 'dockercrd',
            usernameVariable: 'dockerHubUser',
            passwordVariable: 'dockerHubPass'
        )
    ]) {

        sh """
            echo \$dockerHubPass | docker login -u \$dockerHubUser --password-stdin
            docker push ${dockerHubUserName}/${projectName}:${imageTag}
        """
    }
}
