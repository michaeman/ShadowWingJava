
package ai2014proj1;

/**
 *
 * @author insanity
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        // test for instantiation and setters
        try {
            Board b = new BasicBoard(4);
            
            b.setCell(0, 0, 'B');
            b.setCell(0, 1, 'W');
            b.setCell(1, 0, 'B');
            b.setCell(1, 1, 'B');
            
            if (b.isValid()){
                S.P(b);
            }
        } catch (Exception e) {
            S.P("Error in instatiation/setters: "+e.getMessage());
        }
        
     
        // test for loading premade board
        try {
            String s = S.readCharsFromFile("input/t1.txt");
         
            int N = Character.getNumericValue(s.charAt(0));
            
            Board b = new BasicBoard(N);
            b.applyPremadeBoard(s.substring(2)); // one for int, one for newline
            
            if (b.isValid()){
                S.P(b);
            }
        } catch (Exception e) {
            S.P("Error in load premade board function: "+e.getMessage());
        }
        
    }
}
