/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Asus
 */
public class Blender {
    private int id;
    private String type;
    private String mainFunction;
    private String mill;
    private String mortalMaterial;
    private String blades;
    private String speed;
    private String safetyFeatures;

    public Blender() {
    }

    public Blender(String type) {
        this.type = type;
    }

    public Blender(String type, String mainFunction, String mill, String mortalMaterial, String blades, String speed, String safetyFeatures) {
        this.type = type;
        this.mainFunction = mainFunction;
        this.mill = mill;
        this.mortalMaterial = mortalMaterial;
        this.blades = blades;
        this.speed = speed;
        this.safetyFeatures = safetyFeatures;
    }

    public Blender(int id, String type, String mainFunction, String mill, String mortalMaterial, String blades, String speed, String safetyFeatures) {
        this.id = id;
        this.type = type;
        this.mainFunction = mainFunction;
        this.mill = mill;
        this.mortalMaterial = mortalMaterial;
        this.blades = blades;
        this.speed = speed;
        this.safetyFeatures = safetyFeatures;
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

    public String getMainFunction() {
        return mainFunction;
    }

    public void setMainFunction(String mainFunction) {
        this.mainFunction = mainFunction;
    }

    public String getMill() {
        return mill;
    }

    public void setMill(String mill) {
        this.mill = mill;
    }

    public String getMortalMaterial() {
        return mortalMaterial;
    }

    public void setMortalMaterial(String mortalMaterial) {
        this.mortalMaterial = mortalMaterial;
    }

    public String getBlades() {
        return blades;
    }

    public void setBlades(String blades) {
        this.blades = blades;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getSafetyFeatures() {
        return safetyFeatures;
    }

    public void setSafetyFeatures(String safetyFeatures) {
        this.safetyFeatures = safetyFeatures;
    }

    @Override
    public String toString() {
        return type;
    }
}
