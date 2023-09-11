package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class transactions extends JFrame implements ActionListener {

    JButton depositB, withdrawal, fastcash, ministatement, pinChange, balenq, exitB;
    String pinS;

    transactions(String pin) {
        pinS = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Please select your transaction.");
        text.setBounds(210, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        depositB = new JButton("Deposit");
        depositB.setBounds(160, 416, 150, 30);
        depositB.setForeground(Color.BLACK);
        depositB.setBackground(Color.WHITE);
        depositB.addActionListener(this);
        image.add(depositB);

        withdrawal = new JButton("Cash Withdrawal");
        withdrawal.setBounds(350, 416, 150, 30);
        withdrawal.setForeground(Color.BLACK);
        withdrawal.setBackground(Color.WHITE);
        withdrawal.addActionListener(this);
        image.add(withdrawal);

        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(160, 450, 150, 30);
        fastcash.setForeground(Color.BLACK);
        fastcash.setBackground(Color.WHITE);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(350, 450, 150, 30);
        ministatement.setForeground(Color.BLACK);
        ministatement.setBackground(Color.WHITE);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinChange = new JButton("PIN Change");
        pinChange.setBounds(160, 484, 150, 30);
        pinChange.setForeground(Color.BLACK);
        pinChange.setBackground(Color.WHITE);
        pinChange.addActionListener(this);
        image.add(pinChange);

        balenq = new JButton("Balance Enquiry");
        balenq.setBounds(350, 484, 150, 30);
        balenq.setForeground(Color.BLACK);
        balenq.setBackground(Color.WHITE);
        balenq.addActionListener(this);
        image.add(balenq);

        exitB = new JButton("Exit");
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
        new transactions("");
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exitB) {
            setVisible(false);
            new Login().setVisible(true);
        } else if (ae.getSource() == depositB) {
            setVisible(false);
            new deposit(pinS).setVisible(true);
        } else if (ae.getSource() == withdrawal) {
            setVisible(false);
            new Withdrawal(pinS).setVisible(true);
        } else if (ae.getSource() == fastcash) {
            setVisible(false);
            new FastCash(pinS).setVisible(true);
        } else if (ae.getSource() == ministatement) {
            new MiniStatement(pinS);
        } else if (ae.getSource() == pinChange) {
            setVisible(false);
            new PinChange(pinS).setVisible(true);
        } else if (ae.getSource() == balenq) {
            setVisible(false);
            new BalanceEnquiry(pinS).setVisible(true);
        }
    }
}
