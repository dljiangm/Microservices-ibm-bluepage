# Microservice-ibm-bluepage

# What it is for?
	Get bluepage info for an IBMer.

# What is feature?
	It is a Spring boot web applicaion. Simpe and Light, since Micorservice is very hot in IBM.
	
# How to run?
	Spring boot application:
	1. Build jar file after download code. Jar file example: Micro-ibm-bulepage-1.0.jar
	2. Start the applicaion in server. Command example: java -jar "filepath"/Micro-ibm-bluepage-1.0.jar
	
	Docker:
	1. Find the Dockerfile in project folder /docker.
	2. Go to the /docker foler and copy Micro-ibm-bluepage-1.0.jar into /docker folder.
	3. Build image with command 'docker build -t bluepage .'.
	4. Run docker container with command 'docker run -itd -p 8002:8002 --restart=always bluepage'.
	
# How to call the application and get bluepage info?
	The application applies a RESTful API via HTTP + GET + JSON, default port is 800.
	Example url: http://localhost:8002/bluepage/xxxxx@xx.ibm.com
	"xxxxx@xx.ibm.com" is the e-mail id that you need to pass via the API.
	
# What will have in future?
	1. Enable Eureka registry based on Spring cloud.
	2. Apply XML response.
