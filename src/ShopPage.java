import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ShopPage {
    // Class attributes
    JButton homePageButton;
    JButton cartPageButton;
    private ArrayList<Product> productsSold;
    JTable productsSoldTable;

    public ShopPage() {
        homePageButton = new JButton("HOME");
        cartPageButton = new JButton("CART");
        productsSold = new ArrayList<>();
        productsSoldTable = toJTable();
    }

    public void addProduct(Product product, CartPage cartPage) {
        product.buy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cartPage.addProductEntry(product.toProductEntry());
                updateProductEntriesTable();
            }
        });

        productsSold.add(product);
        updateProductEntriesTable();
    }

    private void updateProductEntriesTable() {
        productsSoldTable = toJTable();
    }

    public ArrayList<Product> getProductsSold() {
        return productsSold;
    }

    public void setProductsSold(ArrayList<Product> productsSold) {
        this.productsSold = productsSold;
    }

    private JTable toJTable() {
        String[] columnNames = {"Name", "Price"};
        Object[][] data = new Object[productsSold.size()][5];
        for (int i = 0; i < productsSold.size(); i++) {
            data[i] = productsSold.get(i).toObjectArray();
        }
        return new JTable(data, columnNames);
    }
}
