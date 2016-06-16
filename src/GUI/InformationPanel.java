package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * A class that extends JPanel to create the northern region on the translation GUI
 */
public class InformationPanel extends JPanel{
    
    private JTextField inputDNA, statusMessage;

/**
 * Constructor creates the no argument informationPanel object that holds all the 
 * information about the
 * panels below that will resemble the input and output. Set in a gridLayout
 * this panel will display the sequence name on the left (can be entered by the user)
 * and a status message on the right which will inform the user on what is happening
 */    
    public InformationPanel(){
        
        
        this.setLayout(new GridLayout(2,2));
        
        this.add(new JLabel("Sequence description"));
        this.add(new JLabel("Status: "));
        
        this.add(inputDNA = new JTextField());
        inputDNA.grabFocus();
        
        this.add(statusMessage = new JTextField("ready"));
        statusMessage.setEditable(false);
        statusMessage.setAutoscrolls(true);
   
    }
/**
 * Getter method that pulls the sequenceDescription text which makes up the 
 * name of the sequence to be entered in FASTA format starting with a &gt;
 * @return Text String the sequence name that has been entered into the Sequence description
 * box
 */    
    public String getSequenceDescription(){
        return inputDNA.getText();
    }
 
/**
 * A setter void method that will set the message the user sees displayed below the Status
 * this is useful when updating the user on what is happening or what just happened
 * 
 * @param message String to be delivered to the user
 */    
    public void setStatusMessage(String message){
        statusMessage.setText(message);
    }

/**
 * A setter void method which takes a String and sets it as the sequence description,
 * this should be set in FASTA format starting with a &gt;
 * @param name String which is used to create the title, should be FASTA format
 */    
    public void setSequenceDescription(String name){
        inputDNA.setText(name);
    }
    
}
