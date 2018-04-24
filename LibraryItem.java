package ass;

public abstract class LibraryItem {
    public String itemName;
    public String refNum;
    public int yearOfPublication;
    public LibraryItem(String itemName, String refNum, int yearOfPublication) {
        this.itemName = itemName;
        this.refNum = refNum;
        this.yearOfPublication = yearOfPublication;
    }
}