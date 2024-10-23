package LibraryManagement;

import java.util.ArrayList;
import java.util.Scanner;

class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("1. Add a book");
            System.out.println("2. Borrow a book");
            System.out.println("3. Return a book");
            System.out.println("4. List all books");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            switch (option) {
                case 1:
                    addBook();
                    break;
                case 2:
                    borrowBook();
                    break;
                case 3:
                    returnBook();
                    break;
                case 4:
                    listBooks();
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting the library system...");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        Book book = new Book(title, author);
        books.add(book);
        System.out.println("Book added: " + book + ": \"" + title + "\" " + author);
    }

    private void borrowBook() {
        System.out.print("Enter book title to borrow: ");
        String title = scanner.nextLine();
        for (Book book:books) {
            if (book.getTittle().equalsIgnoreCase(title)) {
                book.borrow();
                return;
            }
        }
        System.out.println("Book not found.");
    }

    private void returnBook() {
        System.out.print("Enter book title to return: ");
        String title = scanner.nextLine();
        for (Book book:books) {
            if (book.getTittle().equalsIgnoreCase(title)) {
                book.returnBook();
                return;
            }
        }
        System.out.println("Book not found.");
    }

    private void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library");
        }
        else {
            System.out.println("Books in the library: ");
            for (Book book:books) {
                System.out.println(book);
            }
        }
    }
}
