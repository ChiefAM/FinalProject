package POS;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
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
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;


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
    
    public static Border outerBorder = BorderFactory.createMatteBorder(1, 1, 2, 2, Color.YELLOW); // Top, left, bottom, right
    public static Border innerBorder = BorderFactory.createEmptyBorder(2, 2, 0, 0); // Add padding
    public static CompoundBorder border = BorderFactory.createCompoundBorder(outerBorder, innerBorder);
    
    public MenuUI()
    {
        
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            while ((line = reader.readLine()) != null) {
                lines.add(line); 

            }
            } catch (IOException ee) {
            System.out.println("Error reading file: " + ee.getMessage());
            }
        instance = this;
        //this is the main menu
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 800);
        this.setExtendedState(JFrame. MAXIMIZED_BOTH);
        this.setVisible(true);
        this.setLayout(new BorderLayout());
        this.getContentPane().setBackground(Color.black);
        this.setTitle("Point of Sale System");


        //this is the POSOption button in the first panel
        POSOption = new JLabel("POS Options:");
        POSOption.setBounds(70, 40, 300, 45);
        POSOption.setFont(new Font("Cosmic Sans",Font.BOLD, 25));
        POSOption.setHorizontalAlignment(JLabel.CENTER);
        POSOption.setOpaque(true);
        POSOption.setForeground(Color.YELLOW);
        POSOption.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        POSOption.setOpaque(true);
        POSOption.setBackground(new Color(119,147,60));
        POSOption.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        //this is the Sales button in the first panel
        Sales = new JButton("Sales");
        Sales.setBounds(50, 100, 400, 50);
        Sales.setFocusable(false);
        Sales.setFont(new Font("Cosmic Sans",Font.BOLD, 25));
        Sales.setForeground(Color.yellow);
        Sales.setBackground(Color.black);
        Sales.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        Sales.addActionListener(this);
        //


        Settings = new JButton("Settings");
        Settings.setBounds(50, 200, 400, 50);
        Settings.setFocusable(false);
        Settings.setFont(new Font("Cosmic Sans",Font.BOLD, 25));
        Settings.setForeground(Color.YELLOW);
        Settings.setBackground(Color.BLACK);
        Settings.setBorder(border);
        Settings.addActionListener(this);

        UserRegister = new JButton("Register");
        UserRegister.setBounds(450, 100, 400, 50);
        UserRegister.setFocusable(false);
        UserRegister.setFont(new Font("Cosmic Sans",Font.BOLD, 25));
        UserRegister.setForeground(Color.YELLOW);
        UserRegister.setBackground(Color.BLACK);
        UserRegister.setBorder(border);
        UserRegister.addActionListener(this);

        UserLogin = new JButton("Login");
        UserLogin.setBounds(450, 150, 400, 50);
        UserLogin.setFocusable(false);
        UserLogin.setFont(new Font("Cosmic Sans",Font.BOLD, 25));
        UserLogin.setForeground(Color.YELLOW);
        UserLogin.setBackground(Color.BLACK);
        UserLogin.setBorder(border);
        UserLogin.addActionListener(this);


        UserLogout = new JButton("Logout");
        UserLogout.setBounds(450, 200, 400, 50);
        UserLogout.setFocusable(false);
        UserLogout.setFont(new Font("Cosmic Sans",Font.BOLD, 25));
        UserLogout.setForeground(Color.YELLOW);
        UserLogout.setBackground(Color.BLACK);
        UserLogout.setBorder(border);
        UserLogout.addActionListener(this);



        
        User = new JLabel("User: Guest");
        User.setBounds(70, 40, 300, 45);
        User.setFont(new Font("Cosmic Sans",Font.BOLD, 25));
        User.setHorizontalAlignment(JLabel.CENTER);
        User.setOpaque(true);
        User.setForeground(Color.black);
        User.setBorder(border);
        User.setOpaque(true);
        User.setBackground(Color.yellow);
        User.setBorder(border);


        JPanel mp = new JPanel();
        mp.setLayout(new GridLayout());
        mp.setBackground(Color.black);
        this.add(mp, BorderLayout.CENTER);

        JPanel up = new JPanel();
        up.setLayout(new GridLayout());
        up.setBackground(Color.black);
        this.add(up, BorderLayout.NORTH);




        up.add(User);
        mp.add(Settings);
        mp.add(UserLogout);
        mp.add(UserLogin);
        mp.add(UserRegister);
        mp.add(Sales);
        if (lines.isEmpty()) {
            new RegisterUI();
        } else if (User.getText().equals("User: Guest"))
        {
            new LoginUI();
        }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
        
        
        
        if(e.getSource() == Sales)
        {


                new SalesUI();
                //close the current window
                this.dispose();


            
        }
        else if(e.getSource() == Settings)
        {
            new SettingsUI();
            //close the current window
            this.dispose();
            
        }
        else if(e.getSource() == UserRegister)
        {
            if(User.getText().equals("User: Guest")){
                new RegisterUI();
                //close the current window
                this.setEnabled(false);
            }
            else
            {
                System.out.println("You are already registered");
            }


            
            
        }
        else if(e.getSource() == UserLogin)
        {
            if(User.getText().equals("User: Guest"))
            {
            new LoginUI();
            //close the current window
            this.setEnabled(false);
            }
            else
            {
                System.out.println("You are already logged in");
            }
            
            
        }
        else if(e.getSource() == UserLogout)
        {
            if(!User.getText().equals("User: Guest"))
            {
                LoginUI.UsernameString = null;
                LoginUI.PasswordString = null;
                User.setText("User: Guest");
                System.out.println("You have been logged out");
            }
            else
            {
                System.out.println("You are already logged out");
            }

            
            
            
        }


        
    }
}

