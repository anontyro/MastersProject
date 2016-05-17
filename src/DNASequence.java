
import java.util.*;

/**
 *  class DNASequence that extends Sequence
 */
public class DNASequence extends Sequence {
    
    private String content =  "";
    private String description = "";

/**
 * create a DNASequence taking two String parmeters
 * @param description
 * @param content 
 */    
    public DNASequence(String description,String content){
        super(description,content);
        this.content = content.toUpperCase();
        this.description = description;
    }
    
/**
 * method that holds a collection of validLetters to be checked against
 * @return Collection validLetters 
 */    
    public Collection validLetters(){
        ArrayList<String>validLetters = new ArrayList<>();
        
        validLetters.add("A");
        validLetters.add("C");
        validLetters.add("T");
        validLetters.add("G");
        
        return validLetters;  
    }
    
/**
 * method to reverse and create a DNA compliment for the second side of the
 * double helix
 * @return  DNASequence
 */    
    public DNASequence revComp(){
        
        char[]reverse = content.toCharArray();
        String reverseContent="";
        for(int i = reverse.length-1;i>=0;i--){
            if(reverse[i]=='A'){
                reverse[i]='T';
            }
            else if(reverse[i]=='G'){
                reverse[i]='C';
            }
            else if(reverse[i]=='T'){
                reverse[i]='A';
            }
            else{
                reverse[i]='G';
            }
            reverseContent+=reverse[i];
        }
        
        DNASequence seq = new DNASequence(description,reverseContent);
        return seq;
    }

    
}
