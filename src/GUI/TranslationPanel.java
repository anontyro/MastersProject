package GUI;

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
        
        this.add(dnaSequ = new JTextArea("Input", 15, 20));
        dnaSequ.setLineWrap(true);
        dnaSequ.setColumns(10);
        dnaSequ.setAutoscrolls(true);
        
        this.add(functionOut = new JTextArea("output", 15, 20));


    
    }
    
    public String getInput(){
        return dnaSequ.toString();
    }
    
    public void setOutput(String output){
        functionOut.setText(output);
    }
}
