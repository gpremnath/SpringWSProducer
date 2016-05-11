package com.office.spring.repository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.office.spring.generated.wservice.GetCountryRequest;
import com.office.spring.generated.wservice.GetCountryResponse;
import com.office.spring.generated.wservice.Country;
import com.office.spring.repository.CountryRepository;

@Endpoint

public class CountryEndpoint {

    private static final String NAMESPACE_URI = "http://com/office/spring/generated/wservice";

    private CountryRepository countryRepository;
    
    @Autowired
    public CountryEndpoint(CountryRepository countryRepository){
        this.countryRepository = countryRepository;
    }

    @PayloadRoot(namespace= NAMESPACE_URI , localPart = "getCountryRequest")
    @ResponsePayload
     public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request){
         GetCountryResponse response = new GetCountryResponse();
         response.setCountry(countryRepository.findCountry(request.getName()));
         return response;
    }

}


