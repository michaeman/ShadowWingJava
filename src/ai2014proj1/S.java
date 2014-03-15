/*
 * Seanlib
 */
package ai2014proj1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author insanity
 */
public abstract class S {
    
    public static String readCharsFromFile(String filename) {
        
        String s = new String("");
        File file = new File(filename);
        BufferedReader r = null;

        try {
            r = new BufferedReader(new FileReader(file));
            String t = null;

            while ((t = r.readLine()) != null) {
                t.trim();
                s += t + "\n";
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {e.printStackTrace();}
        finally {
            try {
                if (r != null) {
                    r.close();
                }
            } catch (IOException e) {}
        }

        return s;
    
    }
    
    // shortcut to save on RSI
    public static void P(Object o){System.out.print(o.toString());}
    
}
