import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage {
    // Class attributes
    JButton shopPageButton;
    JButton cartPageButton;
    JTextArea descriptionTextArea;

    public HomePage() {
        shopPageButton = new JButton("SHOP");
        cartPageButton = new JButton("CART");
        descriptionTextArea = new JTextArea("Welcome to the shop!");
    }
}
