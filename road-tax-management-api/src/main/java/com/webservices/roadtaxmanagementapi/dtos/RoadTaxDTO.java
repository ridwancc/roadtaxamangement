package com.webservices.roadtaxmanagementapi.dtos;

public class RoadTaxDTO {
    private String vehicleRegistrionMark;
    private Boolean sORN;
    private Boolean roadTax;

    public RoadTaxDTO() {
        
    }
    
    public RoadTaxDTO(Boolean roadTax, Boolean sORN, String vehicleRegistrionMark) {
        this.roadTax = roadTax;
        this.sORN = sORN;
        this.vehicleRegistrionMark = vehicleRegistrionMark;
    }


    public Boolean getRoadTax() {
        return roadTax;
    }


    public void setRoadTax(Boolean roadTax) {
        this.roadTax = roadTax;
    }


    public Boolean getSORN() {
        return sORN;
    }


    public void setSORN(Boolean sORN) {
        this.sORN = sORN;
    }

    public String getVehicleRegistrationMark() {
        return vehicleRegistrionMark;
    }

    public void setVehicleRegistrationMark(String vehicleRegistrionMark) {
        this.vehicleRegistrionMark = vehicleRegistrionMark;
    }
    
}
