
package ai2014proj1;

/**
 *
 * @author insanity
 */
public interface GameState {
 
    /* inspect the game */
    Game peek();
    
    /* returns true if the board is in a valid configuration */
    boolean isValid();
    
}
