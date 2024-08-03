package POS;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class CustomerOrder 
{
    JComboBox<String> customerList = new JComboBox<String>();
    CustomerOrder()
    {

        JFrame f = new JFrame("Customer Order");
        f.setSize(800,800);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setLayout(new BorderLayout());
        f.setResizable(false);
        f.getContentPane().setBackground(new Color(238, 236, 225));
        f.setTitle("Customer Order");


        



        //read from fie Customers.csv and display name of customer
        try (BufferedReader reader = new BufferedReader(new FileReader("Customers.csv"))) {
            String line;
            List<List<String>> data = new ArrayList<>();
        
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                List<String> row = Arrays.asList(parts);
                data.add(row);
            }
        
            // Move this outside the reading loop
            for (List<String> dat : data) {
                customerList.addItem(dat.get(0)); 
            }
        
        } catch (IOException e) { // Use a more descriptive variable name
            System.err.println("Error reading file: " + e.getMessage()); // Print to stderr for error messages
        }
        
        
        f.add(customerList, BorderLayout.CENTER);


            
}

    }



