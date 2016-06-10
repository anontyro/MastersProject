package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import DNAprogram.*;
import java.util.*;

/**
 *
 * @author Alex
 */
public class Translator implements ActionListener{
    
    private InformationPanel infoPanel;
    private TranslationPanel translatePan;
    private TranslationTool transTool;
    private String sequDesc = "";
    private String sequBody = "";
    private DNASequence seq;
    private OpenReadingFrame orfSeq;
    
    public Translator(TranslationTool transTool, InformationPanel infoPanel,
            TranslationPanel translatePan){
        
        this.infoPanel = infoPanel;
        this.transTool = transTool;
        this.translatePan = translatePan;
        
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        
        try{
            //Get the title of the sequence from infoPanel
            sequDesc = infoPanel.getSequenceDescription();
            
            //Get the input sequence from the translationPanel
            sequBody = translatePan.getInput();
            
            
            //returns a string from the button pressed
            String command = event.getActionCommand();
            infoPanel.setStatusMessage("Currently: " +command);
            
            
            //control structure to dictate what each button does
            if(command.equals("Reverse Comp")){
                seq = new DNASequence(sequDesc,sequBody);
                seq = seq.revComp();
                if(seq.validateSeq("ATGC",sequBody) == false 
                        || sequBody.equals("")){
                    transTool.tellUser("Sequence can only contain ATGC");
                }
                else{

                    translatePan.setOutput("Reverse Compliment of: " 
                            + seq.getDescription() 
                            + "\n" +seq.getContent());            
                }
            }
            else if(command.equals("Simple Translation")){
                seq = new DNASequence(sequDesc,sequBody);
                if(seq.validateSeq("ATGC",sequBody) == false 
                        || sequBody.equals("")){
                    transTool.tellUser("Sequence can only contain ATGC");
                }
                else{
                    String output ="";
                    String[]sequence = Ribosome.oneFrameTranslate(seq, 0);
                    for(String x:sequence){
                        output +=x;
                    }               
                    translatePan.setOutput("A one frame translation of: " 
                            + seq.getDescription() 
                            +"\n" + output);
                }
            }
            else if(command.equals("Six frame translation")){
                seq = new DNASequence(sequDesc,sequBody);
                if(seq.validateSeq("ATGC",sequBody)==false 
                        || sequBody.equals("")){
                    transTool.tellUser("Sequence can only contain ATGC");
                }
                else{
                    String output ="";
                    String[]sequence = Ribosome.translateDNA(seq);
                    for(String x:sequence){
                        output +=x;
                    }
                    translatePan.setOutput("Six frame translation for: " 
                            + seq.getDescription()
                            + "\n" + output);
                }
            }
            else if(command.equals("Get ORF")){
                orfSeq = new OpenReadingFrame(sequDesc,sequBody);
                if(orfSeq.validateSeq("GALMFWKSNDPVICYHRTQE*",sequBody)==false 
                        || sequBody.equals("")){
                    transTool.tellUser("Sequence must be a valid protien"
                            + "sequence containing: \n"
                            + "GALMFWKSNDPVICYHRTQE*");
                }
                else{
                    //"^(?=.*[M])(?=.*[\\*]).+$"
                    if(sequBody.matches("^(?i)(?=.*[M])(?=.*[\\*]).+$") == false){
                        transTool.tellUser("ORF must have at least one M and *");
                    }
                    else{
                    String output = "";
                    ArrayList<String>sequence;                    
                    sequence = (ArrayList<String>) OpenReadingFrame.getORFs(orfSeq);
                    for(String x:sequence){
                        output+= x + "\n";
                    }
                    translatePan.setOutput("Open reading frames for: "
                            + orfSeq.getDescription()
                            + "\n"+ output);  
                    }
                
                }
            }
            else{
                sequBody ="";
                sequDesc = "";
                translatePan.clearOutput();
                
            }
   
        }
        catch(Exception ex){
           transTool.tellUser(ex.getMessage());
        }
                
    }    
}
