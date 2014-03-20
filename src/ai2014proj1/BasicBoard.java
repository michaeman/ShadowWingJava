
package ai2014proj1;
import java.math.*;
import java.util.ArrayList;

/**
 * 
 * @author insanity
 */
public class BasicBoard implements Board {

    protected final int dimension; // dimension of the board
    protected final int maxN; // dimension of the board
    private BasicBoard.Cell[][] map;
    
    //array to store the x,y of pieces already placed onto the board?
    protected ArrayList<White> arrayOfWhite = new ArrayList<White>();
    protected ArrayList<Black> arrayOfBlack = new ArrayList<Black>();
 
    // constructors
    public BasicBoard(int d) {
        this.dimension = d;
        this.maxN = this.dimension * 2 - 1;
        this.createBoard();
    }
    
    private void createBoard() {
        int d = this.dimension;
        int n = (2*d-2);
        int maxNodes = n*n-d*(d-1)/2;
        int nodes = 1;
        
        Cell root = new Cell();

        while (nodes<=maxNodes)
        {
            Cell nu = new Cell();

            root.insert(nu);
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
    
    public void CheckWin() throws SomeKindOfErrorException
    {
        for (int x=0;x<maxN;x++){
            for(int y=0;y<dimension;y++){
                System.out.println(map[x][y].get());
                if (map[x][y].get() == 'B'){
                    System.out.println("Found a B at x = " + x + ", y = " +y);
                    //arrayOfWhite.add();
                }
                //else (map[x][y].get() == 'W')
            }
        }
        
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
        
        public Cell left;
        public Cell mid;
        public Cell right;



        // insert a cell into this cell
        public int insert(Cell nu){
            if (right == null) { // first, if there is no node to the right - we want it there
                right = nu;
                return 0;
            }
            else // if there is, we want it to insert it itself
            {
                int success = right.insertRightwards(nu);
                if (success == 0)
                {
                    return 0;
                }
            }
            
            // if the right row is full, we get to here

            if ( left == null ) // if there is no left, we want a left
            {
                left = nu;
                return 0;
            }
            if ( mid == null ) // if there is no mid, we want a mid
            {
                mid = nu;
                return 0;
            }else{ // otherwise put it in mid
                int success = mid.insertRightwards(nu);
                
                if (success == 0)
                {return 0;}
            }

            // there is no: left.insertRightwards(nu); 
            // because we left is left of mid in the same row. it exists only to expand on the lefthandside diagonal

            return 1; // error inserting node into tree
        }


        // insert a cell into this cell
        public int insert(Cell nu)
        {
            if (right == null) 
            { // first, if there is no node to the right - we want it there
                right = nu;
                return 0;
            }
            else // if there is, we want it to insert it itself
            {
                int success = right.insertRightwards(nu);
                if (success == 0)
                {
                    return 0;
                }
            }
        }

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


