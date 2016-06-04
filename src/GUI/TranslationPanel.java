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
        
        /*JScrollPane scrollbar1 = new JScrollPane(dnaSequ,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        this.add(scrollbar1); */
        
        this.add(dnaSequ = new JTextArea("", 15, 20));
        dnaSequ.addFocusListener(this);
        dnaSequ.setLineWrap(true);
        dnaSequ.setColumns(10);
        dnaSequ.setAutoscrolls(true);
        
        this.add(functionOut = new JTextArea("output", 15, 20));
        functionOut.setLineWrap(true);
        functionOut.setAutoscrolls(true);

    }
    
    public String getInput(){
        return dnaSequ.getText();
    }
    
    public String getOutput(){
        return functionOut.getText();
    }
    
    public void setOutput(String output){
        String funOutput = "";
        if(functionOut.getText().equals("output")){
            functionOut.setText(null);
        }
        funOutput += functionOut.getText() + "\n" +output;
        functionOut.setText(funOutput);
    }
    public void setInput(String input){
        dnaSequ.setText(input);
    }
    public void clearOutput(){
        functionOut.setText("output");
    }

    @Override
    public void focusGained(FocusEvent e) {
        if((dnaSequ.getText()).equals("Enter sequence here") == true){
            dnaSequ.setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if((dnaSequ.getText()).equals("") == true){
            dnaSequ.setText("Enter sequence here");
        }
    }
}
