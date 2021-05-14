package com.webservices.roadtaxmanagementapi.repositories;

import java.util.List;

import com.webservices.roadtaxmanagementapi.dtos.RoadTaxDTO;
import com.webservices.roadtaxmanagementapi.services.RoadTaxDTOService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoadTaxDTORepository {
    @Autowired
    private RoadTaxDTOService roadTaxDTOService;
    
    @GetMapping("/roadtax")
    public List<RoadTaxDTO> getAllVehicles() {
        return roadTaxDTOService.getAll();
    }

    @RequestMapping("/roadtax/{reg}")
    public RoadTaxDTO getVehicleByRegistration(@PathVariable("reg")String reg) {

        RoadTaxDTO vehicle  = roadTaxDTOService.getVehicle(reg);
        
        return vehicle;
    }
}
