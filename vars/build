def call() {
  echo "Building Docker image"

                sh '''
                    docker build -t ${APP_NAME}:${IMAGE_TAG} .
                '''

                echo "Docker image built successfully"
}
