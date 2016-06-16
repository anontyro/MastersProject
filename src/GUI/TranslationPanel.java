package GUI;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.*;

/**
 *
 * A class that extends JPanel and implements FocusListener set into the centre
 * of the window, where the majority of the work will be done
 */
public class TranslationPanel extends JPanel implements FocusListener{
    
    private JTextArea dnaSequ, functionOut;
    private static boolean updatedInput = false;
    private static String buffer = "";
    private static TranslationTool transTool;
    
/**
 * Constructor that creates a TranslationPanel which takes a TranslationTool
 * object as its parameter. Will create the TranslationPanel which generates two
 * boxes in the centre of the window in a GridLayout which lineWrap enabled.
 * Both will also have scrollbars that appear when needed in the vertical direction
 * only
 * @param transTool 
 */    
    public TranslationPanel(TranslationTool transTool){
        
        this.transTool = transTool;
        
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

/**
 * Getter method that will return a String of the text in the input field
 * @return Text String from the input window 
 */    
    public String getInput(){
        return dnaSequ.getText();
    }

/**
 * Getter method that will return a String of the text in the output field
 * @return Text String from the output window 
 */    
    public String getOutput(){
        return functionOut.getText();
    }
 
/**
 * Setter void method that takes a String and adds it to the strings in the
 * output window. This allows for the user to generate a lot of output in one go
 * @param output String that contains all the previous text in the output field
 * along with the new String output added.
 */    
    public void setOutput(String output){
        String funOutput = "";
        funOutput += functionOut.getText() + "\n" +output;
        funOutput = funOutput.trim();
        functionOut.setText(funOutput);
    }
    
/**
 * Setter method that takes a String and sets it to the input window. It will also
 * format the string to include no spaces
 * @param input String that replaces all previous input and adds the new input
 * string to the region
 */    
    public void setInput(String input){
        input = input.replaceAll("\\n", "");
        dnaSequ.setText(input);
    }
    
/**
 * Void method which will clear all of the output
 */    
    public void clearOutput(){
        functionOut.setText("");
    }

/**
 * FocusEven method which reacts once focusGained. This will remove the initial
 * entered sequence here from the box so the user can add content to it
 * @param e event trigger
 */    
    @Override
    public void focusGained(FocusEvent e) {
        if((dnaSequ.getText()).equals("Enter sequence here") == true){
            dnaSequ.setText("");
        }
     
    }

/**
 * FocusEven method which reacts once focusLost. This will create the initial 
 * sequence the user will see once they click off the text area.
 * @param e event trigger
 */    
    @Override
    public void focusLost(FocusEvent e) {
        if((dnaSequ.getText()).equals("") == true){
            dnaSequ.setText("Enter sequence here");
        }

    }

}

