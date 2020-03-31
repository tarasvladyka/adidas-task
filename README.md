

# Fastest route search app

This application designed to search the fastest route between citites using **jgrapht** library and **Dijkstra** algo.
Application consists of 2 micro-services and discovery service:

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
 - In order to build the components from command line, go to **root** folder and execute next command:
	`mvn clean package`
	
### Run
1. You can run this app using one of the ways:
 - As docker multicontainer app using:
   	`docker-compose up` 
   	
 - Separately, as jar files from console(make
   sure, run the **discovery-service** first, then the **connection-service,**
   and **route-service**) 
   `java -jar <path-to-jar>`
 - From your IDE by just  starting the `main` methods of each service(keep the order, see prev point)
2. Initial data needed to get app work located in `/resources/data.sql` in `city-connection-service`. These scripts are executed when app starts
3. App uses embedded DB, so you don't have to worry about setuping external DB
 
### How to use the app
1.Firstly execute:

`GET` `http://localhost:9600/connections` 

via REST client, or swagger to see the list of connections between cities. You will receive the response with some already predefined data:
```json
{
  "code": "SUCCESS",
  "message": "Operation performed successfully",
  "cityConnections": [
    {
      "id": 1,
      "origCityCode": "LVIV",
      "destCityCode": "LUTSK",
      "departureTime": "2019-05-29T22:00:00",
      "arrivalTime": "2019-05-30T01:00:00"
    },
    {
      "id": 2,
      "origCityCode": "LUTSK",
      "destCityCode": "RIVNE",
      "departureTime": "2019-05-29T15:00:00",
      "arrivalTime": "2019-05-29T16:00:00"
    }
	....
	....
  ]
}
```
2.Then:

`GET` `http://localhost:9610/routes?from=LVIV&to=KYIV&type=LESS_TIME`

This will give you the **shortest route by time** travelling between `LVIV` and `KYIV`. Here is response which you will receive:
```json
{
  "code": "SUCCESS",
  "message": "Operation performed successfully",
  "type": "LESS_TIME",
  "origCity": "LVIV",
  "destCity": "KYIV",
  "connections": 2,
  "totalTravelTime": 8,
  "routeParts": [
    {
      "from": "LVIV",
      "to": "TERNOPIL",
      "travelTime": 2
    },
    {
      "from": "TERNOPIL",
      "to": "ZHYTOMYR",
      "travelTime": 3
    },
    {
      "from": "ZHYTOMYR",
      "to": "KYIV",
      "travelTime": 3
    }
  ]
}
```

### API documentation(Swagger)
You can try to interact with the services through swagger:

**city-connection-service**: `localhost:9600/swagger-ui.html`

**route-service**: `localhost:9610/swagger-ui.html`

###  Eureka dashboard
Eureka dashboard can be accessed using link:  `localhost:8761`
