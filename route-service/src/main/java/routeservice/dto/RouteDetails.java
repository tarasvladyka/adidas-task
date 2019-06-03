package routeservice.dto;

import routeservice.enums.RouteType;

import java.util.List;

public class RouteDetails extends ApiResponse {

    private RouteType type;
    private String origCity;
    private String destCity;
    private Long connections;
    private Long totalTravelTime;
    private List<RoutePart> routeParts;
    public RouteType getType() {
        return type;
    }

    public RouteDetails setType(RouteType type) {
        this.type = type;
        return this;
    }

    public String getOrigCity() {
        return origCity;
    }

    public RouteDetails setOrigCity(String origCity) {
        this.origCity = origCity;
        return this;
    }

    public String getDestCity() {
        return destCity;
    }

    public RouteDetails setDestCity(String destCity) {
        this.destCity = destCity;
        return this;
    }

    public Long getConnections() {
        return connections;
    }

    public RouteDetails setConnections(Long connections) {
        this.connections = connections;
        return this;
    }

    public Long getTotalTravelTime() {
        return totalTravelTime;
    }

    public RouteDetails setTotalTravelTime(Long totalTravelTime) {
        this.totalTravelTime = totalTravelTime;
        return this;
    }

    public List<RoutePart> getRouteParts() {
        return routeParts;
    }

    public RouteDetails setRouteParts(List<RoutePart> routeParts) {
        this.routeParts = routeParts;
        return this;
    }

    @Override
    public String toString() {
        return "RouteDetails{" +
                "type=" + type +
                ", from='" + origCity + '\'' +
                ", to='" + destCity + '\'' +
                ", connections=" + connections +
                ", totalTravelTime=" + totalTravelTime +
                ", routeParts=" + routeParts +
                '}';
    }

    public static class RoutePart {

        private String from;
        private String to;
        private Long travelTime;

        public RoutePart(String from, String to, Long travelTime) {
            this.from = from;
            this.to = to;
            this.travelTime = travelTime;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getTo() {
            return to;
        }

        public void setTo(String to) {
            this.to = to;
        }

        public Long getTravelTime() {
            return travelTime;
        }

        public RoutePart setTravelTime(Long travelTime) {
            this.travelTime = travelTime;
            return this;
        }

        @Override
        public String toString() {
            return "RoutePart{" +
                    "from='" + from + '\'' +
                    ", to='" + to + '\'' +
                    ", travelTime=" + travelTime +
                    '}';
        }
    }
}
