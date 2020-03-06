package com.example.mapping.Error;

import java.util.Set;

public class EmploymentTypeNotFound extends RuntimeException {
    public EmploymentTypeNotFound(Set<String> a) {
        super("Enter a valid type of employment like "+a.toString());
    }
}
