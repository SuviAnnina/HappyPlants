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
import omaprojekti.happyplants.Domain.Cutting;
import omaprojekti.happyplants.Domain.CuttingRepository;
import omaprojekti.happyplants.Domain.Plant;
import omaprojekti.happyplants.Domain.PlantRepository;
import org.thymeleaf.util.StringUtils;

@Controller
public class CuttingController {

    @Autowired
    private CuttingRepository cuttingRepository;

    @Autowired
    private PlantRepository plantRepository;

    /* Listaa kaikki tietokannasta löytyvät pistokkaat (cuttings) */
    @GetMapping("/cuttinglist")
    public String listCuttings(Model model) {
        model.addAttribute("cuttings", cuttingRepository.findAll());
        return "cuttinglist";
    }

    /* Poistaa valitun pistokkan id:n perusteella tietokannasta */
    @GetMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteCutting(@PathVariable("id") Long cuttingId, Model model) {
        cuttingRepository.deleteById(cuttingId);
        return "redirect:/cuttinglist";
    }

    /* Valitaan muokattava pistokas tietokannasta id:n perusteella */
    @GetMapping("/editcutting/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String editCutting(@PathVariable("id") long cuttingId, Model model) {
        Cutting cutting = cuttingRepository.findById(cuttingId).orElse(null);
        if (cutting != null) {
            model.addAttribute("cutting", cutting);
            model.addAttribute("plants", plantRepository.findAll());
        }
        return "editcutting";
    }

    /* Uuden pistokkaan lisäys */
    @GetMapping("/addcutting")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String addCutting(Model model) {
        model.addAttribute("cutting", new Cutting());
        model.addAttribute("plants", plantRepository.findAll());
        return "addcutting";
    }

    /* Uuden pistokkaan tallennus */
    @PostMapping("/saveCutting")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String saveCutting(@Valid Cutting cutting, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addcutting";
        }
        cuttingRepository.save(cutting);
        return "redirect:/cuttinglist";
    }

    /*
     * Päivittää muokatun pistokkaan tiedot vanhojen tietojen tilalle tietokantaan
     */
    @PostMapping("/updateCutting")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String updateCutting(@Valid @ModelAttribute("cutting") Cutting updatedCutting, BindingResult bindingResult,
            Model model) {
        Long cuttingId = updatedCutting.getCuttingId();
        Cutting currentCutting = cuttingRepository.findById(cuttingId).orElse(null);

        if (currentCutting != null) {

            if (StringUtils.isEmpty(updatedCutting.getCuttingName())) {
                model.addAttribute("error", "Cutting name cannot be empty");
                model.addAttribute("plants", plantRepository.findAll());
                return "editcutting";
            }

            currentCutting.setCuttingName(updatedCutting.getCuttingName());
            currentCutting.setCuttingDescription(updatedCutting.getCuttingDescription());
            currentCutting.setDateCut(updatedCutting.getDateCut());
            currentCutting.setPrice(updatedCutting.getPrice());
            currentCutting.setNote(updatedCutting.getNote());

            Plant selectedPlant = plantRepository.findById(updatedCutting.getPlant().getPlantId()).orElse(null);
            currentCutting.setPlant(selectedPlant);

            if (bindingResult.hasErrors()) {
                model.addAttribute("plants", plantRepository.findAll());
                return "editcutting";
            }
            cuttingRepository.save(currentCutting);
        }
        return "redirect:/cuttinglist";
    }
}