/* encoding: utf-8
 */
package NapakalakiGame;

import static java.lang.StrictMath.min;
import java.util.*;

public class BadConsequence {

    private String text;
    private int levels;
    private boolean death;
  
    public int getLevels(){
        return levels;
    }
    
    public boolean getDeath(){
        return death;
    }
    
    public String getText(){
        return text;
    }
 
    public BadConsequence(String texto, int niveles){
        levels=niveles;
        text=texto;
        death=false;
    }  
}

