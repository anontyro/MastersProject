import java.util.*;

public class Ribosome {
    
    private String description = "";
    private String content = "";
    private Map<String,String>translationTable = translationTable();
    
    Ribosome(){
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
    
    public Collection translateDNA(DNASequence newDNA){
        String[]output = new String[10];
        String dnaIn = newDNA.getContent();
       
        
        ArrayList<String>outputFrame = new ArrayList<>();

       
            
           
        //add Iterator to check that the sequence is found in the translationTable    
                
      //  String[]frameOne = (String[]) frame(dnaIn,0,false).toArray();
      //  String[]frameTwo = (String[]) frame(dnaIn,1,false).toArray();
      //  String[]frameThree = (String[]) frame(dnaIn,2,false).toArray();
      // System.out.println(frameOne.toString() + frameTwo.toString() + frameThree.toString());
       

    return frame(dnaIn,1,false);
    }
    
    private Collection frame(String dna, int readFrame, boolean reverse){
        ArrayList<String>frameOut = new ArrayList<>(20);
        ArrayList<String>dnaIn = new ArrayList<>(20);
        String codon = "";
        
        
        for(int i = 0; i <dna.length();i+=3){
            dnaIn.add(dna.substring(i, i+3));
        }
        Iterator<String> iterateRibo = dnaIn.iterator();
        
        
        
        for(int i = readFrame; i < dnaIn.size() ;i++){ 
            if (translationTable.containsKey(iterateRibo.next())){
                frameOut.add(whatProtein(dnaIn.get(i)));
            }
            else{
                frameOut.add("False");
            }
            
        }
        
        return frameOut;
    }
    
    private String whatProtein(String dnaIn){
       return translationTable.get(dnaIn);
    }

}


