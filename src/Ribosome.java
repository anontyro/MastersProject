import java.util.*;
/**
 * simple class for Ribosome
 */
public class Ribosome{
    
    private final Map<String,String>translationTable = translationTable();
    
/**
 * create a Ribosome object, takes no parameters
 */    
    Ribosome(){      
    }
    
/**
 * method for a static translationTable that links the correct protein name to
 * their three DNA base code
 * @return Map TranslationTable
 */       
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
    
/**
 * method that accepts a DNASequence and returns an array of all six different
 * frames ordered fame1, reverse complement 1, frame2, reverse complement 2, etc
 * @param newDNA
 * @return Array of all six reading frames
 */    
    public Collection translateDNA(DNASequence newDNA){
        String[]output = new String[10];
        String dnaIn = newDNA.getContent();
       
        
        ArrayList<String>outputFrame = new ArrayList<>();
        
        outputFrame = (ArrayList<String>) frame(dnaIn);

       
        return frame(dnaIn);
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
    
    public Collection frame(String dna){
        ArrayList<String>out = new ArrayList<>();
        ArrayList<String>inRev = new ArrayList<>();
        ArrayList<String>input = new ArrayList<>();
        ArrayList<String>orderedOut = new ArrayList<>();
        DNASequence seq1 = new DNASequence("temp", dna);
        seq1 = seq1.revComp();
        String dnaRev = seq1.getContent();
        
                
        for(int i = 0;i <dna.length()-2;i++){
            input.add(dna.substring(i, i+3));
            inRev.add(dnaRev.substring(i,i+3));
        }
                
        Iterator<String> iterateRibo = input.iterator();
        Iterator<String> iterateRev = inRev.iterator();
        
        for(int i = 0; i <input.size();i++){
            if(translationTable.containsKey(iterateRibo.next())){
                out.add(whatProtein(input.get(i)));
                out.add(whatProtein(inRev.get(i)));
            }
            else{
                out.add("Error");
            }
        }
        // still not returning the last position of the final frame
        int i = 0;
        while(i<6){
            int x = 0 + i;
            while((i + x) < out.size()+1){
                orderedOut.add(out.get(x));
                x += 6;   
            }
            i++;
        }


        
        return orderedOut;
    }


}


