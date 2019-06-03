package cityconnectionservice.repository;

import cityconnectionservice.domain.CityConnection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityConnectionRepository extends JpaRepository<CityConnection, Long> {

    List<CityConnection> findAllByOrigCityCode(String cityCode);

}
