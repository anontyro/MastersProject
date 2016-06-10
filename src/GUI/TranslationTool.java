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
public class TranslationTool extends QuitableJFrame{
    
     //constructs the InformationPanel object for use
    private InformationPanel infoPanel = new InformationPanel();
        // creates the middle panel for input and output
    private TranslationPanel inOutPanel = new TranslationPanel();
    
    TranslationTool(){
        super("Translation", 500, 500);
        
        this.setLocationRelativeTo(null);
        
        //sets the layout for the frame overall this is currently to BorderLayout
        this.getContentPane().setLayout(new BorderLayout());
        
        
        Translator trans = new Translator(this,infoPanel,inOutPanel);
        MenuBar menu = new MenuBar(this,infoPanel,inOutPanel);
        

        
        //creates menubar
        this.setUpMenubar(menu);
        
        //creates the bottom button panel
        ControlPanel buttonPanel = new ControlPanel(trans);
 
        
        this.getContentPane().add(infoPanel, BorderLayout.NORTH);
        this.getContentPane().add(inOutPanel, BorderLayout.CENTER);
        this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        
        this.pack();
        
        this.setVisible(true);

    }
    
    private void setUpMenubar(MenuBar menu){

        //new menubar
        JMenuBar theBar = new JMenuBar();
        //create a new menu under "File"
        JMenu fileMenu = new JMenu("File");
        //content of "file" menu
        JMenuItem newItem = new JMenuItem("New", new ImageIcon("src\\GUI\\images\\new.png"));
        JMenuItem openItem = new JMenuItem("Open", new ImageIcon("src\\GUI\\images\\open.png"));
        JMenuItem saveItem = new JMenuItem("Save output", new ImageIcon("src\\GUI\\images\\save.png"));
        JMenuItem saveasItem = new JMenuItem("Save output as", new ImageIcon("src\\GUI\\images\\save.png"));
        JMenuItem saveInItem = new JMenuItem("Save input", new ImageIcon("src\\GUI\\images\\save.png"));
        JMenuItem saveasInItem = new JMenuItem("Save input as", new ImageIcon("src\\GUI\\images\\save.png"));
        JMenuItem quitItem = new JMenuItem("Quit", new ImageIcon("src\\GUI\\images\\exit.png"));
        
        //create new menu under "Edit"
        JMenu editMenu = new JMenu("Edit");
        //content of "edit menu
        JMenuItem copyItem = new JMenuItem("Copy output to clipboard");
        
        //build filemenu
        fileMenu.add(newItem);
        newItem.addActionListener(menu);
       
        fileMenu.add(openItem);
        openItem.addActionListener(menu);
       
        fileMenu.add(saveItem);
        saveItem.addActionListener(menu);
       
        fileMenu.add(saveasItem);
        saveasItem.addActionListener(menu);
        
        fileMenu.add(saveInItem);
        saveInItem.addActionListener(menu);
        
        fileMenu.add(saveasInItem);
        saveasInItem.addActionListener(menu);
        
        fileMenu.add(quitItem);
        quitItem.addActionListener(menu);
        
        theBar.add(fileMenu);
        
        //build edit menu
        editMenu.add(copyItem);
        editMenu.addActionListener(menu);
       
        theBar.add(editMenu);
        
        this.setJMenuBar(theBar);
    }
    

/*    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        JFileChooser fc = new JFileChooser();
        File fd = new File(System.getProperty("user.dir"));
        fc.setCurrentDirectory(fd);
        String userDir = System.getProperty("user.dir") +"\\";
       
        if(command.equals("New")){
            inOutPanel.clearOutput();
            inOutPanel.setInput("");
            infoPanel.setSequenceDescription("");
            infoPanel.setStatusMessage("All data cleared");
        }
        else if(command.equals("Open")){
            inOutPanel.clearOutput();
            inOutPanel.setInput("");
            infoPanel.setSequenceDescription("");
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
            name = name.replaceAll(">", "");
            name = userDir+ name +"-output";
            File f = new File(name+".txt");
            if(f.exists() == true){
                saveOrCancel(name,"output");
            }
            else{
                toFile(name,"output");
            }
        }
        else if(command.equals("Save output as")){
            fc.setDialogTitle("Save output as");
            
            if(fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION){
                toFile(fc.getSelectedFile().toString(),"output");
            }
            
        }
        else if(command.equals("Save input")){
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
            
        }
        else if(command.equals("Save input as")){
            fc.setDialogTitle("Save input as");
            if(fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION){
                toFile(fc.getSelectedFile().toString(),"input");
            }
        }
        else{
            this.quitOrCancel();
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
                    this.tellUser("Error could not find correct inORout command");
                }
                File outFile = new File(filename +".txt");
                
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
    
        public void saveOrCancel(String name, String inORout){
        int result = JOptionPane.showConfirmDialog(this, "File " +name +
                ".txt already exists save?", "File overwritten",
                JOptionPane.YES_NO_OPTION);
        
        if(result == JOptionPane.YES_OPTION){
            toFile(name,inORout);
        }
        
    }*/
    
    
    public static void main(String[] args){
        TranslationTool theFrame = new TranslationTool();

    }
    
}
