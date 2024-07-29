package POS;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author antho
 */
public class SalesUI implements ActionListener
{
    
    public SalesUI() 
    {
        JFrame f = new JFrame(); 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setExtendedState(JFrame. MAXIMIZED_BOTH);
        f.setVisible(true);
        f.setLayout(new BorderLayout());
        f.getContentPane().setBackground(new Color(238, 236, 225));
        f.setTitle("Sales");

        
        JLabel Username = new JLabel("Username:");
        Username.setFont(new Font("Cosmic Sans",Font.BOLD, 25));
        Username.setHorizontalAlignment(JLabel.CENTER);
        Username.setOpaque(true);
        Username.setForeground(Color.black);
        Username.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        Username.setText(LoginUI.UsernameString);
        String[] columnNames = {"Item Name", "Price", "Quantity"};
        DefaultTableModel model;

        JPanel SalesPanel = new JPanel();
        SalesPanel.setBackground(Color.CYAN);
        SalesPanel.setLayout(new GridLayout());
        SalesPanel.setBorder(BorderFactory.createRaisedSoftBevelBorder());

        JPanel bot = new JPanel();
        bot.setBackground(Color.blue);
        bot.setLayout(new GridLayout(4,1));
        bot.setBorder(BorderFactory.createRaisedSoftBevelBorder());

        JTable table = new JTable();


        JButton Payment = new JButton("Payment");
        Payment.setFont(new Font("Cosmic Sans",Font.BOLD, 25));
        Payment.setBackground(Color.white);
        Payment.setForeground(Color.black);
        Payment.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        Payment.addActionListener(this);

       
        model = new DefaultTableModel(columnNames, 0); // Start with 0 rows
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        SalesPanel.add(scrollPane);

        JButton backToMenuButton = new JButton("Back to Menu");
        backToMenuButton.setFont(new Font("Cosmic Sans",Font.BOLD, 25));
        backToMenuButton.setBackground(Color.white);
        backToMenuButton.setForeground(Color.black);
        backToMenuButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        backToMenuButton.addActionListener(this);

        
        JButton AddItem = new JButton("Add Item");
        AddItem.setFont(new Font("Cosmic Sans",Font.BOLD, 25));
        AddItem.setBackground(Color.white);
        AddItem.setForeground(Color.black);
        AddItem.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        AddItem.addActionListener(this);


        JPanel ItemJPanel = new JPanel();
        ItemJPanel.setBackground(Color.blue);
        ItemJPanel.setLayout(new GridLayout(10,2));
        ItemJPanel.setBorder(BorderFactory.createRaisedSoftBevelBorder());

        JButton product1 = new JButton("Product 1");
        product1.setFont(new Font("Cosmic Sans",Font.BOLD, 25));
        product1.setBackground(Color.white);
        product1.setForeground(Color.black);
        product1.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        product1.addActionListener(this);
        product1.setFocusable(false);

        JButton product2 = new JButton("Product 2");
        product2.setFont(new Font("Cosmic Sans",Font.BOLD, 25));
        product2.setBackground(Color.white);
        product2.setForeground(Color.black);
        product2.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        product2.addActionListener(this);
        product2.setFocusable(false);

        JButton product3 = new JButton("Product 3");
        product3.setFont(new Font("Cosmic Sans",Font.BOLD, 25));
        product3.setBackground(Color.white);
        product3.setForeground(Color.black);
        product3.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        product3.addActionListener(this);
        product3.setFocusable(false);

        JButton product4 = new JButton("Product 4");
        product4.setFont(new Font("Cosmic Sans",Font.BOLD, 25));
        product4.setBackground(Color.white);
        product4.setForeground(Color.black);
        product4.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        product4.addActionListener(this);
        product4.setFocusable(false);

        JButton product5 = new JButton("Product 5");
        product5.setFont(new Font("Cosmic Sans",Font.BOLD, 25));
        product5.setBackground(Color.white);
        product5.setForeground(Color.black);
        product5.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        product5.addActionListener(this);
        product5.setFocusable(false);



        f.add(ItemJPanel, BorderLayout.WEST);
        ItemJPanel.add(product1);
        ItemJPanel.add(product2);
        ItemJPanel.add(product3);
        ItemJPanel.add(product4);
        ItemJPanel.add(product5);
        bot.add(Payment);
        bot.add(AddItem);
        f.add(SalesPanel, BorderLayout.CENTER);
        f.add(bot, BorderLayout.SOUTH);
        f.add(Username, BorderLayout.NORTH);
        bot.add(backToMenuButton);


        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
