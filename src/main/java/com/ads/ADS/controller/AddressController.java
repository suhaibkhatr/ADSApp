package com.ads.ADS.controller;


import com.ads.ADS.model.Address;
import com.ads.ADS.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/adsweb/api/v1/address")
public class AddressController {

    AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/adsweb/api/v1/address/list")
    public ResponseEntity<List<Address>> getAllAddressesWithPatients() {
        List<Address> addresses = addressService.getAllAddressesWithPatientsSortedByCity();
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }
}
