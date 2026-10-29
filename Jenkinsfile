pipeline {
    agent any

    environment {
        STUDENT_NAME = 'Akzhol Tynysbai'
        STUDENT_ID   = '38313'
        IMAGE_NAME   = 'tynysbai-akzhol-student-api'
        IMAGE_TAG    = 'v1.1-tynysbai-akzhol'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
                echo "Student: ${STUDENT_NAME} (ID ${STUDENT_ID}), group IT2-2306"
                sh 'git log -1 --oneline'
            }
        }

        stage('Build') {
            steps {
                sh 'java -version'
                sh 'chmod +x gradlew'
                sh './gradlew clean assemble --no-daemon'
            }
        }

        stage('Test') {
            steps {
                sh './gradlew test --no-daemon'
            }
            post {
                always {
                    junit 'build/test-results/test/*.xml'
                }
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t $IMAGE_NAME:$IMAGE_TAG .'
            }
        }

        stage('Verify') {
            steps {
                sh '''
                    docker image inspect $IMAGE_NAME:$IMAGE_TAG > /dev/null
                    echo "Image $IMAGE_NAME:$IMAGE_TAG exists"
                    docker images $IMAGE_NAME
                '''
            }
        }
    }

    post {
        success { echo "SUCCESS: pipeline of ${STUDENT_NAME} finished" }
        failure { echo "FAILURE: pipeline of ${STUDENT_NAME} stopped. Check the failed stage." }
    }
}
