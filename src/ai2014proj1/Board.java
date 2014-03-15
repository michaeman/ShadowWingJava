
package ai2014proj1;

/**
 *
 * @author insanity
 */
public interface Board {
 
    
    /* returns true if the board is in a valid configuration */
    public boolean isValid();
    
    
    /* gets the value of the cell at (x,y) */
    public char getCell(int x, int y) throws BoardEmptyException;
    /* sets the value of the cell at (x,y) to val */
    public void setCell(int x, int y, char val) throws BoardEmptyException;
    
    /**
     * pumps in the values of the premade board (as in spec)
     * the first line (the size) should have been removed and used to 
     * instantiate the Board object first.
     */
    public void applyPremadeBoard(String rawBoardConfig) throws SomeKindOfErrorException;

    public void CheckWin() throws SomeKindOfErrorException;

}
