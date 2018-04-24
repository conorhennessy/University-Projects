package ass;

public class Book extends LibraryItem {
    public String author;
    public String publisher;
    public Book(String itemName, String refNum, int yearOfPublication, String author, String publisher) {
        super(itemName, refNum, yearOfPublication);
        this.author = author;
        this.publisher = publisher;
    }
    @Override
    public String toString() {
        return String.format("\"%s\", Ref Num: %s, Year Published: %d, Author: %s, Publisher: %s", itemName, refNum, yearOfPublication, author, publisher);
    }
}
