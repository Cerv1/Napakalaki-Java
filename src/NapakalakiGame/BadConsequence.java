/* encoding: utf-8
 */
package NapakalakiGame;

import static java.lang.StrictMath.min;
import java.util.*;

public class BadConsequence {
    static  final int MAXTREASURES=10;
    private String text;
    private int levels;
    private boolean death;

    
    public boolean isEmpty(){
            boolean empty=false;
            if(nHiddenTreasures==-1){
                 if(specificHiddenTreasures.isEmpty() && specificVisibleTreasures.isEmpty() && levels==0 && death==false)
                    empty=true;
            }
            else{
                if(levels==0 && death==false)
                    empty=true;
            }
               
            return empty;
    }
    
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
   
  
     
    public String toString(){       
        if(death==true){
            return "text= " + text
                    + "\ndeath= " + Boolean.toString(death);
        }
        else if(nVisibleTreasures==-1){
            return "text= " + text
                    + "\nlevels= " + Integer.toString(levels)
                    + "\ndeath= " + Boolean.toString(death)
                    + "\nspecificHiddenTreasures= " + specificHiddenTreasures 
                    + "\nspecificVisibleTreasures= " + specificVisibleTreasures;
        }
        else{
            return "text= " + text
                    + "\nlevels= "+ Integer.toString(levels)
                    + "\ndeath= " + Boolean.toString(death)
                    + "\nnVisibleTreasures= " + Integer.toString(nVisibleTreasures)
                    + "\nnHiddenTreasures= " + Integer.toString(nHiddenTreasures);
        }      
    }   
}

