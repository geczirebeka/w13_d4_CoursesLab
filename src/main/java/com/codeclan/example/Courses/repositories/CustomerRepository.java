package com.codeclan.example.Courses.repositories;

import com.codeclan.example.Courses.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByCustomerBookingsCourseName(String name);
}
