package omaprojekti.happyplants.Domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Species {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long speciesId;

    private String speciesLatinName;
    private String speciesDescription;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "species")
    @JsonIgnoreProperties("species")
    private List<Plant> plants;

    /* Constructors */
    public Species() {
    }

    public Species(String speciesLatinName) {
        this.speciesLatinName = speciesLatinName;
    }

    public Species(String speciesLatinName, String speciesDescription) {
        this.speciesLatinName = speciesLatinName;
        this.speciesDescription = speciesDescription;
    }

    public Species(Long speciesId, String speciesLatinName, String speciesDescription) {
        this.speciesId = speciesId;
        this.speciesLatinName = speciesLatinName;
        this.speciesDescription = speciesDescription;
    }

    /* Setters */
    public void setSpeciesId(Long speciesId) {
        this.speciesId = speciesId;
    }

    public void setSpeciesLatinName(String speciesLatinName) {
        this.speciesLatinName = speciesLatinName;
    }

    public void setSpeciesDescription(String speciesDescription) {
        this.speciesDescription = speciesDescription;
    }

    public void setPlants(List<Plant> plants) {
        this.plants = plants;
    }

    /* Getters */
    public Long getSpeciesId() {
        return speciesId;
    }

    public String getSpeciesLatinName() {
        return speciesLatinName;
    }

    public String getSpeciesDescription() {
        return speciesDescription;
    }

    public List<Plant> getPlants() {
        return plants;
    }

    /* toString */
    @Override
    public String toString() {
        return "Species speciesId: " + speciesId + ", speciesLatinName: " + speciesLatinName + ", speciesDescription: "
                + speciesDescription;
    }
}