package cityconnectionservice.controller;

import cityconnectionservice.dto.CityConnectionsResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value="City connections", tags = "city connection", description="Operations with departure/arrival data for trips between cities")
interface SwaggerHat4CityConnectionController {

    @ApiOperation(value="Get connections from the specified city(if no params - returns all connections)")
    CityConnectionsResponse getCityConnections(@ApiParam(value = "City code") String from);
}
