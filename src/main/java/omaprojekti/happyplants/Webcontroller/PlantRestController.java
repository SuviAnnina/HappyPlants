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

import omaprojekti.happyplants.Domain.Plant;
import omaprojekti.happyplants.Domain.PlantRepository;

@CrossOrigin
@Controller
public class PlantRestController {
    @Autowired
    private PlantRepository plantRepository;

    /* Listaa kaikki Plant-luokan javaoliot JSON listaksi */
    @GetMapping("/plants")
    public @ResponseBody List<Plant> plantListRest() {
        return (List<Plant>) plantRepository.findAll();
    }

    /* Etsii kasvin id:n perusteella ja palauttaa sen JSON muodossa */
    @GetMapping("/plants/{id}")
    public @ResponseBody Optional<Plant> findPlantRest(@PathVariable("id") Long plantId) {
        return plantRepository.findById(plantId);
    }

    /* Tallentaa uuden kasvin tietokantaan */
    @PostMapping("plants")
    public @ResponseBody Plant savePlantRest(@RequestBody Plant plant) {
        return plantRepository.save(plant);
    }
}
