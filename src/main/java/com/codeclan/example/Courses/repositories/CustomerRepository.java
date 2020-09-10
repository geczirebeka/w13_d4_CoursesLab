package com.codeclan.example.Courses.repositories;

import com.codeclan.example.Courses.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByCustomerBookingsCourseNameIgnoreCase(String course);
    List<Customer> findByTownIgnoreCaseAndCustomerBookingsCourseNameIgnoreCase(String town, String course);
    List<Customer> findByAgeGreaterThanAndTownIgnoreCaseAndCustomerBookingsCourseNameIgnoreCase(int age, String town, String course);
}
