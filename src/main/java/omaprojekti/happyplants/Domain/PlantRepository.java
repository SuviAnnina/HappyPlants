package omaprojekti.happyplants.Domain;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface PlantRepository extends CrudRepository<Plant, Long> {
    Optional<Plant> findById(Long plantId);

    List<Plant> findByPlantName(String plantName);
}