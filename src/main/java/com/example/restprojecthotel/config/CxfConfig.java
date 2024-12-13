package com.example.restprojecthotel.config;

import com.example.restprojecthotel.controller.SoapReservationController;
import jakarta.xml.ws.Endpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class CxfConfig {


    @Bean
    public EndpointImpl reservationEndpoint(Bus bus, SoapReservationController soapReservationController) {
        EndpointImpl endpoint = new EndpointImpl(bus, soapReservationController);
        endpoint.publish("/ws");
        return endpoint;
    }
}
