package com.webservices.roadtaxmanagementapi.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.*;

import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy=false)
public class VehicleRegistrations implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne(fetch = FetchType.LAZY)
    private Vehicles vehicle;

    @ManyToOne(fetch = FetchType.LAZY)
    private RegisteredKeepers registeredKeeper;

    private String vehicleRegistrationMark;
    private Boolean sorn;
    private LocalDate registrationExpiry;

    public VehicleRegistrations() {
        
    }

    public VehicleRegistrations(Vehicles vehicle, RegisteredKeepers registeredKeeper, String vehicleRegistrationMark,
            Boolean sorn, LocalDate registrationExpiry) {
        this.vehicle = vehicle;
        this.registeredKeeper = registeredKeeper;
        this.vehicleRegistrationMark = vehicleRegistrationMark;
        this.sorn = sorn;
        this.registrationExpiry = registrationExpiry;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vehicles getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicles vehicle) {
        this.vehicle = vehicle;
    }

    public RegisteredKeepers getRegisteredKeeper() {
        return registeredKeeper;
    }

    public void setRegisteredKeeper(RegisteredKeepers registeredKeeper) {
        this.registeredKeeper = registeredKeeper;
    }

    public String getVehicleRegistrationMark() {
        return vehicleRegistrationMark;
    }

    public void setVehicleRegistrationMark(String vehicleRegistrationMark) {
        this.vehicleRegistrationMark = vehicleRegistrationMark;
    }

    public Boolean getSorn() {
        return sorn;
    }

    public void setSorn(Boolean sorn) {
        this.sorn = sorn;
    }

    public LocalDate getRegistrationExpiry() {
        return registrationExpiry;
    }

    public void setRegistrationExpiry(LocalDate registrationExpiry) {
        this.registrationExpiry = registrationExpiry;
    }

    public void setRegistrationExpiry(String registrationExpiry) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        this.registrationExpiry = LocalDate.parse(registrationExpiry, format);
    }
}
