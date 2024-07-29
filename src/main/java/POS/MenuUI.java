package POS;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


/**
 *
 * @author ChiefAM
 */

public class MenuUI extends JFrame implements ActionListener
{
    JLabel POSOption;
    public static JLabel User;
    JButton Sales;
    JButton UserLogin;
    JButton UserLogout;
    JButton UserRegister;
    JButton Settings;
    public static JFrame instance;
    String fileName = "credentials.txt";
    String line;
    List<String> lines = new ArrayList<>();


    {
        this.setEnabled(true);
    }
    public MenuUI()
    {
        
        instance = this;
        //this is the main menu
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 800);
        this.setExtendedState(JFrame. MAXIMIZED_BOTH);
        this.setVisible(true);
        this.setLayout(new FlowLayout());
        this.getContentPane().setBackground(new Color(238, 236, 225));
        this.setTitle("Point of Sale System");


        //this is the POSOption button in the first panel
        POSOption = new JLabel("POS Options:");
        POSOption.setBounds(70, 40, 300, 45);
        POSOption.setFont(new Font("Cosmic Sans",Font.BOLD, 25));
        POSOption.setHorizontalAlignment(JLabel.CENTER);
        POSOption.setOpaque(true);
        POSOption.setForeground(Color.white);
        POSOption.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        POSOption.setOpaque(true);
        POSOption.setBackground(new Color(119,147,60));
        POSOption.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        //this is the Sales button in the first panel
        Sales = new JButton("Sales");
        Sales.setBounds(50, 100, 400, 50);
        Sales.setFocusable(false);
        Sales.setFont(new Font("Cosmic Sans",Font.BOLD, 25));
        Sales.setForeground(Color.black);
        Sales.setBackground(new Color(192,192,192));
        Sales.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        Sales.addActionListener(this);
        //


        Settings = new JButton("Settings");
        Settings.setBounds(50, 200, 400, 50);
        Settings.setFocusable(false);
        Settings.setFont(new Font("Cosmic Sans",Font.BOLD, 25));
        Settings.setForeground(Color.black);
        Settings.setBackground(new Color(192,192,192));
        Settings.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        Settings.addActionListener(this);

        UserRegister = new JButton("Register");
        UserRegister.setBounds(450, 100, 400, 50);
        UserRegister.setFocusable(false);
        UserRegister.setFont(new Font("Cosmic Sans",Font.BOLD, 25));
        UserRegister.setForeground(Color.black);
        UserRegister.setBackground(new Color(192,192,192));
        UserRegister.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        UserRegister.addActionListener(this);

        UserLogin = new JButton("Login");
        UserLogin.setBounds(450, 150, 400, 50);
        UserLogin.setFocusable(false);
        UserLogin.setFont(new Font("Cosmic Sans",Font.BOLD, 25));
        UserLogin.setForeground(Color.black);
        UserLogin.setBackground(new Color(192,192,192));
        UserLogin.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        UserLogin.addActionListener(this);


        UserLogout = new JButton("Logout");
        UserLogout.setBounds(450, 200, 400, 50);
        UserLogout.setFocusable(false);
        UserLogout.setFont(new Font("Cosmic Sans",Font.BOLD, 25));
        UserLogout.setForeground(Color.black);
        UserLogout.setBackground(new Color(192,192,192));
        UserLogout.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        UserLogout.addActionListener(this);




        User = new JLabel("User: Guest");
        User.setBounds(70, 40, 300, 45);
        User.setFont(new Font("Cosmic Sans",Font.BOLD, 25));
        User.setHorizontalAlignment(JLabel.CENTER);
        User.setOpaque(true);
        User.setForeground(Color.white);
        User.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        User.setOpaque(true);
        User.setBackground(new Color(119,147,60));
        User.setBorder(BorderFactory.createRaisedSoftBevelBorder());








        this.add(User);
        this.add(POSOption);
        this.add(Settings);
        this.add(UserLogout);
        this.add(UserLogin);
        this.add(UserRegister);
        this.add(Sales);
        



}
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Sales)
        {
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            while ((line = reader.readLine()) != null) {
                lines.add(line); 

            }
            } catch (IOException ee) {
            System.out.println("Error reading file: " + ee.getMessage());
            }
            if(lines.isEmpty()){
                new RegisterUI();
            }
            else if(LoginUI.UsernameString!=null)
            {
                new SalesUI();
                //close the current window
                this.dispose();
            }
            else 
            {
                new LoginUI();
                //close the current window
                
                
            }

            
        }
        else if(e.getSource() == Settings)
        {
            new SettingsUI();
            //close the current window
            this.dispose();
            
        }
        else if(e.getSource() == UserRegister)
        {
            RegisterUI r = new RegisterUI();
            //close the current window
            this.setEnabled(false);

            
            
        }
        else if(e.getSource() == UserLogin)
        {
            new LoginUI();
            //close the current window
            this.setEnabled(false);
            
            
            
        }
        else if(e.getSource() == UserLogout)
        {
            LoginUI.UsernameString = null;
            LoginUI.PasswordString = null;
            User.setText("User: Guest");
            
            
            
        }


        
    }
}

