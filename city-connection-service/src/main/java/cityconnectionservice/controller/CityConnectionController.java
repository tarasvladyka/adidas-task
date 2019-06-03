package cityconnectionservice.controller;

import cityconnectionservice.dto.CityConnectionsResponse;
import cityconnectionservice.domain.CityConnection;
import cityconnectionservice.service.CityConnectionService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/connections")
public class CityConnectionController implements SwaggerHat4CityConnectionController {

    private static Logger logger = LoggerFactory.getLogger(CityConnectionController.class);

    @Autowired
    private final CityConnectionService cityConnectionService;

    public CityConnectionController(CityConnectionService cityConnectionService) {
        this.cityConnectionService = cityConnectionService;
    }

    @GetMapping
    public CityConnectionsResponse getCityConnections(@RequestParam(required = false) String from)  {
        if(StringUtils.isEmpty(from)) {
            List<CityConnection> cityConnections = cityConnectionService.getAll();
            logger.info("Getting all connections, found " + cityConnections.size() + " connections");
            return new CityConnectionsResponse(cityConnections);
        }
        List<CityConnection> cityConnections = cityConnectionService.getAllFromCity(from.toUpperCase());
        logger.info("Getting city connections from: " + from + ", found " + cityConnections.size() + " connections");
        return new CityConnectionsResponse(cityConnections);
    }
}
