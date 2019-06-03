package routeservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import routeservice.dto.CityConnections;
import routeservice.service.CityConnectionService;

@Service
public class CityConnectionServiceImpl implements CityConnectionService {

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public CityConnections getAll() {
        return restTemplate.getForObject("http://city-connection-service/connections", CityConnections.class);
    }
}
