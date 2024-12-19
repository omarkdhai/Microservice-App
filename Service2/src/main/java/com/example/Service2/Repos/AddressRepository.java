package com.example.Service2.Repos;

import com.example.Service2.Entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findByCodePostalVille(String postalCode);

    List<Address> findByRueContaining(String streetName);

}
