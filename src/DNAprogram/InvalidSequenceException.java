package DNAprogram;

/**
 * Custom exception class that check the input sequence and prints the message
 * Invalid sequence: + the string up to the error
 **/
public class InvalidSequenceException extends Exception {
    
/**
 * The constructor will take two parameters to provide an error message to the user
 * highlighting where the first problematic character can be found in the sequence
 * @param sequence the complete string of the biological input type 
 * @param index the point at which the error has occurred, the invalid character
 */    
    InvalidSequenceException(String sequence, int index){
        super("Invalid sequence: " + sequence.substring(0,index+1));
        
    }
}
