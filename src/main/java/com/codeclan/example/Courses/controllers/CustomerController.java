package com.codeclan.example.Courses.controllers;

import com.codeclan.example.Courses.models.Customer;
import com.codeclan.example.Courses.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value= "/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(
            @RequestParam(name= "course", required=false) String course,
            @RequestParam(name= "town", required=false) String town,
            @RequestParam(name= "age", required = false) Integer age
    ) {
        if (course != null && town != null && age != null) {
            return new ResponseEntity<>(customerRepository.findByAgeGreaterThanAndTownIgnoreCaseAndCustomerBookingsCourseNameIgnoreCase(age, town, course), HttpStatus.OK);
        }
        if (course != null && town != null) {
            return new ResponseEntity<>(customerRepository.findByTownIgnoreCaseAndCustomerBookingsCourseNameIgnoreCase(town, course), HttpStatus.OK);
        }
        if (course != null) {
            return new ResponseEntity<>(customerRepository.findByCustomerBookingsCourseNameIgnoreCase(course), HttpStatus.OK);
        }
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value= "/customers/{id}")
    public ResponseEntity<Optional<Customer>> getCustomer(@PathVariable Long id) {
        return new ResponseEntity<>(customerRepository.findById(id), HttpStatus.OK);
    }
}
