## How to run Webserver (Encoding project)

Use IntelliJ IDEA to create new project

#### Clone project
> git clone https://github.com/kinhquocnguyen/lightfeather.git

#### Start Tomcat Server
> Run the main class com.lightleather.encoding.EncodingApplication

#### Test Encoding Service
> Send POST request http://localhost:23456/api/encoding (recommend to use Postman)
with below Json content: 
Scenerio 1 (): success with Status 200 
{
	"shift": 3,
	"message": "abcd"
}
Result:
{
    "encodedMessage": "defg"
}

Scenerio 2: fail with Status 500
{
	"shift": 3,
	"message": "12222"
}
Result:
{
    "timestamp": "2020-04-08T03:09:30.185+0000",
    "status": 500,
    "error": "Internal Server Error",
    "message": "Cannot encode the message!",
    "path": "/api/encoding"
}


#### Open the url on browser to test
http://localhost:4200


## How to run Web Component (Sign Up form project)

The project is using Node.js (node-v13.12.0.pkg) and Angular framework version 9.0.7. 
Node.js can be downloaded from https://nodejs.org/en/. After download Node.js, please follow the below steps.
Run the commands using windows command or linux terminal

#### Clone project
> git clone https://github.com/kinhquocnguyen/lightfeather.git

> cd signup

#### Install npm package
> npm install

#### Start the Angular application
> ng serve

#### Open the url on browser to test
http://localhost:4200
