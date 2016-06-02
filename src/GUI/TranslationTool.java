package GUI;

import DNAprogram.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 *
 * @author Alex
 */
public class TranslationTool extends QuitableJFrame implements ActionListener{
    
    TranslationTool(){
        super("Translation", 500, 500);
        
        this.setLocationRelativeTo(null);
        
        //sets the layout for the frame overall this is currently to BorderLayout
        this.getContentPane().setLayout(new BorderLayout());
        
        //constructs the InformationPanel object for use
        InformationPanel infoPanel = new InformationPanel();
        // creates the middle panel for input and output
        TranslationPanel inOutPanel = new TranslationPanel();
        //creates the bottom button panel
        ControlPanel buttonPanel = new ControlPanel();
        
        this.getContentPane().add(infoPanel, BorderLayout.NORTH);
        this.getContentPane().add(inOutPanel, BorderLayout.CENTER);
        this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        
        this.pack();
        
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public static void main(String[] args){
        TranslationTool theFrame = new TranslationTool();

    }
    
}
