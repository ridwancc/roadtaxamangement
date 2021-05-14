package com.webservices.roadtaxmanagementapi.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.webservices.roadtaxmanagementapi.dtos.TaxPaymentDTO;
import com.webservices.roadtaxmanagementapi.entities.TaxPayments;
import com.webservices.roadtaxmanagementapi.repositories.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TaxPaymentDTOService {

    @Autowired
    private TaxPaymentRepository taxPaymentRepository;

    public List<TaxPaymentDTO> getAll() {
        return ((List<TaxPayments>) taxPaymentRepository
        .findAll())
        .stream()
        .map(this::convertToTaxPaymentDTO)
        .collect(Collectors.toList());
    }

    private TaxPaymentDTO convertToTaxPaymentDTO(TaxPayments taxPayments) {
        TaxPaymentDTO taxPaymentDTO = new TaxPaymentDTO();

        LocalDate paymentDate = taxPayments.getPaymentDate();
        String vehicleRegistrationMark = taxPayments.getVehicleRegistration().getVehicleRegistrationMark();
        String taxBandLetter = taxPayments.getTaxBand().getTaxBandLetter();
        int rate = taxPayments.getTaxBand().getRate();

        taxPaymentDTO.setPaymentDate(paymentDate);
        taxPaymentDTO.setVehicleRegistrationMark(vehicleRegistrationMark);
        taxPaymentDTO.setTaxBandLetter(taxBandLetter);
        taxPaymentDTO.setRate(rate);

        return taxPaymentDTO;
    }
    
}
