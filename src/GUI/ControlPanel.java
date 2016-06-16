package GUI;

import javax.swing.*;
import java.awt.*;


/**
 * 
 * ControlPanel extends JPanel class holds the buttons that make up the South
 * region of the TranslationTool frame
 */
public class ControlPanel extends JPanel{

/**
 * Constructor that takes a Translator object which is its ActionListerner class
 * for the buttons
 * @param trans object
 */    
    public ControlPanel(Translator trans){
        
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
