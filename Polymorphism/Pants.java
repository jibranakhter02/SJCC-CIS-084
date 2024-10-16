public class Pants extends Clothing {
    private int length;
    private int waist;
    
    // Constructor
    public Pants(int itemID, String type, String brand, int length, int waist, String color, double price, int inStock) {
        setItemID(itemID);
        setType(type);
        setBrand(brand);
        setLength(length);
        setWaist(waist);
        setColor(color);
        setPrice(price);
        setInStock(inStock);
    }

    // Getters
    public int getLength() {
        return length;
    }

    public int getWaist() {
        return waist;
    }

    // Setters
    public void setLength(int length) {
        this.length = length;
    }

    public void setWaist(int waist) {
        this.waist = waist;
    }

    // Overriding toString method to include length and waist
    @Override
public String toString() {
    return String.format("%-4d %6.2f %s, %s by %s - Length: %d, Waist: %d, Color: %s, In stock: %d", 
        getItemID(), getPrice(), getType(), getBrand(), getColor(), getLength(), getWaist(), getColor(), getInStock());
}

}