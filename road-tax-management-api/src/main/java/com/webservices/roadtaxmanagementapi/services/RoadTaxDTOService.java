package com.webservices.roadtaxmanagementapi.services;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

import com.webservices.roadtaxmanagementapi.dtos.RoadTaxDTO;
import com.webservices.roadtaxmanagementapi.entities.VehicleRegistrations;
import com.webservices.roadtaxmanagementapi.repositories.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoadTaxDTOService {

    @Autowired
    private VehicleRegistrationRepository vehicleRegistrationRepository;

    public List<RoadTaxDTO> getAll() {
        return ((List<VehicleRegistrations>) vehicleRegistrationRepository
        .findAll())
        .stream()
        .map(this::convertToRoadTaxDTO)
        .collect(Collectors.toList());
    }

    public RoadTaxDTO getVehicle(String vehicleRegistrationMark) {
        Boolean vehicleDoesExist = vehicleRegistrationRepository.existsByVehicleRegistrationMark(vehicleRegistrationMark);

        if (vehicleDoesExist) {
            return convertToRoadTaxDTO(vehicleRegistrationRepository.findByVehicleRegistrationMark(vehicleRegistrationMark));
        }
        return null;
    }

    private RoadTaxDTO convertToRoadTaxDTO(VehicleRegistrations vehicleRegistration) {
        RoadTaxDTO roadTaxDTO = new RoadTaxDTO();

        String vehicleRegistrationMark = vehicleRegistration.getVehicleRegistrationMark();
        Boolean sORN = vehicleRegistration.getSorn();
        Boolean roadTax = false;

        LocalDate today = LocalDate.now();
        Period diff = Period.between(today, vehicleRegistration.getRegistrationExpiry());
        if (diff.getMonths() < 12) {
            roadTax = true;
        }

        roadTaxDTO.setVehicleRegistrationMark(vehicleRegistrationMark);
        roadTaxDTO.setSORN(sORN);
        roadTaxDTO.setRoadTax(roadTax);

        return roadTaxDTO;
    }
    
    
}
