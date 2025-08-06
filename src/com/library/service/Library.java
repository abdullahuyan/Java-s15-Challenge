package com.library.service;

import com.library.models.*;

import java.time.LocalDate;
import java.util.*;

public class Library {
    private Map<Integer, Book> books;
    private Map<String, Reader> readers;
    private Map<String, Set<Book>> categories;
    private Map<Integer, Bill> bills;
    private int billIdCounter;

    public Library() {
        this.books = new HashMap<>();
        this.readers = new HashMap<>();
        this.categories = new HashMap<>();
        this.bills = new HashMap<>();
        this.billIdCounter = 1;
    }

    public void addBook(int bookID, String authorName, String name, double price, String status, String edition, String dateOfPurchase, String category) {
        Author author = new Author(authorName);
        Book book = new Book(bookID, author, name, price, status, edition, dateOfPurchase);
        books.put(bookID, book);
        categories.computeIfAbsent(category, k -> new HashSet<>()).add(book);
    }

    public void updateBook(int bookID, String name, double price, String status, String edition, String dateOfPurchase, String category) {
        Book book = books.get(bookID);
        if (book != null) {
            if (name != null) book.setName(name);
            if (price > 0) book.setPrice(price);
            if (status != null) book.updateStatus(status);
            if (edition != null) book.setEdition(edition);
            if (dateOfPurchase != null) book.setDateOfPurchase(dateOfPurchase);
            // Kategori güncellemesi için eski kategoriden çıkar, yeni kategoriye ekle
            for (Set<Book> catBooks : categories.values()) {
                if (catBooks.remove(book)) break;
            }
            categories.computeIfAbsent(category, k -> new HashSet<>()).add(book);
            System.out.println("Book updated: ID " + bookID);
        } else {
            System.out.println("Book not found: ID " + bookID);
        }
    }

    public void removeBook(int bookID) {
        Book book = books.remove(bookID);
        if (book != null) {
            for (Set<Book> catBooks : categories.values()) {
                catBooks.remove(book);
            }

            System.out.println("Book removed: ID " + bookID);
        } else {
            System.out.println("Book not found: ID " + bookID);
        }
    }

    public void addReader(Reader reader) {
        readers.put(reader.getName(), reader);
    }

    public boolean lendBook(int bookID, String readerName) {
        Book book = books.get(bookID);
        Reader reader = readers.get(readerName);
        if (book != null && reader != null && book.getOwner() == null && reader.borrowBook(book)) {
            book.setOwner(reader);
            Bill bill = new Bill(billIdCounter++, reader.getName(), bookID, 10.0, LocalDate.now());
            bills.put(bill.getId(), bill);
            System.out.println("Book lent: " + book.getName() + " to " + readerName + ", Bill ID: " + bill.getId());
            return true;
        }
        System.out.println("Cannot lend book: Book not available or reader limit reached.");
        return false;
    }

    public boolean returnBook(int bookID, String readerName) {
        Book book = books.get(bookID);
        Reader reader = readers.get(readerName);
        if (book != null && reader != null && book.getOwner() == reader && reader.returnBook(book)) {
            book.setOwner(null);
            for (Bill bill : bills.values()) {
                if (bill.getReaderName().equals(readerName) && bill.getBookID() == bookID) {
                    bills.remove(bill.getId());
                    System.out.println("Book returned: " + book.getName() + ", Refunded: $" + bill.getAmount());
                    break;
                }
            }
            return true;
        }
        System.out.println("Cannot return book: Book not borrowed by this reader.");
        return false;
    }

    public void displayBooksByCategory(String category) {
        Set<Book> catBooks = categories.get(category);
        if (catBooks != null && !catBooks.isEmpty()) {
            System.out.println("Books in category " + category + ":");
            catBooks.forEach(Book::display);
        } else {
            System.out.println("No books found in category: " + category);
        }
    }

    public void displayBooksByAuthor(String authorName) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.getAuthor() != null && book.getAuthor().getName().equalsIgnoreCase(authorName)) {
                foundBooks.add(book);
            }
        }
        if (!foundBooks.isEmpty()) {
            System.out.println("Books by " + authorName + ":");
            foundBooks.forEach(Book::display);
        } else {
            System.out.println("No books found by author: " + authorName);
        }
    }

    public Book findBookById(int id) {
        Book book = books.get(id);
        if (book != null) {
            book.display();
            return book;
        } else {
            System.out.println("Book not found with ID: " + id);
            return null;
        }
    }

    public List<Book> findBooksByTitle(String title) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.getName().toLowerCase().contains(title.toLowerCase())) {
                book.display();
                foundBooks.add(book);
            }
        }
        if (foundBooks.isEmpty()) {
            System.out.println("No books found with title containing: " + title);
        }
        return foundBooks;
    }

    public List<Book> findBooksByAuthor(String author) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.getAuthor() != null && book.getAuthor().getName().toLowerCase().contains(author.toLowerCase())) {
                book.display();
                foundBooks.add(book);
            }
        }
        if (foundBooks.isEmpty()) {
            System.out.println("No books found by author: " + author);
        }
        return foundBooks;
    }
}

class Bill {
    private int id;
    private String readerName;
    private int bookID;
    private double amount;
    private LocalDate issueDate;

    public Bill(int id, String readerName, int bookID, double amount, LocalDate issueDate) {
        this.id = id;
        this.readerName = readerName;
        this.bookID = bookID;
        this.amount = amount;
        this.issueDate = issueDate;
    }

    public int getId() {
        return id;
    }

    public String getReaderName() {
        return readerName;
    }

    public int getBookID() {
        return bookID;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }
}