package com.library.models;

public class Book {
    private int bookID;
    private Author author;
    private String name;
    private double price;
    private String status;
    private String edition;
    private String dateOfPurchase;
    private Person owner;

    public Book(int bookID, Author author, String name, double price, String status, String edition, String dateOfPurchase) {
        this.bookID = bookID;
        this.author = author;
        this.name = name;
        this.price = price;
        this.status = status;
        this.edition = edition;
        this.dateOfPurchase = dateOfPurchase;
        this.owner = null;
        if (author != null) {
            author.addBook(this);
        }
    }

    public int getBookID() {
        return bookID;
    }

    public Author getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public String getEdition() {
        return edition;
    }

    public String getDateOfPurchase() {
        return dateOfPurchase;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public void setDateOfPurchase(String dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public void display() {
        System.out.println("Book ID: " + bookID + ", Title: " + name + ", Author: " + (author != null ? author.getName() : "Unknown") + ", Status: " + status);
    }

    public void updateStatus(String status) {
        this.status = status;
    }
}