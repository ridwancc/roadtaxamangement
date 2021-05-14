package com.webservices.roadtaxmanagementapi.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Vehicles implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
      
    private String manufacturer;
    private String model;
    private int year;
    private String fueltype;

    public Vehicles() {
        
    }

    public Vehicles(String manufacturer, String model, int year, String fueltype) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.fueltype = fueltype;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getFueltype() {
        return fueltype;
    }

    public void setFueltype(String fueltype) {
        this.fueltype = fueltype;
    }
    
}
