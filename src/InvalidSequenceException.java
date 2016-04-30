/*
 * 
 */
public class InvalidSequenceException extends Exception {
    InvalidSequenceException(String sequence, int index){
        super("Invalid sequence: " + sequence.substring(0,index));
        
    }
}
