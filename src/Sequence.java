

public class Sequence {
    private String description = "";
    private String content = "";
    private int sequenceLength = 0;
    
    Sequence(String description, String content){
        this.description = description;
        this.content = content;
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
    
    public boolean simpleValidate() throws InvalidSequenceException{
        for(int i = 0; i < getLength(); i++){
            if(content.charAt(i)!= 'A')
               if(content.charAt(i) != 'C')
                   if(content.charAt(i) != 'T')
                       if(content.charAt(i) != 'G'){
                           throw new InvalidSequenceException(content,i);
                          // return false;
                       }
                
               
            
        }
        return true;
    }
    
    public boolean validate() throws InvalidSequenceException{
        int index = 0;
        try{
            
        for(int i = 0; i < getLength(); i++){
            if (content.charAt(i) != ('A' | 'T' | 'G' | 'C')){
                i = index;
                throw (new InvalidSequenceException(content,i));
                
                
            }
            }
        }
        catch(InvalidSequenceException error){
            throw (new InvalidSequenceException(content,index));
        }
            
        
        
        
        return true;
        
        
    }
}
