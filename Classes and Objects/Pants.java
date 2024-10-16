package booksandclothesinheritence;

public class Pants extends Clothing {
    private String length;
    private String waist;

    // Constructor
    public Pants() {
        super(); // Call the constructor of the superclass Clothing
    }

    public Pants(String type, String brand, String length, String waist, String color, double price, int inStock) {
        super(type, brand, color); // Call the constructor of the superclass Clothing
        setLength(length);
        setWaist(waist);
        setPrice(price);
        setInStock(inStock);
    }

    // Getter and setter methods for length
    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    // Getter and setter methods for waist
    public String getWaist() {
        return waist;
    }

    public void setWaist(String waist) {
        this.waist = waist;
    }

    // toString() method to provide a custom string representation
    @Override
    public String toString() {
        return String.format("%s %s, %s, Length: %s, Waist: %s", getBrand(), getType(), getColor(), getLength(), getWaist());
    }
}