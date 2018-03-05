pipeline {
    agent {
        docker {
            image 'maven:3.5.2-jdk-9-slim'
            args '-v /root/.m2:/root/.m2'
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B clean compile'
            }
            post {
                always {
                    checkstyle pattern: '**/checkstyle-result.xml'
                    pmd canComputeNew: false, canRunOnFailed: true, defaultEncoding: '', healthy: '', pattern: 'pmd.xml', unHealthy: ''
                    // cpd
                }
            }
        }
        stage('Test') {
            steps {
                sh 'mvn -B test'
            }
            post {
                always {
                    junit '**/*-reports/**/*.xml'
                    jacoco classPattern: '**/target/**/classes', execPattern: '**/target/jacoco-aggregate.exec'
                }
            }
        }
        stage('Integration-Test') {
            steps {
                sh 'mvn -B verify'
            }
            post {
                always {
                    junit '**/*-reports/**/*.xml'
                    jacoco classPattern: '**/target/**/classes', execPattern: '**/target/jacoco-aggregate.exec'
                }
            }
        }
        stage('Deploy') {
            steps {
                //timeout(time: 5, unit: 'DAYS') {
                //    input message: 'Approve deployment?'
                //}
                echo 'Deploy'
            }
        }
    }
    post {
        success {
            archive "target/*-exec.jar"
        }
    }
}
