
package GUI;

import DNAprogram.*;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.datatransfer.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alex
 */
public class MenuBar implements ActionListener{
    
    private InformationPanel infoPanel;
    private TranslationPanel inOutPanel;
    private TranslationTool transTool;
    private String output = "";
    private String userDir = System.getProperty("user.dir") +
            System.getProperty("file.separator");
    private static JFileChooser fc = new JFileChooser();
    private static String saveInput = null;
    private static String saveOutput = null;

    public MenuBar(TranslationTool transTool, InformationPanel infoPanel,
            TranslationPanel translatePan){
        
        this.infoPanel = infoPanel;
        this.transTool = transTool;
        this.inOutPanel = translatePan;
        File fd = new File(System.getProperty("user.dir"));
        fc.setCurrentDirectory(fd);   
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        String descrip = infoPanel.getSequenceDescription();
        
        if(command.equals("New")){
            inOutPanel.clearOutput();
            inOutPanel.setInput("");
            infoPanel.setSequenceDescription("");
            infoPanel.setStatusMessage("All data cleared");
            saveInput = null;
            saveOutput = null;
            
        }
        else if(command.equals("Open")){
            inOutPanel.clearOutput();
            inOutPanel.setInput("");
            infoPanel.setSequenceDescription("");
            saveOutput = null;
            fc.setDialogTitle("Import");
            if(fc.showOpenDialog(transTool) == JFileChooser.APPROVE_OPTION){

                if(fc.getSelectedFile().canRead()){
                    if(fc.getSelectedFile().canWrite()){
                        try{
                            String content = (String)Sequence.getContent(fc.getSelectedFile().getAbsolutePath());
                            inOutPanel.setInput(content);

                            String description = (String)Sequence.getDescription(fc.getSelectedFile().getAbsolutePath());
                            infoPanel.setSequenceDescription(description);
                            saveInput = fc.getSelectedFile().toString();
                            
                            infoPanel.setStatusMessage(fc.getSelectedFile()+" file loaded");

                            transTool.setTitle("Translation " + fc.getSelectedFile().toString());
                            

                        }
                        catch(IOException ioE){
                            transTool.tellUser(ioE.getMessage());
                        }
                    }
                    else{
                    transTool.tellUser("Error file cannot be written to!");
                    }
                }
                else{
                    transTool.tellUser("Error file cannot be read from!");
                }
            }
            else{                
            }
        }
        else if(command.equals("Save output")){
            if (saveOutput !=null){
                String content = inOutPanel.getOutput();
                Sequence.toFile(saveOutput,"output",descrip,content);
                infoPanel.setStatusMessage("File saved as " + saveOutput);
                }
            else{
                fc.setDialogTitle("Save output as");
                
                if(fc.showSaveDialog(transTool)== JFileChooser.APPROVE_OPTION){
                    Sequence.toFile((fc.getSelectedFile().toString()+".txt"),"output",
                            descrip,inOutPanel.getOutput());
                    saveOutput = fc.getSelectedFile().toString();
                    infoPanel.setStatusMessage("File saved as " +saveOutput);
                }
            }
        }
        else if(command.equals("Save output as")){
            fc.setDialogTitle("Save output as");
            
            if(fc.showSaveDialog(transTool) == JFileChooser.APPROVE_OPTION){
                Sequence.toFile((fc.getSelectedFile().toString()+".txt"),"output", 
                        descrip, inOutPanel.getOutput());
                saveOutput = fc.getSelectedFile().toString();
                infoPanel.setStatusMessage("File saved as " +saveOutput);
            }    
        }
        else if(command.equals("Save input")){
            
            if (saveInput !=null){
                Sequence.toFile(saveInput,"input", descrip, inOutPanel.getInput());
                infoPanel.setStatusMessage("Saved input as: " +saveInput+".txt");

                }
            else{
                fc.setDialogTitle("Save input as");
                
                if(fc.showSaveDialog(transTool)== JFileChooser.APPROVE_OPTION){
                    Sequence.toFile((fc.getSelectedFile().toString() + ".txt"),"input",
                            descrip, inOutPanel.getInput());
                    saveInput = fc.getSelectedFile().toString();
                    infoPanel.setStatusMessage("File saved as " +saveInput);

                }
            }    
        }
        else if(command.equals("Save input as")){
            fc.setDialogTitle("Save input as");
            if(fc.showSaveDialog(transTool) == JFileChooser.APPROVE_OPTION){
                Sequence.toFile((fc.getSelectedFile().toString()+".txt"),"input",
                        descrip, inOutPanel.getInput());
                saveInput = fc.getSelectedFile().toString();
                infoPanel.setStatusMessage("File saved as " +saveInput);

            }
        }
        else if(command.equals("Copy output to clipboard")){
            String output =  inOutPanel.getOutput();
            StringSelection stringSelection = new StringSelection(output);
            Clipboard clipB = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipB.setContents(stringSelection, null);
        }
        else if(command.equals("Copy output to input")){
            String result = "";
            String outputMove = inOutPanel.getOutput();
            if(!outputMove.equals("")){
                outputMove = outputMove.substring(outputMove.lastIndexOf("\n"));
                outputMove = outputMove.replaceAll("([^GALMFWKSNDPVICYHRTQE*])?", "");
            }
            StringSelection stringSelection = new StringSelection(outputMove);
            Clipboard clipB = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipB.setContents(stringSelection, null);
            
            Transferable contents = clipB.getContents(null);
            try {
                result = (String)contents.getTransferData(DataFlavor.stringFlavor);
            } 
            catch (UnsupportedFlavorException | IOException ex) {
                infoPanel.setStatusMessage(ex.getMessage());
            }
            finally{
                inOutPanel.setInput(result);
            }
            
        }
        else{
            transTool.quitOrCancel();
        }
    }


   
}
