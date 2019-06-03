package routeservice.builder;

import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.DirectedWeightedMultigraph;
import org.jgrapht.graph.SimpleDirectedGraph;
import routeservice.dto.CityConnection;
import routeservice.dto.CityConnections;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class CityConnectionsGraphBuilder {

    private DirectedGraph<String, CityConnection> target;

    private CityConnections cityConnections;

    public DirectedGraph<String, CityConnection> buildWeightedGraph(CityConnections cityConnections){
        this.target = new DirectedWeightedMultigraph<>(CityConnection.class);
        this.cityConnections = cityConnections;
        addVertexes();
        addWeightedEdges();
        return target;
    }

    public DirectedGraph<String, CityConnection> buildSimpleGraph(CityConnections cityConnections){
        this.target = new SimpleDirectedGraph<>(CityConnection.class);
        this.cityConnections = cityConnections;
        addVertexes();
        addSimpleEdges();
        return target;
    }

    private void addVertexes() {
        cityConnections.getCityConnections().forEach(c-> {
            target.addVertex(c.getOrigCityCode());
            target.addVertex(c.getDestCityCode());
        });
    }

    private void addSimpleEdges() {
        cityConnections.getCityConnections().forEach(c-> {
            target.addEdge(c.getOrigCityCode(), c.getDestCityCode(), c);
        });
    }

    private void addWeightedEdges() {
        cityConnections.getCityConnections().forEach(c-> {
            target.addEdge(c.getOrigCityCode(), c.getDestCityCode(), c);
            ((DirectedWeightedMultigraph)target).setEdgeWeight(c, Duration.between(c.getDepartureTime(), c.getArrivalTime()).get(ChronoUnit.SECONDS));
        });
    }
}
