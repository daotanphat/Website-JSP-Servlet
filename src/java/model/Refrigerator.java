/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Asus
 */
public class Refrigerator {
    private int id;
    private String type;
    private String capacity;
    private String energySaving;
    private String refrigeration;
    private String antimicrobialDeodorozing;
    private String foodPreservation;

    public Refrigerator() {
    }

    public Refrigerator(String type) {
        this.type = type;
    }

    public Refrigerator(String type, String capacity, String energySaving, String refrigeration, String antimicrobialDeodorozing, String foodPreservation) {
        this.type = type;
        this.capacity = capacity;
        this.energySaving = energySaving;
        this.refrigeration = refrigeration;
        this.antimicrobialDeodorozing = antimicrobialDeodorozing;
        this.foodPreservation = foodPreservation;
    }

    public Refrigerator(int id, String type, String capacity, String energySaving, String refrigeration, String antimicrobialDeodorozing, String foodPreservation) {
        this.id = id;
        this.type = type;
        this.capacity = capacity;
        this.energySaving = energySaving;
        this.refrigeration = refrigeration;
        this.antimicrobialDeodorozing = antimicrobialDeodorozing;
        this.foodPreservation = foodPreservation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getEnergySaving() {
        return energySaving;
    }

    public void setEnergySaving(String energySaving) {
        this.energySaving = energySaving;
    }

    public String getRefrigeration() {
        return refrigeration;
    }

    public void setRefrigeration(String refrigeration) {
        this.refrigeration = refrigeration;
    }

    public String getAntimicrobialDeodorozing() {
        return antimicrobialDeodorozing;
    }

    public void setAntimicrobialDeodorozing(String antimicrobialDeodorozing) {
        this.antimicrobialDeodorozing = antimicrobialDeodorozing;
    }

    public String getFoodPreservation() {
        return foodPreservation;
    }

    public void setFoodPreservation(String foodPreservation) {
        this.foodPreservation = foodPreservation;
    }
    
    @Override
    public String toString() {
        return type;
    }
}
