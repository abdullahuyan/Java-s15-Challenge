package com.library.models;

public class Faculty extends Reader {
    public Faculty(String name) {
        super(name);
    }

    @Override
    public void whoYouAre() {
        System.out.println("I am a Faculty member: " + getName());
    }
}
