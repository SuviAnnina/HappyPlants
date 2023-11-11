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
import org.springframework.web.bind.annotation.ResponseBody;
import jakarta.validation.Valid;
import omaprojekti.happyplants.Domain.Species;
import omaprojekti.happyplants.Domain.SpeciesRepository;

@CrossOrigin
@Controller
public class SpeciesRestController {

    @Autowired
    private SpeciesRepository speciesRepository;

    /* Listaa kaikki Species-luokan javaoliot JSON listaksi */
    @GetMapping("/species")
    public @ResponseBody List<Species> speciesListRest() {
        return (List<Species>) speciesRepository.findAll();
    }

    /* Etsii lajin (species) id:n perusteella ja palauttaa sen JSON muodossa */
    @GetMapping("/species/{id}")
    public @ResponseBody Optional<Species> findSpeciesRest(@PathVariable("id") Long speciesId) {
        return speciesRepository.findById(speciesId);
    }

    /* Tallentaa uuden lajin (species) */
    @PostMapping("/species")
    public @ResponseBody Species saveSpeciesRest(@Valid @RequestBody Species species) {
        return speciesRepository.save(species);
    }
}