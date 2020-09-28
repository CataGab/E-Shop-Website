package shop;

public class Product implements Comparable<Product>{
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
    @Override               //I added those in order to make the remove button from the basket to work
    public int compareTo(Product other) {
        return 0;
    }

    public String toString() {
        return title + "\t " + price;
    }

    public int hashCode() { return PID.hashCode(); }

    public boolean equals(Object o)
    { return PID==((Product)o).PID;}


}
