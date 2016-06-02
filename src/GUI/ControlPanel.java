package GUI;

import javax.swing.*;
import java.awt.*;


/**
 *
 * @author Alex
 */
public class ControlPanel extends JPanel{
    
    ControlPanel(Translator trans){
        
        JButton revcomButton, simpletransButton, sixFrameButton, orfButton, clear;
        
        this.add(revcomButton = new JButton("Reverse Comp"));
        revcomButton.addActionListener(trans);
        
        this.add(simpletransButton = new JButton("Simple Translation"));
        simpletransButton.addActionListener(trans);
        
        this.add(sixFrameButton = new JButton("Six frame translation"));
        sixFrameButton.addActionListener(trans);
        
        this.add(orfButton = new JButton("Get ORF"));
        orfButton.addActionListener(trans);
        
        this.add(clear = new JButton("Clear"));
        clear.addActionListener(trans);
        
        
    }
}
