
import java.io.IOException;
import java.util.*;

//test class that will contain all the testing code
public class Test {
    public static void main(String[]args){
        
        try{

            DNASequence seq = DNASequence.makeSequence("insulin.txt");
            
            System.out.println(seq.toString());
            
            String[]insulinFrames = Ribosome.translateDNA(seq);
            String outFrames = "";
            for(String x:insulinFrames){
                outFrames += x;
            }
            System.out.println("\n \n");
            
            OpenReadingFrame insulinPro = new OpenReadingFrame(seq.getDescription(),outFrames);
            System.out.println("Protien is: \n " + insulinPro.toString());
            
            System.out.println("\n \n");
            
            
            ArrayList<String>insulinOut;            
            insulinOut = (ArrayList<String>) OpenReadingFrame.getORFs(insulinPro);
            String outputInsulin = "";
            
            for(String x:insulinOut){
                outputInsulin += x + "\n";
            }

            System.out.println(outputInsulin);
     
        }
        catch(IOException e){
            System.err.println(e);
        } catch (InvalidSequenceException ex) {
            System.err.println(ex);
        }
        
    }
    
}
