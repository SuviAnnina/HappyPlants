package omaprojekti.happyplants;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import omaprojekti.happyplants.Webcontroller.CuttingController;
import omaprojekti.happyplants.Webcontroller.PlantController;
import omaprojekti.happyplants.Webcontroller.SpeciesController;
import omaprojekti.happyplants.Webcontroller.UserController;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class HappyplantsApplicationTests {

	@Autowired
	private SpeciesController speciesController;

	@Autowired
	private PlantController plantController;

	@Autowired
	private CuttingController cuttingController;

	@Autowired
	private UserController userController;

	/* Testataan, latautuvatko Controller luokat */
	@Test
	void contextLoads() {
		assertThat(speciesController).isNotNull();
		assertThat(plantController).isNotNull();
		assertThat(cuttingController).isNotNull();
		assertThat(userController).isNotNull();
	}
}