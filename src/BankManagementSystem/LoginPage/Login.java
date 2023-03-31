package BankManagementSystem.LoginPage;

import BankManagementSystem.LoginPage.AfterLogin.MainTransactionMenu;
import BankManagementSystem.LoginPage.RegisterForm.RegisterForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


//JFRAme is used to make the frame
public class Login extends JFrame implements ActionListener {

    JButton login,clear,register;
    JTextField accountTextField;
    JPasswordField textFieldPin;

    public Login(){

        //to change background color
        getContentPane().setBackground(Color.WHITE);
        setTitle("MSS System");
        setSize(720,570);
        setLocation(250,120);
        setLayout(null);

        //to insert the image we have to create imageicon class object
        ImageIcon imageIcon =
                new ImageIcon(ClassLoader.getSystemResource("Icon/logo.jpg"));

        //image size is to big so we have to make the iamge size small
        Image image = imageIcon.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);

        //we cannt put image inside Jlabel so we should use imageicon
        ImageIcon imageIcon1 = new ImageIcon(image);

        //now we have to insert the image inside the frame so use Jlabael and the add that in frame
        JLabel jLabel = new JLabel(imageIcon1);

        /*now to change the position of image we have to make change in jlabel so
        *x=distance from left , y = distance from toop ,width,height= image h,w
        */
        jLabel.setBounds(60,60,105,110);
        add(jLabel);


        //for title
        JLabel jlabelText = new JLabel("MSS System");
        Font textFont = new Font("Italic",Font.BOLD,34);
        jlabelText.setFont(textFont);
        jlabelText.setBounds(180,75,450,40);
        add(jlabelText);

        //for  card number
        JLabel accountNum = new JLabel("Account number:");
        Font accountFont = new Font("Raleway",Font.BOLD,20);
        accountNum.setFont(accountFont);
        accountNum.setBounds(90,200,200,40);
        add(accountNum);

        //for text field or input box
        accountTextField = new JTextField();
        accountTextField.setBounds(300,200,240,40);
        add(accountTextField);

        //for card pin number
        JLabel cardPin = new JLabel("Pin number:");
        Font cardPinFont = new Font("Raleway",Font.BOLD,20);
        cardPin.setFont(cardPinFont);
        cardPin.setBounds(90,270,160,40);
        add(cardPin);

        //for text field or input box
        textFieldPin = new JPasswordField();
        textFieldPin.setBounds(300,270,240,40);
        add(textFieldPin);

        //for button
        login = new JButton("SIGN IN");
        login.setBounds(300,330,100,30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        clear = new JButton("Clear");
        clear.setBounds(440,330,100,30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

        register = new JButton("Register");
        register.setBounds(380,400,100,30);
        register.setBackground(Color.black);
        register.setForeground(Color.white);
        register.addActionListener(this);
        add(register);


        setVisible(true);

    }

    public static void main(String[] args) {
        Login login = new Login();
    }

    //this function is used when we click the button
    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        //for validation of login
        if(actionEvent.getSource() == login){

            DbConnection dbConnection = new DbConnection();
            ResultSet resultSet = null;


            String accountNUmber = accountTextField.getText();
            String pinNumber = textFieldPin.getText();

            String query =
                    "select * from Login where Account_Number = '"+accountNUmber+"' and Pin_Number = '"+pinNumber+"'";

            //now executing the query using database
            try {

                //when the query is used it give back the data in the form of Resultset
                resultSet = dbConnection.s.executeQuery(query);
                if(resultSet.next()){
                    setVisible(false);
                    new MainTransactionMenu(pinNumber).setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null,"Your account number and pin is invalid");
                }

            }catch (Exception e){
                e.printStackTrace();
            }


        }else if (actionEvent.getSource() == clear){
            accountTextField.setText("");
            textFieldPin.setText("");

        } else if (actionEvent.getSource() == register) {
                setVisible(false);
                new RegisterForm().setVisible(true);
        }else {

        }
    }
}
