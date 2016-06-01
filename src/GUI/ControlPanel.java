package GUI;

import javax.swing.*;
import java.awt.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alex
 */
public class ControlPanel extends JPanel{
    
    ControlPanel(){
        
        JButton revcomButton, simpletransButton, sixFrameButton, orfButton, clear;
        
        this.add(revcomButton = new JButton("Reverse Comp"));
        
        this.add(simpletransButton = new JButton("Simple Translation"));
        
        this.add(sixFrameButton = new JButton("Six frame translation"));
        
        this.add(orfButton = new JButton("Get ORF"));
        
        this.add(clear = new JButton("Clear"));
        
        
        
    }
}
