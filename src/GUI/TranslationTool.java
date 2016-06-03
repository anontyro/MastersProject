package GUI;

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
        
        //create menubar
        this.setUpMenubar();
        
        //constructs the InformationPanel object for use
        InformationPanel infoPanel = new InformationPanel();
        // creates the middle panel for input and output
        TranslationPanel inOutPanel = new TranslationPanel();

        
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
        JMenuItem openItem = new JMenuItem("Open file");
        JMenuItem saveItem = new JMenuItem("Save file");
        JMenuItem saveasItem = new JMenuItem("Save as");
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
        
       this.quitOrCancel();
    }
    
    
    public static void main(String[] args){
        TranslationTool theFrame = new TranslationTool();

    }
    
}
