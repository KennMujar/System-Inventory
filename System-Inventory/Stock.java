import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.RoundRectangle2D;

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
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class Stock extends Main {
    static JPanel stockBotPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));
    static JFrame addFrame = new JFrame();
    static JFrame editFrame = new JFrame();

    static JLabel stockImage = new JLabel();

    static JTextField searchField = new JTextField("SEARCH PRODUCT");

    static JButton addNew = new JButton("+");

    public static void StockUI() {

        /*
         * JScrollPane jsp = new JScrollPane();
         * jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
         * jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
         */

        // If JPanel is full
        /*
         * frame = new JFrame();
         * frame.setBounds(0, 0, 820, 950);
         * frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         * frame.getContentPane().setLayout(null);
         * JPanel panel = new JPanel();
         * panel.setLayout(null);
         * 
         * final JScrollPane scrollPanel = new JScrollPane(
         * panel,
         * ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
         * ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
         * scrollPanel.setBounds(0, 0, 800, 900);
         * panel.setBounds(0, 0, 1920, 1080);
         * panel.setPreferredSize(new Dimension(1920, 1080));
         * frame.getContentPane().add(scrollPanel);
         */
        JPanel topPanel = new JPanel();
        Functions functions = new Functions();
        JButton search = new JButton("SEARCH");
        JButton refresh = new JButton("REFRESH");

        searchField.setPreferredSize(new Dimension(700, 50));
        searchField.setBackground(Color.WHITE);
        searchField.setFont(new Font("Arial", Font.BOLD, 25));
        searchField.setForeground(Color.black);
        searchField.setHorizontalAlignment(JTextField.CENTER);

        search.setName("Search");
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
        functions.StocksFunctions(refresh);

        addNew.setName("addNew");
        addNew.setPreferredSize(new Dimension(150, 200));
        addNew.setFont(new Font("Arial", Font.BOLD, 40));
        addNew.setFocusPainted(false);
        addNew.setBorderPainted(false);
        addNew.setBackground(new Color(128, 128, 128));
        addNew.setForeground(Color.black);
        functions.StocksFunctions(addNew);

        topPanel.add(searchField);
        topPanel.add(search);
        topPanel.add(refresh);
        topPanel.setOpaque(false);
        topPanel.setBorder(BorderFactory.createTitledBorder("Some Stupid Options"));

        stockBotPanel.add(addNew);

        stockBotPanel.setOpaque(false);
        stockBotPanel.setBorder(BorderFactory.createTitledBorder("Some Stupid Products"));

        stockPanel.add(topPanel, BorderLayout.NORTH);
        stockPanel.add(stockBotPanel, BorderLayout.CENTER);
        stockPanel.setOpaque(false);
        stockPanel.setBorder(new EmptyBorder(20, 80, 25, 80));

    }

    public static JPanel generateStockItem() {
        // Here
        Functions functions = new Functions();
        JPanel stockNewItem = new JPanel(new BorderLayout());
        JPanel stockDescription = new JPanel();
        JPanel stockOption = new JPanel();

        JLabel itemName = new JLabel("VANITAS (60)", SwingConstants.CENTER);
        JLabel price = new JLabel("₱ 1,600", SwingConstants.CENTER);
        JLabel newImage = new JLabel();
        JButton editButton = new JButton("EDIT");
        JButton removeButton = new JButton("REMOVE");

        ImageIcon imageIcon = new ImageIcon(
                new ImageIcon("Assets\\Picture.jpg")
                        .getImage().getScaledInstance(250, 200, Image.SCALE_SMOOTH));

        // Here
        editButton.setName("Edit");
        editButton.setPreferredSize(new Dimension(250, 60));
        editButton.setBackground(new Color(90, 171, 97));
        editButton.setFont(new Font("Arial", Font.BOLD, 20));
        editButton.setFocusPainted(false);
        editButton.setForeground(Color.black);
        functions.StocksFunctions(editButton);

        removeButton.setName("Remove");
        removeButton.setPreferredSize(new Dimension(250, 60));
        removeButton.setBackground(new Color(216, 49, 49));
        removeButton.setFont(new Font("Arial", Font.BOLD, 20));
        removeButton.setFocusPainted(false);
        removeButton.setForeground(Color.black);
        functions.StocksFunctions(removeButton);

        stockDescription.setLayout(new GridBagLayout());
        stockOption.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.VERTICAL;

        stockOption.setName("Option");
        stockOption.setVisible(false);
        stockOption.setBounds(0, 180, 250, 120);
        stockOption.setOpaque(false);
        stockOption.add(editButton, gbc);
        stockOption.add(removeButton, gbc);

        itemName.setFont(new Font("Arial", Font.BOLD, 30));
        itemName.setPreferredSize(new Dimension(250, 40));
        itemName.setForeground(Color.BLACK);
        price.setFont(new Font("Arial", Font.BOLD, 25));
        price.setPreferredSize(new Dimension(250, 50));
        price.setForeground(Color.BLACK);

        stockDescription.setPreferredSize(new Dimension(250, 100));
        stockDescription.setOpaque(false);
        stockDescription.add(itemName, gbc);
        stockDescription.add(price, gbc);

        stockNewItem.setName("StockItem");
        stockNewItem.setPreferredSize(new Dimension(250, 300));
        stockNewItem.add(stockOption, BorderLayout.SOUTH);
        stockNewItem.add(newImage, BorderLayout.NORTH);
        stockNewItem.add(stockDescription, BorderLayout.SOUTH);

        newImage.setPreferredSize(new Dimension(250, 200));
        newImage.setIcon(imageIcon);
        newImage.setLayout(new BorderLayout());
        newImage.setOpaque(true);
        newImage.setBackground(Color.white);

        // Hover Item Options
        stockNewItem.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                stockOption.setVisible(true);
            }
        });
        stockPanel.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                stockOption.setVisible(false);

            }
        });

        return stockNewItem;

    }

    public static void addFrame() {
        Functions functions = new Functions();
        JLabel space = new JLabel();
        ImageIcon imageIcon = new ImageIcon(
                new ImageIcon("Assets\\Default.png")
                        .getImage().getScaledInstance(230, 230, Image.SCALE_SMOOTH));

        JTextField itemName = new JTextField("  ");
        JTextField quantity = new JTextField("  ");
        JTextField price = new JTextField(" ");
        JLabel nameLabel = new JLabel("Name");
        JLabel quantityLabel = new JLabel("Quantity");
        JLabel priceLabel = new JLabel("Price");

        JButton selectImage = new JButton("Choose");
        JPanel panel = new JPanel();
        JButton cancel = new JButton("CANCEL");
        JButton add = new JButton("ADD");

        stockImage.setBounds(65, 10, 230, 230);
        stockImage.setIcon(imageIcon);

        selectImage.setName("Select");
        selectImage.setBounds(230, 245, 90, 30);
        selectImage.setFont(new Font("Arial", Font.BOLD, 12));
        selectImage.setFocusPainted(false);
        selectImage.setForeground(Color.black);
        functions.StocksFunctions(selectImage);

        nameLabel.setBounds(30, 285, 70, 40);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        itemName.setBounds(120, 285, 200, 35);
        itemName.setFont(new Font("Arial", Font.PLAIN, 20));

        quantityLabel.setBounds(30, 330, 100, 40);
        quantityLabel.setFont(new Font("Arial", Font.BOLD, 20));
        quantity.setBounds(120, 330, 200, 35);
        quantity.setFont(new Font("Arial", Font.PLAIN, 20));

        priceLabel.setBounds(30, 375, 100, 40);
        priceLabel.setFont(new Font("Arial", Font.BOLD, 20));
        price.setBounds(120, 375, 200, 35);
        price.setFont(new Font("Arial", Font.PLAIN, 20));

        cancel.setName("Cancel");
        cancel.setFont(new Font("Arial", Font.BOLD, 25));
        cancel.setBackground(new Color(216, 49, 49));
        cancel.setFocusPainted(false);
        cancel.setForeground(Color.white);

        cancel.setPreferredSize(new Dimension(150, 60));
        functions.StocksFunctions(cancel);

        add.setName("Add");
        add.setFont(new Font("Arial", Font.BOLD, 25));
        add.setFocusPainted(false);
        add.setForeground(Color.white);
        add.setBackground(new Color(90, 171, 97));
        add.setPreferredSize(new Dimension(150, 60));
        functions.StocksFunctions(add);

        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
        panel.add(cancel);
        panel.add(Box.createHorizontalGlue());
        panel.add(add);
        panel.setBorder(new EmptyBorder(20, 20, 15, 20));

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {

        }

        addFrame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                addFrame.setShape(new RoundRectangle2D.Double(0, 0, addFrame.getWidth(), addFrame.getHeight(), 80, 80));
            }
        });

        addFrame.setFocusable(true);
        addFrame.setUndecorated(true);
        addFrame.setVisible(true);
        addFrame.setResizable(false);
        addFrame.setSize(350, 500);
        addFrame.setLocationRelativeTo(null);
        addFrame.add(stockImage);
        addFrame.add(selectImage);
        addFrame.add(nameLabel);
        addFrame.add(itemName);
        addFrame.add(quantityLabel);
        addFrame.add(quantity);
        addFrame.add(priceLabel);
        addFrame.add(price);
        addFrame.add(space);
        addFrame.add(panel, BorderLayout.SOUTH);
    }

    public static void editFrame() {
        Functions functions = new Functions();
        JLabel space = new JLabel();
        ImageIcon imageIcon = new ImageIcon(
                new ImageIcon("Assets\\Default.png")
                        .getImage().getScaledInstance(230, 230, Image.SCALE_SMOOTH));

        JTextField itemName = new JTextField("  ");
        JTextField quantity = new JTextField("  ");
        JTextField price = new JTextField(" ");
        JLabel nameLabel = new JLabel("Name");
        JLabel quantityLabel = new JLabel("Quantity");
        JLabel priceLabel = new JLabel("Price");

        JButton selectImage = new JButton("Choose");
        JPanel panel = new JPanel();
        JButton cancel = new JButton("CANCEL");
        JButton add = new JButton("SAVE");

        stockImage.setBounds(65, 10, 230, 230);
        stockImage.setIcon(imageIcon);

        selectImage.setName("Select");
        selectImage.setBounds(230, 245, 90, 30);
        selectImage.setFont(new Font("Arial", Font.BOLD, 12));
        selectImage.setFocusPainted(false);
        selectImage.setForeground(Color.black);
        functions.StocksFunctions(selectImage);

        nameLabel.setBounds(30, 285, 70, 40);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        itemName.setBounds(120, 285, 200, 35);
        itemName.setFont(new Font("Arial", Font.PLAIN, 20));

        quantityLabel.setBounds(30, 330, 100, 40);
        quantityLabel.setFont(new Font("Arial", Font.BOLD, 20));
        quantity.setBounds(120, 330, 200, 35);
        quantity.setFont(new Font("Arial", Font.PLAIN, 20));

        priceLabel.setBounds(30, 375, 100, 40);
        priceLabel.setFont(new Font("Arial", Font.BOLD, 20));
        price.setBounds(120, 375, 200, 35);
        price.setFont(new Font("Arial", Font.PLAIN, 20));

        cancel.setName("Cancel");
        cancel.setFont(new Font("Arial", Font.BOLD, 25));
        cancel.setFocusPainted(false);
        cancel.setForeground(Color.white);
        cancel.setBackground(Color.red);
        cancel.setPreferredSize(new Dimension(150, 60));
        functions.StocksFunctions(cancel);

        add.setName("Save");
        add.setFont(new Font("Arial", Font.BOLD, 25));
        add.setFocusPainted(false);
        add.setForeground(Color.white);
        add.setBackground(Color.GREEN);
        add.setPreferredSize(new Dimension(150, 60));
        functions.StocksFunctions(add);

        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
        panel.add(cancel);
        panel.add(Box.createHorizontalGlue());
        panel.add(add);
        panel.setBorder(new EmptyBorder(20, 20, 15, 20));

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {

        }

        editFrame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                editFrame.setShape(
                        new RoundRectangle2D.Double(0, 0, editFrame.getWidth(), editFrame.getHeight(), 80, 80));
            }
        });

        editFrame.setFocusable(true);
        editFrame.setUndecorated(true);
        editFrame.setVisible(true);
        editFrame.setResizable(false);
        editFrame.setSize(350, 500);
        editFrame.setLocationRelativeTo(null);
        editFrame.add(stockImage);
        editFrame.add(selectImage);
        editFrame.add(nameLabel);
        editFrame.add(itemName);
        editFrame.add(quantityLabel);
        editFrame.add(quantity);
        editFrame.add(priceLabel);
        editFrame.add(price);
        editFrame.add(space);
        editFrame.add(panel, BorderLayout.SOUTH);
    }

}
