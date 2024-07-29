/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package POS;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author antho
 */
public class RegisterUI implements ActionListener
{
            JTextField UsernameField;
            JPasswordField PasswordField;
            JButton RegisterButton;
            JFrame f = new JFrame();
            String fileName = "credentials.txt";
            String line;
            public static List<String> lines = new ArrayList<>();
            public static String UsernameString;
            String PasswordString;
            
            public RegisterUI() 
            {
                
                f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                f.setSize(400,400);
                f.setLocationRelativeTo(null);
                f.setVisible(true);
                f.setLayout(new FlowLayout());
                f.setResizable(false);
                f.getContentPane().setBackground(new Color(238, 236, 225));
                f.setTitle("Register");

                JPanel panel1 = new JPanel();
                panel1.setBounds(50, 300, 1000, 300);
                panel1.setBackground(new Color(195,214,155));
                panel1.setLayout(new GridLayout());

                JPanel panel2 = new JPanel();
                panel2.setBounds(50, 600, 1000, 300);
                panel2.setBackground(new Color(195,214,155));
                panel2.setLayout(new GridLayout());


                JLabel Username = new JLabel("Username:");
                Username.setFont(new Font("Cosmic Sans",Font.BOLD, 25));
                Username.setHorizontalAlignment(JLabel.CENTER);
                Username.setOpaque(true);
                Username.setForeground(Color.black);
                Username.setBorder(BorderFactory.createRaisedSoftBevelBorder());
                Username.setFocusable(false);
                
                JLabel Password = new JLabel("Password:");
                Password.setFont(new Font("Cosmic Sans",Font.BOLD, 25));
                Password.setHorizontalAlignment(JLabel.CENTER);
                Password.setOpaque(true);
                Password.setForeground(Color.black);
                Password.setBorder(BorderFactory.createRaisedSoftBevelBorder());
                Password.setFocusable(false);




                UsernameField = new JTextField();
                UsernameField.setFont(new Font("Cosmic Sans",Font.BOLD, 25));
                UsernameField.setHorizontalAlignment(JTextField.CENTER);
                UsernameField.setOpaque(true);
                UsernameField.setForeground(Color.black);
                UsernameField.setBorder(BorderFactory.createRaisedSoftBevelBorder());


                PasswordField = new JPasswordField();
                PasswordField.setFont(new Font("Cosmic Sans",Font.BOLD, 25));
                PasswordField.setHorizontalAlignment(JTextField.CENTER);
                PasswordField.setOpaque(true);
                PasswordField.setForeground(Color.black);
                PasswordField.setBorder(BorderFactory.createRaisedSoftBevelBorder());
                


                RegisterButton = new JButton("Register");
                RegisterButton.setFont(new Font("Cosmic Sans",Font.BOLD, 25));
                RegisterButton.setFocusable(false);
                RegisterButton.setForeground(Color.black);
                RegisterButton.setBackground(new Color(192,192,192));
                RegisterButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());
                RegisterButton.addActionListener(this);
                RegisterButton.setFocusable(false);

                panel1.add(Username);
                panel1.add(UsernameField);
                f.add(panel1);
                panel2.add(Password);
                panel2.add(PasswordField);
                f.add(panel2);
                f.add(RegisterButton);



}

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == RegisterButton)
        {
            String Username = UsernameField.getText();
            String Password = PasswordField.getText();

            if(Username.isEmpty() || Password.isEmpty())
            {
                return;
            }
            MenuUI.instance.setEnabled(true);
            MenuUI.instance.toFront();
            MenuUI.instance.requestFocus();
            f.dispose();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                writer.write(Username + "\n" + Password);
                
                
                
                System.out.println("Successfully wrote to the file.");
    
            } catch (IOException ee) {
                System.out.println("An error occurred."); 
            }

            UsernameString = lines.get(0);
            PasswordString = lines.get(1);
        }
    }
}
