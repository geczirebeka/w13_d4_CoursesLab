package com.codeclan.example.Courses.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "town")
    private String town;

    @Column(name = "rating")
    private int rating;

    @JsonIgnoreProperties({"course"})
    @OneToMany(mappedBy = "course")
    private List<Booking> courseBookings;

    public Course(String name, String town, int rating) {
        this.name = name;
        this.town = town;
        this.rating = rating;
        this.courseBookings = new ArrayList<>();
    }

    public Course() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public List<Booking> getCourseBookings() {
        return courseBookings;
    }

    public void setCourseBookings(List<Booking> courseBookings) {
        this.courseBookings = courseBookings;
    }

    public void addBooking(Booking booking) {
        courseBookings.add(booking);
    }
}