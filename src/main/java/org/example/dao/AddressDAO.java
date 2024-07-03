package org.example.dao;

import org.example.entity.Address;

import java.util.List;

public interface AddressDAO {
    //create
    void addAddress(Address address);

    //read
    List<Address> getAll();

    Address getById(Long id);

    //update
    void update(Address address);

    //delete
    void remove(Address address);
}
