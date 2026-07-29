def call() {
  echo "Pushing Docker image"

                withCredentials([usernamePassword(
                    credentialsId: 'dockerhub-cred',
                    usernameVariable: 'DOCKER_USER',
                    passwordVariable: 'DOCKER_PASS'
                )]) {

                    sh '''
                        echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin
                        docker tag ${APP_NAME}:${IMAGE_TAG} "$DOCKER_USER"/${APP_NAME}:${IMAGE_TAG}
                        docker push "$DOCKER_USER"/${APP_NAME}:${IMAGE_TAG}
                    '''

                    echo "Docker image pushed successfully"
                }
}
