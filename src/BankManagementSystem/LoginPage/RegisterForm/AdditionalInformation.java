package BankManagementSystem.LoginPage.RegisterForm;

import BankManagementSystem.LoginPage.DbConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AdditionalInformation extends JFrame implements ActionListener {
    JTextField textFieldIncome,textFieldEducation,textFieldOccupation;
    JRadioButton radioButtonYes,radioButtonNo;
    JComboBox jComboBoxReligion;
    JButton next;
    String formNum;


    public AdditionalInformation(String formNumber){
        this.formNum = formNumber;
        setTitle("Additional Information");
        setSize(700,550);
        setLocation(250,120);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel jlabelText = new JLabel("User Additional info : ");
        Font textFont = new Font("Italic",Font.BOLD,23);
        jlabelText.setFont(textFont);
        jlabelText.setBounds(60,40,300,40);
        add(jlabelText);

        //for registration number
        JLabel jlabelRegistration = new JLabel("Registration no > : "+ formNum);
        Font textFontRandom = new Font("Italic",Font.BOLD,18);
        jlabelRegistration.setFont(textFontRandom);
        jlabelRegistration.setBounds(390,40,260,40);
        add(jlabelRegistration);



        //Religion section
        JLabel religion = new JLabel("Religion : ");
        Font religionFont = new Font("Italic",Font.BOLD,15);
        religion.setFont(religionFont);
        religion.setBounds(70,100,130,30);
        add(religion);

        //for dropdown menu we have to create Jcombox
        String[] religions = {"Hindu","Buddhist","Muslim","Kirat","Other"};
        jComboBoxReligion = new JComboBox<>(religions);
        jComboBoxReligion.setBounds(180,100,220,30);
        jComboBoxReligion.setBackground(Color.WHITE);
        add(jComboBoxReligion);


        //Income section
        JLabel income = new JLabel("Income : ");
        Font incomeFont = new Font("Italic",Font.BOLD,15);
        income.setFont(incomeFont);
        income.setBounds(70,150,130,30);
        add(income);

        textFieldIncome = new JTextField();
        textFieldIncome.setBounds(180,150,220,30);
        add(textFieldIncome);


        //Education section
        JLabel education = new JLabel("Education : ");
        Font educationFont = new Font("Italic",Font.BOLD,15);
        education.setFont(educationFont);
        education.setBounds(70,200,130,30);
        add(education);

        textFieldEducation = new JTextField();
        textFieldEducation.setBounds(180,200,220,30);
        add(textFieldEducation);


        //Occupation section
        JLabel Occupation = new JLabel("Occupation : ");
        Font occupationFont = new Font("Italic",Font.BOLD,15);
        Occupation.setFont(occupationFont);
        Occupation.setBounds(70,250,130,30);
        add(Occupation);

        textFieldOccupation = new JTextField();
        textFieldOccupation.setBounds(180,250,220,30);
        add(textFieldOccupation);



        //Senior citizen section
        JLabel senior = new JLabel("Senior ");
        Font seniorFont = new Font("Italic",Font.BOLD,15);
        senior.setFont(seniorFont);
        senior.setBounds(70,300,130,30);
        add(senior);
        JLabel seniorCitizen = new JLabel("citizen :");
        Font citizenFont = new Font("Italic",Font.BOLD,15);
        seniorCitizen.setFont(citizenFont);
        seniorCitizen.setBounds(70,320,130,30);
        add(seniorCitizen);

        radioButtonYes = new JRadioButton("Yes");
        radioButtonYes.setBounds(180,310,70,30);
        radioButtonYes.setBackground(Color.WHITE);
        add(radioButtonYes);

        radioButtonNo = new JRadioButton("No");
        radioButtonNo.setBounds(250,310,80,30);
        radioButtonNo.setBackground(Color.WHITE);
        add(radioButtonNo);

        //the radiobutton should be select only once so using button group
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButtonYes);
        buttonGroup.add(radioButtonNo);

        //Existing account section
        JLabel existing = new JLabel("Existing ");
        Font existingFont = new Font("Italic",Font.BOLD,15);
        existing.setFont(existingFont);
        existing.setBounds(70,350,130,30);
        add(existing);
        JLabel existingAccount = new JLabel("Account :");
        Font accountFont = new Font("Italic",Font.BOLD,15);
        existingAccount.setFont(accountFont);
        existingAccount.setBounds(70,370,130,30);
        add(existingAccount);

        radioButtonYes = new JRadioButton("Yes");
        radioButtonYes.setBounds(180,360,70,30);
        radioButtonYes.setBackground(Color.WHITE);
        add(radioButtonYes);

        radioButtonNo = new JRadioButton("No");
        radioButtonNo.setBounds(250,360,80,30);
        radioButtonNo.setBackground(Color.WHITE);
        add(radioButtonNo);

        //the account  should be select only once so using button group
        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(radioButtonYes);
        buttonGroup1.add(radioButtonNo);


        //button
        next = new JButton("Next");
        next.setBounds(500,450,80,30);
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        //actionlistner using
        next.addActionListener(this);
        add(next);



        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String from_Number = ""+formNum;
        String religionStr = (String)jComboBoxReligion.getSelectedItem();
        String incomeStr = textFieldIncome.getText();
        String educationStr = textFieldEducation.getText();
        String jobStr = textFieldOccupation.getText();
        //for redio buttons
        String seniorCitizen = null;
        if(radioButtonYes.isSelected()){
            seniorCitizen="Yes";
        } else if (radioButtonNo.isSelected()) {
            seniorCitizen="No";
        }

        String existingAcount = null;
        if(radioButtonYes.isSelected()){
            existingAcount="Yes";
        } else if (radioButtonNo.isSelected()) {
            existingAcount="No";
        }


        try {

            //validation for email
            if(educationStr.equals("")){
                //this is used to pop up the message box if user does not enter the name
                JOptionPane.showMessageDialog(null,"Please enter your education!!");
            }
            else {

                //for database connection
                DbConnection databaseConnection = new DbConnection();
                //query which helps to insert data inside the signup table created in database
                String query1 =
                        "insert into additionalInfo values('"+from_Number+"','"+religionStr+"','"+incomeStr+"','"+educationStr+"','"+jobStr+"','"+seniorCitizen+"','"+existingAcount+"')";
                //now we have to execute the query using the statement inside connection class
                databaseConnection.s.execute(query1);

                setVisible(false);
                new FinalRegistration(formNum).setVisible(true);

            }

        }catch (Exception e1){
            e1.printStackTrace();
        }

    }


    public static void main(String[] args) {
        AdditionalInformation additionalInformation = new AdditionalInformation("");
    }
}
