package bankmanagementsystem;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class signupThree extends JFrame implements ActionListener {
    // Global declarations
    String formno;
    JRadioButton savingsR, fdR, currentR, rdR;
    JCheckBox atmChB, inChB, mbChB, esaChB, cbChB, esChB, dcChB;
    JButton submitB, cancelB;

    signupThree(String formNo) {
        formno = formNo;

        JLabel accountDetails = new JLabel("Page 3: Account Details");
        accountDetails.setBounds(230, 40, 400, 40);
        accountDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        add(accountDetails);

        JLabel accountType = new JLabel("Account Type:");
        accountType.setBounds(100, 140, 200, 30);
        accountType.setFont(new Font("Raleway", Font.BOLD, 22));
        add(accountType);
        // Radiobuttons for type of account
        savingsR = new JRadioButton("Savings Account");
        fdR = new JRadioButton("Fixed Deposit Account");
        currentR = new JRadioButton("Current Account");
        rdR = new JRadioButton("Recurring Deposit Account");
        ButtonGroup acType = new ButtonGroup();
        acType.add(savingsR);
        acType.add(currentR);
        acType.add(fdR);
        acType.add(rdR);
        savingsR.setFont(new Font("Raleway", Font.PLAIN, 16));
        savingsR.setBackground(Color.WHITE);
        currentR.setFont(new Font("Raleway", Font.PLAIN, 16));
        currentR.setBackground(Color.WHITE);
        fdR.setFont(new Font("Raleway", Font.PLAIN, 16));
        fdR.setBackground(Color.WHITE);
        rdR.setFont(new Font("Raleway", Font.PLAIN, 16));
        rdR.setBackground(Color.WHITE);
        savingsR.setBounds(100, 180, 150, 20);
        currentR.setBounds(100, 220, 150, 20);
        fdR.setBounds(350, 180, 250, 20);
        rdR.setBounds(350, 220, 250, 20);
        add(savingsR);
        add(currentR);
        add(rdR);
        add(fdR);

        JLabel cardNo = new JLabel("Card No:");
        cardNo.setBounds(100, 300, 200, 30);
        cardNo.setFont(new Font("Raleway", Font.BOLD, 22));
        add(cardNo);
        JLabel cnumber = new JLabel("XXXX-XXXX-XXXX-4184");
        cnumber.setBounds(330, 300, 300, 30);
        cnumber.setFont(new Font("Raleway", Font.BOLD, 22));
        add(cnumber);

        JLabel cardLabel = new JLabel("Your 16 digit card number.");
        cardLabel.setBounds(100, 330, 300, 20);
        cardLabel.setFont(new Font("Raleway", Font.PLAIN, 12));
        add(cardLabel);

        JLabel pinNo = new JLabel("PIN:");
        pinNo.setBounds(100, 370, 200, 30);
        pinNo.setFont(new Font("Raleway", Font.BOLD, 22));
        add(pinNo);
        JLabel pnumber = new JLabel("XXXX");
        pnumber.setBounds(330, 370, 300, 30);
        pnumber.setFont(new Font("Raleway", Font.BOLD, 22));
        add(pnumber);

        JLabel pinLabel = new JLabel("Your 4 digit PIN.");
        pinLabel.setBounds(100, 400, 300, 20);
        pinLabel.setFont(new Font("Raleway", Font.PLAIN, 12));
        add(pinLabel);

        JLabel servicesL = new JLabel("Services Required:");
        servicesL.setBounds(100, 450, 250, 30);
        servicesL.setFont(new Font("Raleway", Font.BOLD, 22));
        add(servicesL);
        atmChB = new JCheckBox("ATM Card");
        atmChB.setBackground(Color.WHITE);
        atmChB.setFont(new Font("Raleway", Font.PLAIN, 16));
        atmChB.setBounds(100, 500, 200, 30);
        add(atmChB);
        inChB = new JCheckBox("Internet Banking");
        inChB.setBackground(Color.WHITE);
        inChB.setFont(new Font("Raleway", Font.PLAIN, 16));
        inChB.setBounds(350, 500, 200, 30);
        add(inChB);
        mbChB = new JCheckBox("Mobile Banking");
        mbChB.setBackground(Color.WHITE);
        mbChB.setFont(new Font("Raleway", Font.PLAIN, 16));
        mbChB.setBounds(100, 550, 200, 30);
        add(mbChB);
        esaChB = new JCheckBox("Email and SMS alerts");
        esaChB.setBackground(Color.WHITE);
        esaChB.setFont(new Font("Raleway", Font.PLAIN, 16));
        esaChB.setBounds(350, 550, 200, 30);
        add(esaChB);
        cbChB = new JCheckBox("Cheque Book");
        cbChB.setBackground(Color.WHITE);
        cbChB.setFont(new Font("Raleway", Font.PLAIN, 16));
        cbChB.setBounds(100, 600, 200, 30);
        add(cbChB);
        esChB = new JCheckBox("E-Statement");
        esChB.setBackground(Color.WHITE);
        esChB.setFont(new Font("Raleway", Font.PLAIN, 16));
        esChB.setBounds(350, 600, 200, 30);
        add(esChB);

        dcChB = new JCheckBox(
                "I hereby declare that the above entered details are correct to the best of my knowledge.");
        dcChB.setBackground(Color.WHITE);
        dcChB.setFont(new Font("Raleway", Font.BOLD, 12));
        dcChB.setBounds(100, 680, 520, 30);
        add(dcChB);

        submitB = new JButton("Submit");
        cancelB = new JButton("Cancel");
        submitB.setBackground(Color.BLACK);
        submitB.setForeground(Color.WHITE);
        submitB.setBounds(150, 730, 150, 30);
        submitB.setFont(new Font("Raleway", Font.BOLD, 20));
        submitB.addActionListener(this);
        cancelB.setBackground(Color.BLACK);
        cancelB.setForeground(Color.WHITE);
        cancelB.setBounds(350, 730, 150, 30);
        cancelB.setFont(new Font("Raleway", Font.BOLD, 20));
        cancelB.addActionListener(this);
        add(submitB);
        add(cancelB);

        setLayout(null);
        setSize(720, 820);
        setTitle("New Account Application Form - Page 3");
        setLocation(350, 0);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
    }

    public static void main(String args[]) {
        new signupThree("");
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submitB) {
            // JOptionPane.showMessageDialog(null, "Submitted");
            String accountTypeS = null;
            if (savingsR.isSelected()) {
                accountTypeS = "Savings";
            } else if (fdR.isSelected()) {
                accountTypeS = "Fixed Deposit";
            } else if (currentR.isSelected()) {
                accountTypeS = "Current";
            } else if (rdR.isSelected()) {
                accountTypeS = "Recurring Deposit Account";
            }
            // Generating random pin and card numbers
            Random random = new Random();
            String cardNOS = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
            String pinS = "" + Math.abs((random.nextLong() % 9000L) + 1000L);

            String facilityS = "";
            if (atmChB.isSelected()) {
                facilityS = facilityS + " ATM card";
            } else if (inChB.isSelected()) {
                facilityS = facilityS + " Internet Banking";
            } else if (mbChB.isSelected()) {
                facilityS = facilityS + " Mobile Banking";
            } else if (esaChB.isSelected()) {
                facilityS = facilityS + " Email and SMS alerts";
            } else if (cbChB.isSelected()) {
                facilityS = facilityS + " Cheque Book";
            } else if (esChB.isSelected()) {
                facilityS = facilityS + " E-Statement";
            }

            if (dcChB.isSelected() && accountTypeS != null) {
                try {
                    Conn c = new Conn();
                    String query1 = "insert into signup3 values('" + formno + "','" + accountTypeS + "','" + cardNOS
                            + "','" + pinS
                            + "','" + facilityS + "')";
                    String query2 = "insert into login values('" + formno + "','" + cardNOS + "','" + pinS + "')";
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    // Display Card No and PIN
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardNOS + "\nPIN: " + pinS);
                    setVisible(false);
                    new deposit(pinS).setVisible(true);
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please agree to the declaration before submission of data!");
            }

        } else if (ae.getSource() == cancelB) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }
}
