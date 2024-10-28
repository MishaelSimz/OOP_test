package services;
// Importing the necessary packages
import java.util.ArrayList;
import java.util.List;
import models.LibraryItem;

public class Library {
    // Instance of the library class
    private List<LibraryItem> libraryItems = new ArrayList<>();
    // adding item    
    public void addItem(LibraryItem item){
        libraryItems.add(item);
        System.out.println("Item added to library");
    }
    // removing item    
    public void removeItem(String id){
        libraryItems.removeIf(item -> item.toString().contains("ID: " + id));
        System.out.println("Item has been removed from the library.");
    }
    // finding items    
    public LibraryItem findItemByTitle(String title) {
        return libraryItems.stream()
                .filter(item -> item.toString().contains("Title: " + title))
                .findFirst()
                .orElse(null);
    }
    // Listing the items   
    public void listItems() {
        libraryItems.forEach(item -> System.out.println(item.getDetails()));
    }

}
