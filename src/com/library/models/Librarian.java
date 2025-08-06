package com.library.models;

public class Librarian extends Person {
    public Librarian(String name) {
        super(name);
    }

    public void searchBook(Book book) {
        book.display();
    }

    public void verifyMember(Reader reader) {
        System.out.println("Verified member: " + reader.getName());
    }

    public void issueBook(Book book, Reader reader) {
        if (book.getOwner() == null) {
            book.setOwner(reader);
            reader.borrowBook(book);
            System.out.println("Issued book: " + book.getName() + " to " + reader.getName());
        } else {
            System.out.println("Book is already issued.");
        }
    }

    public void calculateFine(Reader reader) {
        System.out.println("Calculated fine for " + reader.getName() + " (placeholder amount: $5).");
    }

    @Override
    public void whoYouAre() {
        System.out.println("I am a Librarian: " + getName());
    }
}
