package omaprojekti.happyplants.Domain;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long plantId;

    @NotBlank(message = "Name cannot be empty")
    private String plantName;

    private String lightRequirement;
    private String plantDescription;

    @ManyToOne
    @JsonIgnoreProperties("plants")
    @JoinColumn(name = "speciesId")
    private Species species;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plant")
    @JsonIgnoreProperties("plant")
    private List<Cutting> cuttings;

    /* Constructors */
    public Plant() {
    }

    public Plant(String plantName) {
        this.plantName = plantName;
    }

    public Plant(String plantName, String plantDescription) {
        this.plantName = plantName;
        this.plantDescription = plantDescription;
    }

    public Plant(Long plantId, String plantName, String lightRequirement, String plantDescription) {
        this.plantId = plantId;
        this.plantName = plantName;
        this.lightRequirement = lightRequirement;
        this.plantDescription = plantDescription;
    }

    public Plant(String plantName, String plantDescription, Species species) {
        this.plantName = plantName;
        this.plantDescription = plantDescription;
        this.species = species;
    }

    public Plant(String plantName, String lightRequirement, String plantDescription, Species species) {
        this.plantName = plantName;
        this.lightRequirement = lightRequirement;
        this.plantDescription = plantDescription;
        this.species = species;
    }

    /* Setters */
    public void setPlantId(Long plantId) {
        this.plantId = plantId;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public void setLightRequirement(String lightRequirement) {
        this.lightRequirement = lightRequirement;
    }

    public void setPlantDescription(String plantDescription) {
        this.plantDescription = plantDescription;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public void setCuttings(List<Cutting> cuttings) {
        this.cuttings = cuttings;
    }

    /* Getters */
    public Long getPlantId() {
        return plantId;
    }

    public String getPlantName() {
        return plantName;
    }

    public String getLightRequirement() {
        return lightRequirement;
    }

    public String getPlantDescription() {
        return plantDescription;
    }

    public Species getSpecies() {
        return species;
    }

    public List<Cutting> getCuttings() {
        return cuttings;
    }

    /* toString */
    @Override
    public String toString() {
        return "Plant plantId: " + plantId + ", plant name: " + plantName + ", light requirement: " + lightRequirement
                + ", plant description: " + plantDescription;
    }
}