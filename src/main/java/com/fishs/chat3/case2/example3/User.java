package com.fishs.chat3.case2.example3;

public record User(String name, int age) {

    public User {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("name can not be null or empty");
        if (age < 0) throw new IllegalArgumentException("age can not be negative");
    }
}
