package com.example.mapping.Error;

import java.util.Set;

public class DesignationNotFound extends RuntimeException {
    public DesignationNotFound(Set<String> a) {
        super("Enter a valid designation of type "+a.toString());
    }
}