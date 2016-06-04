package GUI;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Alex
 */
public class InformationPanel extends JPanel{
    
    private JTextField inputDNA, statusMessage;
    
    InformationPanel(){
        
        
        this.setLayout(new GridLayout(2,2));
        
        this.add(new JLabel("Sequence description"));
        this.add(new JLabel("Status: "));
        
        this.add(inputDNA = new JTextField());
        inputDNA.grabFocus();
        
        this.add(statusMessage = new JTextField("ready"));
        statusMessage.setEditable(false);
        statusMessage.setAutoscrolls(true);
   
    }
    
    public String getSequenceDescription(){
        return inputDNA.getText();
    }
    
    public void setStatusMessage(String message){
        statusMessage.setText(message);
    }
    
    public void setSequenceDescription(String name){
        inputDNA.setText(name);
    }
    
}
