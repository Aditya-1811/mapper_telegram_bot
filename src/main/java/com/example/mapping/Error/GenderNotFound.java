package com.example.mapping.Error;

import java.util.Set;

public class GenderNotFound extends RuntimeException {
    public GenderNotFound(Set<String> a) {
        super("Enter a valid gender of type " + a.toString());
    }
}