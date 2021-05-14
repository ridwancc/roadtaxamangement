package com.webservices.roadtaxmanagementapi.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.*;

@Entity
public class TaxPayments implements Serializable {
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private VehicleRegistrations vehicleRegistration;

    @ManyToOne(fetch = FetchType.LAZY)
    private TaxBands taxBand;

    private LocalDate paymentDate;

    public TaxPayments() {
        
    }

    public TaxPayments(VehicleRegistrations vehicleRegistration, TaxBands taxBand, LocalDate paymentDate) {
        this.vehicleRegistration = vehicleRegistration;
        this.taxBand = taxBand;
        this.paymentDate = paymentDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public VehicleRegistrations getVehicleRegistration() {
        return vehicleRegistration;
    }

    public void setVehicleRegistration(VehicleRegistrations vehicleRegistration) {
        this.vehicleRegistration = vehicleRegistration;
    }

    public TaxBands getTaxBand() {
        return taxBand;
    }

    public void setTaxBand(TaxBands taxBand) {
        this.taxBand = taxBand;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        this.paymentDate = LocalDate.parse(paymentDate, format);
    }

    
}
