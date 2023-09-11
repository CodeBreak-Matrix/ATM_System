package bankmanagementsystem;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class deposit extends JFrame implements ActionListener {

    JTextField depositField;
    JButton depositB, backB;
    String pinS;

    deposit(String pin) {
        pinS = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Enter the amount you wish to deposit:");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(170, 300, 400, 20);
        image.add(text);

        depositField = new JTextField();
        depositField.setFont(new Font("Raleway", Font.PLAIN, 22));
        depositField.setBounds(170, 350, 320, 25);
        image.add(depositField);

        depositB = new JButton("Deposit");
        depositB.setForeground(Color.BLACK);
        depositB.setBackground(Color.WHITE);
        depositB.setBounds(355, 485, 135, 30);
        depositB.addActionListener(this);
        image.add(depositB);

        backB = new JButton("Back");
        backB.setForeground(Color.BLACK);
        backB.setBackground(Color.WHITE);
        backB.setBounds(355, 520, 135, 30);
        backB.addActionListener(this);
        image.add(backB);

        setSize(900, 900);
        setLayout(null);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public static void main(String args[]) {
        new deposit("");
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == depositB) {
            String amountS = depositField.getText();
            String type = "Deposit";
            Date date = new Date();
            if (amountS.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter a valid amount.");
            } else {
                Conn c = new Conn();
                String query = "insert into bank values('" + pinS + "','" + date + "','" + type + "','" + amountS
                        + "')";
                try {
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs. " + amountS + " deposited successfully!");
                    setVisible(false);
                    new transactions(pinS).setVisible(true);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } else if (ae.getSource() == backB) {
            setVisible(false);
            new transactions(pinS);
        }
    }

}
