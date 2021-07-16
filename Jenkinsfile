pipeline {
	agent any
	stages {
		stage('Clone') {
			steps {
				git 'https://github.com/EndMan95/angularDemo.git'
			}
		}
		stage('BuildAndPush'){
			steps{
				// This step should not normally be used in your script. Consult the inline help for details.
				withDockerRegistry(credentialsId: 'hieu', url: 'https://index.docker.io/v1/') {
					sh label: '', script: 'docker build -t hieunm95/dockerhub_for_jenkins:v1 .'
					sh label: '', script: 'docker push -t hieunm95/dockerhub_for_jenkins:v1'
				}
			}
		}
	}
}