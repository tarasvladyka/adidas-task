package cityconnectionservice.dto;

import cityconnectionservice.domain.CityConnection;

import java.util.List;

public class CityConnectionsResponse extends ApiResponse {

    private List<CityConnection> cityConnections;

    public CityConnectionsResponse(List<CityConnection> cityConnections) {
        this.cityConnections = cityConnections;
    }

    public List<CityConnection> getCityConnections() {
        return cityConnections;
    }

    public void setCityConnections(List<CityConnection> cityConnections) {
        this.cityConnections = cityConnections;
    }
}
