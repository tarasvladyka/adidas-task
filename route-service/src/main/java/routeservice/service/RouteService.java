package routeservice.service;

import routeservice.dto.RouteDetails;

public interface RouteService {

    RouteDetails getRouteByLessTime(String from, String to);

    RouteDetails getRouteByLessConnections(String from, String to);
}
