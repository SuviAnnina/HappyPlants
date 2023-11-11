package omaprojekti.happyplants.Webcontroller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.validation.Valid;
import omaprojekti.happyplants.Domain.Cutting;
import omaprojekti.happyplants.Domain.CuttingRepository;

@CrossOrigin
@Controller
public class CuttingRestController {

    @Autowired
    private CuttingRepository cuttingRepository;

    /* Listaa kaikki Cutting-luokan javaoliot JSON listaksi */
    @GetMapping("/cuttings")
    public @ResponseBody List<Cutting> cuttingListRest() {
        return (List<Cutting>) cuttingRepository.findAll();
    }

    /* Etsii pistokkaan (cutting) id:n perusteella ja palauttaa sen JSON muodossa */
    @GetMapping("/cuttings/{id}")
    public @ResponseBody Optional<Cutting> findCuttingRest(@PathVariable("id") Long cuttingId) {
        return cuttingRepository.findById(cuttingId);
    }

    /*
     * http://localhost:8080/api/cuttings/search/findByCuttingName?name=Juoru
     */
    /* etsii pistokkaan nimen perusteella tietokannasta */
    @GetMapping("/search")
    public @ResponseBody List<Cutting> searchCuttingsByName(@RequestParam("cuttingName") String cuttingName) {
        return cuttingRepository.findByCuttingName(cuttingName);
    }

    /* Tallentaa uuden pistokkaan tietokantaan */
    @PostMapping("/cuttings")
    public @ResponseBody Cutting saveCuttingRest(@Valid @RequestBody Cutting cutting) {
        return cuttingRepository.save(cutting);
    }
}