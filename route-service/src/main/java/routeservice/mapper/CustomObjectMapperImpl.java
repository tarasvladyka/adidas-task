package routeservice.mapper;

import org.jgrapht.alg.DijkstraShortestPath;
import org.springframework.stereotype.Component;
import routeservice.dto.CityConnection;
import routeservice.dto.RouteDetails;

import java.time.Duration;
import java.util.stream.Collectors;

@Component
public class CustomObjectMapperImpl implements CustomObjectMapper {

    @Override
    public RouteDetails map(DijkstraShortestPath<String, CityConnection> path) {
        return new RouteDetails()
                .setConnections(path.getPathEdgeList().size() - 1L)
                .setTotalTravelTime(path.getPathEdgeList().stream()
                        .map(c->Duration.between(c.getDepartureTime(), c.getArrivalTime()))
                        .reduce(Duration::plus)
                        .get().toHours())
                .setRouteParts(
                        path.getPathEdgeList()
                                .stream().map(c-> new RouteDetails.RoutePart(
                                        c.getOrigCityCode(),
                                        c.getDestCityCode(),
                                        Duration.between(c.getDepartureTime(), c.getArrivalTime()).toHours()))
                                .collect(Collectors.toList()));
    }
}
