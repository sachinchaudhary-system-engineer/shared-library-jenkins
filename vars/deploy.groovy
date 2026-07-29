def call() {
  sh '''
                    kubectl apply -f k8s/
                    
                    kubectl set image deployment/webapp-deployment -n webapp webapp-container=${DOCKER_REPO}/${APP_NAME}:${IMAGE_TAG}
                    
                    kubectl rollout status deployment/webapp-deployment -n webapp
                    
                    kubectl get pods -n webapp
                    kubectl get deployment -n webapp
                    kubectl get svc -n webapp
                    kubectl get ingress -n webapp
                '''
}
