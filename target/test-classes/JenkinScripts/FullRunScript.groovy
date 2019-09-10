pipeline {
	agent any
	tools {
		maven 'Maven 3.52'
		jdk 'OpenJDK jdk-8.0.202.08'
	}
	stages {
		stage('Initialize') {
			steps {
			   echo "PATH = ${PATH}"
			   echo "M2_HOME = ${M2_HOME}"
			   echo "JAVA_HOME = ${JAVA_HOME}"
			}
		}
		stage ('Clone') {
			steps {
			   bat 'mvn -version'
			   git url: 'https://github.com/kraviraju/Adidas_POM_Selenium.git'
			}
		}
		 stage ('Compile') {
			steps {
			   bat 'mvn clean test -DsuiteXmlFile=AddtoCartTestNG.xml'
			   bat 'mvn clean test -DsuiteXmlFile=ValidateCartTestNG.xml'
			   bat 'mvn clean test -DsuiteXmlFile=RemovefromCartTestNG.xml'
			}
		}
	}
}