import java.util.*;
import java.io.*;

public abstract class Sequence {
    private String description = "";
    private String content = "";
    
 
    
    Sequence(String description, String content){
        this.description = description;
        this.content = content.toUpperCase();
        try{
        validate(validLetters());
        }
        catch (InvalidSequenceException error){
            System.err.println(error);
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

    }
    
    public abstract Collection validLetters();
    
    public String toString(){
        return description+"\n"+content; 
    }
    
    public void writeToFile(String filename) throws IOException{
        PrintWriter out = null;
        
        try{
            
            String outDescription ="";
            String[]outDescrip = (toString().split("\n"));
            /*
            for(int i = 0; i < outDescrip.length;i++){
            outDescription += outDescrip[i];
                       
        }*/
            outDescription = outDescrip[0] + " \n " + outDescrip[1];
            
            File outFile = new File(filename);
            
            FileWriter fout = new FileWriter(outFile);
            BufferedWriter bout = new BufferedWriter(fout);
            out = new PrintWriter(bout);
            
            out.println(description);
            out.println(content);
            out.println(outDescription);
            out.close();
        }
        catch(IOException error){
            System.err.println(error.getMessage());
        }
        finally{
            if(out !=null){out.close();}
        }
    }
    
    public String getDescription(String filename) throws IOException{
        File inFile = new File(filename);
        BufferedReader bin = null;
        String descOutput = "";
        String output = "";
        String body = "";
        
        try{
            FileReader fin = new FileReader(inFile);
            bin = new BufferedReader(fin);
            
            String line = bin.readLine();
            while(line != null){    
            descOutput += line + "\n";
            line = bin.readLine();
            }
            
            String[]textSplit = descOutput.split("\n");
            
            for(int i = 0; i < textSplit.length;i++){
                if(textSplit[i].startsWith(">")){
                    output += textSplit[i];
                }
                else
                     body += textSplit[i];
            }
            output.trim();
                
        }
        catch(IOException e){
            System.err.println(e.getMessage());
        }
        finally{
            if(bin !=null) {bin.close();}
        }
        
        
        return output;
    }
    
    public String getContent(String filename) throws IOException{
        File inFile = new File(filename);
        BufferedReader bin = null;
        String descOutput = "";
        String output = "";
        String body = "";
        
        try{
            FileReader fin = new FileReader(inFile);
            bin = new BufferedReader(fin);
            
            String line = bin.readLine();
            while(line != null){    
            descOutput += line + "\n";
            line = bin.readLine();
            }
            
            String[]textSplit = descOutput.split("\n");
            
            for(int i = 0; i < textSplit.length;i++){
                if(textSplit[i].startsWith(">")){
                    output += textSplit[i];
                }
                else
                     body += textSplit[i];
            }
            output.trim();
            body.trim();
                
        }
        catch(IOException e){
            System.err.println(e.getMessage());
        }
        finally{
            if(bin !=null) {bin.close();}
        }
        
        
        return body;
    }    
    
}
