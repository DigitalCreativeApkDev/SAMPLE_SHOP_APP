import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CartPage {
    // Class attributes
    JButton homePageButton;
    JButton shopPageButton;
    JButton checkoutButton;
    private ArrayList<ProductEntry> productEntries;
    JTable productEntriesTable;
    JTextArea totalSpent;

    public CartPage() {
        homePageButton = new JButton("HOME");
        shopPageButton = new JButton("SHOP");
        checkoutButton = new JButton("CHECKOUT");
        this.productEntries = new ArrayList<>();
        productEntriesTable = toJTable();
        totalSpent = new JTextArea("Total = $" + calculateTotalSpent());
    }

    private void updateTotalSpent() {
        totalSpent = new JTextArea("Total = $" + calculateTotalSpent());
    }

    public double calculateTotalSpent() {
        double total = 0; // initial value
        for (ProductEntry productEntry : productEntries) {
            total += productEntry.getSubtotal();
        }
        return total;
    }

    private void updateProductEntriesTable() {
        productEntriesTable = toJTable();
    }

    public ArrayList<ProductEntry> getProductEntries() {
        return productEntries;
    }

    public void setProductEntries(ArrayList<ProductEntry> productEntries) {
        this.productEntries = productEntries;
    }

    private ArrayList<String> getProductEntryNames() {
        ArrayList<String> result = new ArrayList<>();
        for (ProductEntry productEntry : productEntries) {
            result.add(productEntry.getItem());
        }
        return result;
    }

    private ProductEntry getProductEntryByName(String item) {
        for (ProductEntry productEntry : productEntries) {
            if (productEntry.getItem().equals(item)) {
                return productEntry;
            }
        }
        return null;
    }

    public void addProductEntry(ProductEntry productEntry) {
        if (getProductEntryNames().contains(productEntry.getItem())) {
            ProductEntry correspondingEntry = getProductEntryByName(productEntry.getItem());
            assert correspondingEntry != null;
            correspondingEntry.increaseQuantity();
        }
        else {
            productEntry.remove.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    productEntries.remove(productEntry);
                    updateProductEntriesTable();
                    updateTotalSpent();
                }
            });
            productEntries.add(productEntry);
        }
        updateProductEntriesTable();
        updateTotalSpent();
    }

    private JTable toJTable() {
        String[] columnNames = {"Item", "Price", "Quantity", "Subtotal"};
        Object[][] data = new Object[productEntries.size()][5];
        for (int i = 0; i < productEntries.size(); i++) {
            data[i] = productEntries.get(i).toObjectArray();
        }
        return new JTable(data, columnNames);
    }
}
