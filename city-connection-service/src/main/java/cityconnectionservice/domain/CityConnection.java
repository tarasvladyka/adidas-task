package cityconnectionservice.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="city_connection")
public class CityConnection {

    @Id
    private Long id;

    @Column(name="orig_city_code")
    private String origCityCode;

    @Column(name="dest_city_code")
    private String destCityCode;

    @Column(name="departure_time")
    private LocalDateTime departureTime;

    @Column(name="arrival_time")
    private LocalDateTime arrivalTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}
