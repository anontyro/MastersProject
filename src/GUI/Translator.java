package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Alex
 */
public class Translator implements ActionListener{
    
    private ControlPanel controls;
    private InformationPanel infoPanel;
    private TranslationPanel translatePan;
    private String sequDesc = "";
    private String sequBody = "";
    
    public Translator(ControlPanel controls, InformationPanel infoPanel,
            TranslationPanel translationPan){
        
        this.controls = controls;
        this.infoPanel = infoPanel;
        this.translatePan = translatePan;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        try{
            sequDesc = infoPanel.getSequenceDescription();
            sequBody = translatePan.getInput();
            
        }
        catch(Exception ex){
            System.err.println(ex);
        }
        
    }
    
}
