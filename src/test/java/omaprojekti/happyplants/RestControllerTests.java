package omaprojekti.happyplants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import omaprojekti.happyplants.Webcontroller.CuttingRestController;
import omaprojekti.happyplants.Webcontroller.PlantRestController;
import omaprojekti.happyplants.Webcontroller.SpeciesRestController;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

@SpringBootTest
public class RestControllerTests {

    @Autowired
    private CuttingRestController cuttingRestController;

    @Autowired
    private PlantRestController plantRestController;

    @Autowired
    private SpeciesRestController speciesRestController;

    /* Testataan, latautuvatko RestController luokat */
    @Test
    public void restControllerLoads() {
        assertThat(cuttingRestController).isNotNull();
        assertThat(plantRestController).isNotNull();
        assertThat(speciesRestController).isNotNull();
    }
}