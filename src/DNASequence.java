import java.io.*;
import java.util.*;

/**
 * class DNASequence that extends Sequence to create DNASequence objects
 */
public class DNASequence extends Sequence {
    
    private String content =  "";
    private String description = "";

/**
 * create a DNASequence taking two String parm
 * @param description requires input in FASTA format starting with &gt; 
 * @param content the DNA sequence for the object which should only contain valid
 * letters and no spaces, will be converted to upper case if required
 */    
    public DNASequence(String description,String content){
        super(description,content);
        this.content = content.toUpperCase();
        this.description = description;
    }
    
    /**
     * Creates a new DNASequence object from a file pulling the description
     * and content
     * @param filename requires the absolute filename of given file and if required its
     * full dir listing, will end in a valid extension .txt .doc etc
     * @throws IOException thrown if file read error
     * @throws InvalidSequenceException will be thrown if the content of the file
     * contains illegal characters not represented in a DNA sequence
     */
    public DNASequence(String filename) throws IOException, InvalidSequenceException{
        super(filename);
    }
    
/**
 * method that holds a collection of validLetters to be checked against
 * @return Collection validLetters 
 */    
    public Collection validLetters(){        
        return convertString("ATGC");  
    }
    
/**
 * method to reverse and create a DNA compliment for the second side of the
 * double helix
 * @return  DNASequence
 */    
    public DNASequence revComp(){
        
        char[]reverse = content.toCharArray();
        String reverseContent="";
        for(int i = reverse.length-1;i>=0;i--){
            if(reverse[i]=='A'){
                reverse[i]='T';
            }
            else if(reverse[i]=='G'){
                reverse[i]='C';
            }
            else if(reverse[i]=='T'){
                reverse[i]='A';
            }
            else{
                reverse[i]='G';
            }
            reverseContent+=reverse[i];
        }
        
        DNASequence seq = new DNASequence(description,reverseContent);
        return seq;
    }
 
/**
 * static method that can make a new DNASequence object from the file, which
 * must be formatted in FASTA format starting with a &gt; when
 * stating file if not in current dir must state the full path
 * @param filename in a string format ending in the suffix .txt .doc etc
 * @return a new DNASequence object made from the FASTA
 * @throws IOException thrown when the file reading is interrupted for any reason
 */    
    public static DNASequence makeSequence(String filename) throws IOException{
        DNASequence dnaSequ;
        dnaSequ = new DNASequence(getDescription(filename),getContent(filename));
        return dnaSequ;
    }

    
}
