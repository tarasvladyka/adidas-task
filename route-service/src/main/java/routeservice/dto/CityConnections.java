package routeservice.dto;

import java.util.List;

public class CityConnections {

    private List<CityConnection> cityConnections;

    public CityConnections() {
    }

    public CityConnections(List<CityConnection> cityConnections) {
        this.cityConnections = cityConnections;
    }

    public List<CityConnection> getCityConnections() {
        return cityConnections;
    }

    public void setCityConnections(List<CityConnection> cityConnections) {
        this.cityConnections = cityConnections;
    }
}
