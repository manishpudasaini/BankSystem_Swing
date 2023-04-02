package BankManagementSystem.LoginPage.AfterLogin;

import BankManagementSystem.LoginPage.DbConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePin extends JFrame implements ActionListener {
    String change_pin;
    JTextField textFieldold,textFieldNew;

    JButton changeButton,backButton;
    public ChangePin(String changePin){
        this.change_pin = changePin;

        setLayout(null);
        setTitle("Change Pin Number - MSS System");
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
        JLabel jlabelText = new JLabel(" Change your Pin number");
        Font textFont = new Font("Italic",Font.BOLD,23);
        jlabelText.setFont(textFont);
        jlabelText.setBounds(60,40,500,40);
        jlabelText.setForeground(Color.WHITE);
        imageBackground.add(jlabelText);


        //for textfield new pin
        JLabel name = new JLabel("New Pin : ");
        Font nameFont = new Font("Italic",Font.BOLD,15);
        name.setFont(nameFont);
        name.setBounds(70,100,170,30);
        name.setForeground(Color.WHITE);
        imageBackground.add(name);

        textFieldold = new JTextField();
        textFieldold.setBounds(190,100,220,30);
        imageBackground.add(textFieldold);

        //for textfield re enter pin
        JLabel nameRe = new JLabel("Re-Enter Pin: ");
        Font nameReFont = new Font("Italic",Font.BOLD,15);
        nameRe.setFont(nameReFont);
        nameRe.setBounds(70,160,170,30);
        nameRe.setForeground(Color.WHITE);
        imageBackground.add(nameRe);

        textFieldNew = new JTextField();
        textFieldNew.setBounds(190,160,220,30);
        imageBackground.add(textFieldNew);

        //for change button
        changeButton =  new JButton("Change");
        changeButton.setBounds(80,280,130,30);
        changeButton.addActionListener(this);
        imageBackground.add(changeButton);

        //for back button
        backButton =  new JButton("Back");
        backButton.setBounds(250,280,130,30);
        backButton.addActionListener(this);
        imageBackground.add(backButton);

        setUndecorated(true);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == changeButton){
            try {
                String newPin = textFieldold.getText();
                String rePin = textFieldNew.getText();

                if(newPin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter your new pin");
                }
                else if(!newPin.equals(rePin)){
                    JOptionPane.showMessageDialog(null,"Please enter same pin number");
                }
                else {

                    DbConnection dbConnection = new DbConnection();

                    //for table transaction
                    String queryForTableTransaction =
                            "update Transaction set Pin_Number = '"+rePin+ "' where Pin_Number = '"+change_pin+"' ";

                    //for table Login
                    String queryForTableLogin=
                            "update Login set Pin_Number = '"+rePin+ "' where Pin_Number = '"+change_pin+"' ";

                    //for table Account Info
                    String queryForTableAccountInfo =
                            "update AccountInfo set Pin_NUmber = '"+rePin+ "' where Pin_NUmber = '"+change_pin+"' ";

                    //now executing the query
                    dbConnection.s.executeUpdate(queryForTableTransaction);
                    dbConnection.s.executeUpdate(queryForTableLogin);
                    dbConnection.s.executeUpdate(queryForTableAccountInfo);

                    JOptionPane.showMessageDialog(null,"Pin code change successfully");

                    setVisible(false);
                    new MainTransactionMenu(rePin).setVisible(true);

                }


            }catch (Exception e2){
                e2.printStackTrace();
            }

        } else if (e.getSource() == backButton) {
            setVisible(false);
            new MainTransactionMenu(change_pin).setVisible(true);
        }

    }
    public static void main(String[] args) {
        new ChangePin("");
    }


}
