package omaprojekti.happyplants.Domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Cutting {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cuttingId;

    private String cuttingName;
    private String cuttingDescription;
    private String dateCut;
    private double price;
    private String note;

    @ManyToOne
    @JsonIgnoreProperties("cuttings")
    @JoinColumn(name = "plantId")
    private Plant plant;

    /* Constructors */

    public Cutting() {
    }

    public Cutting(String cuttingName, String cuttingDescription) {
        this.cuttingName = cuttingName;
        this.cuttingDescription = cuttingDescription;
    }

    public Cutting(String cuttingName, String cuttingDescription, double price) {
        this.cuttingName = cuttingName;
        this.cuttingDescription = cuttingDescription;
        this.price = price;
    }

    public Cutting(String cuttingName, String cuttingDescription, String dateCut, Plant plant, String note) {
        this.cuttingName = cuttingName;
        this.cuttingDescription = cuttingDescription;
        this.dateCut = dateCut;
        this.plant = plant;
        this.note = note;
    }

    public Cutting(Long cuttingId, String cuttingName, String cuttingDescription, String dateCut, double price,
            String note,
            Plant plant) {
        this.cuttingId = cuttingId;
        this.cuttingName = cuttingName;
        this.cuttingDescription = cuttingDescription;
        this.dateCut = dateCut;
        this.price = price;
        this.note = note;
        this.plant = plant;
    }

    /* Setters */
    public void setCuttingId(Long cuttingId) {
        this.cuttingId = cuttingId;
    }

    public void setCuttingName(String cuttingName) {
        this.cuttingName = cuttingName;
    }

    public void setCuttingDescription(String cuttingDescription) {
        this.cuttingDescription = cuttingDescription;
    }

    public void setDateCut(String dateCut) {
        this.dateCut = dateCut;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }

    /* Getters */
    public Long getCuttingId() {
        return cuttingId;
    }

    public String getCuttingName() {
        return cuttingName;
    }

    public String getCuttingDescription() {
        return cuttingDescription;
    }

    public String getDateCut() {
        return dateCut;
    }

    public double getPrice() {
        return price;
    }

    public String getNote() {
        return note;
    }

    public Plant getPlant() {
        return plant;
    }

    /* toString */
    @Override
    public String toString() {
        return "Cutting cuttingId: " + cuttingId + ", name: " + cuttingName + ", description: " + cuttingDescription
                + ", date cut: "
                + dateCut + ", price: " + price + ", note: " + note;
    }
}
