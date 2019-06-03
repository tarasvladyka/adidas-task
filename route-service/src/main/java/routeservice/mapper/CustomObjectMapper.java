package routeservice.mapper;

import org.jgrapht.alg.DijkstraShortestPath;
import routeservice.dto.CityConnection;
import routeservice.dto.RouteDetails;

public interface CustomObjectMapper {

    RouteDetails map(DijkstraShortestPath<String, CityConnection> path);
}
