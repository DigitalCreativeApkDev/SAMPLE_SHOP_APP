import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Main {
    // Static variables for the pages available
    static CartPage cartPage = new CartPage();
    static ConfirmationPage confirmationPage = new ConfirmationPage();
    static HomePage homePage = new HomePage();
    static ShopPage shopPage = new ShopPage();
    static boolean homeFrameInitialised = false;
    static boolean shopFrameInitialised = false;
    static boolean cartFrameInitialised = false;
    static boolean confirmationFrameInitialised = false;

    static void initialiseHomeFrame() {
        JFrame homeFrame = new JFrame("Home Page");

        // Creating panel
        JPanel homePanel = new JPanel();
        homePanel.setLayout(new FlowLayout());

        homePage.shopPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homeFrame.setVisible(false);
                if (!shopFrameInitialised) {
                    initialiseShopFrame();
                }
            }
        });

        homePage.cartPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homeFrame.setVisible(false);
                if (!cartFrameInitialised) {
                    initialiseCartFrame();
                }
            }
        });

        homePanel.add(homePage.shopPageButton);
        homePanel.add(homePage.cartPageButton);
        homePanel.add(homePage.descriptionTextArea);

        JButton refreshButton = new JButton("REFRESH");
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homeFrame.setVisible(false);
                initialiseHomeFrame();
            }
        });
        homePanel.add(refreshButton);

        homeFrame.add(homePanel);
        homeFrame.setSize(400, 150);
        homeFrame.setVisible(true);
        shopFrameInitialised = false;
        cartFrameInitialised = false;
        confirmationFrameInitialised = false;
        homeFrameInitialised = true;
    }

    static void initialiseConfirmationFrame() {
        JFrame confirmationFrame = new JFrame("Confirmation Page");

        // Creating panel
        JPanel confirmationPanel = new JPanel();
        confirmationPanel.setLayout(new FlowLayout());

        confirmationPage.shopAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cartPage.setProductEntries(new ArrayList<>());
                confirmationFrame.setVisible(false);
                if (!homeFrameInitialised) {
                    initialiseHomeFrame();
                }
            }
        });

        confirmationPanel.add(confirmationPage.shopAgainButton);
        confirmationPanel.add(confirmationPage.confirmationTextArea);

        JButton refreshButton = new JButton("REFRESH");
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmationFrame.setVisible(false);
                initialiseConfirmationFrame();
            }
        });
        confirmationPanel.add(refreshButton);

        confirmationFrame.add(confirmationPanel);
        confirmationFrame.setSize(400, 150);
        confirmationFrame.setVisible(true);
        homeFrameInitialised = false;
        shopFrameInitialised = false;
        cartFrameInitialised = false;
        confirmationFrameInitialised = true;
    }

    static void initialiseCartFrame() {
        JFrame cartFrame = new JFrame("Cart Page");

        // Creating panel
        JPanel cartPanel = new JPanel();
        cartPanel.setLayout(new FlowLayout());

        cartPage.homePageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cartFrame.setVisible(false);
                if (!homeFrameInitialised) {
                    initialiseHomeFrame();
                }
            }
        });

        cartPage.shopPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cartFrame.setVisible(false);
                if (!shopFrameInitialised) {
                    initialiseShopFrame();
                }
            }
        });

        cartPage.checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cartFrame.setVisible(false);
                confirmationPage.confirmationTextArea.setText("Thank you for your purchase! You have spent $" +
                        cartPage.calculateTotalSpent() + "!");
                if (!confirmationFrameInitialised) {
                    initialiseConfirmationFrame();
                }
            }
        });

        cartPanel.add(cartPage.homePageButton);
        cartPanel.add(cartPage.shopPageButton);
        cartPanel.add(cartPage.checkoutButton);
        cartPanel.add(cartPage.productEntriesTable);

        for (ProductEntry productEntry : cartPage.getProductEntries()) {
            cartPanel.add(productEntry.remove);
        }

        cartPanel.add(cartPage.totalSpent);

        JButton refreshButton = new JButton("REFRESH");
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cartFrame.setVisible(false);
                initialiseCartFrame();
            }
        });
        cartPanel.add(refreshButton);

        cartFrame.add(cartPanel);
        cartFrame.setSize(400, 800);
        cartFrame.setVisible(true);
        homeFrameInitialised = false;
        shopFrameInitialised = false;
        cartFrameInitialised = true;
        confirmationFrameInitialised = false;
    }

    static void initialiseShopFrame() {
        JFrame shopFrame = new JFrame("Shop Page");

        // Creating panel
        JPanel shopPanel = new JPanel();
        shopPanel.setLayout(new FlowLayout());

        shopPage.homePageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shopFrame.setVisible(false);
                if (!homeFrameInitialised) {
                    initialiseHomeFrame();
                }
            }
        });

        shopPage.cartPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shopFrame.setVisible(false);
                if (!cartFrameInitialised) {
                    initialiseCartFrame();
                }
            }
        });

        shopPanel.add(shopPage.homePageButton);
        shopPanel.add(shopPage.cartPageButton);
        shopPanel.add(shopPage.productsSoldTable);
        for (Product product : shopPage.getProductsSold()) {
            shopPanel.add(product.buy);
        }

        JButton refreshButton = new JButton("REFRESH");
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shopFrame.setVisible(false);
                initialiseShopFrame();
            }
        });
        shopPanel.add(refreshButton);

        shopFrame.add(shopPanel);
        shopFrame.setSize(400, 800);
        shopFrame.setVisible(true);
        homeFrameInitialised = false;
        shopFrameInitialised = true;
        cartFrameInitialised = false;
        confirmationFrameInitialised = false;
    }

    static {
        shopPage.addProduct(new Product("Product 1", 11.99), cartPage);
        shopPage.addProduct(new Product("Product 2", 7.99), cartPage);
        shopPage.addProduct(new Product("Product 3", 13.99), cartPage);
        shopPage.addProduct(new Product("Product 4", 8.99), cartPage);
        shopPage.addProduct(new Product("Product 5", 12.99), cartPage);
        shopPage.addProduct(new Product("Product 6", 9.99), cartPage);
        shopPage.addProduct(new Product("Product 7", 14.99), cartPage);
        shopPage.addProduct(new Product("Product 8", 10.99), cartPage);
    }

    public static void main(String[] args) {
        if (!homeFrameInitialised) {
            // Initialise the home page.
            initialiseHomeFrame();
        }
    }
}
