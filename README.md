# simple-rest-service

Simple Rest service using Spring MVC and Boot with minimal configuration 

uses redis/jedis driver see beans.xml for config 

for docker run using
docker run -p 6379:6379 redis


Compile as maven project 

mvn clean install 

Execute from

Application.java


AddName POST call http://localhost:8080/addName?firstname=James&lastname=Bond

GetName GET call http://localhost:8080/getName?firstname=James

payload

{
  "firstName": "Jason",
  "lastName": "Bourne",
  "phone": "000-000-000",
  "email": "secret@gmail.com"
}
