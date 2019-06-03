package routeservice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import routeservice.dto.RouteDetails;
import routeservice.enums.RouteType;
import routeservice.service.CityConnectionService;
import routeservice.service.RouteService;

@RestController
@RequestMapping(path = "/routes")
@Api(value="route", tags = "route operations")
public class RouteController {

    private static Logger logger = LoggerFactory.getLogger(RouteController.class);

    @Autowired
    private final CityConnectionService cityConnectionService;

    @Autowired
    private final RouteService routeService;

    public RouteController(CityConnectionService cityConnectionService, RouteService routeService) {
        this.cityConnectionService = cityConnectionService;
        this.routeService = routeService;
    }

    @GetMapping
    @ApiOperation(value="Compiles the route between cities using provided route type")
    public RouteDetails getRoute(@ApiParam(value = "Desired route type") @RequestParam RouteType type, @RequestParam String from, @RequestParam String to) {
        logger.info("Compiling route from " + from + " to " + to + ", type=" + type);
        RouteDetails routeDetails;
        if(RouteType.LESS_TIME == type) {
            routeDetails = routeService.getRouteByLessTime(from, to);
        } else {
            routeDetails = routeService.getRouteByLessConnections(from, to);
        }
        logger.info("Compiled route: " + routeDetails);
        return routeDetails;
    }
}
