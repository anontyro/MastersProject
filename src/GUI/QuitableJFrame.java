package GUI;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.*;

/**
 * 
 * QuitableJFrame extends JFrame and implements WindowListener this provides
 * the framework for the TranslationTool frame to sit in
 */
public class QuitableJFrame extends JFrame implements WindowListener{

/**
 * Constructor Will create a personalised JFrame window that contains some basic functionality
 * @param title String is passed to assign the title of the window 
 * @param xpixels int is passed to setup the size of x in pixels
 * @param ypixels int is passed to setup the size of y in pixels
 */    
    public QuitableJFrame(String title, int xpixels, int ypixels){
        super(title);
        this.addWindowListener(this);
        if (xpixels > 0 && ypixels > 0){
            this.setSize(xpixels, ypixels);
        }
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        //this.setLocation(null);
    }
    
/**
 * Overloaded constructor that only takes the String Title and pulls default size
 * from JFrame
 * @param title String is passed and assigned to the title of the window
 */    
    public QuitableJFrame(String title){
        this(title, 0, 0);
    }
       
/**
 * Utility that pops up an inputDialog when the user wants to add a value
 * @param message String Sets the message you will ask the user
 * @param defaultValue int value that is a default incase the user inputs an incorrect
 * value or no value
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
     * @param message String to pass to the pop-up box to inform the user of
     * anything that is displayed to the user
     */
    public void tellUser(String message){
        JOptionPane.showMessageDialog(this, message, "Information", 
                JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * Warning message dialog
     * @param warning String sends a warning message to the user informing them
     * of any issue encountered
     */
    public void warnUser(String warning){
        JOptionPane.showMessageDialog(this,warning, "Warning",
                JOptionPane.WARNING_MESSAGE);
    }

/**
 * Setter method will allow access to the LookAndFeel, takes a String to pass 
 * @param lookAndFeel String to be passed to the LookAndFeel class
 */    
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
        
    }

/**
 * Will setup the windowClosing event
 * @param e windows event
 */    
    @Override
    public void windowClosing(WindowEvent e) {
        this.quitOrCancel();
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
    
    
}
