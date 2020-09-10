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
        Customer customer2 = new Customer("Rebeka", "Edinburgh", 26);
        customerRepository.save(customer2);
        Customer customer3 = new Customer("Alina", "Glasgow", 29);
        customerRepository.save(customer3);
        Customer customer4 = new Customer("Jane", "Glasgow", 27);
        customerRepository.save(customer4);
        Customer customer5 = new Customer("James", "Inverness", 27);
        customerRepository.save(customer5);
        Customer customer6 = new Customer("Robert", "Inverness", 30);
        customerRepository.save(customer6);

        Course course1 = new Course("CodeClan", "Edinburgh", 3);
        courseRepository.save(course1);
        Course course2 = new Course("Python Basics", "Glasgow", 4);
        courseRepository.save(course2);
        Course course3 = new Course("Java Advanced", "Inverness", 2);
        courseRepository.save(course3);
        Course course4 = new Course("UX Intro", "Edinburgh", 5);
        courseRepository.save(course4);
        Course course5 = new Course("Professional Software Development", "Glasgow", 4);
        courseRepository.save(course5);

        Booking booking1 = new Booking("01-01-01", customer1, course1);
        bookingRepository.save(booking1);
        Booking booking2 = new Booking("02-02-02", customer1, course1);
        bookingRepository.save(booking2);
        Booking booking3 = new Booking("15-05-20", customer2, course4);
        bookingRepository.save(booking3);
        Booking booking4 = new Booking("30-09-20", customer3, course5);
        bookingRepository.save(booking4);
        Booking booking5 = new Booking("15-11-20", customer5, course3);
        bookingRepository.save(booking5);
        Booking booking6 = new Booking("15-11-20", customer4, course3);
        bookingRepository.save(booking6);
        Booking booking7 = new Booking("30-09-20", customer1, course5);
        bookingRepository.save(booking7);

    }
}
