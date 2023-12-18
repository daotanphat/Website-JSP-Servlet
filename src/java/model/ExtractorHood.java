/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Asus
 */
public class ExtractorHood {
    private int id;
    private String type;
    private String control;
    private String maxNoise;
    private String meshMaterial;
    private String lighting;
    private String airOutletPipeDiameter;

    public ExtractorHood() {
    }

    public ExtractorHood(String type) {
        this.type = type;
    }

    public ExtractorHood(String type, String control, String maxNoise, String meshMaterial, String lighting, String airOutletPipeDiameter) {
        this.type = type;
        this.control = control;
        this.maxNoise = maxNoise;
        this.meshMaterial = meshMaterial;
        this.lighting = lighting;
        this.airOutletPipeDiameter = airOutletPipeDiameter;
    }
    
    public ExtractorHood(int id, String type, String control, String maxNoise, String meshMaterial, String lighting, String airOutletPipeDiameter) {
        this.id = id;
        this.type = type;
        this.control = control;
        this.maxNoise = maxNoise;
        this.meshMaterial = meshMaterial;
        this.lighting = lighting;
        this.airOutletPipeDiameter = airOutletPipeDiameter;
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

    public String getControl() {
        return control;
    }

    public void setControl(String control) {
        this.control = control;
    }

    public String getMaxNoise() {
        return maxNoise;
    }

    public void setMaxNoise(String maxNoise) {
        this.maxNoise = maxNoise;
    }

    public String getMeshMaterial() {
        return meshMaterial;
    }

    public void setMeshMaterial(String meshMaterial) {
        this.meshMaterial = meshMaterial;
    }

    public String getLighting() {
        return lighting;
    }

    public void setLighting(String lighting) {
        this.lighting = lighting;
    }

    public String getAirOutletPipeDiameter() {
        return airOutletPipeDiameter;
    }

    public void setAirOutletPipeDiameter(String airOutletPipeDiameter) {
        this.airOutletPipeDiameter = airOutletPipeDiameter;
    }
    
    @Override
    public String toString() {
        return type;
    }
}
