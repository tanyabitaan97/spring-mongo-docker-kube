pipeline {
    agent any

    environment {
        DEPLOY_ENV = ''
    }

    stages {
        stage('Select Environment') {
            steps {
                script {
                    DEPLOY_ENV = input(
                        message: 'Select the deployment environment',
                        parameters: [
                            choice(name: 'DEPLOY_ENV', choices: ['dev', 'prod'], description: 'Choose deployment environment')
                        ]
                    )
                }
            }
        }
        
         stage('Clean up output file') {
    steps {
        sh 'rm -f output.txt'
    }
}

        stage('Run Job A - Build') {
            steps {
                script {
                    echo "Triggering Job: compile_data"
                    sh 'echo "=== Running compile_data ===" >> output.txt'
                    build job: 'compile_spring'
                    sh 'echo "=== Finished compile_data ===" >> output.txt'
                }
            }
        }

        stage('Run Job B - Test') {
            steps {
                script {
                    echo "Triggering Job: review_data"
                    sh 'echo "=== Running review_data ===" >> output.txt'
                    build job: 'review_spring'
                    sh 'echo "=== Finished review_data ===" >> output.txt'
                }
            }
        }

        stage('Run Job C - Deploy') {
            steps {
                script {
                    input message: "Are you sure you want to deploy to '${DEPLOY_ENV}'?"
                    sh "echo '=== Deploying to ${DEPLOY_ENV} ===' >> output.txt"
                    build job: 'package_spring', parameters: [
                        string(name: 'ENV', value: DEPLOY_ENV)
                    ]
                    sh "echo '=== Deployment to ${DEPLOY_ENV} Complete ===' >> output.txt"
                }
            }
        }
       
    }

    post {
        always {
            archiveArtifacts artifacts: 'output.txt', fingerprint: true
        }
        success {
            echo "All jobs completed successfully for environment: ${DEPLOY_ENV}"
        }
        failure {
            echo 'One or more jobs failed.'
        }
    }
}
