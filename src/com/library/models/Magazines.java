package com.library.models;

public class Magazines extends Book{
    public Magazines(int bookID, Author author, String name, double price, String status, String edition, String dateOfPurchase) {
        super(bookID, author, name, price, status, edition, dateOfPurchase);
    }
}
