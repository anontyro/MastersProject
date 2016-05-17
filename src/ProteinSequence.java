import java.util.*;

/**
 * class ProteinSequence that extends Sequence
 */
public class ProteinSequence extends Sequence {

/**
 * creates a new ProteinSequence taking two string parameters
 * @param description
 * @param content 
 */    
    public ProteinSequence(String description, String content) {
        super(description, content);
    }
    
/**
 * method that contains all the valid protein characters that can be accepted
 * @return Collection of valid protein characters
 */    
    public Collection validLetters(){
        return convertString("GALMFWKSNDPVICYHRTQE");
    }
    
    protected Collection convertString(String convertString){
        ArrayList<String>validProtein = new ArrayList<>();
        //String validpro = "GALMFWKSNDPVICYHRTQE";
        for(int i=0;i< convertString.length();i++){
            validProtein.add(convertString.substring(i, i+1));
        }
        return validProtein;
    }
    
/**
 * method that accepts the protein single character code to return the three
 * letter code
 * @param aaCode
 * @return String protein three digit code
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
 * method that accepts the three digit code to return the full protein name
 * @param aaCode
 * @return String protein name
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
