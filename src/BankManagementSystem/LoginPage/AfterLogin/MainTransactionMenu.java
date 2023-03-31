package BankManagementSystem.LoginPage.AfterLogin;

import BankManagementSystem.LoginPage.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainTransactionMenu extends JFrame implements ActionListener {

    JButton depositeButton,withdrawButton,statementButton,changePinButton,checkBalanceButton,exitButton,exitLoginButton;
    String Pin_NUmber;
    public MainTransactionMenu(String pinNumber){
        this.Pin_NUmber = pinNumber;

        setLayout(null);
        setTitle("Main menu - MSS System");
        setSize(850,800);
        setLocation(250,120);


        ImageIcon imageIcon =
                new ImageIcon(ClassLoader.getSystemResource("Icon/menu.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(850,800,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel imageBackground = new JLabel(imageIcon1);
        imageBackground.setBounds(0,0,850,800);
        add(imageBackground);

        //jlabel for title
        JLabel text = new JLabel("Welcome to MSS system");
        text.setBounds(200,120,450,40);
        Font textFont = new Font("Italic",Font.BOLD,25);
        text.setFont(textFont);
        text.setForeground(Color.WHITE);
        imageBackground.add(text);

        //for button
        //'first Deposite button
        depositeButton = new JButton("Deposite");
        depositeButton.setBounds(130,250,190,40);
        imageBackground.add(depositeButton);

        //for withdraw jbutton
        withdrawButton = new JButton("Withdrawal");
        withdrawButton.setBounds(460,250,190,40);
        imageBackground.add(withdrawButton);

        //for statement jbutton
        statementButton = new JButton("Statement");
        statementButton.setBounds(130,320,190,40);
        imageBackground.add(statementButton);

        //for change login pin code
        changePinButton = new JButton("Change Pin ");
        changePinButton.setBounds(460,320,190,40);
        imageBackground.add(changePinButton);

        //for check Balance
        checkBalanceButton = new JButton("Check Balance ");
        checkBalanceButton.setBounds(130,390,190,40);
        imageBackground.add(checkBalanceButton);

        //for exit  to login page
        exitLoginButton = new JButton("Login page");
        exitLoginButton.setBounds(350,650,160,40);
        exitLoginButton.setBackground(Color.red);
        exitLoginButton.setForeground(Color.white);
        exitLoginButton.addActionListener(this);
        imageBackground.add(exitLoginButton);

        //for exit system
        exitButton = new JButton("Exit");
        exitButton.setBounds(590,650,160,40);
        exitButton.setBackground(Color.red);
        exitButton.setForeground(Color.white);
        exitButton.addActionListener(this);
        imageBackground.add(exitButton);


        //to remove the white frame outside
        setUndecorated(true);

        //it should always in last
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == exitLoginButton){

            setVisible(false);
            new Login().setVisible(true);
        }else if(e.getSource() == exitButton){
            JOptionPane.showMessageDialog(null,"Thank you for using our system");
            System.exit(0);
        }

    }

    public static void main(String[] args) {
        new MainTransactionMenu("");

    }


}
