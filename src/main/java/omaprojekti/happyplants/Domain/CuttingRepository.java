package omaprojekti.happyplants.Domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CuttingRepository extends CrudRepository<Cutting, Long> {

    List<Cutting> findByCuttingName(String name);
}
