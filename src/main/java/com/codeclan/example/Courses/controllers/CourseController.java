package com.codeclan.example.Courses.controllers;

import com.codeclan.example.Courses.models.Course;
import com.codeclan.example.Courses.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            return new ResponseEntity<>(courseRepository.findByCourseBookingsCustomerNameIgnoreCase(customer), HttpStatus.OK);
        }
        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value= "/courses/{id}")
    public ResponseEntity<Optional<Course>> getCourse(@PathVariable Long id) {
        return new ResponseEntity<>(courseRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value= "/courses")
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        courseRepository.save(course);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }

    @PutMapping(value= "/courses/{id}")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course, @PathVariable Long id) {
        courseRepository.save(course);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @DeleteMapping(value= "/courses/{id}")
    public ResponseEntity<List<Course>> deleteCourse(@PathVariable Long id) {
        courseRepository.deleteById(id);
        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }
}
