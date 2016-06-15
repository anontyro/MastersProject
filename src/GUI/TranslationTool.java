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
    private TranslationPanel inOutPanel = new TranslationPanel(this);
    
    TranslationTool(){
        super("Translation", 1000, 800);
        
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
        
        //create a new save menu
        JMenu saveMenu = new JMenu("Save...");
        
        //create new menu under "Edit"
        JMenu editMenu = new JMenu("Edit");
        
        //content of "edit menu
        JMenuItem copyItem = new JMenuItem("Copy output to clipboard");
        JMenuItem outTOinItem = new JMenuItem("Copy output to input");
        
        //build filemenu
        fileMenu.add(newItem);
        newItem.addActionListener(menu);
       
        fileMenu.add(openItem);
        openItem.addActionListener(menu);
        
        //adds the save submenu using separators to make it clear it is appart
        fileMenu.addSeparator();
        fileMenu.add(saveMenu);
        fileMenu.addSeparator();
       
        //start of save menu items
        saveMenu.add(saveItem);
        saveItem.addActionListener(menu);
       
        saveMenu.add(saveasItem);
        saveasItem.addActionListener(menu);
        
        saveMenu.add(saveInItem);
        saveInItem.addActionListener(menu);
        
        saveMenu.add(saveasInItem);
        saveasInItem.addActionListener(menu);
        
        //end of save menu items
        
        fileMenu.add(quitItem);
        quitItem.addActionListener(menu);
        
        
        theBar.add(fileMenu);
        
        //build edit menu
        editMenu.add(copyItem);
        copyItem.addActionListener(menu);
       
        editMenu.add(outTOinItem);
        outTOinItem.addActionListener(menu);
        
        theBar.add(editMenu);
        
        //setup the menu
        this.setJMenuBar(theBar);
    }
       
    public static void main(String[] args){
        TranslationTool theFrame = new TranslationTool();

    }
    
}