package com.library.models;

public class Journals extends Book {
    public Journals(int bookID, Author author, String name, double price, String status, String edition, String dateOfPurchase) {
        super(bookID, author, name, price, status, edition, dateOfPurchase);
    }
}
