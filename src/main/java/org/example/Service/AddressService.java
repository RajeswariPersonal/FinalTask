package org.example.Service;

import org.example.DTO.StudentDto;
import org.example.Entity.Address;
import org.example.Entity.Student;
import org.example.Reponce.ApiResponse;
import org.example.Repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    public ResponseEntity<ApiResponse> saveAddress(Address address)
    {
        addressRepository.save(address);
        ApiResponse response = new ApiResponse("Success", 200);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public List<Address> getAllAddress()
    {
        return addressRepository.findAll();
    }

    public ResponseEntity<ApiResponse> deleteAddressById(int id)
    {
        addressRepository.deleteById(id);
        ApiResponse response = new ApiResponse("Success", 200);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<ApiResponse> updateAddress(Address address, int id)
    {
        Address addressDetails =  addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found with id " + id));
        addressDetails.setAddressLine1(address.getAddressLine1());
        addressDetails.setAddressLine2(address.getAddressLine2());
        addressDetails.setCity(address.getCity());

        addressRepository.save(addressDetails);
        ApiResponse response = new ApiResponse("Success", 200);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
