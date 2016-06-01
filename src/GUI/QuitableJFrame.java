package GUI;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class QuitableJFrame extends JFrame implements WindowListener{
    
    public QuitableJFrame(String title, int xpixels, int ypixels){
        super(title);
        this.addWindowListener(this);
        if (xpixels > 0 && ypixels > 0){
            this.setSize(xpixels, ypixels);
        }
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
    
    
    public QuitableJFrame(String title){
        this(title, 0, 0);
    }
       
    /**
     * Utility that pops up an inputDialog when the user wants to add a value
     * @param message
     * @param defaultValue
     * @return 
     */
    public int getValueFromUser(String message, int defaultValue){
        String valueString = JOptionPane.showInputDialog(this,message,
                "input value", JOptionPane.QUESTION_MESSAGE);
        if(valueString == null) return defaultValue;
        else
            try{
                int value = Integer.parseInt(valueString);
                return value;
            }
            catch(NumberFormatException e){
                return defaultValue;
            }
    }
    
    // test to run the frame
    public static void main(String[]args){
        JFrame f = new QuitableJFrame("Testing", 300,300);
        f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        f.setVisible(true);
    }
    
    /**
     * Utility to pop up a quit/cancel dialog associated with the frame
     */
    public void quitOrCancel(){
        int result = JOptionPane.showConfirmDialog(this, 
                "Are you sure you want to exit " + this.getTitle() + "?",
                "Exit program",
                JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION){
            System.exit(1);
        }
        
    }
    
    /**
     * Utility to pop up a message dialog
     * @param message 
     */
    public void tellUser(String message){
        JOptionPane.showMessageDialog(this, message, "Information", 
                JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * Warning message dialog
     * @param warning 
     */
    public void warnUser(String warning){
        JOptionPane.showMessageDialog(this,warning, "Warning",
                JOptionPane.WARNING_MESSAGE);
    }
    
    public void setLookAndFeel(String lookAndFeel){
        try{
            UIManager.setLookAndFeel(lookAndFeel);
            
            SwingUtilities.updateComponentTreeUI(this);
            
            this.validate();
            
            this.repaint();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosing(WindowEvent e) {
        this.quitOrCancel();
    }

    @Override
    public void windowClosed(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowIconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowActivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
