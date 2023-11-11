package omaprojekti.happyplants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import omaprojekti.happyplants.Domain.Cutting;
import omaprojekti.happyplants.Domain.CuttingRepository;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.jupiter.api.Test;

@DataJpaTest
public class CuttingRepositoryTest {

    @Autowired
    private CuttingRepository cuttingRepository;

    /* Testataan että uusi pistoks (Cutting) saadaan lisättyä tietokantaan */
    @Test
    public void createNewCuttingTest() {
        Cutting cutting = new Cutting("Cuttingtest", "Test description");
        cuttingRepository.save(cutting);
        assertThat(cutting.getCuttingId()).isNotNull();
    }

    /* Testataan että pistokas (Cutting) löytyy tietokannasta */
    @Test
    public void searchCuttingByCuttingName() {
        Cutting cutting = new Cutting("Cuttingtest", "Test description");
        cuttingRepository.save(cutting);
        List<Cutting> findCutting = cuttingRepository.findByCuttingName("Cuttingtest");
        assertThat(findCutting.get(0).getCuttingName()).isEqualTo("Cuttingtest");
    }

    /* Testataan että pistokas (Cutting) saadaan poistettua tietokannasta */
    @Test
    public void deleteCuttingTest() {
        Cutting cutting = new Cutting("Cuttingtest", "Test description");
        cuttingRepository.save(cutting);
        cuttingRepository.deleteById(cutting.getCuttingId());
        boolean cuttingExists = cuttingRepository.existsById(cutting.getCuttingId());
        assertThat(cuttingExists).isFalse();
    }

    /* Testaan että pistokkaan (Cutting) tietoja voidaan muokata */
    @Test
    public void editCuttingInfoTest() {
        Cutting cutting = new Cutting("Cuttingtest", "Test description");
        cuttingRepository.save(cutting);

        Cutting currenCutting = cuttingRepository.findById(cutting.getCuttingId()).orElse(null);

        currenCutting.setCuttingName("Test cutting");
        currenCutting.setCuttingDescription("Description test");
        cuttingRepository.save(currenCutting);

        assertThat(currenCutting.getCuttingDescription()).isEqualTo("Description test");
    }
}