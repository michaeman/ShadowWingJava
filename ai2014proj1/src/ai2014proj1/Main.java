
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
        
        
        Board b = new BasicBoard(4);
        if (b.isValid()){
            System.out.print(b);
        }
        
    }
}
