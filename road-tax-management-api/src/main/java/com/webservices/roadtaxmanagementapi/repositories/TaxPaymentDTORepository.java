package com.webservices.roadtaxmanagementapi.repositories;

import java.util.List;

import com.webservices.roadtaxmanagementapi.dtos.TaxPaymentDTO;
import com.webservices.roadtaxmanagementapi.services.TaxPaymentDTOService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaxPaymentDTORepository {
    @Autowired
    private TaxPaymentDTOService taxPaymentDTOService;
    
    @GetMapping("/payments")
    public List<TaxPaymentDTO> getAllPayments() {
        return taxPaymentDTOService.getAll();
    }
}
