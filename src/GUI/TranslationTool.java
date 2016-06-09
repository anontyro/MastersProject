package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import DNAprogram.*;
import java.io.*;


/**
 *
 * @author Alex
 */
public class TranslationTool extends QuitableJFrame implements ActionListener{
    
     //constructs the InformationPanel object for use
    private InformationPanel infoPanel = new InformationPanel();
        // creates the middle panel for input and output
    private TranslationPanel inOutPanel = new TranslationPanel();
    
    TranslationTool(){
        super("Translation", 500, 500);
        
        this.setLocationRelativeTo(null);
        
        //sets the layout for the frame overall this is currently to BorderLayout
        this.getContentPane().setLayout(new BorderLayout());
        
        //create menubar
        this.setUpMenubar();
        
        Translator trans = new Translator(this,infoPanel,inOutPanel);
        
        //creates the bottom button panel
        ControlPanel buttonPanel = new ControlPanel(trans);
 
        
        this.getContentPane().add(infoPanel, BorderLayout.NORTH);
        this.getContentPane().add(inOutPanel, BorderLayout.CENTER);
        this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        
        this.pack();
        
        this.setVisible(true);

    }
    
    private void setUpMenubar(){
        //new menubar
        JMenuBar theBar = new JMenuBar();
        //create a new menu under "File"
        JMenu fileMenu = new JMenu("File");
        //content of "file" menu
        JMenuItem newItem = new JMenuItem("New");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save output");
        JMenuItem saveasItem = new JMenuItem("Save output as");
        JMenuItem saveInItem = new JMenuItem("Save input");
        JMenuItem saveasInItem = new JMenuItem("Save input as");
        JMenuItem quitItem = new JMenuItem("Quit");
        
        //create new menu under "Edit"
        JMenu editMenu = new JMenu("Edit");
        //content of "edit menu
        JMenuItem copyItem = new JMenuItem("Copy to clipboard");
        
        //build filemenu
        fileMenu.add(newItem);
        newItem.addActionListener(this);
       
        fileMenu.add(openItem);
        openItem.addActionListener(this);
       
        fileMenu.add(saveItem);
        saveItem.addActionListener(this);
       
        fileMenu.add(saveasItem);
        saveasItem.addActionListener(this);
        
        fileMenu.add(saveInItem);
        saveInItem.addActionListener(this);
        
        fileMenu.add(saveasInItem);
        saveasInItem.addActionListener(this);
        
        fileMenu.add(quitItem);
        quitItem.addActionListener(this);
        
        theBar.add(fileMenu);
        
        //build edit menu
        editMenu.add(copyItem);
        editMenu.addActionListener(this);
       
        theBar.add(editMenu);
        
        this.setJMenuBar(theBar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        JFileChooser fc = new JFileChooser();
 
        
        if(command.equals("New")){
            inOutPanel.clearOutput();
            inOutPanel.setInput("");
            infoPanel.setSequenceDescription("");
            infoPanel.setStatusMessage("All data cleared");
        }
        else if(command.equals("Open")){
;
            fc.setDialogTitle("Import");
            if(fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
                
            }
            if(fc.getSelectedFile().canRead()){
                if(fc.getSelectedFile().canWrite()){
                    try{                       
                        String content = (String)Sequence.getContent(fc.getSelectedFile().getAbsolutePath());
                        inOutPanel.setInput(content);
                        
                        String descrip = (String)Sequence.getDescription(fc.getSelectedFile().getAbsolutePath());
                        infoPanel.setSequenceDescription(descrip);
                                                
                    }
                    catch(IOException ioE){
                        this.tellUser(ioE.getMessage());
                    }
                }               
            }
            else{
                this.tellUser("Error file cannot be read to or written to!");
            }
            infoPanel.setStatusMessage(fc.getSelectedFile() + ".txt" +" file loaded");
            
        }
        else if(command.equals("Save output")){
            String name = infoPanel.getSequenceDescription();
            name = name.trim();
            name = name.replaceAll("\\s", "_");
            File f = new File(name +".txt");
            if(f.exists() == true){
                saveOrCancel(name);
            }
            else{
                toFile(name+".txt");
            }
        }
        else if(command.equals("Save output as")){
            fc.setDialogTitle("Save output as");
            if(fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION){
                
            }
            toFile(fc.getSelectedFile()+".txt");
        }
        else if(command.equals("Save input")){
                    
                
        }
        else if(command.equals("Save input as")){
            
        }
        else{
            this.quitOrCancel();
        }
        
        
    }
    
    public void toFile(String filename){
        
            PrintWriter out = null;
            try{
                String content = inOutPanel.getOutput();
                String descrip = infoPanel.getSequenceDescription();
                
                File outFile = new File(filename);
                
                FileWriter fout = new FileWriter(outFile);
                BufferedWriter bout = new BufferedWriter(fout);
                out = new PrintWriter(bout);
                
                out.println(descrip);
                out.println(content);
                out.close();
                
                this.tellUser("Saved " +descrip + " to " +filename);
                infoPanel.setStatusMessage("File saved as " +filename);
                
            }
            catch(IOException ioException){
                this.tellUser(ioException.getMessage());
            }
            finally{
                if(out !=null){out.close();}
            }
        
    }
    
        public void saveOrCancel(String name){
        name = name +".txt ";
        int result = JOptionPane.showConfirmDialog(this, "File " +name +
                "already exists save?", "File overwritten",
                JOptionPane.YES_NO_OPTION);
        
        if(result == JOptionPane.YES_OPTION){
            toFile(name);
        }
        
    }
    
    
    public static void main(String[] args){
        TranslationTool theFrame = new TranslationTool();

    }
    
}
