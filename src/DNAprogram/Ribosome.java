package DNAprogram;

import java.util.*;
/**
 * simple class for Ribosome that creates several static methods to be used with
 * different sequences
 */
public class Ribosome{
    
    private static final Map<String,String>translationTable = translationTable();
    
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
 * @param newDNA a DNASequence object that is taken to be read into the six different
 * reading frames
 * @return Array of all six reading frames
 */    
    public static String[] translateDNA(DNASequence newDNA){
        String dnaIn = newDNA.getContent();
       
        return frame(dnaIn);
    }
/**
 * A simple translation method that will only translate one frame
 * @param newDNA DNASequence object taken to be transcribed
 * @param readFrame The frame which the user wants to translate in a number where 0
 * is the first and 2 is the third frame
 * @return a string Array of the first translated frame
 */    
    public static String[] oneFrameTranslate(DNASequence newDNA, int readFrame){
        String dnaIn = newDNA.getContent();
        
        return frame(dnaIn,readFrame);
    }
    
    private static String[] frame(String dna, int readFrame){
        ArrayList<String>frameOut = new ArrayList<>(20);
        ArrayList<String>dnaIn = new ArrayList<>(20);
        String codon = "";
        
        
        for(int i = 0; i <dna.length()-2;i+=3){
            dnaIn.add(dna.substring(i, i+3));
        }
        Iterator<String> iterateRibo = dnaIn.iterator();
        
        try{
            for(int i = readFrame; i < dnaIn.size() ;i++){ 
                if (translationTable.containsKey(iterateRibo.next())){
                    frameOut.add(whatProtein(dnaIn.get(i)));
                }
                else{
                    throw new InvalidSequenceException(dna,i);
                }            
            }
        }
        catch(InvalidSequenceException e){
            System.err.println(e);
        }
        
        String[]outputArray = new String[frameOut.size()];
        outputArray = frameOut.toArray(outputArray);
        
        return outputArray;
    }
    
    private static String whatProtein(String dnaIn){
       return translationTable.get(dnaIn);
    }
    
    private static String[] frame(String dna){
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
        try{
            for(int i = 0; i <input.size();i++){
                if(translationTable.containsKey(iterateRibo.next())){
                    out.add(whatProtein(input.get(i)));
                    out.add(whatProtein(inRev.get(i)));
                }
                else{
                    throw new InvalidSequenceException(dna,i);

                }
            }
        }
        catch(InvalidSequenceException e){
                System.err.print(e);
        }
        
        input.clear();
        inRev.clear();

        int i = 0;
        while(i<6){
            int x = 0 + i;
            while((i + x) < out.size()+1){
                orderedOut.add(out.get(x));
                x += 6;   
            }
            i++;
        }
        String[]outputArray = new String[orderedOut.size()];
        outputArray = orderedOut.toArray(outputArray);
        
        return outputArray;
    }
}


