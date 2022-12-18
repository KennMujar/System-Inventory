import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author KennMujar
 */
public class Main {

        static JFrame frame = new JFrame();
        static JPanel homePanel = new JPanel();
        static JPanel stockPanel = new JPanel(new BorderLayout());
        static JPanel buyPanel = new JPanel(new BorderLayout());
        static JPanel cartPanel = new JPanel();

        static JButton home = new JButton();
        static JButton stocks = new JButton();
        static JButton buy = new JButton();
        static JButton darkMode = new JButton();
        static JButton exit = new JButton();

        static JPanel optionPanel = new JPanel();

        public static void main(String[] args) {

                Functions functions = new Functions();
                JLabel title = new JLabel("GĒMU");
                JLabel description = new JLabel("Asset Store");
                ImageIcon homeIcon = new ImageIcon(
                                new ImageIcon("Assets\\Home.png")
                                                .getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));

                ImageIcon stocksIcon = new ImageIcon(
                                new ImageIcon("Assets\\Stocks.png")
                                                .getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));

                ImageIcon buyIcon = new ImageIcon(
                                new ImageIcon("Assets\\Order.png")
                                                .getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));

                ImageIcon darkModeIcon = new ImageIcon(
                                new ImageIcon("Assets\\Dark Mode.png")
                                                .getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH));

                ImageIcon exitIcon = new ImageIcon(
                                new ImageIcon("Assets\\Exit.png")
                                                .getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH));

                // MAIN FRAME

                frame.getContentPane().setBackground(Color.white);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setUndecorated(true);
                frame.setVisible(true);
                frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));

                // PANELS
                optionPanel.setLayout(new BoxLayout(optionPanel, BoxLayout.Y_AXIS));
                optionPanel.setBackground(new Color(193, 193, 193, 255));
                optionPanel.setPreferredSize(new Dimension(80, 1000));
                optionPanel.setMaximumSize(new Dimension(80, 1000));
                optionPanel.add(home);
                optionPanel.add(stocks);
                optionPanel.add(buy);
                optionPanel.add(Box.createVerticalGlue());
                optionPanel.add(darkMode);
                optionPanel.add(exit);
                frame.getContentPane().add(optionPanel);

                // BUTTONS
                home.setName("Home");
                home.setPreferredSize(new Dimension(80, 100));
                home.setFont(new Font("Arial", Font.BOLD, 25));
                home.setFocusPainted(false);
                home.setBorderPainted(false);
                home.setForeground(Color.white);
                home.setEnabled(false);
                home.setBackground(Color.white);
                home.setIcon(homeIcon);
                functions.optionPanelButton(home);

                stocks.setName("Stocks");
                stocks.setPreferredSize(new Dimension(80, 100));
                stocks.setContentAreaFilled(false);
                stocks.setFont(new Font("Arial", Font.BOLD, 25));
                stocks.setBorderPainted(false);
                stocks.setFocusPainted(false);
                stocks.setIcon(stocksIcon);
                stocks.setForeground(Color.black);
                functions.optionPanelButton(stocks);

                buy.setName("Buy");
                buy.setPreferredSize(new Dimension(80, 100));
                buy.setOpaque(false);
                buy.setContentAreaFilled(false);
                buy.setFocusPainted(false);
                buy.setBorderPainted(false);
                buy.setIcon(buyIcon);
                functions.optionPanelButton(buy);

                darkMode.setName("Dark Mode");
                darkMode.setPreferredSize(new Dimension(80, 80));
                darkMode.setOpaque(false);
                darkMode.setContentAreaFilled(false);
                darkMode.setFocusPainted(false);
                darkMode.setBorderPainted(false);
                darkMode.setIcon(darkModeIcon);
                functions.optionPanelButton(darkMode);

                exit.setName("Exit");
                exit.setPreferredSize(new Dimension(80, 80));
                exit.setOpaque(false);
                exit.setContentAreaFilled(false);
                exit.setFocusPainted(false);
                exit.setBorderPainted(false);
                exit.setIcon(exitIcon);
                functions.optionPanelButton(exit);

                frame.getContentPane().add(homePanel);
                frame.getContentPane().add(stockPanel);
                frame.getContentPane().add(buyPanel);
                frame.getContentPane().add(cartPanel);

                homePanel.setLayout(new GridBagLayout());
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridwidth = GridBagConstraints.REMAINDER;
                gbc.fill = GridBagConstraints.HORIZONTAL;

                title.setFont(new Font("Montserrat", Font.BOLD, 200));
                description.setFont(new Font("Montserrat", Font.PLAIN, 30));

                homePanel.add(title, gbc);
                homePanel.add(description, gbc);
                homePanel.setBackground(new Color(0, 150, 152));
                homePanel.setVisible(true);

                stockPanel.setVisible(false);
                buyPanel.setVisible(false);
                cartPanel.setVisible(false);
                Stock.StockUI();
                Buy.BuyUI();

        }

}
