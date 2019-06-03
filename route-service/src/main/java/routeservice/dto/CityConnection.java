package routeservice.dto;

import org.jgrapht.graph.DefaultWeightedEdge;

import java.time.LocalDateTime;

public class CityConnection extends DefaultWeightedEdge {

    private String origCityCode;
    private String destCityCode;
    private LocalDateTime arrivalTime;
    private LocalDateTime departureTime;

    public String getOrigCityCode() {
        return origCityCode;
    }

    public void setOrigCityCode(String origCityCode) {
        this.origCityCode = origCityCode;
    }

    public String getDestCityCode() {
        return destCityCode;
    }

    public void setDestCityCode(String destCityCode) {
        this.destCityCode = destCityCode;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }
}
