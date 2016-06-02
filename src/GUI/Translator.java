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
    private String output = "";
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
                if(validateSeq("ATGC") == false){
                    transTool.tellUser("Sequence can only contain ATGC");
                }
                else{
                    seq = new DNASequence(sequDesc,sequBody);
                    seq = seq.revComp();
                    translatePan.setOutput(seq.getContent());            
                }
            }
            else if(command.equals("Simple Translation")){
                if(validateSeq("ATGC") == false){
                    transTool.tellUser("Sequence can only contain ATGC");
                }
                else{
                    seq = new DNASequence(sequDesc,sequBody);
                    String[]sequence = Ribosome.oneFrameTranslate(seq, 0);
                    for(String x:sequence){
                        output +=x;
                    }               
                    translatePan.setOutput(output);
                }
            }
            else if(command.equals("Six frame translation")){
                if(validateSeq("ATGC")==false){
                    transTool.tellUser("Sequence can only contain ATGC");
                }
                else{
                    seq = new DNASequence(sequDesc,sequBody);
                    String[]sequence = Ribosome.translateDNA(seq);
                    for(String x:sequence){
                        output +=x;
                    }
                    translatePan.setOutput(output);
                }
            }
            else if(command.equals("Get ORF")){
                if(validateSeq("GALMFWKSNDPVICYHRTQE*")==false){
                    transTool.tellUser("Sequence must be a valid protien"
                            + "sequence containing: \n"
                            + "GALMFWKSNDPVICYHRTQE*");
                }
                else{
                    ArrayList<String>sequence;
                    orfSeq = new OpenReadingFrame(sequDesc,sequBody);
                    sequence = (ArrayList<String>) OpenReadingFrame.getORFs(orfSeq);
                    for(String x:sequence){
                        output+= x + "\n";
                    }
                        translatePan.setOutput(output);               
                }
            }
            else{
                sequBody ="";
                sequDesc = "";
                output = "";
                translatePan.clearOutput();
                
            }
   
        }
        catch(Exception ex){
           transTool.tellUser(ex.getMessage());
        }
        
        

        
    }
    private boolean validateSeq(String valid){
        sequBody = sequBody.toUpperCase();
        ArrayList<String>validLetters;
        validLetters =(ArrayList<String>) convertString(valid);
        ArrayList<String>contentList = new ArrayList<>();
        
        for(int i = 0; i < sequBody.length();i++){
            contentList.add(sequBody.substring(i,i+1));
        }
        
        Iterator<String> iterateValid = contentList.iterator();
        
        for(int i = 0; i< contentList.size();i++){
            if(!validLetters.contains(iterateValid.next())){
                return false;
            }
        }
        return true;
    }
    
    private Collection convertString(String convertString){
            ArrayList<String>validLetters = new ArrayList<>();
            
            for(int i=0; i< convertString.length();i++){
                validLetters.add(convertString.substring(i,i+1));
            }
            return validLetters;
        }
    
}
