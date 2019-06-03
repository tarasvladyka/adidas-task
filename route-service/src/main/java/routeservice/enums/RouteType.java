package routeservice.enums;

public enum RouteType {
    LESS_CONNECTIONS,
    LESS_TIME;

    public static RouteType of(String s) {
        for(RouteType routeType : RouteType.values()) {
            if(routeType.name().equalsIgnoreCase(s)) {
                return routeType;
            }
        }
        return null;
    }
}
