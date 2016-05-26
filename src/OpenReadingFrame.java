import java.util.*;

/**
 * subclass used for the string comparison in order to order the reading frames
 * in the correct order
 * @author Alex
 */
class StringLengthListSort implements Comparator<String>{
    
/**
 * method that will evaluate two strings and return the length difference of the two
 * @param s1 the open reading frame to be compared
 * @param s2 the next open reading frame to be compared
 * @return  returns the difference in size of the two strings
 */    
    public int compare(String s1, String s2){
        return s2.length() - s1.length();
    }
}

/**
 * This class extends proteinSequences to provide extra abilities to proteins when
 * you want to create the open reading frames for the sequence strings
 * @author Alex
 */
public class OpenReadingFrame extends ProteinSequence{
    
    private String description = "";
    private String content = "";

/**
 * 
 * @param description
 * @param content
 * @throws InvalidSequenceException 
 */    
    OpenReadingFrame(String description, String content) throws InvalidSequenceException{
        super(description,content);
        this.content = content;
        this.description = description;
        /*
        try{
            this.content = content;
            this.description = description;
            if (content.charAt(0) != 'M' || content.charAt(content.length()-1) != '*'){
                throw new InvalidSequenceException(content,0);
            }
        }
            catch(InvalidSequenceException e){
                System.err.println(e);
                System.exit(1);
            }
        */
    }
/**
 * 
 * @return 
 */    
    public Collection validLetters(){
        return convertString("GALMFWKSNDPVICYHRTQE*");
    }

/**
 * 
 * @param proSequ
 * @return 
 */    
    public static Collection getORFs(ProteinSequence proSequ){
       ArrayList<String>output = new ArrayList<>();
       
       String protien = proSequ.getContent();
       char[]frameArray = protien.toCharArray();
       
       for(int i = 0; i <frameArray.length; i++){
           if(frameArray[i] == 'M'){
               String frameCapture = "";
               do{
                   frameCapture+=frameArray[i];
                   i++;
                   if(frameArray[i] =='*'){
                       frameCapture+=frameArray[i];
                       frameCapture = frameCapture.trim();
                       output.add(frameCapture);
                   }
               }
               while(frameArray[i] != '*');
           }
       }
       
      StringLengthListSort ss = new StringLengthListSort();
      Collections.sort(output,ss);
       
       
       return output;
    }
    
    

    
    
}
