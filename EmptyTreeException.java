/**
 * 
 * @author Fatima Hasan 	
 * This is an exception class that is thrown by the methods : largest and smallest in the binary
 * search tree.
 */
public class EmptyTreeException extends Exception {
	public EmptyTreeException(String string) {
		super(string);
	}
}
