package shop;

import java.text.DecimalFormat;

public class Product {
    public String PID;
    public String artist;
    public String title;
    public String description;
    public int price;
    public String thumbnail;
    public String fullimage;

    public Product(
            String PID, String artist, String title,
            String description, int price, String thumbnail, String fullimage) {
        this.PID = PID;
        this.artist = artist;
        this.title = title;
        this.description = description;
        this.price = price;
        this.thumbnail = thumbnail;
        this.fullimage = fullimage;
    }

    public String toString() {
        return title + "\t " + price;
    }

    public String getPrice() {
        double doubleTotal = (double) price;
        double total = doubleTotal/100;
        DecimalFormat df = new DecimalFormat("#0.00");
        return String.valueOf(df.format(total));
    }

}
