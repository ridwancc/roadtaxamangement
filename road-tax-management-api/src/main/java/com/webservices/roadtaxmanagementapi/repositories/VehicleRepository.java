package com.webservices.roadtaxmanagementapi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.webservices.roadtaxmanagementapi.entities.*;

@RepositoryRestResource(collectionResourceRel = "vehicles", path="vehicles")
public interface VehicleRepository extends CrudRepository<Vehicles, Long> {
}
