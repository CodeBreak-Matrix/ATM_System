package bankmanagementsystem;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class Withdrawal extends JFrame implements ActionListener {

    JTextField withdrawField;
    JButton withdrawB, backB;
    String pinS;

    Withdrawal(String pin) {
        pinS = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Enter the amount you wish to withdraw:");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(170, 300, 400, 20);
        image.add(text);

        withdrawField = new JTextField();
        withdrawField.setFont(new Font("Raleway", Font.PLAIN, 22));
        withdrawField.setBounds(170, 350, 320, 25);
        image.add(withdrawField);

        withdrawB = new JButton("Withdraw");
        withdrawB.setForeground(Color.BLACK);
        withdrawB.setBackground(Color.WHITE);
        withdrawB.setBounds(355, 485, 135, 30);
        withdrawB.addActionListener(this);
        image.add(withdrawB);

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
        new Withdrawal("");
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == withdrawB) {
            String amountS = withdrawField.getText();
            String type = "Withdrawal";
            Date date = new Date();
            if (amountS.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter a valid amount.");
            } else {
                Conn c = new Conn();
                String query = "insert into bank values('" + pinS + "','" + date + "','" + type + "','" + amountS
                        + "')";
                try {
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs. " + amountS + " withdrawn successfully!");
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
