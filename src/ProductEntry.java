import javax.swing.JButton;

public class ProductEntry {
    private String item;
    private double price;
    private int quantity;
    private double subtotal;
    JButton remove;

    public ProductEntry(String item, double price, int quantity, double subtotal) {
        this.item = item;
        this.price = price;
        this.quantity = quantity;
        this.subtotal = subtotal;
        this.remove = new JButton("REMOVE " + item.toUpperCase());
    }

    public void increaseQuantity() {
        quantity += 1;
        subtotal += price;
    }

    public Object[] toObjectArray() {
        return new Object[]{item, price, quantity, subtotal};
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
