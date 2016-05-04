import java.util.*;

public class Sequence {
    private String description = "";
    private String content = "";
    private ArrayList<String>validLetters;
 
    
    Sequence(String description, String content){
        this.description = description;
        this.content = content;
        try{
        validate(validLetters());
        }
        catch (InvalidSequenceException error){
            System.out.println(error);
            System.exit(1);
        }
    }
    
    public String getDescription(){
        return description;
    }
    
    public String getContent(){
        return content;
    }
    
    public int getLength(){
        return content.length();
    }
    
    
    public void validate(Collection<String>validLetters) throws InvalidSequenceException {
        ArrayList<String>contentList = new ArrayList<>();
        
        for(int i = 0 ; i < getLength() ; i++){
            contentList.add(content.substring(i, i+1));           
        }
        
        Iterator<String> iterateValid = contentList.iterator();
        int index = 0;
        
        for(int i = 0; i < contentList.size(); i++){
            if(validLetters.contains(iterateValid.next())){
                index++;
            }
            else{
                throw new InvalidSequenceException(content,i);
            }                
        }  
         System.out.println(content);
    }
    
    public Collection validLetters(){
        validLetters = new ArrayList<String>();
        
        validLetters.add("A");
        validLetters.add("C");
        validLetters.add("T");
        validLetters.add("G");
        
        return validLetters;       
    }
    
}
