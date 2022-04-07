# Ticket Garage Automation

## Database Configuration
The project using the H2 database. The db name is garagedb and it is working with default configurations.
For help on other issues related to the H2 database, you can go to the relevant link:
https://www.baeldung.com/spring-boot-h2-database

## Application Configuration
The project is developed with Spring Boot. If you start the project on your localhost, 
you can access on the 8080 port. 

## Endpoints

### Park Service:
````
POST /api/cars/park HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Content-Length: 77

{
    "plate": "34-SO-1938",
    "colour": "Black",
    "type": "TRUCK"
}
````

### Status Service:
````
GET /api/cars/status HTTP/1.1
Host: localhost:8080
````

### Leave Service:
````
POST /api/cars/leave HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Content-Length: 47

{
    "ticket": "202204072241Black34SO1932"
}
````