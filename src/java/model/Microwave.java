/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Asus
 */
public class Microwave {
    private int id;
    private String type;
    private String volume;
    private String furnaceCavityMaterial;
    private String mainFunction;
    private String control;

    public Microwave() {
    }

    public Microwave(String type) {
        this.type = type;
    }

    public Microwave(String type, String volume, String furnaceCavityMaterial, String mainFunction, String control) {
        this.type = type;
        this.volume = volume;
        this.furnaceCavityMaterial = furnaceCavityMaterial;
        this.mainFunction = mainFunction;
        this.control = control;
    }

    public Microwave(int id, String type, String volume, String furnaceCavityMaterial, String mainFunction, String control) {
        this.id = id;
        this.type = type;
        this.volume = volume;
        this.furnaceCavityMaterial = furnaceCavityMaterial;
        this.mainFunction = mainFunction;
        this.control = control;
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

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getFurnaceCavityMaterial() {
        return furnaceCavityMaterial;
    }

    public void setFurnaceCavityMaterial(String furnaceCavityMaterial) {
        this.furnaceCavityMaterial = furnaceCavityMaterial;
    }

    public String getMainFunction() {
        return mainFunction;
    }

    public void setMainFunction(String mainFunction) {
        this.mainFunction = mainFunction;
    }

    public String getControl() {
        return control;
    }

    public void setControl(String control) {
        this.control = control;
    }
    
    @Override
    public String toString() {
        return type;
    }
}
