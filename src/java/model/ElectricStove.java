/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Asus
 */
public class ElectricStove {
    private int id;
    private String type;
    private String surfaceMaterial;
    private String controlPanel;
    private String cookerType;
    private String safetyFeatures;

    public ElectricStove() {
    }

    public ElectricStove(String type) {
        this.type = type;
    }

    public ElectricStove(String type, String surfaceMaterial, String controlPanel, String cookerType, String safetyFeatures) {
        this.type = type;
        this.surfaceMaterial = surfaceMaterial;
        this.controlPanel = controlPanel;
        this.cookerType = cookerType;
        this.safetyFeatures = safetyFeatures;
    }

    public ElectricStove(int id, String type, String surfaceMaterial, String controlPanel, String cookerType, String safetyFeatures) {
        this.id = id;
        this.type = type;
        this.surfaceMaterial = surfaceMaterial;
        this.controlPanel = controlPanel;
        this.cookerType = cookerType;
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

    public String getSurfaceMaterial() {
        return surfaceMaterial;
    }

    public void setSurfaceMaterial(String surfaceMaterial) {
        this.surfaceMaterial = surfaceMaterial;
    }

    public String getControlPanel() {
        return controlPanel;
    }

    public void setControlPanel(String controlPanel) {
        this.controlPanel = controlPanel;
    }

    public String getCookerType() {
        return cookerType;
    }

    public void setCookerType(String cookerType) {
        this.cookerType = cookerType;
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
