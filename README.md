

# Fastest route search app

This application designed to search the fastest route between citites using **jgrapht** library and **Dijkstra** algo.
Application consists of 3 services:

1. **city-connection-service** (provides the travel time data between cities)
2. **route-service** (provides ability to search the fastest route, by time and connections between cities)
3. **discovery-service** (used to register and discover  microservices)

## Technologies used

 - Spring boot 2.1.5
- Spring cloud netflix eureka (Greenwich.SR1 version)
- java 8
- maven 3.3
- docker engine 18.09.2
- h2 database
- jgrapht 0.7.3
- swagger 2.9.2

## Getting started
### Prerequisites
In order to run this application you will need:

- JDK 8
- Maven 3.3 or later	
- Docker(optional)


### Build
 - In order to build the components from command line, go to root folder and execute next command:
	`mvn clean package`
	
### Run
 - You can either run it as docker multicontainer app using:
   	`docker-compose up` 
   	
 - Or separately, as jar files from console(make
   sure, run the **discovery-service** first, then the **connection-service,**
   and r**oute-service**) 
   `java -jar <path-to-jar>`
 - Or from your IDE by just  starting the main methods of the services(remember the order, see prev point)

### API documentation(Swagger)
You can try the services through swagger:

**city-connection-service**: `localhost:9600/swagger-ui.html`

**route-service**: `localhost:9610/swagger-ui.html`

###  Eureka dashboard
Eureka dashboard can be accessed using link:  `localhost:8761`
