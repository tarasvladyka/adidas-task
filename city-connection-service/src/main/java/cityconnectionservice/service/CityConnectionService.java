package cityconnectionservice.service;

import cityconnectionservice.domain.CityConnection;

import java.util.List;

public interface CityConnectionService {

    List<CityConnection> getAll();

    List<CityConnection> getAllFromCity(String cityCode);
}
