
import java.util.*;
import java.io.*;

public class Test {
    public static void main(String[]args){
        
      /*  String testSq = ">Rhino DNA \n "
                + "ATCGAAATAACGGTAGGGG";
        
        String outName = "";
        String outContent ="";
        
        System.out.println(testSq);
        
        String[] textSplit = testSq.split("\n");
        
        for(int i = 0; i< textSplit.length;i++){
            if(textSplit[i].startsWith(">")){
                outName+= textSplit[i];
            }
            else
                outContent+= textSplit[i];
        }
        
        System.out.println(outName);
        System.out.println("Break");
        System.out.println(outContent);
        
        */
        
                                //GALMFWKSNDPVICYHRTQE*
        
        DNASequence sq1 = new DNASequence(">test","attatcata");
        ProteinSequence sq2 = new ProteinSequence("Lactate", "SNDVVIRSSPVICYH");
        Ribosome ribo = new Ribosome();
        
        String content = "MFWK*ASPV*AMSW*";
        ArrayList<String>allFrames = new ArrayList<>();
        for(int i = 0; i <content.length();i++){
            allFrames.add(content.substring(i, i+1));
        }
        
        System.out.println(allFrames.toString());
        
        ArrayList<String>orf = new ArrayList<>();
        for(String x: allFrames){
            int count = 0;
            if(x.equals("M")){
                while(x != "*"){
                    
                    
                }
            }
        }
        
/*

  try{
            OpenReadingFrame orf = new OpenReadingFrame("Lactate", "MSNDVVVPV*");
            System.out.println(orf);
        }
        catch(InvalidSequenceException e){
            System.err.println(e);
        }
*/
        
       // System.out.println(sq1.getContent());
       // System.out.println(sq1.validLetters());
       // System.out.println(sq1.getLength());
       // System.out.println(sq1.toString());
       // System.out.println(sq1.revComp());
       // System.out.println(ribo.translateDNA(sq1));
       // System.out.println(ribo.whatProtein("ATG"));
       // ribo.translateDNA(sq1);
        
        
        //System.out.println(sq1.revComp());
        
        /*System.out.println(sq1.getFullName("P"));
        try{
         //sq1.writeToFile("test.txt");
        
         System.out.println(sq1.getDescription("test.txt"));
         System.out.println();
         System.out.println(sq1.getContent("test.txt"));
         
         
        }
        catch (IOException error) {
            System.err.println(error.getMessage());
        }
        
        
        String seq = "ATGATGATGCTTTTC";
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
