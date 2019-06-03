package cityconnectionservice.dto;

public class CityConnectionDto {

    private String departureCityCode;

    private String arrivalCityCode;

    private String departureTime;

    private String arrivalTime;

    public CityConnectionDto(String departureCityCode, String arrivalCityCode, String departureTime, String arrivalTime) {
        this.departureCityCode = departureCityCode;
        this.arrivalCityCode = arrivalCityCode;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureCityCode() {
        return departureCityCode;
    }

    public void setDepartureCityCode(String departureCityCode) {
        this.departureCityCode = departureCityCode;
    }

    public String getArrivalCityCode() {
        return arrivalCityCode;
    }

    public void setArrivalCityCode(String arrivalCityCode) {
        this.arrivalCityCode = arrivalCityCode;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}
