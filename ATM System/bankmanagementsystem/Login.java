package bankmanagementsystem;

import java.awt.*; //Package for image
import java.awt.event.*;
import javax.swing.*; //For JFrame, JLabel etc.
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JButton login, signUp, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;

    Login() {
        setTitle("Automated Teller Machine");// Sets the name in the title bar
        setLayout(null); // To use our own custom layouts

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);

        // Welcome to ATM Label
        JLabel text = new JLabel("Welcome to ATM!");
        text.setBounds(200, 40, 400, 40);
        text.setFont(new Font("Osward", Font.BOLD, 38));
        add(text);

        // Card No section
        JLabel cardNo = new JLabel("Card No:");
        cardNo.setBounds(120, 150, 250, 30);
        cardNo.setFont(new Font("Raleway", Font.BOLD, 28));
        add(cardNo);
        cardTextField = new JTextField();
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        cardTextField.setBounds(300, 150, 230, 30);
        add(cardTextField);

        // PIN section
        JLabel PIN = new JLabel("PIN:");
        PIN.setBounds(120, 220, 250, 30);
        PIN.setFont(new Font("Raleway", Font.BOLD, 28));
        add(PIN);
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220, 230, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);

        login = new JButton("Sign In");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear = new JButton("Clear");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signUp = new JButton("Sign Up");
        signUp.setBounds(300, 350, 230, 30);
        signUp.setBackground(Color.BLACK);
        signUp.setForeground(Color.WHITE);
        signUp.addActionListener(this);
        add(signUp);

        getContentPane().setBackground(Color.WHITE);
        setSize(800, 480); // Set size of the window
        setVisible(true); // Allows us to see the JFrame
        setLocation(350, 200); // Set location on screen where the frame opens.
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            try {
                Conn c = new Conn();
                String cardNoS = cardTextField.getText();
                String PINS = String.valueOf(pinTextField.getPassword());
                String query = "select * from login where Card_No = '" + cardNoS + "'and PIN = '" + PINS + "'";
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    JOptionPane.showMessageDialog(null, "Logged in successfully");
                    new transactions(PINS).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect PIN");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == signUp) {
            setVisible(false);
            new SignupOne().setVisible(true);
        } else if (ae.getSource() == clear) {
            cardTextField.setText("");
            pinTextField.setText("");
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
