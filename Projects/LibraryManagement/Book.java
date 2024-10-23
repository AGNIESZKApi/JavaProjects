package LibraryManagement;

public class Book {
    private String tittle;
    private String author;
    private boolean isAvailable;

    public Book(String tittle, String author) {
        this.tittle = tittle;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    public String getTittle() {
        return tittle;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void borrow() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("You've borrowed \"" + tittle + "\"");
        } else {
            System.out.println("Sorry, \"" + tittle + "\" is already borrowed.");
        }
    }

    public void returnBook() {
        isAvailable = true;
        System.out.println("You've already returned \"" + tittle + "\"");
    }

}
