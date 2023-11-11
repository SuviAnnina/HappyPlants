package omaprojekti.happyplants.Domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface SpeciesRepository extends CrudRepository<Species, Long> {
    List<Species> findBySpeciesLatinName(String speciesLatinName);

    List<Species> findBySpeciesDescription(String speciesDescription);
}