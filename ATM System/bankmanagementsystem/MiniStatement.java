package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame {

    MiniStatement(String pin) {

        JLabel mini = new JLabel();
        mini.setBounds(20, 140, 400, 200);
        add(mini);

        JLabel bankName = new JLabel("Bank of Pravaal");
        bankName.setBounds(150, 20, 100, 20);
        add(bankName);

        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);

        JLabel balanceL = new JLabel();
        balanceL.setBounds(20, 400, 300, 20);
        add(balanceL);

        int balance = 0;

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where PIN = '" + pin + "'");
            while (rs.next()) {
                card.setText("Card No: " + rs.getString("Card_No").substring(0, 4) + "XXXXXXXX"
                        + rs.getString("Card_No").substring(12));

            }

        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where PIN = '" + pin + "'");
            while (rs.next()) {
                mini.setText(
                        mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                                + rs.getString("Type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                                + rs.getString("Amount") + "<br><br><html>");
                if (rs.getString("Type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("Amount"));
                } else if (rs.getString("Type").equals("Withdrawal")) {
                    balance -= Integer.parseInt(rs.getString("Amount"));
                }
            }
            balanceL.setText("Your current balance is Rs." + balance);
        } catch (Exception e) {
            System.out.println(e);
        }

        setTitle("Mini Statement");
        setLayout(null);
        setSize(400, 600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public static void main(String args[]) {
        new MiniStatement("");
    }
}
