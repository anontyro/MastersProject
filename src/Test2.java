
import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 class StringLengthListSort implements Comparator<String>{
    
    public int compare(String s1, String s2){
        return s2.length() - s1.length();
    }
    
    
}
*/

public class Test2 {
    public static void main(String[]args){
        DNASequence sq1 = new DNASequence(">test","attatcata");
        ProteinSequence sq2 = new ProteinSequence("Lactate", "SNDVVIRSSPVICYH");
        Ribosome ribo = new Ribosome();
        
        try{
           // System.out.println(sq1.getDescription("insulin.txt"));
            System.out.println();
            //System.out.println(sq1.getContent("insulin.txt"));
            System.out.println();
            DNASequence seq = new DNASequence("insulin.txt");
            
            //DNASequence insulin = new DNASequence(sq1.getDescription("insulin.txt"),sq1.getContent("insulin.txt"));
            System.out.println(seq.toString());
            
            String[]insulinFrames = ribo.translateDNA(seq);
            String outFrames = "";
            for(String x:insulinFrames){
                outFrames += x;
            }
            System.out.println(outFrames);
            
            OpenReadingFrame insulinPro = new OpenReadingFrame(seq.getDescription(),outFrames);
            System.out.println("Protien is: \n " + insulinPro.toString());
            ArrayList<String>insulinOut = new ArrayList<>();
            
            insulinOut = (ArrayList<String>) insulinPro.getORFs(insulinPro);
            
            System.out.println(insulinOut.toString());
     
        }
        catch(IOException e){
            System.err.println(e);
        } catch (InvalidSequenceException ex) {
            Logger.getLogger(Test2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
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
        
        
        
                                //GALMFWKSNDPVICYHRTQE*
        


        ArrayList<String>orf = new ArrayList<>();
        String content = "MFWK*ASPV*AMSW*CYHRTMFWQK*HRTYYMQTRHYYY*VICDPMGALSNP*CYHQEMGALMFWK*MFWK*";
        
        //GALMFWKSNDPVICYHRTQE
        //Open reading frame logic
        
        
        
        ArrayList<String>allFrames = new ArrayList<>();
        for(int i = 0; i <content.length();i++){
            allFrames.add(content.substring(i, i+1).trim());
        }
        String[]frameArray = new String[allFrames.size()];
        frameArray = allFrames.toArray(frameArray);
        
        String frameOutput = "";
        for(int i = 0; i < frameArray.length;i++){
            frameOutput += frameArray[i];
        }
        System.out.println(frameOutput);

        
        for(int i = 0; i <frameArray.length;i++){
            if(frameArray[i].equals("M")){
                String frameCapture = "";
                do{
                    frameCapture+=frameArray[i];
                    i++; 
                    if(frameArray[i].equals("*")){
                        frameCapture+=frameArray[i];
                        frameCapture = frameCapture.trim();
                        orf.add(frameCapture);
                    }
                }
                while(!frameArray[i].equals("*"));

            }
        }
        
        System.out.println(orf.toString());
        
        */
        /*
        
        StringLengthListSort ss = new StringLengthListSort();
        Collections.sort(orf,ss);
 
        System.out.println(orf.toString());
        
        */
        /*
        
        String[]dnaArray =ribo.translateDNA(sq1);
        String outDNA = "";
        for(String x : dnaArray){
            outDNA+= x;
        }
        System.out.println(outDNA);
        
        try{
            OpenReadingFrame orf2 = new OpenReadingFrame(">Lactate", "MFWK*ASPV*AMSW*CYHRTMFWQK*HRTYYMQTRHYYY*VICDPMGALSNP*CYHQEMGALMFWK*MFWK*");
            System.out.println(orf2.getContent());
            System.out.println(orf2.getORFs(orf2));
        }
        catch(InvalidSequenceException e){
            System.err.println(e);
        }
        
        System.out.println(sq1.getContent());

        */

        
        

/*
        try{
            System.out.println(sq1.getDescription("test.txt"));
            System.out.println();
            System.out.println(sq1.getContent("test.txt"));
            System.out.println();
        }
        catch(IOException e){
            System.err.println(e);
        }

        
*/
        
       // System.out.println(sq1.getContent());
       // System.out.println(sq1.validLetters());
       // System.out.println(sq1.getLength());
       // System.out.println(sq1.toString());
       // System.out.println(sq1.revComp());
       // 
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
