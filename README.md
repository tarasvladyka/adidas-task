
# Shortest route search app

This application designed to search the fastest route between citites using **jgrapht** library and **Dijkstra** algo.
Application consists of 3 services:

1. **city-connection-service** (provides the travel time data between cities)
2. **route-service** (provides ability to search the fastest route, by time and connections between cities)
3. **discovery-service** (used to register and discover  microservices)

Application build using Spring Boot and Spring cloud(Netflix Eureka) + H2 in-memory database. Also swagger available as a API documentation.

## Getting started
### Prerequisites
In order to run this application you will need:

- JDK 8
- Maven 3.3 or later	
- Docker


### Build an run
1. In order to build the components from command line, go to root folder and execute next command:
	`mvn clean package`

2. Run the apps in docker:
	`docker-compose up`



### API documentation(Swagger)
You can try the services through swagger:

**city-connection-service**: `localhost:9600/swagger-ui.html`

**route-service**: `localhost:9610/swagger-ui.html`