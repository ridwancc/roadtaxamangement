package com.webservices.roadtaxmanagementapi.dtos;

import java.time.LocalDate;

public class TaxPaymentDTO {
    private LocalDate paymentDate;
    private String vehicleRegistrationMark;
    private String taxBandLetter;
    private int rate;

    public TaxPaymentDTO() {

    }

    public TaxPaymentDTO(LocalDate paymentDate, String vehicleRegistrationMark, String taxBandLetter, int rate) {
        this.paymentDate = paymentDate;
        this.vehicleRegistrationMark = vehicleRegistrationMark;
        this.taxBandLetter = taxBandLetter;
        this.rate = rate;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getVehicleRegistrationMark() {
        return vehicleRegistrationMark;
    }

    public void setVehicleRegistrationMark(String vehicleRegistrationMark) {
        this.vehicleRegistrationMark = vehicleRegistrationMark;
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
    
}
