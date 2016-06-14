
package GUI;

import DNAprogram.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

/**
 *
 * @author Alex
 */
public class MenuBar implements ActionListener, MenuListener{
    
    private InformationPanel infoPanel;
    private TranslationPanel inOutPanel;
    private TranslationTool transTool;
    private String sequDesc = "";
    private String sequBody = "";
    private String output = "";
    private DNASequence seq;
    private OpenReadingFrame orfSeq;
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
            sequBody="";
            sequDesc="";
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
        else{
            transTool.quitOrCancel();
        }
    }
    
    /*
    public void toFile(String filename, String inORout){
        String content ="";
        String descrip = infoPanel.getSequenceDescription();
        
            PrintWriter out = null;
            try{
                if(inORout.equals("output")){
                    content = inOutPanel.getOutput();

                }
                else if(inORout.equals("input")){
                   content = inOutPanel.getInput();
                }
                else{
                    transTool.tellUser("Error could not find correct inORout command");
                }
                File outFile = new File(filename);
                
                FileWriter fout = new FileWriter(outFile);
                BufferedWriter bout = new BufferedWriter(fout);
                out = new PrintWriter(bout);
                
                out.println(descrip);
                out.println(content);
                out.close();
                
                transTool.tellUser("Saved " +descrip + " to " +filename);
                infoPanel.setStatusMessage("File saved as " +filename);
                
            }
            catch(IOException ioException){
                transTool.tellUser(ioException.getMessage());
            }
            finally{
                if(out !=null){out.close();}
            }
    }
    
        public void saveOrCancel(String name, String inORout, String descrip,
                String content){
        int result = JOptionPane.showConfirmDialog(transTool, "File " +name +
                ".txt already exists save?", "File overwritten",
                JOptionPane.YES_NO_OPTION);
        
        if(result == JOptionPane.YES_OPTION){
            Sequence.toFile(name,inORout,descrip,content);
        }   
    }
        */

    @Override
    public void menuSelected(MenuEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void menuDeselected(MenuEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void menuCanceled(MenuEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
