package omaprojekti.happyplants.Webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import omaprojekti.happyplants.Domain.Species;
import omaprojekti.happyplants.Domain.SpeciesRepository;

@Controller
public class SpeciesController {

    @Autowired
    private SpeciesRepository speciesRepository;

    /* Listaa kaikki lajikkeet (species) */
    @GetMapping("/specieslist")
    public String listAllSpecies(Model model) {
        model.addAttribute("allSpecies", speciesRepository.findAll());
        return "specieslist";
    }

    /* Poistaa valitun lajikkeen id:n perusteella */
    @GetMapping("/deletespecies/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteSpecies(@PathVariable("id") Long speciesId, Model model) {
        speciesRepository.deleteById(speciesId);
        return "redirect:/specieslist";
    }

    /* Valitaan muokattava lajike id:n perusteella */
    @GetMapping("/editspecies/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String editSpecies(@PathVariable("id") Long speciesId, Model model) {
        Species species = speciesRepository.findById(speciesId).orElse(null);
        if (species != null) {
            model.addAttribute("species", species);
        }
        return "editspecies";
    }

    /* Uuden lajikkeen lisäys */
    @GetMapping("/addspecies")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String addSpecies(Model model) {
        model.addAttribute("species", new Species());
        return "addspecies";
    }

    /* Uuden lajikkeen tallennus */
    @PostMapping("/saveSpecies")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String saveSpecies(@Valid Species species, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addspecies";
        }
        speciesRepository.save(species);
        return "redirect:/specieslist";
    }

    /* Päivittää muokatun lajikkeen tiedot vanhojen tilalle */
    @PostMapping("/updateSpecies")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String updateSpecies(@Valid @ModelAttribute("species") Species updatedSpecies, BindingResult bindingResult) {
        Long speciesId = updatedSpecies.getSpeciesId();
        Species currentSpecies = speciesRepository.findById(speciesId).orElse(null);

        if (currentSpecies != null) {
            currentSpecies.setSpeciesLatinName(updatedSpecies.getSpeciesLatinName());
            currentSpecies.setSpeciesDescription(updatedSpecies.getSpeciesDescription());

            if (bindingResult.hasErrors()) {
                return "editspecies";
            }
            speciesRepository.save(currentSpecies);
        }
        return "redirect:/specieslist";
    }
}