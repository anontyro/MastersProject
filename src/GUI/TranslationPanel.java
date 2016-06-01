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
        
        this.setLayout(new FlowLayout());
        
        this.add(dnaSequ = new JTextArea("Input"));
        this.add(functionOut = new JTextArea("output"));

        dnaSequ.setAutoscrolls(true);
    
}
}
