import javax.swing.*;

public class Product {
    // Class attributes
    private String name;
    private double price;
    JButton buy;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        this.buy = new JButton("BUY " + name.toUpperCase());
    }

    public ProductEntry toProductEntry() {
        return new ProductEntry(name, price, 1, price);
    }

    public Object[] toObjectArray() {
        return new Object[]{name, price};
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
