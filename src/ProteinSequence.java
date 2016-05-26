import java.util.*;
import java.io.*;

/**
 * class ProteinSequence that extends Sequence
 */
public class ProteinSequence extends Sequence {

/**
 * creates a new ProteinSequence taking two string parameters
 * @param description Name of the protein or file in FASTA format starting with a &gt;
 * @param content The protein sequence to be accepted as an object, must only use
 * valid protein characters if not an error will occur
 */    
    public ProteinSequence(String description, String content) {
        super(description, content);
    }
/**
 * Creates a new protein object from a specific file
 * @param filename absolute filename required to build the new protein object from
 * requires full dir path if not in current directory with file extension .txt .doc etc
 * @throws IOException If a read error is encountered exception is thrown
 * @throws InvalidSequenceException if the file has an invalid character for a
 * protein it will cause this error to be thrown
 */    
    public ProteinSequence(String filename) throws IOException, InvalidSequenceException{
        super(filename);
    }
    
/**
 * method that contains all the valid protein characters that can be accepted
 * @return Collection of valid protein characters
 */    
    public Collection validLetters(){
        return convertString("GALMFWKSNDPVICYHRTQE");
    }
    

    
/**
 * static method that accepts the protein single character code to return the three
 * letter code
 * @param aaCode accepts an amino acid single character code string
 * @return threeLetterCode will be output for the single character code
 */    
    public static String getThreeLetterCode(String aaCode){
        String[]threeLetters = {"Gly", "Ala", "Leu", "Met", "Phe", "Trp", "Lys",
            "Ser", "Asn", "Asp", "Pro", "Val", "Ile", "Cys", "Tyr", "His", "Arg",
            "Thr", "Gln", "Glu"};
        String[]proCodes = {"G","A","L","M","F","W","K","S","N","D","P","V","I",
            "C","Y","H","R","T","Q","E"};
        
        Map<String,String>protienMap = new HashMap<>(20);
        for(int i = 0; i < proCodes.length;i++){
            protienMap.put(proCodes[i], threeLetters[i]);
        }
        
        return protienMap.get(aaCode);
    }
    
/**
 * static method that accepts the three digit code to return the full protein name
 * @param aaCode a string that is a valid three letter code for an amino acid
 * starting with an uppercase letter
 * @return fullProtien will output the full name of the amino acid as a string
 */    
    public static String getFullName(String aaCode){
        String[]threeLetters = {"Gly", "Ala", "Leu", "Met", "Phe", "Trp", "Lys",
            "Ser", "Asn", "Asp", "Pro", "Val", "Ile", "Cys", "Tyr", "His", "Arg",
            "Thr", "Gln", "Glu"};
        String[]fullProtien = {"Glycine", "Alanine", "Leucine", "Methionine",
            "Phenylalanine", "Tryptophan", "Lysine", "Serine", "Asparagine",
            "Aspartic acid", "Proline", "Valine", "Isoleucine", "Cystine",
            "Tyrosine", "Histidine", "Arginine", "Threonine", "Glutamine",
            "Glutamic acid"};
        
        Map<String,String>fullNameMap = new HashMap<>(20);
        for(int i = 0; i < fullProtien.length;i++){
            fullNameMap.put(threeLetters[i], fullProtien[i]);
        }
        return fullNameMap.get(getThreeLetterCode(aaCode));
    }
    
}
