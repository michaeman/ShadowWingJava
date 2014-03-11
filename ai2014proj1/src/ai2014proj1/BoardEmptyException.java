
package ai2014proj1;

/**
 *
 * @author insanity
 */
public class BoardEmptyException extends Exception {

    /**
     * Creates a new instance of
     * <code>BoardEmptyException</code> without detail message.
     */
    public BoardEmptyException() {
    }

    /**
     * Constructs an instance of
     * <code>BoardEmptyException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public BoardEmptyException(String msg) {
        super(msg);
    }
}
