package org.example.Controller;

import org.example.Entity.Address;
import org.example.Entity.Student;
import org.example.Reponce.ApiResponse;
import org.example.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/address")
public class AddressController {
    @Autowired
    AddressService addressService;

    @PostMapping
    ResponseEntity<ApiResponse> saveAddress (@RequestBody Address address)
    {
       return addressService.saveAddress(address);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateAddress(@PathVariable int id, @RequestBody Address address)
    {
        return addressService.updateAddress(address, id);
    }

    @GetMapping
    public ResponseEntity<List<Address>> getAllAddress()
    {
        List<Address> address =  addressService.getAllAddress();
        return ResponseEntity.ok(address);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteAddressById(@PathVariable int id) {
        return addressService.deleteAddressById(id);
    }
}
