package routeservice.service.impl;

import org.jgrapht.DirectedGraph;
import org.jgrapht.alg.ConnectivityInspector;
import org.jgrapht.alg.DijkstraShortestPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import routeservice.builder.CityConnectionsGraphBuilder;
import routeservice.dto.CityConnection;
import routeservice.dto.RouteDetails;
import routeservice.enums.RouteType;
import routeservice.exception.CompileRouteException;
import routeservice.mapper.CustomObjectMapper;
import routeservice.service.CityConnectionService;
import routeservice.service.RouteService;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private final CityConnectionService cityConnectionService;

    @Autowired
    private CustomObjectMapper customObjectMapper;

    public RouteServiceImpl(CityConnectionService cityConnectionService) {
        this.cityConnectionService = cityConnectionService;
    }

    @Override
    public RouteDetails getRouteByLessConnections(String from, String to) {
        DirectedGraph<String, CityConnection> graph = new CityConnectionsGraphBuilder().buildSimpleGraph(cityConnectionService.getAll());
        checkRouteExists(graph, from, to);
        DijkstraShortestPath<String, CityConnection> path = new DijkstraShortestPath<>(graph, from, to);

        return customObjectMapper.map(path)
                .setOrigCity(from)
                .setDestCity(to)
                .setType(RouteType.LESS_CONNECTIONS);
    }

    @Override
    public RouteDetails getRouteByLessTime(String from, String to) {
        DirectedGraph<String, CityConnection> graph = new CityConnectionsGraphBuilder().buildWeightedGraph(
                cityConnectionService.getAll());

        checkRouteExists(graph, from, to);
        DijkstraShortestPath<String, CityConnection> path = new DijkstraShortestPath<>(graph, from, to);

        return customObjectMapper.map(path)
                .setOrigCity(from)
                .setDestCity(to)
                .setType(RouteType.LESS_TIME);
    }

    private void checkRouteExists(DirectedGraph<String, CityConnection> graph, String from, String to) {
        if(!graph.containsVertex(from) || !graph.containsVertex(to) || !new ConnectivityInspector<>(graph).pathExists(from, to)) {
            throw new CompileRouteException();
        }
    }
}
