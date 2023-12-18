/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Asus
 */
public class WaterPurifier {
    private int id;
    private String type;
    private String numFilter;
    private String capacity;
    private String filtrationDischargeRatio;

    public WaterPurifier() {
    }

    public WaterPurifier(String type) {
        this.type = type;
    }

    public WaterPurifier(String type, String numFilter, String capacity, String filtrationDischargeRatio) {
        this.type = type;
        this.numFilter = numFilter;
        this.capacity = capacity;
        this.filtrationDischargeRatio = filtrationDischargeRatio;
    }
    
    public WaterPurifier(int id, String type, String numFilter, String capacity, String filtrationDischargeRatio) {
        this.id = id;
        this.type = type;
        this.numFilter = numFilter;
        this.capacity = capacity;
        this.filtrationDischargeRatio = filtrationDischargeRatio;
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

    public String getNumFilter() {
        return numFilter;
    }

    public void setNumFilter(String numFilter) {
        this.numFilter = numFilter;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getFiltrationDischargeRatio() {
        return filtrationDischargeRatio;
    }

    public void setFiltrationDischargeRatio(String filtrationDischargeRatio) {
        this.filtrationDischargeRatio = filtrationDischargeRatio;
    } 
    
    @Override
    public String toString() {
        return type;
    }
}
