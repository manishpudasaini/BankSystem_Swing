package BankManagementSystem.LoginPage.AfterLogin;

import BankManagementSystem.LoginPage.DbConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class TransactionStatement extends JFrame implements ActionListener {

    String Pin_Number;
    JButton back;
    public TransactionStatement(String pinNum){
        this.Pin_Number = pinNum;

        setTitle("Transaction statement");
        setLayout(null);
        setTitle("Cash Deposit - MSS System");
        setSize(850,700);
        setLocation(250,120);


        JLabel bankname = new JLabel("MSS system");
        Font bankNameFont = new Font("Italic",Font.BOLD,25);
        bankname.setFont(bankNameFont);
        bankname.setBounds(300,60,700,40);
        add(bankname);

        //jlabe for account NUmber
        JLabel text = new JLabel();
        Font textFont = new Font("Italic",Font.BOLD,17);
        text.setFont(textFont);
        text.setBounds(80,120,500,40);
        add(text);

        //jlabel for last 5 transaction
        JLabel transaction = new JLabel();
        Font transactionFont = new Font("Italic",Font.BOLD,17);
        transaction.setFont(transactionFont);
        transaction.setBounds(70,200,700,200);
        add(transaction);


        //this is done to extract the account number from the database table login
        try{

            DbConnection dbConnection = new DbConnection();
            ResultSet resultSet;
            String query =
                    "select * from Login where Pin_Number = '"+Pin_Number+"'";

            resultSet = dbConnection.s.executeQuery(query);

            while (resultSet.next()){
                text.setText("Account number : "+resultSet.getString("Account_Number"));
            }


        }catch (Exception e){
            e.printStackTrace();
        }

        //for extracting the transaction
        try{

            DbConnection dbConnection1 = new DbConnection();
            ResultSet resultSet1 ;
            String query1 =
                    "select * from Transaction where Pin_number = '"+Pin_Number+"'";

            resultSet1 = dbConnection1.s.executeQuery(query1);

            while (resultSet1.next()){
                transaction.setText(transaction.getText() + "<html>"
                        + resultSet1.getString("Date") + "  "
                        +resultSet1.getString("Transaction_type")+"  "
                        +resultSet1.getString("Amount") + "<br><br><html>");
            }


        }catch (Exception e2){
            e2.printStackTrace();
        }

        //for back button
        back = new JButton("Back");
        back.setBounds(600,590,100,35);
        back.addActionListener(this);
        add(back);

        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back){
            setVisible(false);
            new MainTransactionMenu(Pin_Number).setVisible(true);

        }

    }

    public static void main(String[] args) {
        new TransactionStatement("");
    }


}
