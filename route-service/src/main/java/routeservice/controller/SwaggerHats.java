package routeservice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import routeservice.dto.RouteDetails;
import routeservice.enums.RouteType;

@Api(value="route", tags = "route operations")
interface SwaggerHat4RouteController {

    @ApiOperation(value="Compiles the route between cities using provided route type")
    RouteDetails getRoute(@ApiParam(value = "Desired route type") RouteType type, String from, String to);
}
