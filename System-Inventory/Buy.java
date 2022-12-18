import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Buy extends Stock {
    static JPanel buyBotPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));

    static JButton cart = new JButton();

    public static void BuyUI() {
        ImageIcon cartIcon = new ImageIcon(
                new ImageIcon("Assets\\CartWhiteMode.png")
                        .getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        JPanel topPanel = new JPanel();
        Functions functions = new Functions();
        JButton search = new JButton("SEARCH");
        JButton refresh = new JButton("REFRESH");
        JTextField searchField = new JTextField();

        // Here

        searchField.setPreferredSize(new Dimension(700, 50));
        searchField.setBackground(Color.WHITE);
        searchField.setFont(new Font("Arial", Font.BOLD, 25));
        searchField.setForeground(Color.black);
        searchField.setHorizontalAlignment(JTextField.CENTER);

        search.setPreferredSize(new Dimension(150, 50));
        search.setBackground(Color.WHITE);
        search.setFont(new Font("Arial", Font.BOLD, 20));
        search.setFocusPainted(false);
        search.setForeground(Color.black);

        refresh.setName("Refresh");
        refresh.setPreferredSize(new Dimension(150, 50));
        refresh.setBackground(Color.WHITE);
        refresh.setFont(new Font("Arial", Font.BOLD, 20));
        refresh.setFocusPainted(false);
        refresh.setForeground(Color.black);
        functions.BuyFunctions(refresh);

        cart.setName("Cart");
        cart.setPreferredSize(new Dimension(50, 50));
        cart.setFont(new Font("Arial", Font.BOLD, 25));
        cart.setContentAreaFilled(false);
        cart.setFocusPainted(false);
        cart.setBorderPainted(false);
        cart.setIcon(cartIcon);
        functions.BuyFunctions(cart);

        topPanel.add(searchField);
        topPanel.add(search);
        topPanel.add(refresh);
        topPanel.add(cart);
        topPanel.setOpaque(false);
        topPanel.setBorder(BorderFactory.createTitledBorder("Some Stupid Options"));

        buyBotPanel.setOpaque(false);
        buyBotPanel.setBorder(BorderFactory.createTitledBorder("Some Stupid Products"));

        buyPanel.add(topPanel, BorderLayout.NORTH);
        buyPanel.add(buyBotPanel, BorderLayout.CENTER);
        buyPanel.setOpaque(false);
        buyPanel.setBorder(new EmptyBorder(20, 80, 25, 80));

        cartPanel.setOpaque(false);
    }

    public static JPanel generateBuyItem() {
        JPanel stockItem = new JPanel(new BorderLayout());
        JLabel buyImage = new JLabel();
        JPanel buyDescription = new JPanel();
        JPanel buyOption = new JPanel();
        Functions functions = new Functions();
        JLabel itemName = new JLabel("L RYUZAKI (60)", SwingConstants.CENTER);
        JLabel price = new JLabel("₱ 1,600", SwingConstants.CENTER);

        JButton addCart = new JButton("ADD TO CART");

        ImageIcon imageIcon = new ImageIcon(
                new ImageIcon("Assets\\ryuzaki.jpg")
                        .getImage().getScaledInstance(250, 200, Image.SCALE_SMOOTH));

        // Here
        addCart.setName("addToCart");
        addCart.setPreferredSize(new Dimension(250, 80));
        addCart.setBackground(Color.green);
        addCart.setFont(new Font("Arial", Font.BOLD, 20));
        addCart.setFocusPainted(false);
        addCart.setForeground(Color.black);
        functions.StocksFunctions(addCart);

        buyDescription.setLayout(new GridBagLayout());
        buyOption.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.VERTICAL;

        buyOption.setVisible(false);
        buyOption.setBounds(0, 210, 250, 80);
        buyOption.setOpaque(false);
        buyOption.add(addCart, gbc);

        itemName.setFont(new Font("Arial", Font.BOLD, 30));
        itemName.setPreferredSize(new Dimension(250, 40));
        itemName.setForeground(Color.BLACK);
        price.setFont(new Font("Arial", Font.BOLD, 25));
        price.setPreferredSize(new Dimension(250, 50));
        price.setForeground(Color.BLACK);

        buyDescription.setPreferredSize(new Dimension(250, 100));
        buyDescription.setOpaque(false);
        buyDescription.add(itemName, gbc);
        buyDescription.add(price, gbc);

        stockItem.setName("Option");
        stockItem.setPreferredSize(new Dimension(250, 300));

        stockItem.add(buyOption, BorderLayout.SOUTH);
        stockItem.add(buyImage, BorderLayout.NORTH);
        stockItem.add(buyDescription, BorderLayout.SOUTH);

        buyImage.setPreferredSize(new Dimension(250, 200));
        buyImage.setIcon(imageIcon);
        buyImage.setLayout(new BorderLayout());
        buyImage.setOpaque(true);
        buyImage.setBackground(Color.white);

        return stockItem;
    }

    public static void Cart() {
        JButton order = new JButton("ORDER");

        order.setFocusPainted(false);
        order.setBorderPainted(false);
        order.setPreferredSize(new Dimension(200, 100));
        order.setFont(new Font("Arial", Font.PLAIN, 50));

        cartPanel.add(order);
        cartPanel.setOpaque(false);
        cartPanel.setBorder(new EmptyBorder(20, 80, 25, 80));
    }

    public static void Receipt() {
        JFrame frame = new JFrame();

        frame.setSize(new Dimension(400, 600));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setUndecorated(true);

    }
}
