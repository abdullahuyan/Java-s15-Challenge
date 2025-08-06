package com.library.models;

public class Student extends Reader {
    public Student(String name) {
        super(name);
    }

    @Override
    public void whoYouAre() {
        System.out.println("I am a Student: " + getName());
    }
}
