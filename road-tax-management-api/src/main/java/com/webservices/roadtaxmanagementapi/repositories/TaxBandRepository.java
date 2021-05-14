package com.webservices.roadtaxmanagementapi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.webservices.roadtaxmanagementapi.entities.*;

@RepositoryRestResource(collectionResourceRel = "taxbands", path="taxbands")
public interface TaxBandRepository extends CrudRepository<TaxBands, Long> {
    
}
