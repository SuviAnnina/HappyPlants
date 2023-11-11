package omaprojekti.happyplants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import omaprojekti.happyplants.Domain.Species;
import omaprojekti.happyplants.Domain.SpeciesRepository;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.jupiter.api.Test;

@DataJpaTest
public class SpeciesRepositoryTest {

    @Autowired
    private SpeciesRepository speciesRepository;

    /* Testataan että uusi laji (Species) saadaan lisättyä ja tallennettua */
    @Test
    public void createNewSpeciesTest() {
        Species species = new Species("Speciestest");
        speciesRepository.save(species);
        assertThat(species.getSpeciesId()).isNotNull();
    }

    /* Testataan että tietokannasta löydetään lisätty laji (Species) */
    @Test
    public void searchSpeciesByLatinNameTest() {
        Species species = new Species("Fancy Name");
        speciesRepository.save(species);
        List<Species> findSpecies = speciesRepository.findBySpeciesLatinName("Fancy Name");
        assertThat(findSpecies.get(0).getSpeciesLatinName()).isEqualTo("Fancy Name");
    }

    /* Testataan että laji (Species) saadaan poistettua tietokannasta */
    @Test
    public void deleteSpeciesTest() {
        Species species = new Species("Speciestest");
        speciesRepository.save(species);
        speciesRepository.deleteById(species.getSpeciesId());
        boolean speciesExists = speciesRepository.existsById(species.getSpeciesId());
        assertThat(speciesExists).isFalse();
    }

    /* Testataan että lajin (Species) tietoja voidaan muokata */
    @Test
    public void editSpeciesInfoTest() {
        Species species = new Species("Fancy Name", "Great plant");
        speciesRepository.save(species);

        Species currentSpecies = speciesRepository.findById(species.getSpeciesId()).orElse(null);

        currentSpecies.setSpeciesLatinName("Fancy Latin Name");
        currentSpecies.setSpeciesDescription("Great And Fancy Plant");
        speciesRepository.save(currentSpecies);

        assertThat(currentSpecies.getSpeciesDescription()).isEqualTo("Great And Fancy Plant");

    }
}