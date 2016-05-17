import java.util.*;

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
    
    public static Collection getORFs(){
       ArrayList<String>output = new ArrayList<>();
       
       
       
       return output;
    }
    
    
}
