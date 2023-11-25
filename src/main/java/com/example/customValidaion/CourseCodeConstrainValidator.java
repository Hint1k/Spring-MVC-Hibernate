package com.example.customValidaion;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstrainValidator implements ConstraintValidator<CourseCode, String> {

    private  String coursePrefix;
    @Override
    public void initialize(CourseCode courseCode) {
        coursePrefix=courseCode.value();
    }

    @Override
    public boolean isValid(String string, ConstraintValidatorContext constraintValidatorContext) {
        boolean result;
        if (string != null) {
            result = string.startsWith(coursePrefix);
        } else {
            result = true;
        }
        return result;
    }
}
