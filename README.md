# Viewing book (microservices arhitecture)

## About
viewingbook -  application that allows you to keep records of viewed titles using a microservice architecture.

### Spring 
Spring-MVC part - contains all the basic logic of the MVC architecture of the entire application. This microservice is responsible for recognizing http requests, maintaining the Notebook database, and storing the session token.
### Spring-Auth 
Registration-MVC part - includes generating a session token using the Bcrypt library and algorithm, registering the user and storing his data as a hash in the database for greater security, and verifying the entered data for user authorization.
### Spring-API-Gateway 
Api-GateWay part - is the connecting link of all services, serves to combine and reduce the number of generated tokens (one token received during authorization is enough), transfers one session token to all services and redirects it to the necessary api gateway based on the design pattern.

## Services links
- Spring : https://github.com/TaarMaan/Spring
- Auth-Spring : https://github.com/TaarMaan/SpringAuth
- API-Gateway-Spring : https://github.com/TaarMaan/SpringAuth
