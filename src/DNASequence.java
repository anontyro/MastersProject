
import java.util.*;
import java.io.*;


public class DNASequence extends Sequence {
    
    private String content =  "";
    private String description = "";
    
    public DNASequence(String description,String content){
        super(description,content);
        this.content = content;
        this.description = description;
    }
    
    public Collection validLetters(){
        ArrayList<String>validLetters = new ArrayList<>();
        
        validLetters.add("A");
        validLetters.add("C");
        validLetters.add("T");
        validLetters.add("G");
        
        return validLetters;  
    }
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
                reverse[i]='C';
            }
            reverseContent+=reverse[i];
        }
        
        DNASequence seq = new DNASequence(description,reverseContent);
        return seq;
    }

    
}
