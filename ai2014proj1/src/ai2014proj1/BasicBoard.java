
package ai2014proj1;
import java.math.*;

/**
 * 
 * @author insanity
 */
public class BasicBoard implements Board {

    protected final int dimension; // dimension of the board
    protected final int maxN; // dimension of the board
    private BasicBoard.Cell[][] map;
    
 
    // constructors
    public BasicBoard(int d) {
        this.dimension = d;
        this.maxN = this.dimension * 2 - 1;
        this.createBoard();
    }
    
    private void createBoard() {
        int n = this.dimension;
        
        // fill map with invalid/empty cells
        map = new BasicBoard.Cell[this.maxN][];
        int h = 2*n-2;
        for(int r=0;r<this.maxN;r++)
        {
            BasicBoard.Cell[] row = new BasicBoard.Cell[this.maxN];        
            for(int c=0;c<this.maxN;c++)
            {
                row[c] = new BasicBoard.Cell();
                // if this cell is on the board, set it to blank
                // column less than the full length + row height 
                //  && row is less than half way
                if (c<n+r && r<n){ 
                    row[c].set('-');
                }
                // column less than the full length + minus some value
                //  && row is greater than or equal to half way
                else if (c<n+h && r>=n){
                    row[c].set('-');
                }
            }
            h--;
            map[r] = row;
        }
    }

    // Printing and shit
    @Override
    public String toString() {
        final StringBuilder printableMap = new StringBuilder(this.maxN);
        
        // construct printable map
        for(int r=0;r<this.maxN;r++)
        {       
            printableMap.append( cellRowToString(this.map[r]));
            printableMap.append( '\n' );
        }
        
        return printableMap.toString();
    }
    private String cellRowToString(final BasicBoard.Cell[] cells){
        final StringBuilder printableRow = new StringBuilder(this.maxN);
        
        if (cells.length==0) {return "";}
        
        for(int c=0;c<this.maxN && cells[c].get()!='X';c++)
        {
            printableRow.append( cells[c].get() );
        }
        return printableRow.toString();
    }

    @Override
    public boolean isValid() {
        return true; // TODO: make this actually work
    }
    
    @Override
    public char getCell(int x, int y) throws BoardEmptyException {
        if (map.length==0) 
        {throw new BoardEmptyException("Cannot get cell: board is empty");} 
        
        return map[x][y].get();
    }

    @Override
    public void applyPremadeBoard(String rawBoardConfig) throws SomeKindOfErrorException {
        try {
        String[] lines = rawBoardConfig.split("\n");
        
         // drop first line if its the size of the map
        int startpoint = 0;
        if (lines[0].length()<=1) {startpoint = 1;}
        
        for(int r = startpoint; r< lines.length ; r++){
            String[] cells = lines[r].split(" ");
            
            for(int c=0;c<cells.length;c++){
                map[r][c].set(cells[c].charAt(0));
            }
        }
        } catch(Exception e){
            throw new SomeKindOfErrorException(e.getMessage());
        }
        
        if (!this.isValid())
        {throw new SomeKindOfErrorException("Badly formatted premade board");}
        
    }

    @Override
    public void setCell(int x, int y, char val) throws BoardEmptyException {
        if (map.length==0) 
        {throw new BoardEmptyException("Cannot get cell: board is empty");} 
        
        map[x][y].set(val);
    }
    
    // subclasses
    private class Cell {
        private char contents;
        
         // create new empty cell
        public Cell(){
            contents = 'X'; // black:B, white:W, blank:-, invalid:X
        }
        
        // set the contents of the cell
        public void set(char c){
            contents = c;
        }
        // get the contents of the cell
        public char get(){
            return contents;
        }
    }
}


