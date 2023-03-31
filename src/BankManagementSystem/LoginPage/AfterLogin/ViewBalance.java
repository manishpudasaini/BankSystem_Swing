package BankManagementSystem.LoginPage.AfterLogin;

import BankManagementSystem.LoginPage.DbConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewBalance extends JFrame implements ActionListener {
    String Pin_number;
    JButton backButton;
    public ViewBalance(String pinNum){

        this.Pin_number = pinNum;

        setLayout(null);
        setTitle("View Balance Number - MSS System");
        setSize(850,600);
        setLocation(250,120);

        //for background image
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Icon/menu.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(850,600,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel imageBackground = new JLabel(imageIcon1);
        imageBackground.setBounds(0,0,850,600);
        add(imageBackground);


        //to show the current balance we have to first use database
        DbConnection dbConnection = new DbConnection();
        ResultSet resultSet;
        int balance = 0;
        try {
            resultSet = dbConnection.s.executeQuery("Select * from Transaction where Pin_Number = '"+Pin_number+"'");


            while (resultSet.next()){
                if(resultSet.getString("Transaction_type").equals("Deposite")){
                    balance = balance+ Integer.parseInt(resultSet.getString("Amount"));
                }else if(resultSet.getString("Transaction_type").equals("Withdraw")){
                    balance = balance - Integer.parseInt(resultSet.getString("Amount"));
                }
            }


        }catch (Exception e){
            e.printStackTrace();
        }

        //for title
        JLabel jlabelText = new JLabel("Your current balance is Rs "+balance);
        Font textFont = new Font("Italic",Font.BOLD,23);
        jlabelText.setFont(textFont);
        jlabelText.setBounds(60,40,500,40);
        jlabelText.setForeground(Color.WHITE);
        imageBackground.add(jlabelText);

        //for button
        backButton = new JButton("Back");
        backButton.setBounds(580,500,80,30);
        backButton.addActionListener(this);
        imageBackground.add(backButton);

        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backButton){
            setVisible(false);
            new MainTransactionMenu(Pin_number).setVisible(true);
        }

    }

    public static void main(String[] args) {
        new ViewBalance("");
    }


}
