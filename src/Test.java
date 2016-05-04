
import java.util.*;

public class Test {
    public static void main(String[]args){
        
        DNASequence sq2 = new DNASequence("test","ATGCACAAAGGG");
        ProteinSequence sq1 = new ProteinSequence("Lactate", "SNDVVIRSSPVICYH");

        System.out.println(sq1.getContent());
        System.out.println(sq1.validLetters());
        System.out.println(sq1.getLength());
        //System.out.println(sq1.revComp());
        
        System.out.println(sq1.getFullName("P"));
        
        
        /*String seq = "ATGATGATGCTTTTC";
        String flipReverse = "";
        char[]reverse = seq.toCharArray();
        System.out.println(reverse.length);
        for(int i = reverse.length-1; i >= 0;i--){
            flipReverse+=reverse[i];
        }
        System.out.println(flipReverse);
        System.out.println(flipReverse.length());
        
               
       
        
        ArrayList<String>dna = new ArrayList<>();
        ArrayList<String>valid = new ArrayList<>();
       
        
        String validLet = "ATCG";
        for(int i = 0; i< validLet.length(); i++){
            valid.add(validLet.substring(i, i+1));
        }
                
        valid.add("A");
        valid.add("C");
        valid.add("G");
        valid.add("T");

        
        String content = "AGTGTCCTAAQ";
        
        for(int i = 0; i< content.length(); i++){
            dna.add(content.substring(i, i+1));
        }
        
        System.out.println(dna);
        System.out.println(valid);
        
        Iterator<String> iterate = dna.iterator();
        int index = 0;
        for(int i = 0; i < dna.size(); i++){
            if(valid.contains(iterate.next())){
                index++;
                
            }
            else{
                System.out.println("Error not valid");
                break;
            }
        }


        */
        

    }
}
