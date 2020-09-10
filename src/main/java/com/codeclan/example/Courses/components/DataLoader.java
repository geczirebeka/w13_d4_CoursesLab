package com.codeclan.example.Courses.components;

import com.codeclan.example.Courses.models.Booking;
import com.codeclan.example.Courses.models.Course;
import com.codeclan.example.Courses.models.Customer;
import com.codeclan.example.Courses.repositories.BookingRepository;
import com.codeclan.example.Courses.repositories.CourseRepository;
import com.codeclan.example.Courses.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    public DataLoader() {
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Customer customer1 = new Customer("Tomek", "Edinburgh", 27);
        customerRepository.save(customer1);

        Course course1 = new Course("CodeClan", "Edinburgh", 3);
        courseRepository.save(course1);

        Booking booking1 = new Booking("01-01-01", customer1, course1);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("02-02-02", customer1, course1);
        bookingRepository.save(booking2);
    }
}
