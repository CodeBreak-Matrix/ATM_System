package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton am1B, am2B, am3B, am4B, am5B, am6B, exitB;
    String pinS;

    FastCash(String pin) {
        pinS = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Select withdrawal amount:");
        text.setBounds(210, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        am1B = new JButton("Rs. 100");
        am1B.setBounds(160, 416, 150, 30);
        am1B.setForeground(Color.BLACK);
        am1B.setBackground(Color.WHITE);
        am1B.addActionListener(this);
        image.add(am1B);

        am2B = new JButton("Rs. 500");
        am2B.setBounds(350, 416, 150, 30);
        am2B.setForeground(Color.BLACK);
        am2B.setBackground(Color.WHITE);
        am2B.addActionListener(this);
        image.add(am2B);

        am3B = new JButton("Rs. 1000");
        am3B.setBounds(160, 450, 150, 30);
        am3B.setForeground(Color.BLACK);
        am3B.setBackground(Color.WHITE);
        am3B.addActionListener(this);
        image.add(am3B);

        am4B = new JButton("Rs. 2000");
        am4B.setBounds(350, 450, 150, 30);
        am4B.setForeground(Color.BLACK);
        am4B.setBackground(Color.WHITE);
        am4B.addActionListener(this);
        image.add(am4B);

        am5B = new JButton("Rs. 5000");
        am5B.setBounds(160, 484, 150, 30);
        am5B.setForeground(Color.BLACK);
        am5B.setBackground(Color.WHITE);
        am5B.addActionListener(this);
        image.add(am5B);

        am6B = new JButton("Rs. 10000");
        am6B.setBounds(350, 484, 150, 30);
        am6B.setForeground(Color.BLACK);
        am6B.setBackground(Color.WHITE);
        am6B.addActionListener(this);
        image.add(am6B);

        exitB = new JButton("Back");
        exitB.setBounds(350, 518, 150, 30);
        exitB.setForeground(Color.BLACK);
        exitB.setBackground(Color.WHITE);
        exitB.addActionListener(this);
        image.add(exitB);

        setSize(900, 900);
        setUndecorated(true);
        setLocation(300, 0);
        setVisible(true);

    }

    public static void main(String args[]) {
        new FastCash("");
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exitB) {
            setVisible(false);
            new transactions(pinS).setVisible(true);
        } else {
            String amountS = ((JButton) ae.getSource()).getText().substring(4);
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("select * from bank where PIN = '" + pinS + "'");
                int balance = 0;
                while (rs.next()) {
                    if (rs.getString("Type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("Amount"));
                    } else if (rs.getString("Type").equals("Withdrawal")) {
                        balance -= Integer.parseInt(rs.getString("Amount"));
                    }
                }
                if (ae.getSource() != exitB && balance < Integer.parseInt(amountS)) {
                    JOptionPane.showMessageDialog(null, "Insufficient balance!");
                    return;
                }

                Date date = new Date();
                String type = "Withdrawal";
                String query = "insert into bank values('" + pinS + "','" + date + "','" + type + "','" + amountS
                        + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs " + amountS + " withdrawn successfully!");
                setVisible(false);
                new transactions(pinS).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
