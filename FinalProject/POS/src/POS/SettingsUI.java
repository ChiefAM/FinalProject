package POS;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author antho
 */
public class SettingsUI 
{
        SettingsUI()
        {
            JFrame frame = new JFrame();
            frame.setSize(800, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            
            JPanel panel = new JPanel();
            panel.setBackground(Color.BLUE);
            frame.add(panel);
            
            
        }



}
