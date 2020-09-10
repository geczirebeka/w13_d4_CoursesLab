package com.codeclan.example.Courses.controllers;

import com.codeclan.example.Courses.models.Course;
import com.codeclan.example.Courses.repositories.CourseRepository;
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
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

//    url:/courses?rating=2
    @GetMapping(value= "/courses")
    public ResponseEntity<List<Course>> getAllCourses(
            @RequestParam(name="rating", required=false) Integer rating,
            @RequestParam(name="customer", required=false) String customer
    ) {
        if (rating != null) {
            return new ResponseEntity<>(courseRepository.findByRating(rating), HttpStatus.OK);
        }
        if (customer != null) {
            return new ResponseEntity<>(courseRepository.findByCourseBookingsCustomerName(customer), HttpStatus.OK);
        }
        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value= "/courses/{id}")
    public ResponseEntity<Optional<Course>> getCourse(@PathVariable Long id) {
        return new ResponseEntity<>(courseRepository.findById(id), HttpStatus.OK);
    }
}
