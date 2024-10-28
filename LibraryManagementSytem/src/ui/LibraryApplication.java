package ui;
// Import all the required packages
import java.time.LocalDate;
import java.util.Scanner;
import models.Book;
import models.LibraryItem;
import models.Magazine;
import services.Library;

public class LibraryApplication {
    private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Display a list of options to the user
    
        boolean exit = false;
        while (!exit) {
            System.out.println("Library Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Add Magazine");
            System.out.println("3. Remove Item");
            System.out.println("4. Find Item by Title");
            System.out.println("5. List All Items");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            // Check option selected and execute appropriate method
            switch (choice) {
                case 1 -> addBook();
                case 2 -> addMagazine();
                case 3 -> removeItem();
                case 4 -> findItem();
                case 5 -> library.listItems();
                case 6 -> exit = true;
                default -> System.out.println("Invalid choice.");
            }
        }
    }
    // Adding a book
    private static void addBook() {
        System.out.print("Enter Book ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Book Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter Book ISBN: ");
        String isbn = scanner.nextLine();

        LibraryItem book = new Book(id, title, author, isbn);
        library.addItem(book);
    }
    // Adding a magazine
    private static void addMagazine() {
        System.out.print("Enter Magazine ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Magazine Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Issue Date (YYYY-MM-DD): ");
        LocalDate issueDate = LocalDate.parse(scanner.nextLine());

        LibraryItem magazine = new Magazine(id, title, issueDate);
        library.addItem(magazine);
    }
    // Removing items
    private static void removeItem() {
        System.out.print("Enter Item ID to remove item: ");
        String id = scanner.nextLine();
        library.removeItem(id);
    }
    // Finding an item
    private static void findItem() {
        System.out.print("Enter Item Title to find: ");
        String title = scanner.nextLine();
        LibraryItem item = library.findItemByTitle(title);
        System.out.println(item != null ? item.getDetails() : "Item not found.");
    }
}
