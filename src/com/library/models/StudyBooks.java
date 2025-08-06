package com.library.models;

public class StudyBooks extends Book{
    public StudyBooks(int bookID, Author author, String name, double price, String status, String edition, String dateOfPurchase) {
        super(bookID, author, name, price, status, edition, dateOfPurchase);
    }
}
