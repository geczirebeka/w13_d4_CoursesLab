package com.codeclan.example.Courses;

import com.codeclan.example.Courses.models.Customer;
import com.codeclan.example.Courses.repositories.BookingRepository;
import com.codeclan.example.Courses.repositories.CourseRepository;
import com.codeclan.example.Courses.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class CoursesApplicationTests {

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canGetCustomersByTownAndCourseName() {
		List<Customer> found = customerRepository.findByTownIgnoreCaseAndCustomerBookingsCourseNameIgnoreCase("Edinburgh", "UX Intro");
		assertEquals(2, found.size());
	}

	@Test
	public void canGetCustomersByAgeAndTownAndCourseName() {
		List<Customer> found = customerRepository.findByAgeGreaterThanAndTownIgnoreCaseAndCustomerBookingsCourseNameIgnoreCase(26, "Edinburgh", "UX Intro");
		assertEquals(1, found.size());
		assertEquals("Tomek", found.get(0).getName());
	}


}
