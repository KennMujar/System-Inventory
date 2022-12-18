
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author KennMujar
 */

public class Functions extends Buy {
    public boolean isWhite = true;
    static ImageIcon WhiteMode = new ImageIcon(
            new ImageIcon("Assets\\CartWhiteMode.png")
                    .getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
    static ImageIcon DarkMode = new ImageIcon(
            new ImageIcon("Assets\\CartDarkMode.png")
                    .getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
    static ImageIcon hoverWhiteMode = new ImageIcon(
            new ImageIcon(
                    "Assets\\CartHoverWhiteMode.png")
                    .getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
    static ImageIcon hoverDarkMode = new ImageIcon(
            new ImageIcon(
                    "Assets\\CartHoverDarkMode.png")
                    .getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));

    public void optionPanelButton(JButton button) {

        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                String clickedButton = button.getName();

                switch (clickedButton) {
                    case "Home" -> {
                        // We set button to enable and disable
                        home.setEnabled(false);
                        stocks.setEnabled(true);
                        buy.setEnabled(true);
                        // Setting visibility of Panels
                        homePanel.setVisible(true);
                        stockPanel.setVisible(false);
                        buyPanel.setVisible(false);
                        cartPanel.setVisible(false);

                    }
                    case "Stocks" -> {
                        // Set buttons to enable and disable
                        home.setEnabled(true);
                        stocks.setEnabled(false);
                        buy.setEnabled(true);

                        // Set Visibility of Panels
                        homePanel.setVisible(false);
                        stockPanel.setVisible(true);
                        buyPanel.setVisible(false);
                        cartPanel.setVisible(false);

                    }

                    case "Buy" -> {
                        // We set button to enable and disable
                        home.setEnabled(true);
                        stocks.setEnabled(true);
                        buy.setEnabled(false);
                        // Setting Panel Visibility
                        homePanel.setVisible(false);
                        stockPanel.setVisible(false);
                        buyPanel.setVisible(true);
                        cartPanel.setVisible(false);

                    }
                    case "Dark Mode" -> {

                        if (isWhite) {
                            optionPanel.setBackground(new Color(52, 55, 70, 255));
                            frame.getContentPane().setBackground(new Color(33, 34, 44, 255));
                            addNew.setBackground(Color.WHITE);
                            isWhite = false;
                        } else {
                            optionPanel.setBackground(new Color(193, 193, 193, 255));
                            frame.getContentPane().setBackground(Color.white);
                            addNew.setBackground(new Color(128, 128, 128));
                            isWhite = true;
                        }

                    }
                    case "Exit" -> {
                        System.exit(0);
                    }
                }
                // Check if Button is Enabled so we can change the background color
                if (isWhite) {
                    if (home.isEnabled()) {
                        home.setContentAreaFilled(false);
                    } else {
                        home.setContentAreaFilled(true);
                        home.setBackground(Color.WHITE);

                    }

                    if (stocks.isEnabled()) {
                        stocks.setContentAreaFilled(false);
                    } else {
                        stocks.setContentAreaFilled(true);
                        stocks.setBackground(Color.WHITE);
                    }

                    if (buy.isEnabled()) {
                        buy.setContentAreaFilled(false);
                    } else {
                        buy.setContentAreaFilled(true);
                        buy.setBackground(Color.WHITE);
                    }
                    cart.setIcon(WhiteMode);

                } else {
                    if (home.isEnabled()) {
                        home.setContentAreaFilled(false);
                    } else {
                        home.setContentAreaFilled(true);
                        home.setBackground(new Color(33, 34, 44, 255));

                    }

                    if (stocks.isEnabled()) {
                        stocks.setContentAreaFilled(false);
                    } else {
                        stocks.setContentAreaFilled(true);
                        stocks.setBackground(new Color(33, 34, 44, 255));
                    }

                    if (buy.isEnabled()) {
                        buy.setContentAreaFilled(false);
                    } else {
                        buy.setContentAreaFilled(true);
                        buy.setBackground(new Color(33, 34, 44, 255));
                    }
                    cart.setIcon(DarkMode);

                }

            }
        });

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setContentAreaFilled(true);
                if (button.isEnabled()) {
                    if (isWhite)
                        button.setBackground(Color.WHITE);
                    else {
                        button.setBackground(new Color(33, 34, 44, 255));
                    }
                }

            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (button.isEnabled())
                    button.setContentAreaFilled(false);
            }
        });

    }

    public void StocksFunctions(JButton button) {
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                String clickedButton = button.getName();

                switch (clickedButton) {
                    case "addNew":
                        if (!addFrame.isVisible()) {
                            addFrame();
                        }

                        break;
                    case "Select":
                        JFileChooser fileChooser = new JFileChooser();
                        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                        int result = fileChooser.showOpenDialog(fileChooser.getParent());
                        if (result == JFileChooser.APPROVE_OPTION) {
                            try {
                                File file = fileChooser.getSelectedFile();
                                BufferedImage picture = ImageIO.read(file);
                                ImageIcon imageIcon = new ImageIcon(
                                        new ImageIcon(picture)
                                                .getImage().getScaledInstance(230, 230, Image.SCALE_SMOOTH));
                                stockImage.setIcon(imageIcon);
                            } catch (IOException ioe) {
                                ioe.printStackTrace();
                                JOptionPane.showMessageDialog(null, "ERROR");
                            }
                        }
                        break;
                    case "Cancel":
                        addFrame.dispose();
                        editFrame.dispose();
                        break;
                    case "Add":
                        // Do: Insert data in Notepad
                        // First, Check if the item is already existing, if yes send a message already
                        // exist
                        // If not, Add it in stock panel and buy panel
                        stockPanel.remove(addNew);
                        stockBotPanel.add(generateStockItem());
                        stockBotPanel.add(addNew);
                        buyBotPanel.add(generateBuyItem());
                        addFrame.dispose();
                        SwingUtilities.updateComponentTreeUI(frame);

                        break;
                    case "Save":
                        // DO: Update Notepad
                        editFrame.dispose();
                    case "Edit":
                        editFrame();
                        break;
                    case "Remove":

                        break;
                    case "Refresh":
                        searchField.setText("");
                        SwingUtilities.updateComponentTreeUI(frame);
                        break;
                    case "Search":
                        break;
                }
            }
        });

        searchField.addFocusListener(new FocusListener() {

            public void focusGained(FocusEvent e) {
                searchField.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });

    }

    public void BuyFunctions(JButton button) {
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                String clickedButton = button.getName();

                switch (clickedButton) {
                    case "Cart" -> {
                        homePanel.setVisible(false);
                        stockPanel.setVisible(false);
                        buyPanel.setVisible(false);
                        cartPanel.setVisible(true);
                        buy.setEnabled(true);
                    }
                    case "Refresh" -> {

                        SwingUtilities.updateComponentTreeUI(frame);
                        searchField.setText("SEARCH PRODUCT");
                    }

                }
            }
        });

        // Hover

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (button.getName() == "Cart") {

                    if (isWhite) {
                        System.out.println(isWhite);
                        cart.setIcon(hoverWhiteMode);
                    } else {
                        System.out.println(isWhite);
                        cart.setIcon(hoverDarkMode);

                    }
                }

            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (button.getName() == "Cart") {
                    if (isWhite) {
                        cart.setIcon(WhiteMode);
                    } else {
                        cart.setIcon(DarkMode);
                    }
                }

            }
        });
        // Hover Panel for Items

    }

    public void CartFunctions() {

    }
}
