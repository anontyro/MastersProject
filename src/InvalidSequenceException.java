/**
 * Custom exception class that check the input sequence and prints the message
 * Invalid sequence: + the string up to the error
 **/
public class InvalidSequenceException extends Exception {
    InvalidSequenceException(String sequence, int index){
        super("Invalid sequence: " + sequence.substring(0,index));
        
    }
}
