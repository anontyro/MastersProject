
package GUI;

import DNAprogram.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

/**
 *
 * @author Alex
 */
public class MenuBar implements ActionListener{
    
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
    private static String opened;


    
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
        
        if(command.equals("New")){
            sequBody="";
            sequDesc="";
            inOutPanel.clearOutput();
            inOutPanel.setInput("");
            infoPanel.setSequenceDescription("");
            infoPanel.setStatusMessage("All data cleared");
            opened = null;
        }
        else if(command.equals("Open")){
            inOutPanel.clearOutput();
            inOutPanel.setInput("");
            infoPanel.setSequenceDescription("");
;
            fc.setDialogTitle("Import");
            if(fc.showOpenDialog(transTool) == JFileChooser.APPROVE_OPTION){

                if(fc.getSelectedFile().canRead()){
                    if(fc.getSelectedFile().canWrite()){
                        try{
                            String content = (String)Sequence.getContent(fc.getSelectedFile().getAbsolutePath());
                            inOutPanel.setInput(content);

                            String descrip = (String)Sequence.getDescription(fc.getSelectedFile().getAbsolutePath());
                            infoPanel.setSequenceDescription(descrip);
                            opened = fc.getSelectedFile().toString();
                            System.out.println(opened);
                            
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
                    transTool.tellUser("Error file cannot be read to!");
                }
            }
            else{                
            }
    
        }
        else if(command.equals("Save output")){
            if (opened !=null){
                toFile(opened,"output");
                infoPanel.setStatusMessage("Saved");
                }
            else{
                fc.setDialogTitle("Save output as");
                
                if(fc.showSaveDialog(transTool)== JFileChooser.APPROVE_OPTION){
                    toFile(fc.getSelectedFile().toString(),"output");
                    opened = fc.getSelectedFile().toString();
                }
            }
        }
        else if(command.equals("Save output as")){
            fc.setDialogTitle("Save output as");
            
            if(fc.showSaveDialog(transTool) == JFileChooser.APPROVE_OPTION){
                toFile(fc.getSelectedFile().toString()+".txt","output");
            }
            
        }
        else if(command.equals("Save input")){
            
            if (opened !=null){
                toFile(opened,"input");
                infoPanel.setStatusMessage("Saved");
                }
            else{
                fc.setDialogTitle("Save input as");
                
                if(fc.showSaveDialog(transTool)== JFileChooser.APPROVE_OPTION){
                    toFile(fc.getSelectedFile().toString(),"input");
                    opened = fc.getSelectedFile().toString();
                }
            }
            
            /*
            String name = infoPanel.getSequenceDescription();
            name = name.trim();
            name = name.replaceAll("\\s", "_");
            name = name.replaceAll(">", "");
            name = userDir+ name +"-input";
            File f = new File(name+".txt");
            if(f.exists() == true){
                saveOrCancel(name,"input");
            }
            else{
                toFile(name,"input");
            }
                    */
            
        }
        else if(command.equals("Save input as")){
            fc.setDialogTitle("Save input as");
            if(fc.showSaveDialog(transTool) == JFileChooser.APPROVE_OPTION){
                toFile(fc.getSelectedFile().toString()+".txt","input");
            }
        }
        else{
            transTool.quitOrCancel();
        }
    
    }
    
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
    
        public void saveOrCancel(String name, String inORout){
        int result = JOptionPane.showConfirmDialog(transTool, "File " +name +
                ".txt already exists save?", "File overwritten",
                JOptionPane.YES_NO_OPTION);
        
        if(result == JOptionPane.YES_OPTION){
            toFile(name,inORout);
        }
        
    }
        
        
    
}
