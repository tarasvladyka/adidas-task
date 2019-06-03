package cityconnectionservice.service.impl;

import cityconnectionservice.repository.CityConnectionRepository;
import cityconnectionservice.service.CityConnectionService;
import cityconnectionservice.domain.CityConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityConnectionServiceImpl implements CityConnectionService {

    @Autowired
    private final CityConnectionRepository cityConnectionRepository;

    public CityConnectionServiceImpl(CityConnectionRepository cityConnectionRepository) {
        this.cityConnectionRepository = cityConnectionRepository;
    }

    @Override
    public List<CityConnection> getAll() {
        return cityConnectionRepository.findAll();
    }

    @Override
    public List<CityConnection> getAllFromCity(String cityCode) {
        return cityConnectionRepository.findAllByOrigCityCode(cityCode);
    }
}
