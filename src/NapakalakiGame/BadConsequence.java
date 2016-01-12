/* encoding: utf-8
 */
package NapakalakiGame;

import static java.lang.StrictMath.min;
import java.util.*;

public abstract class BadConsequence {

    private String text;
    private int levels;
  
    public BadConsequence(String texto, int niveles){
        levels=niveles;
        text=texto;
    }  
    
    public int getLevels(){
        return levels;
    }
    
    public String getText(){
        return text;
    }
    
   public abstract boolean isEmpty();
   public abstract void substractVisibleTreasure (Treasure t);
   public abstract void substractHiddenTreasure (Treasure t);
   public abstract BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h);
 
}

