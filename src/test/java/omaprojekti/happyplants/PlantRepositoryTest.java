package omaprojekti.happyplants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import omaprojekti.happyplants.Domain.Plant;
import omaprojekti.happyplants.Domain.PlantRepository;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.jupiter.api.Test;

@DataJpaTest
public class PlantRepositoryTest {

    @Autowired
    private PlantRepository plantRepository;

    /* Testataan että uusi kasvi saadaan lisättyä ja tallennettua tietokantaan */
    @Test
    public void createNewPlantTest() {
        Plant plant = new Plant("Testplant", "Test description");
        plantRepository.save(plant);
        assertThat(plant.getPlantId()).isNotNull();
    }

    /* Testataan että tietokannasta löydetään lisätty kasvi */
    @Test
    public void searchPlantByPlantName() {
        Plant plant = new Plant("Testplant", "Test description");
        plantRepository.save(plant);
        List<Plant> findPlant = plantRepository.findByPlantName("Testplant");
        assertThat(findPlant.get(0).getPlantName()).isEqualTo("Testplant");
    }

    /* Testataan että kasvi saadaan poistettua tietokannasta */
    @Test
    public void deletePlantTest() {
        Plant plant = new Plant("Testplant", "Test description");
        plantRepository.save(plant);
        plantRepository.deleteById(plant.getPlantId());
        boolean plantExists = plantRepository.existsById(plant.getPlantId());
        assertThat(plantExists).isFalse();
    }

    /* Testataan että kasvin tietoja voidaan muuttaa */
    @Test
    public void editPlantInfoTest() {
        Plant plant = new Plant("Testplant", "Test description");
        plantRepository.save(plant);

        Plant currentPlant = plantRepository.findById(plant.getPlantId()).orElse(null);

        currentPlant.setPlantName("Plant test");
        currentPlant.setPlantDescription("Description test");
        plantRepository.save(currentPlant);

        assertThat(currentPlant.getPlantDescription()).isEqualTo("Description test");
    }
}