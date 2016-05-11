import java.util.*;

public class Ribosome extends ProteinSequence {
    
    private String description = "";
    private String content = "";
    private Map<String,String>translationTable = translationTable();
    
    Ribosome(String description, String content){
        super(description,content);
        this.description = description;
        this.content = content;
    }
    
    public Collection validLetters(){
        
        return convertString("GALMFWKSNDPVICYHRTQE");
    }
    
    
    public static Map translationTable(){
        Map<String, String>translationTable = new HashMap<>(60);
        
        String[]codons = {"TTT", "TTC", "TTA", "TTG", "CTT", "CTC", "CTA", "CTG",
            "ATT", "ATC", "ATA", "ATG", "GTT", "GTC", "GTA", "GTG", "TCT", "TCC",
            "TCA", "TCG", "CCT", "CCC", "CCA", "CCG", "ACT", "ACC", "ACA", "ACG",
            "GCT", "GCC", "GCA", "GCG", "TAT", "TAC", "TAA", "TAG", "CAT", "CAC",
            "CAA", "CAG", "AAT", "AAC", "AAA", "AAG", "GAT", "GAC", "GAA", "GAG",
            "TGT", "TGC", "TGA", "TGG", "CGT", "CGC", "CGA", "CGG", "AGT", "AGC",
            "AGA", "AGG", "GGT", "GGC", "GGA", "GGG" };
        
        String[]protienRef = {"F","F","L","L","L","L","L","L","I","I","I","M","V"
                ,"V","V","V","S","S","S","S","P","P","P","P","T","T","T","T","A"
                ,"A","A","A","Y","Y","*","*","H","H","Q","Q","N","N","K","K","D"
                ,"D","E","E","C","C","*","W","R","R","R","R","S","S","R","R","G"
                ,"G","G","G"};
        
        for(int i = 0; i < codons.length;i++){
            translationTable.put(codons[i],protienRef[i]);
        }
        return translationTable;
     
    }
    
    public String[] translateDNA(DNASequence newDNA){
        String[]output = new String[10];
        String dnaIn = newDNA.toString();
       
        
        ArrayList<String>outputFrame = new ArrayList<>();

        for(int x = 0; x<dnaIn.length();x = x+3){
            dnaIn.substring(x, x+2);
           
        //add Iterator to check that the sequence is found in the translationTable    
                
        }
        
       

        return output;
    }

}


