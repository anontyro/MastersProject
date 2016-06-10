package GUI;

import DNAprogram.InvalidSequenceException;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.*;

/**
 *
 * @author Alex
 */
public class TranslationPanel extends JPanel implements FocusListener{
    
    private JTextArea dnaSequ, functionOut;
    
    TranslationPanel(){
        
        this.setLayout(new GridLayout(1,1));
        

        
        this.add(dnaSequ = new JTextArea("", 15, 20));
        dnaSequ.addFocusListener(this);
        dnaSequ.setLineWrap(true);
        dnaSequ.setColumns(10);
        dnaSequ.setAutoscrolls(true);
        
        JScrollPane scrollbar1 = new JScrollPane(dnaSequ,
        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        this.add(scrollbar1);
        
        this.add(functionOut = new JTextArea("", 15, 20));
        functionOut.setLineWrap(true);
        functionOut.setAutoscrolls(true);
        
        JScrollPane scrollbar2 = new JScrollPane(functionOut,
        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        this.add(scrollbar2);
                  
    }
    
    public String getInput(){
        return dnaSequ.getText();
    }
    
    public String getOutput(){
        return functionOut.getText();
    }
    
    public void setOutput(String output){
        String funOutput = "";
        funOutput += functionOut.getText() + "\n" +output;
        funOutput = funOutput.trim();
        functionOut.setText(funOutput);
    }
    public void setInput(String input){
        dnaSequ.setText(input);
    }
    public void clearOutput(){
        functionOut.setText("");
    }

    @Override
    public void focusGained(FocusEvent e) {
        if((dnaSequ.getText()).equals("Enter sequence here") == true){
            dnaSequ.setText("");
        }
        if((functionOut.getText()).equals("Output will print here...") == true){
            functionOut.setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if((dnaSequ.getText()).equals("") == true){
            dnaSequ.setText("Enter sequence here");
        }
        if((functionOut.getText()).equals("") == true){
            functionOut.setText("Output will print here...");
        }
    }
}
