package com.library.models;

import java.util.HashSet;
import java.util.Set;

public class Reader extends Person {
    private Set<Book> books;

    public Reader(String name) {
        super(name);
        this.books = new HashSet<>();
    }

    public Set<Book> getBooks() {
        return books;
    }

    public boolean borrowBook(Book book) {
        if (books.size() < 5 && book.getOwner() == null) {
            books.add(book);
            return true;
        }
        return false;
    }

    public boolean returnBook(Book book) {
        if (books.remove(book)) {
            return true;
        }
        return false;
    }

    @Override
    public void whoYouAre() {
        System.out.println("I am a Reader: " + getName() + " with " + books.size() + " books.");
    }
}