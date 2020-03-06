package com.example.mapping.Error;

import java.util.Set;

public class UnsupportedException extends RuntimeException {

    public UnsupportedException(Set<String> keys) {
        super("Field " + keys.toString() + " update is not allow.");
    }
}