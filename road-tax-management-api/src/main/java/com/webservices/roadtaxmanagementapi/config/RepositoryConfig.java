package com.webservices.roadtaxmanagementapi.config;

import com.webservices.roadtaxmanagementapi.entities.*;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class RepositoryConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(TaxBands.class);
        config.exposeIdsFor(Vehicles.class);
        config.exposeIdsFor(RegisteredKeepers.class);
        config.exposeIdsFor(TaxPayments.class);
        config.exposeIdsFor(VehicleRegistrations.class);
    }    

}

