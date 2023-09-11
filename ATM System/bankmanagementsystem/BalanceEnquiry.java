package bankmanagementsystem;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;

public class BalanceEnquiry extends JFrame implements ActionListener {
    String pinS;
    JButton backB;

    BalanceEnquiry(String pin) {

        pinS = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        backB = new JButton("Back");
        backB.setBounds(355, 520, 150, 30);
        backB.setForeground(Color.BLACK);
        backB.setBackground(Color.WHITE);
        backB.addActionListener(this);
        image.add(backB);

        int balance = 0;
        Conn c = new Conn();
        try {
            ResultSet rs = c.s.executeQuery("select * from bank where PIN = '" + pinS + "'");

            while (rs.next()) {
                if (rs.getString("Type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("Amount"));
                } else if (rs.getString("Type").equals("Withdrawal")) {
                    balance -= Integer.parseInt(rs.getString("Amount"));
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        JLabel text = new JLabel("Your current account balance is Rs. " + balance);
        text.setFont(new Font("Raleway", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        text.setBounds(170, 300, 400, 30);
        image.add(text);

        setLayout(null);
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public static void main(String args[]) {
        new BalanceEnquiry("");
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new transactions(pinS).setVisible(true);
    }
}
