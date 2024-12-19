package com.example.Service2.Services;

import com.example.Service2.Entities.Address;
import com.example.Service2.Repos.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public Address save(Address address) {
        return addressRepository.save(address);
    }

    public Address findById(Long id) {
        return addressRepository.findById(id).orElseThrow(() -> new RuntimeException("Address not found"));
    }

    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    public List<Address> findAddressesByPostalCode(String postalCode) {
        return addressRepository.findByCodePostalVille(postalCode);
    }

    public List<Address> findAddressesByStreetName(String streetName) {
        return addressRepository.findByRueContaining(streetName);
    }

    public Address updatePostalCode(Long id, String newPostalCode) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found"));
        address.setCodePostalVille(newPostalCode);
        return addressRepository.save(address);
    }
}

