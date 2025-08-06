package com.library;

import com.library.models.*;
import com.library.service.Library;

import java.util.Scanner;

public class LibraryApp {
    private Scanner scanner;
    private Library library;

    public LibraryApp() {
        this.scanner = new Scanner(System.in);
        this.library = new Library();
    }

    public void start() {
        System.out.println("Library System started at 01:12 PM +03 on Wednesday, August 06, 2025.");
        boolean running = true;

        while (running) {
            System.out.println("\nLibrary Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Update Book");
            System.out.println("3. Remove Book");
            System.out.println("4. Search Book");
            System.out.println("5. Display Books by Category");
            System.out.println("6. Display Books by Author");
            System.out.println("7. Lend Book");
            System.out.println("8. Return Book");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    addBook();
                    break;
                case "2":
                    updateBook();
                    break;
                case "3":
                    removeBook();
                    break;
                case "4":
                    searchBook();
                    break;
                case "5":
                    displayBooksByCategory();
                    break;
                case "6":
                    displayBooksByAuthor();
                    break;
                case "7":
                    lendBook();
                    break;
                case "8":
                    returnBook();
                    break;
                case "0":
                    running = false;
                    System.out.println("Exiting Library System...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        scanner.close();
    }

    private void addBook() {
        System.out.print("Enter Book ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Author Name: ");
        String authorName = scanner.nextLine();
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Price: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter Status: ");
        String status = scanner.nextLine();
        System.out.print("Enter Edition: ");
        String edition = scanner.nextLine();
        System.out.print("Enter Date of Purchase: ");
        String date = scanner.nextLine();
        System.out.print("Enter Category: ");
        String category = scanner.nextLine();

        library.addBook(id, authorName, title, price, status, edition, date, category);
    }

    private void updateBook() {
        System.out.print("Enter Book ID to update: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter new Title (press Enter to skip): ");
        String title = scanner.nextLine().isEmpty() ? null : scanner.nextLine();
        System.out.print("Enter new Price (0 to skip): ");
        double price = Double.parseDouble(scanner.nextLine().isEmpty() ? "0" : scanner.nextLine());
        System.out.print("Enter new Status (press Enter to skip): ");
        String status = scanner.nextLine().isEmpty() ? null : scanner.nextLine();
        System.out.print("Enter new Edition (press Enter to skip): ");
        String edition = scanner.nextLine().isEmpty() ? null : scanner.nextLine();
        System.out.print("Enter new Date of Purchase (press Enter to skip): ");
        String date = scanner.nextLine().isEmpty() ? null : scanner.nextLine();
        System.out.print("Enter new Category (press Enter to skip): ");
        String category = scanner.nextLine().isEmpty() ? null : scanner.nextLine();

        library.updateBook(id, title, price, status, edition, date, category);
    }

    private void removeBook() {
        System.out.print("Enter Book ID to remove: ");
        int id = Integer.parseInt(scanner.nextLine());
        library.removeBook(id);
    }

    private void searchBook() {
        System.out.println("Search by: 1. ID, 2. Title, 3. Author");
        System.out.print("Enter choice: ");
        String searchType = scanner.nextLine();
        switch (searchType) {
            case "1":
                System.out.print("Enter Book ID: ");
                int id = Integer.parseInt(scanner.nextLine());
                library.findBookById(id);
                break;
            case "2":
                System.out.print("Enter Title (or part of it): ");
                String title = scanner.nextLine();
                library.findBooksByTitle(title);
                break;
            case "3":
                System.out.print("Enter Author (or part of it): ");
                String author = scanner.nextLine();
                library.findBooksByAuthor(author);
                break;
            default:
                System.out.println("Invalid search type!");
        }
    }

    private void displayBooksByCategory() {
        System.out.print("Enter Category: ");
        String category = scanner.nextLine();
        library.displayBooksByCategory(category);
    }

    private void displayBooksByAuthor() {
        System.out.print("Enter Author Name: ");
        String authorName = scanner.nextLine();
        library.displayBooksByAuthor(authorName);
    }

    private void lendBook() {
        System.out.print("Enter Book ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Reader Name: ");
        String readerName = scanner.nextLine();
        library.lendBook(id, readerName);
    }

    private void returnBook() {
        System.out.print("Enter Book ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Reader Name: ");
        String readerName = scanner.nextLine();
        library.returnBook(id, readerName);
    }


}