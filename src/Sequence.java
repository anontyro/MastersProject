
import java.util.*;
import java.io.*;

/**
 * An abstract class Sequence
 */

public abstract class Sequence {
    private String description = "";
    private String content = "";
    
 
/**
 * Constructor that takes two Strings 
 * @param description
 * @param content 
 * Will perform validation on content param if mismatch catches InvalidSequenceException
 */    
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
    
    Sequence(String filename) throws IOException{
        try{
            content = getContent(filename);
            description = getDescription(filename);
            content = content.toUpperCase();
        }
        catch(IOException e){
            System.err.println(e);
        }
    }


/**
 * return the description field
 * 
 */        
    public String getDescription(){
        return description;
    }

/**
 * return the content field 
 *  
 */
    public String getContent(){
        return content;
    }

/**
 * return the size of the content added
 * 
 */    
    public int getLength(){
        return content.length();
    }

/**
 * validate accepts the validLetters() method and then will compare the method
 * to the data in the content. If there is a mismatch will throw InvalidSequenceException
 * @param validLetters
 * @throws InvalidSequenceException 
 */    
    public void validate(Collection<String>validLetters) throws InvalidSequenceException {
        ArrayList<String>contentList = new ArrayList<>();
        
        for(int i = 0 ; i < getLength() ; i++){
            contentList.add(content.substring(i, i+1));           
        }
        
        Iterator<String> iterateValid = contentList.iterator();

        for(int i = 0; i < contentList.size(); i++){
            if(!validLetters.contains(iterateValid.next())){
                throw new InvalidSequenceException(content,i);
            }
                
        }  

    }

/**
 * abstract method validLetters that returns a Collection which will be used in
 * validate
 * @return Collection
 */    
    public abstract Collection validLetters();

/**
 * @return String description and content on two different lines.
 * If the content is longer than 80 characters it will split the lines
 * to allow for better readability (splits every 80 characters)
 */    
    public String toString(){
        String value = "80";
        String output = content.replaceAll("(.{" + value + "})","$1\n").trim();
        
        return description+"\n"+output; 
    }
    


/**
 * method to write the sequence description and content to a chosen filename
 * @param filename
 * @throws IOException 
 */    
    public void writeToFile(String filename) throws IOException{
        PrintWriter out = null;
        
        try{
            
            String outDescription ="";
            String[]outDescrip = (toString().split("\n"));

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
    
/**
 * method to read the description from a chosen file, following the FASTA format
 * starting with '>'
 * @param filename
 * @return output file
 * @throws IOException 
 */    
    public String getDescription(String filename) throws IOException{

            return readFile(0,filename);        
    }

/**
 * method to get the content from a chosen file following the FASTA format
 * @param filename
 * @return output filename
 * @throws IOException 
 */    
    public String getContent(String filename) throws IOException{
 
        return readFile(1,filename);
    }
    
    private String readFile(int toReturn, String filename) throws IOException{
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
            output = output.trim();
            body = body.trim();
            body = body.replaceAll("\\s+","");
                
        }
        catch(IOException e){
            System.err.println(e.getMessage());
        }
        finally{
            if(bin !=null) {bin.close();}
        }
        
        if (toReturn == 0){
            return output;
        }
        else{
            return body;
        }

    }
    
}
