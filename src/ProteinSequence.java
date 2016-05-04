import java.util.*;

public class ProteinSequence extends Sequence {

    public ProteinSequence(String description, String content) {
        super(description, content);
    }
    
    public Collection validLetters(){
        return convertString();
    }
    
    private Collection convertString(){
        ArrayList<String>validProtein = new ArrayList<>();
        String validpro = "GALMFWKSNDPVICYHRTQE";
        for(int i=0;i< validpro.length();i++){
            validProtein.add(validpro.substring(i, i+1));
        }
        return validProtein;
    }
    
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
