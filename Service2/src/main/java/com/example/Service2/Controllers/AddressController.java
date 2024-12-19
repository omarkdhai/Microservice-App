package com.example.Service2.Controllers;

import com.example.Service2.Entities.Address;
import com.example.Service2.Services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @PostMapping
    public ResponseEntity<Address> createAddress(@RequestBody Address address) {
        return ResponseEntity.ok(addressService.save(address));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddress(@PathVariable Long id) {
        return ResponseEntity.ok(addressService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Address>> getAllAddresses() {
        return ResponseEntity.ok(addressService.findAll());
    }

    @GetMapping("/postalCode/{postalCode}")
    public ResponseEntity<List<Address>> getAddressesByPostalCode(@PathVariable String postalCode) {
        return ResponseEntity.ok(addressService.findAddressesByPostalCode(postalCode));
    }

    @GetMapping("/street/{streetName}")
    public ResponseEntity<List<Address>> getAddressesByStreetName(@PathVariable String streetName) {
        return ResponseEntity.ok(addressService.findAddressesByStreetName(streetName));
    }

    @PutMapping("/updatePostalCode/{id}")
    public ResponseEntity<Address> updatePostalCode(@PathVariable Long id, @RequestBody String newPostalCode) {
        return ResponseEntity.ok(addressService.updatePostalCode(id, newPostalCode));
    }
}

