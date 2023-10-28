package omaprojekti.happyplants.Webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import omaprojekti.happyplants.Domain.Cutting;
import omaprojekti.happyplants.Domain.CuttingRepository;
import omaprojekti.happyplants.Domain.PlantRepository;

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
    public String deleteCutting(@PathVariable("id") Long cuttingId, Model model) {
        cuttingRepository.deleteById(cuttingId);
        return "redirect:/cuttinglist";
    }

    /* Valitaan muokattava pistokas tietokannasta id:n perusteella */
    @GetMapping("/editcutting/{id}")
    public String editCutting(@PathVariable("id") long cuttingId, Model model) {
        Cutting cutting = cuttingRepository.findById(cuttingId).orElse(null);
        if (cutting != null) {
            model.addAttribute("cutting", cutting);
            model.addAttribute("plants", plantRepository.findAll());
        }
        return "editcutting";
    }

    /* Uuden pistokkaan lisäys */

    /* Uuden pistokkaan tallennus */

    /*
     * Päivittää muokatun pistokkaan tiedot vanhojen tietojen tilalle tietokantaan
     */
}
