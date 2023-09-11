package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUpTwo extends JFrame implements ActionListener {

    JButton next;
    JComboBox<String> religionCB, categoryCB, incomeCB, qualiCB, occupCB;
    JTextField panF, aadharF;
    String formno;
    JRadioButton sY, sN, eY, eN;

    SignUpTwo(String formNo) {
        // Global declarations
        formno = formNo;
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setBounds(290, 80, 400, 30);
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        add(additionalDetails);

        JLabel religion = new JLabel("Religion:");
        religion.setBounds(100, 140, 100, 30);
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        add(religion);
        // ComboBox to add religion:
        String valReligion[] = { "Christian", "Hindu", "Sikh", "Muslim", "Other" };
        religionCB = new JComboBox<String>(valReligion);
        religionCB.setBounds(320, 140, 400, 30);
        religionCB.setFont(new Font("Raleway", Font.PLAIN, 20));
        religionCB.setBackground(Color.WHITE);
        add(religionCB);

        JLabel category = new JLabel("Category:");
        category.setBounds(100, 190, 200, 30);
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        add(category);
        String valcategory[] = { "General", "OBC", "SC", "ST", "Other" };
        categoryCB = new JComboBox<>(valcategory);
        categoryCB.setFont(new Font("Raleway", Font.PLAIN, 20));
        categoryCB.setBounds(320, 190, 400, 30);
        categoryCB.setBackground(Color.WHITE);
        add(categoryCB);

        JLabel income = new JLabel("Income:");
        income.setBounds(100, 240, 150, 30);
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        add(income);
        String valincome[] = { "Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000" };
        incomeCB = new JComboBox<>(valincome);
        incomeCB.setFont(new Font("Raleway", Font.PLAIN, 20));
        incomeCB.setBounds(320, 240, 400, 30);
        incomeCB.setBackground(Color.WHITE);
        add(incomeCB);

        JLabel edu = new JLabel("Educational");
        edu.setBounds(100, 290, 200, 30);
        edu.setFont(new Font("Raleway", Font.BOLD, 20));
        add(edu);

        JLabel quali = new JLabel("Qualification:");
        quali.setBounds(100, 320, 200, 30);
        quali.setFont(new Font("Raleway", Font.BOLD, 20));
        add(quali);
        String valquali[] = { "Non-Graduation", "Graduation", "Post-graduation", "Doctrate", "Others" };
        qualiCB = new JComboBox<>(valquali);
        qualiCB.setFont(new Font("Raleway", Font.PLAIN, 20));
        qualiCB.setBounds(320, 305, 400, 30);
        qualiCB.setBackground(Color.WHITE);
        add(qualiCB);

        JLabel occup = new JLabel("Occupation:");
        occup.setBounds(100, 370, 200, 30);
        occup.setFont(new Font("Raleway", Font.BOLD, 20));
        add(occup);
        String valoccup[] = { "Salaried", "Self-Employed", "Businessman", "Student", "Retired", "Others" };
        occupCB = new JComboBox<>(valoccup);
        occupCB.setFont(new Font("Raleway", Font.PLAIN, 20));
        occupCB.setBounds(320, 370, 400, 30);
        occupCB.setBackground(Color.WHITE);
        add(occupCB);

        JLabel panNo = new JLabel("PAN Number:");
        panNo.setBounds(100, 420, 200, 30);
        panNo.setFont(new Font("Raleway", Font.BOLD, 20));
        add(panNo);
        panF = new JTextField();
        panF.setFont(new Font("Raleway", Font.PLAIN, 20));
        panF.setBounds(320, 420, 400, 30);
        add(panF);

        JLabel aadhar = new JLabel("Aadhar Number:");
        aadhar.setBounds(100, 470, 200, 30);
        aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        add(aadhar);
        aadharF = new JTextField();
        aadharF.setFont(new Font("Raleway", Font.PLAIN, 20));
        aadharF.setBounds(320, 470, 400, 30);
        add(aadharF);

        JLabel seniorC = new JLabel("Senior Citizen:");
        seniorC.setBounds(100, 520, 200, 30);
        seniorC.setFont(new Font("Raleway", Font.BOLD, 20));
        add(seniorC);
        sY = new JRadioButton("Yes");
        sN = new JRadioButton("No");
        ButtonGroup seniority = new ButtonGroup();
        seniority.add(sY);
        seniority.add(sN);
        sY.setBounds(320, 520, 134, 30);
        sN.setBounds(454, 520, 134, 30);
        sY.setBackground(Color.WHITE);
        sN.setBackground(Color.WHITE);
        sY.setFont(new Font("Raleway", Font.PLAIN, 20));
        sN.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(sY);
        add(sN);

        JLabel exisac = new JLabel("Existing Account:");
        exisac.setBounds(100, 570, 200, 30);
        exisac.setFont(new Font("Raleway", Font.BOLD, 20));
        add(exisac);
        eY = new JRadioButton("Yes");
        eN = new JRadioButton("No");
        ButtonGroup existence = new ButtonGroup();
        existence.add(eY);
        existence.add(eN);
        eY.setBounds(320, 570, 134, 30);
        eN.setBounds(454, 570, 134, 30);
        eY.setBackground(Color.WHITE);
        eN.setBackground(Color.WHITE);
        eY.setFont(new Font("Raleway", Font.PLAIN, 20));
        eN.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(eY);
        add(eN);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(570, 620, 150, 30);
        next.setFont(new Font("Raleway", Font.BOLD, 20));
        next.addActionListener(this);
        add(next);

        setLayout(null);
        setSize(830, 780);
        setTitle("New Account Application Form - Page 2");
        setLocation(350, 10);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
    }

    public void actionPerformed(ActionEvent ae) {
        // String data
        String religionS = (String) religionCB.getSelectedItem();
        String categoryS = (String) categoryCB.getSelectedItem();
        String incomeS = (String) incomeCB.getSelectedItem();
        String eqS = (String) qualiCB.getSelectedItem();
        String ocS = (String) occupCB.getSelectedItem();
        String panS = panF.getText();
        String aadharS = aadharF.getText();
        String scS = null;
        String eaS = null;

        if (sY.isSelected()) {
            scS = "Yes";
        } else if (sN.isSelected()) {
            scS = "No";
        }
        if (eY.isSelected()) {
            eaS = "Yes";
        } else if (eN.isSelected()) {
            eaS = "No";
        }
        try {
            if (panS == "" || aadharS == "") {
                JOptionPane.showMessageDialog(null, "Aadhar or PAN number is missing.");
            } else {
                Conn c = new Conn();
                String query = "insert into signup2 values('" + formno + "','" + religionS + "','" + categoryS + "','"
                        + incomeS + "','"
                        + eqS + "','" + ocS + "','" + panS + "','" + aadharS + "','" + scS + "','" + eaS + "')";
                c.s.executeUpdate(query);
                setVisible(false);
                new signupThree(formno).setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String args[]) {
        new SignUpTwo("");
    }
}
