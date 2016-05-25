import java.util.*;

class StringLengthListSort implements Comparator<String>{
    
    public int compare(String s1, String s2){
        return s2.length() - s1.length();
    }
}

public class OpenReadingFrame extends ProteinSequence{
    private String description = "";
    private String content = "";

    OpenReadingFrame(String description, String content) throws InvalidSequenceException{
        super(description,content);
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
    }
    
    public Collection validLetters(){
        return convertString("GALMFWKSNDPVICYHRTQE*");
    }
    
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
    public String getContent(){
        return content;
    }
    

    
    
}
