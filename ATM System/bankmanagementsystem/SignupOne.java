package bankmanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame implements ActionListener {
    // Global declarations
    JTextField nameF, fNameField, emailIDF, addressF, cityF, pinF, stateF;
    JRadioButton male, female, otherg, married, unmarried, divorced;
    JDateChooser dateChooser;
    Long random;
    JButton next;

    SignupOne() {
        Random rand = new Random();
        random = Math.abs(rand.nextLong() % 9000L + 1000L);
        JLabel formNo = new JLabel("APPLICATION FORM NO: " + random);
        formNo.setBounds(140, 20, 600, 40);
        formNo.setFont(new Font("Times New Roman", Font.BOLD, 38));
        add(formNo);

        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setBounds(290, 80, 400, 30);
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        add(personalDetails);

        JLabel name = new JLabel("Name:");
        name.setBounds(100, 140, 100, 30);
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        nameF = new JTextField();
        nameF.setFont(new Font("Raleway", Font.PLAIN, 20));
        nameF.setBounds(320, 140, 400, 30);
        add(name);
        add(nameF);

        JLabel fName = new JLabel("Father's name:");
        fName.setBounds(100, 190, 200, 30);
        fName.setFont(new Font("Raleway", Font.BOLD, 20));
        fNameField = new JTextField();
        fNameField.setFont(new Font("Raleway", Font.PLAIN, 20));
        fNameField.setBounds(320, 190, 400, 30);
        add(fName);
        add(fNameField);

        JLabel bDate = new JLabel("Date of Birth:");
        bDate.setBounds(100, 240, 150, 30);
        bDate.setFont(new Font("Raleway", Font.BOLD, 20));
        // Add a calendar here
        dateChooser = new JDateChooser();
        dateChooser.setBounds(320, 240, 400, 30);
        dateChooser.setFont(new Font("Raleway", Font.PLAIN, 15));
        dateChooser.setBackground(new Color(105, 105, 105));
        add(bDate);
        add(dateChooser);

        JLabel gender = new JLabel("Gender: ");
        gender.setBounds(100, 290, 200, 30);
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        // Radio buttons
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        otherg = new JRadioButton("Others");
        male.setBounds(320, 290, 134, 30);
        female.setBounds(454, 290, 134, 30);
        otherg.setBounds(598, 290, 134, 30);
        male.setBackground(Color.WHITE);
        female.setBackground(Color.WHITE);
        otherg.setBackground(Color.WHITE);
        ButtonGroup genders = new ButtonGroup();
        genders.add(male);
        genders.add(female);
        genders.add(otherg);
        male.setFont(new Font("Raleway", Font.PLAIN, 20));
        female.setFont(new Font("Raleway", Font.PLAIN, 20));
        otherg.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(male);
        add(female);
        add(otherg);
        add(gender);

        JLabel emailID = new JLabel("Email Address:");
        emailID.setBounds(100, 340, 200, 30);
        emailID.setFont(new Font("Raleway", Font.BOLD, 20));
        emailIDF = new JTextField();
        emailIDF.setFont(new Font("Raleway", Font.PLAIN, 20));
        emailIDF.setBounds(320, 340, 400, 30);
        add(emailIDF);
        add(emailID);

        JLabel maritalStatus = new JLabel("Marital Status:");
        maritalStatus.setBounds(100, 390, 200, 30);
        maritalStatus.setFont(new Font("Raleway", Font.BOLD, 20));
        // Radio buttons
        married = new JRadioButton("Married");
        unmarried = new JRadioButton("Unmarried");
        divorced = new JRadioButton("Divorced");
        ButtonGroup marriage = new ButtonGroup();
        marriage.add(married);
        marriage.add(unmarried);
        marriage.add(divorced);
        married.setBounds(320, 390, 134, 30);
        unmarried.setBounds(454, 390, 134, 30);
        divorced.setBounds(598, 390, 134, 30);
        married.setBackground(Color.WHITE);
        unmarried.setBackground(Color.WHITE);
        divorced.setBackground(Color.WHITE);
        married.setFont(new Font("Raleway", Font.PLAIN, 20));
        unmarried.setFont(new Font("Raleway", Font.PLAIN, 20));
        divorced.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(married);
        add(unmarried);
        add(divorced);
        add(maritalStatus);

        JLabel address = new JLabel("Address:");
        address.setBounds(100, 440, 200, 30);
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        addressF = new JTextField();
        addressF.setFont(new Font("Raleway", Font.PLAIN, 20));
        addressF.setBounds(320, 440, 400, 30);
        add(addressF);
        add(address);

        JLabel city = new JLabel("City:");
        city.setBounds(100, 490, 200, 30);
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        cityF = new JTextField();
        cityF.setFont(new Font("Raleway", Font.PLAIN, 20));
        cityF.setBounds(320, 490, 400, 30);
        add(cityF);
        add(city);

        JLabel pinCode = new JLabel("PIN Code:");
        pinCode.setBounds(100, 540, 200, 30);
        pinCode.setFont(new Font("Raleway", Font.BOLD, 20));
        pinF = new JTextField();
        pinF.setFont(new Font("Raleway", Font.PLAIN, 20));
        pinF.setBounds(320, 540, 400, 30);
        add(pinF);
        add(pinCode);

        JLabel stateL = new JLabel("State:");
        stateL.setBounds(100, 590, 200, 30);
        stateL.setFont(new Font("Raleway", Font.BOLD, 20));
        stateF = new JTextField();
        stateF.setFont(new Font("Raleway", Font.PLAIN, 20));
        stateF.setBounds(320, 590, 400, 30);
        add(stateF);
        add(stateL);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(570, 640, 150, 30);
        next.setFont(new Font("Raleway", Font.BOLD, 20));
        next.addActionListener(this);
        add(next);

        setLayout(null);
        setTitle("New Account Application Form - Page 1");
        setSize(830, 780);
        setLocation(350, 10);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);

    }

    public void actionPerformed(ActionEvent ae) {
        String formNo = "" + random;
        String name = nameF.getText();
        String fname = fNameField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String genderS = null;
        if (male.isSelected()) {
            genderS = "male";
        } else if (female.isSelected()) {
            genderS = "female";
        } else if (otherg.isSelected()) {
            genderS = "other";
        }
        String emailS = emailIDF.getText();
        String maritalS = null;
        if (married.isSelected()) {
            maritalS = "married";
        } else if (unmarried.isSelected()) {
            maritalS = "unmarried";
        } else if (divorced.isSelected()) {
            maritalS = "divorced";
        }
        String addS = addressF.getText();
        String cityS = cityF.getText();
        String pinS = pinF.getText();
        String stateS = stateF.getText();

        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is required");
            } // Add other validation if required
            else {
                Conn c = new Conn();
                String query = "insert into signup1 values('" + formNo + "','" + name + "','" + fname + "','" + dob
                        + "','" + genderS + "','" + emailS + "','" + maritalS + "','" + addS + "','" + cityS + "','"
                        + pinS + "','" + stateS + "')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignUpTwo(formNo).setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String args[]) {
        new SignupOne();
    }
}
