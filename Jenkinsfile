pipeline {
    agent {
        docker {
            image 'maven:3.6.0-jdk-11'
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
                    recordIssues enabledForFailure: true, tools: [java(), checkStyle(), pmdParser(), javaDoc(), mavenConsole(), cpd(), taskScanner(highTags: 'FIXME', ignoreCase: true, includePattern: '**/*.java, **/*.xml', normalTags: 'TODO,HACK')]
                }
            }
        }
        stage('Test') {
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
    }
    post {
        success {
            archive "target/*.jar"
        }
    }
}
