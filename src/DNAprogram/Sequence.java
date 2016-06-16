package DNAprogram;

import GUI.InformationPanel;
import GUI.TranslationTool;

import java.util.*;
import java.io.*;

/**
 * An abstract class Sequence is the superclass for a number of classes, this
 * class provides the general functionality needed when creating a new biological
 * sequence
 */

public abstract class Sequence {
    private String description = "";
    private static String content = "";
    private static InformationPanel infoPanel;
    private static TranslationTool translationTool;
    private String descrip;
     
/**
 * Constructor that takes two Strings to create a new sequence object, will throw
 * an error if the content contains invalid letters, accepts lowercase letters
 * as they will be converted to uppercase
 * @param description the description input required in the FASTA format, starting with
 * a &gt;
 * @param content the full content string to be made into an object
 */    
    public Sequence(String description, String content){
        this.description = description;
        this.content = content.toUpperCase();
        try{
        validate(validLetters());
        }
        catch (InvalidSequenceException error){
            System.err.println(error);
        }
    }

/**
 * This constructor accepts only a filename string to then create a new sequence
 * object from that file, requires the file to be in a FASTA format
 * @param filename full filename of the file including dir if in a different directory
 * with the extension eg .txt .doc etc
 */    
    public Sequence(String filename){
        try{
            content = getContent(filename);
            description = getDescription(filename);
            content = content.toUpperCase();
            validate(validLetters());
        }
        catch(IOException ex){
            System.err.println(ex);
        }
        catch(InvalidSequenceException e){
            System.err.println(e);
        }
    }

/**
 * return the description of the object in FASTA format starting with a &gt;
 * @return Will return the name of the sequence in the FASTA format
 */        
    public String getDescription(){
        return description;
    }

/**
 * Calls the content field containing the main sequence
 *  @return Will return the body of the sequence in an unformatted manner
 */
    public String getContent(){
        return content;
    }

/**
 * Method to check how long the content is in the file
 * @return will Return the total length of the main file content
 */    
    public static int getLength(){
        return content.length();
    }

/**
 * validate accepts the validLetters() method and then will compare the method
 * to the data in the content, If there is a mismatch will throw InvalidSequenceException
 * @param validLetters a collection of strings that contain all the valid
 * characters
 * @throws InvalidSequenceException if the letters are not correctly validated 
 * this exception is thrown showing the problematic string
 */    
    public static void validate(Collection<String>validLetters) throws InvalidSequenceException {
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
 * accepts validLetters() and checks to see if they are valid, will return boolean
 * @param validLetters
 * @return boolean true if valid false if invalid
 */    
    public static boolean isValid(Collection<String>validLetters){
        ArrayList<String>contentList = new ArrayList<>();
        
        for(int i = 0 ; i < getLength() ; i++){
            contentList.add(content.substring(i, i+1));           
        }
        
        Iterator<String> iterateValid = contentList.iterator();

        for(String x:contentList){
            if(!validLetters.contains(iterateValid.next())){
                return false;
            }                
        }  
        return true;
    }

/**
 * 
 * @param valid
 * @param sequBody
 * @return 
 */    
        public boolean validateSeq(String valid, String sequBody){
        sequBody = sequBody.toUpperCase();
        ArrayList<String>validLetters;
        validLetters =(ArrayList<String>) convertString(valid);
        ArrayList<String>contentList = new ArrayList<>();
        
        for(int i = 0; i < sequBody.length();i++){
            contentList.add(sequBody.substring(i,i+1));
        }
        
        Iterator<String> iterateValid = contentList.iterator();
        
        for(int i = 0; i< contentList.size();i++){
            if(!validLetters.contains(iterateValid.next())){
                return false;
            }
        }
        return true;
    }

/**
 * abstract method validLetters that returns a Collection which will be used in
 * validate
 * @return Collection this will be used to check if the input is valid
 */    
    public abstract Collection validLetters();

/**
 * Will create a string of the description and main string content, if the output
 * is longer than 80 characters it will be split over lines totalling 80 chars 
 * per line
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
 * @param filename accepts a filename or full dir path, written as a string with the 
 * correct suffix .txt .doc etc
 */    
    public void writeToFile(String filename){
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
 * 
 * @param filename
 * @param inORout
 * @param descrip
 * @param content 
 */    
    public static void toFile(String filename, String inORout, String descrip,
            String content){
    

        PrintWriter out = null;
        try{
            
            File outFile = new File(filename);

            FileWriter fout = new FileWriter(outFile);
            BufferedWriter bout = new BufferedWriter(fout);
            out = new PrintWriter(bout);

            out.println(descrip);
            out.println(content);
            out.close();

        }
        catch(IOException ioException){
            translationTool.tellUser(ioException.getMessage());
        }
        finally{
            if(out !=null){out.close();}
        }
    }
/**
* method to read the description from a chosen file, following the FASTA format
* starting with &gt;
* @param filename requires a string file or full dir string ending in the correct suffix
*  .txt .doc etc
* @return description that comes directly from the file line starting with &gt;
* @throws IOException thrown if a reading error occurs
*/    
public static String getDescription(String filename) throws IOException{

        return readFile(0,filename);        
}

/**
* static method to get the content from a chosen file following the FASTA format
* @param filename requires a string file or full dir string ending in the correct
* suffix .txt .doc etc
* @return content that comes directly from the file in FASTA format with no spacing
* or special characters only valid letters in uppercase
* @throws IOException thrown if a reading error occurs
*/    
public static String getContent(String filename) throws IOException{

    return readFile(1,filename);
}

private static String readFile(int toReturn, String filename) throws IOException{
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
    
/**
 * protected class that takes a String and changes it to a collection, this is currently used for
 * the validation processes to make updating easy
 * @param convertString string of characters required to be used for validation
 * @return validLetters an ArrayList of strings containing each valid letter
 * to be used by validate
 */    
        protected Collection convertString(String convertString){
            ArrayList<String>validLetters = new ArrayList<>();

            for(int i=0;i< convertString.length();i++){
                validLetters.add(convertString.substring(i, i+1));
            }
            return validLetters;
    }
}
