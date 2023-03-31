package BankManagementSystem.LoginPage.RegisterForm;

import BankManagementSystem.LoginPage.DbConnection;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RegisterForm extends JFrame implements ActionListener {
    long randomNumber;
    JTextField textFieldNAme,textFieldAddress,textFieldEmail,textFieldPhone;
    JDateChooser jDateChooser;
    JRadioButton radioButtonMale,radioButtonFemale;
    JButton next;


    public RegisterForm(){
        setTitle("Register user");
        setSize(690,550);
        getContentPane().setBackground(Color.WHITE);
        setLocation(250,120);
        setLayout(null);

        JLabel jlabelText = new JLabel("Registration form: ");
        Font textFont = new Font("Italic",Font.BOLD,23);
        jlabelText.setFont(textFont);
        jlabelText.setBounds(60,40,270,40);
        add(jlabelText);

        //for application form number which will always be different and random::
        Random random = new Random();
        randomNumber = Math.abs((random.nextLong()%9000L)+1000L);
        JLabel jlabelRandom = new JLabel("Registration no > : "+ randomNumber);
        Font textFontRandom = new Font("Italic",Font.BOLD,18);
        jlabelRandom.setFont(textFontRandom);
        jlabelRandom.setBounds(390,40,260,40);
        add(jlabelRandom);

        //name section
        JLabel name = new JLabel("Name : ");
        Font nameFont = new Font("Italic",Font.BOLD,15);
        name.setFont(nameFont);
        name.setBounds(70,100,130,30);
        add(name);

        textFieldNAme = new JTextField();
        textFieldNAme.setBounds(160,100,220,30);
        add(textFieldNAme);


        //address section
        JLabel address = new JLabel("Address : ");
        Font addressFont = new Font("Italic",Font.BOLD,15);
        address.setFont(addressFont);
        address.setBounds(70,150,130,30);
        add(address);

        textFieldAddress = new JTextField();
        textFieldAddress.setBounds(160,150,220,30);
        add(textFieldAddress);

        //dob section
        JLabel dob = new JLabel("DOB : ");
        Font dobFont = new Font("Italic",Font.BOLD,15);
        dob.setFont(dobFont);
        dob.setBounds(70,200,130,30);
        add(dob);

        jDateChooser = new JDateChooser();
        jDateChooser.setBounds(160,200,130,30);
        jDateChooser.setForeground(Color.BLUE);
        add(jDateChooser);

        //Gender section
        JLabel gender = new JLabel("Gender : ");
        Font genderFont = new Font("Italic",Font.BOLD,15);
        gender.setFont(genderFont);
        gender.setBounds(70,250,130,30);
        add(gender);

        radioButtonMale = new JRadioButton("Male");
        radioButtonMale.setBounds(160,250,70,30);
        radioButtonMale.setBackground(Color.WHITE);
        add(radioButtonMale);

        radioButtonFemale = new JRadioButton("Female");
        radioButtonFemale.setBounds(250,250,80,30);
        radioButtonFemale.setBackground(Color.WHITE);
        add(radioButtonFemale);

        //the gender should be select only once so using button group
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButtonMale);
        buttonGroup.add(radioButtonFemale);

        //Email section
        JLabel email = new JLabel("Email : ");
        Font emailFont = new Font("Italic",Font.BOLD,15);
        email.setFont(emailFont);
        email.setBounds(70,300,130,30);
        add(email);

        textFieldEmail = new JTextField();
        textFieldEmail.setBounds(160,300,220,30);
        add(textFieldEmail);

        //Phone number section
        JLabel phone = new JLabel("Phone :");
        Font phoneFont = new Font("Italic",Font.BOLD,15);
        phone.setFont(phoneFont);
        phone.setBounds(70,350,130,30);
        add(phone);

        textFieldPhone = new JTextField();
        textFieldPhone.setBounds(160,350,220,30);
        add(textFieldPhone);



        //button
        next = new JButton("Next");
        next.setBounds(450,440,80,30);
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        //actionlistner using
        next.addActionListener(this);
        add(next);


        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String from_Number = ""+randomNumber;
        String name = textFieldNAme.getText();
        String address = textFieldAddress.getText();
        String email = textFieldEmail.getText();
        String date_of_birth = ((JTextField)jDateChooser.getDateEditor().getUiComponent()).getText();
        String phone_number = textFieldPhone.getText();
        String gender = null;
                if(radioButtonMale.isSelected()){
                    gender="Male";
                } else if (radioButtonFemale.isSelected()) {
                    gender="Female";
                }else {
                    gender="Undefined";
                }


        try {


            //Validation for name
            if(name.equals("")){
                //this is used to pop up the message box if user does not enter the name
                JOptionPane.showMessageDialog(null,"Please enter your name!!");
            }

            //validation for address
            else if (address.equals("")){
                //this is used to pop up the message box if user does not enter the name
                JOptionPane.showMessageDialog(null,"Please enter your address!!");
            }

            //validation for email
            else if(email.equals("")){
                //this is used to pop up the message box if user does not enter the name
                JOptionPane.showMessageDialog(null,"Please enter your email address!!");
            }

            //validation for date of birth
            else if(date_of_birth.equals("")){
                //this is used to pop up the message box if user does not enter the name
                JOptionPane.showMessageDialog(null,"Please enter your Date of birth!!");
            }

            //validation for phone
            else if(phone_number.equals("")){
                //this is used to pop up the message box if user does not enter the name
                JOptionPane.showMessageDialog(null,"Please enter your Phone number!!");
            }

            //validation for gender
            else if(gender.equals("")){
                //this is used to pop up the message box if user does not enter the name
                JOptionPane.showMessageDialog(null,"Please select your gender!!");
            }else {

                //for database connection
                DbConnection databaseConnection = new DbConnection();
                //query which helps to insert data inside the signup table created in database
                String query =
                        "insert into signup values('"+from_Number+"','"+name+"','"+address+"','"+email+"','"+date_of_birth+"','"+phone_number+"','"+gender+"')";
                //now we have to execute the query using the statement inside connection class
                databaseConnection.s.execute(query);

                setVisible(false);
                new AdditionalInformation(from_Number).setVisible(true);

            }

        }catch (Exception e1){
            e1.printStackTrace();
        }

    }
    public static void main(String[] args) {
        RegisterForm registerForm = new RegisterForm();
    }


}
