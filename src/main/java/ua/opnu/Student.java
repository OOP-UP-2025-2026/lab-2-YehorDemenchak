package ua.opnu;

import java.util.Arrays;

public class Student {
    private String name;
    private int year;
    private String[] courses = {};

    Student(String name, int year) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (year < 1 || year > 4) {
            throw new IllegalArgumentException("Year must be between 1 and 4");
        }

        this.name = name;
        this.year = year;
    }

    void addCourse(String courseName) {
        if (courseName == null || courseName.trim().isEmpty()) {
            throw new IllegalArgumentException("Course name cannot be null or empty");
        }

        String[] newCourses = Arrays.copyOf(courses, courses.length + 1);
        newCourses[newCourses.length - 1] = courseName;
        this.courses = newCourses;
    }

    void dropAll() {
        this.courses = new String[0];
    }

    int getCourseCount() {
        return courses.length;
    }

    String getName() {
        return name;
    }

    int getTuition() {
        return year * 20000;
    }

    int getYear() {
        return year;
    }
}
