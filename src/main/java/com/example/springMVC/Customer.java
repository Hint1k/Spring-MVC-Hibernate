package com.example.springMVC;

import com.example.customValidaion.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {
    private String firstName;
    @NotEmpty(message = "cannot be empty")
    @Size(min=2, max=15, message = "name must be between 2 and 15 letters")
    private String lastName;
    @NotNull(message = "cannot be empty")
    @Min(value=0, message ="must be be greater or equal to 0")
    @Max(value=10, message ="must be less or equal to 10")
    private Integer freePasses;
    @NotEmpty(message = "cannot be empty")
    @Pattern(regexp="^[a-zA-Z0-9]{3,5}", message="min 3, max 5 letter/digits allowed")
    private String postalCode;
    @CourseCode(value="TOP", message="must start with TOP")
    private String courseCode;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
