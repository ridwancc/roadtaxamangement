package com.webservices.roadtaxmanagementapi.entities;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy=false)
public class TaxBands implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String taxBandLetter;
    private int rate;
    private String fuel;


    public TaxBands() {
        
    };

    public TaxBands(String taxBandLetter, int rate, String fuel) {
        this.taxBandLetter = taxBandLetter;
        this.rate = rate;
        this.fuel = fuel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaxBandLetter() {
        return taxBandLetter;
    }

    public void setTaxBandLetter(String taxBandLetter) {
        this.taxBandLetter = taxBandLetter;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }
    
}
