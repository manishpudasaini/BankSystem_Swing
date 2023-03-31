package BankManagementSystem.LoginPage.RegisterForm;

import BankManagementSystem.LoginPage.DbConnection;
import BankManagementSystem.LoginPage.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class FinalRegistration extends JFrame implements ActionListener {
    String formNum;

    JRadioButton savingAccount,fixedDepositeAccount,atmcardAccount,emailAlertAccount,mobilebankingAccount,accepAccount;
    JButton Submit,Cancel;
    public FinalRegistration(String formNum){
        this.formNum = formNum;
        setTitle("Final Registration");
        setSize(800,700);
        setLocation(250,120);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);


        //for title
        JLabel title = new JLabel("Final Step");
        Font textFont = new Font("Italic",Font.BOLD,23);
        title.setFont(textFont);
        title.setBounds(130,40,160,40);
        add(title);

        //for registration number
        JLabel registrationNumber = new JLabel("Registration no: "+formNum);
        Font formFont = new Font("Italic",Font.BOLD,19);
        registrationNumber.setFont(formFont);
        registrationNumber.setBounds(450,40,290,40);
        add(registrationNumber);


        //Account type
        JLabel accountType= new JLabel("Account Type");
        Font accountFont = new Font("Italic",Font.BOLD,17);
        accountType.setFont(accountFont);
        accountType.setBounds(130,100,160,40);
        add(accountType);

        //radio button Saving account
        savingAccount = new JRadioButton("Saving Account");
        Font savingFont = new Font("Italic",Font.BOLD,15);
        savingAccount.setFont(savingFont);
        savingAccount.setBounds(150,130,200,30);
        savingAccount.setBackground(Color.WHITE);
        add(savingAccount);

        //radio button Fixed deposite
        fixedDepositeAccount = new JRadioButton("Fixed Deposite Account");
        Font fixedFont = new Font("Italic",Font.BOLD,15);
        fixedDepositeAccount.setFont(fixedFont);
        fixedDepositeAccount.setBounds(400,130,300,30);
        fixedDepositeAccount.setBackground(Color.WHITE);
        add(fixedDepositeAccount);

        //one button should be clicked at a time so use ButtonGroup
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(savingAccount);
        buttonGroup.add(fixedDepositeAccount);

        //Account Number
        JLabel accountNumber= new JLabel("Account Number :: ");
        Font accountNumberFont = new Font("Italic",Font.BOLD,17);
        accountNumber.setFont(accountNumberFont);
        accountNumber.setBounds(130,220,200,40);
        add(accountNumber);

        //CARD NUMBER
        JLabel cardNumber= new JLabel("7143-XXXX-XXXX-XXXX ");
        Font cardNumberFont = new Font("Italic",Font.BOLD,17);
        cardNumber.setFont(cardNumberFont);
        cardNumber.setBounds(360,220,400,40);
        add(cardNumber);

        //CARD NUMBER Info
        JLabel cardNumberInfo= new JLabel("(16 digit acc number)");
        Font cardNumberInfoFont = new Font("Italic",Font.BOLD,12);
        cardNumberInfo.setFont(cardNumberInfoFont);
        cardNumberInfo.setBounds(360,240,400,40);
        add(cardNumberInfo);

        //Pin Number
        JLabel pinNumber= new JLabel("Pin Number :: ");
        Font pinNumberFont = new Font("Italic",Font.BOLD,17);
        pinNumber.setFont(accountNumberFont);
        pinNumber.setBounds(130,320,200,40);
        add(pinNumber);

        //CARD NUMBER
        JLabel pinNum= new JLabel("XXXX");
        Font pinNumFont = new Font("Italic",Font.BOLD,17);
        pinNum.setFont(pinNumFont);
        pinNum.setBounds(360,320,200,40);
        add(pinNum);

        //Pin NUMBER Info
        JLabel pinNumberInfo= new JLabel("(4 digit pin number)");
        Font pinNumberInfoFont = new Font("Italic",Font.BOLD,12);
        pinNumberInfo.setFont(cardNumberInfoFont);
        pinNumberInfo.setBounds(360,340,400,40);
        add(pinNumberInfo);


        //services Required
        JLabel serviceRequired= new JLabel("Services Required :: ");
        Font serviceFont = new Font("Italic",Font.BOLD,17);
        serviceRequired.setFont(accountNumberFont);
        serviceRequired.setBounds(130,400,200,40);
        add(serviceRequired);

        //service Radiobox
        //atm card
        atmcardAccount = new JRadioButton("ATM card");
        Font atmcadrFont = new Font("Italic",Font.BOLD,15);
        atmcardAccount.setFont(atmcadrFont);
        atmcardAccount.setBounds(150,425,200,30);
        atmcardAccount.setBackground(Color.WHITE);
        add(atmcardAccount);

        //email alert
        emailAlertAccount = new JRadioButton("Email alert");
        Font emailAlertFont = new Font("Italic",Font.BOLD,15);
        emailAlertAccount.setFont(emailAlertFont);
        emailAlertAccount.setBounds(390,425,200,30);
        emailAlertAccount.setBackground(Color.WHITE);
        add(emailAlertAccount);

        //mobile banking
        mobilebankingAccount = new JRadioButton("Mobile Banking");
        Font mobileFont = new Font("Italic",Font.BOLD,15);
        mobilebankingAccount.setFont(mobileFont);
        mobilebankingAccount.setBounds(150,450,200,30);
        mobilebankingAccount.setBackground(Color.WHITE);
        add(mobilebankingAccount);


        //acept the detail info i entered
        accepAccount = new JRadioButton("All the information i enter are correct.");
        Font acceptFont = new Font("Italic",Font.BOLD,15);
        accepAccount.setFont(acceptFont);
        accepAccount.setBounds(150,520,500,30);
        accepAccount.setBackground(Color.WHITE);
        add(accepAccount);

        //Buttons submit
        Submit = new JButton("Submit");
        Submit.setBounds(300,630,100,30);
        Submit.setBackground(Color.black);
        Submit.setForeground(Color.white);
        Submit.addActionListener(this);
        add(Submit);

        //Buttons cancel
        Cancel = new JButton("Cancel");
        Cancel.setBounds(490,630,100,30);
        Cancel.setBackground(Color.black);
        Cancel.setForeground(Color.white);
        Cancel.addActionListener(this);
        add(Cancel);


        setUndecorated(true);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Submit){

            String accountType=null;
                if(savingAccount.isSelected()){
                    accountType="Saving account";
                } else if (fixedDepositeAccount.isSelected()) {
                    accountType="Fixed Deposite Account";
                }

            //this is used to create the random number for account number
            Random accountRandom = new Random();
            String accountNumber = ""+ Math.abs((accountRandom.nextLong() % 70000000L)+ 7143714300000000L);

            //to generate unique Pin number
            String pinNumber = ""+Math.abs((accountRandom.nextLong() % 3000L)+7000L);
            
            //for serivices
            String facility = "";
            if(atmcardAccount.isSelected()){
                facility=facility+", Atm Card";
            } else if (emailAlertAccount.isSelected()) {
                facility = facility+", Email alert ";
            } else if (mobilebankingAccount.isSelected()) {
                facility =facility+", Mobile Banking";

            }

            try{

                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null,"Please select your account type");
                }else {

                    DbConnection dbConnection = new DbConnection();

                    //database insert query for table aacount info
                    String query1 =
                            "insert into AccountInfo values('"+formNum+"','"+accountType+"','"+accountNumber+"','"+pinNumber+"','"+facility+"')";

                    //database insert query for table login
                    String query2 =
                            "insert into Login values('"+formNum+"','"+accountNumber+"','"+pinNumber+"')";

                    dbConnection.s.execute(query1);
                    dbConnection.s.execute(query2);

                    JOptionPane.showMessageDialog(null,"Your account number is :: "+accountNumber+
                            "\n Pin code :: "+pinNumber);

                    setVisible(false);
                    new Login().setVisible(true);


                }


            }catch (Exception e4){
                e4.printStackTrace();
            }


        } else if (e.getSource() == Cancel) {
            setVisible(false);
            new Login().setVisible(true);
        }

    }


    public static void main(String[] args) {
        FinalRegistration finalRegistration = new FinalRegistration("");
    }


}
