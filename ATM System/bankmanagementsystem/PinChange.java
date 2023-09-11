package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PinChange extends JFrame implements ActionListener {

    String pinS;
    JPasswordField pinF, rpinF;
    JButton changeB, backB;

    PinChange(String pin) {
        pinS = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Change your PIN:");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(250, 280, 500, 30);
        image.add(text);

        JLabel newPIN = new JLabel("New PIN:");
        newPIN.setForeground(Color.WHITE);
        newPIN.setFont(new Font("System", Font.BOLD, 16));
        newPIN.setBounds(165, 320, 180, 25);
        image.add(newPIN);

        pinF = new JPasswordField();
        pinF.setFont(new Font("Raleway", Font.PLAIN, 22));
        pinF.setBounds(350, 320, 150, 25);
        image.add(pinF);

        JLabel rePIN = new JLabel("Re-enter new PIN:");
        rePIN.setForeground(Color.WHITE);
        rePIN.setFont(new Font("System", Font.BOLD, 16));
        rePIN.setBounds(165, 360, 180, 25);
        image.add(rePIN);

        rpinF = new JPasswordField();
        rpinF.setFont(new Font("Raleway", Font.PLAIN, 22));
        rpinF.setBounds(350, 360, 150, 25);
        image.add(rpinF);

        changeB = new JButton("Change");
        changeB.setForeground(Color.BLACK);
        changeB.setBackground(Color.WHITE);
        changeB.setBounds(355, 485, 150, 30);
        changeB.addActionListener(this);
        image.add(changeB);

        backB = new JButton("Back");
        backB.setForeground(Color.BLACK);
        backB.setBackground(Color.WHITE);
        backB.setBounds(355, 520, 150, 30);
        backB.addActionListener(this);
        image.add(backB);

        setLayout(null);
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public static void main(String args[]) {
        new PinChange("");
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == backB) {
            setVisible(false);
            new transactions(pinS).setVisible(true);
        } else if (ae.getSource() == changeB) {
            try {
                String newpin = String.valueOf(pinF.getPassword());
                String repin = String.valueOf(rpinF.getPassword());

                if (!newpin.equals(repin)) {
                    JOptionPane.showMessageDialog(null, "Re-entered PIN and new PIN do not match!");
                    return;
                }
                if (newpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid new PIN");
                    return;
                }

                if (repin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
                    return;
                }

                Conn c = new Conn();
                String query1 = "update bank set PIN ='" + newpin + "' where PIN = '" + pinS + "'";
                String query2 = "update login set PIN ='" + newpin + "' where PIN = '" + pinS + "'";
                String query3 = "update signup3 set PIN ='" + newpin + "' where PIN = '" + pinS + "'";

                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully!");

                setVisible(false);
                new transactions(newpin).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
