package BankManagementSystem.LoginPage.AfterLogin;

import BankManagementSystem.LoginPage.DbConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class WithdrawAmount extends JFrame implements ActionListener {

    JTextField withdrawTextField;
    JButton withdrawButton,backButton;
    String Pin_number;
    public WithdrawAmount(String pinNumber){
        this.Pin_number = pinNumber;
        setLayout(null);
        setTitle("Cash Withdraw- MSS System");
        setSize(850,600);
        setLocation(250,120);

        //for background image
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Icon/menu.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(850,600,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel imageBackground = new JLabel(imageIcon1);
        imageBackground.setBounds(0,0,850,600);
        add(imageBackground);

        //for title
        JLabel textLabel = new JLabel("Please enter a amount you want to withdraw");
        Font textFont = new Font("Italic",Font.BOLD,25);
        textLabel.setFont(textFont);
        textLabel.setBounds(70,60,700,40);
        textLabel.setForeground(Color.WHITE);
        imageBackground.add(textLabel);

        //for input box to write ammount
        withdrawTextField = new JTextField();
        withdrawTextField.setBounds(90,120,350,35);
        imageBackground.add(withdrawTextField);

        //for deposite button
        withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(100,200,150,35);
        withdrawButton.addActionListener(this);
        imageBackground.add(withdrawButton);

        //for backbutton
        backButton = new JButton("Back");
        backButton.setBounds(100,270,150,35);
        backButton.addActionListener(this);
        imageBackground.add(backButton);


        setUndecorated(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == withdrawButton){
            String amonutField = withdrawTextField.getText();
            Date dateTime =new Date();
            String type = "Withdraw";

            //if deposite amount is empty
            if(amonutField.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter amount to withdraw");
            }else {
                try {
                    DbConnection dbConnection = new DbConnection();
                    String query =
                            "insert into Transaction values('"+Pin_number+"','"+dateTime+"','"+type+"','"+amonutField+"')";

                    dbConnection.s.execute(query);
                    JOptionPane.showMessageDialog(null,"Amount Rs "+amonutField+" withdraw successfully");

                    new MainTransactionMenu(Pin_number).setVisible(true);


                }catch (Exception e1){
                    e1.printStackTrace();
                }

            }

        } else if (e.getSource() == backButton) {
            setVisible(false);
            new MainTransactionMenu(Pin_number).setVisible(true);

        }

    }

    public static void main(String[] args) {
        new WithdrawAmount("");
    }


}
