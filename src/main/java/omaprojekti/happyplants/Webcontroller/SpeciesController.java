package omaprojekti.happyplants.Webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/* import omaprojekti.happyplants.Domain.PlantRepository; */
import omaprojekti.happyplants.Domain.Species;
import omaprojekti.happyplants.Domain.SpeciesRepository;

@Controller
public class SpeciesController {

    @Autowired
    private SpeciesRepository speciesRepository;

    /*
     * @Autowired
     * private PlantRepository plantRepository;
     */

    /* Listaa kaikki lajikkeet (species) */
    @GetMapping("/specieslist")
    public String listAllSpecies(Model model) {
        model.addAttribute("allSpecies", speciesRepository.findAll());
        return "specieslist";
    }

    /* Poistaa valitun lajikkeen id:n perusteella */
    @GetMapping("/deletespecies/{id}")
    public String deleteSpecies(@PathVariable("id") Long speciesId, Model model) {
        speciesRepository.deleteById(speciesId);
        return "redirect:/specieslist";
    }

    /* Valitaan muokattava lajike id:n perusteella */
    @GetMapping("/editspecies/{id}")
    public String editSpecies(@PathVariable("id") Long speciesId, Model model) {
        Species species = speciesRepository.findById(speciesId).orElse(null);
        if (species != null) {
            model.addAttribute("species", species);
            /* model.addAttribute("plants", plantRepository.findAll()); */
        }
        return "editspecies";
    }
    /* Tarvitaanko planttia tähän? Tarkista */

    /* Uuden lajikkeen lisäys */
    @GetMapping("/addspecies")
    public String addSpecies(Model model) {
        model.addAttribute("species", new Species());
        /* model.addAttribute("plants", plantRepository.findAll()); */
        return "addspecies";
    }

    /* Uuden lajikkeen tallennus */
    @PostMapping("/saveSpecies")
    public String saveSpecies(Species species) {
        speciesRepository.save(species);
        return "redirect:/specieslist";
    }

    /* Päivittää muokatun lajikkeen tiedot vanhojen tilalle */
    @PostMapping("/updateSpecies")
    public String updateSpecies(@ModelAttribute("species") Species updatedSpecies) {
        Long speciesId = updatedSpecies.getSpeciesId();
        Species currentSpecies = speciesRepository.findById(speciesId).orElse(null);

        if (currentSpecies != null) {
            currentSpecies.setSpeciesLatinName(updatedSpecies.getSpeciesLatinName());
            currentSpecies.setSpeciesDescription(updatedSpecies.getSpeciesDescription());

            speciesRepository.save(currentSpecies);
        }
        return "redirect:/specieslist";
    }
}
