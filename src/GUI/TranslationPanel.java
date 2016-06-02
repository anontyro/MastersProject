package GUI;

import DNAprogram.InvalidSequenceException;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Alex
 */
public class TranslationPanel extends JPanel{
    
    private JTextArea dnaSequ, functionOut;
    
    TranslationPanel(){
        
        this.setLayout(new GridLayout(1,1));
        
        /*JScrollPane scrollbar1 = new JScrollPane(dnaSequ,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        this.add(scrollbar1); */
        
        this.add(dnaSequ = new JTextArea("Enter sequence here", 15, 20));
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
}
