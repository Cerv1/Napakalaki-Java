/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;


public class NumericBadConsequence  extends BadConsequence{
    private int nVisibleTreasures;
    private int nHiddenTreasures;
      
    public NumericBadConsequence(String t, int nivel, int nV, int nH){
        super(t,nivel);
        nVisibleTreasures=nV;
        nHiddenTreasures=nH;
    }
    
    public int getNVisibleTreasures(){
        return nVisibleTreasures;
    }
    
    public int getNHiddenTreasures(){
        return nHiddenTreasures;
    }
    
     public void substractVisibleTreasure(){
        nVisibleTreasures--;
     }
     
     public void substractHiddenTreasure(){
        nHiddenTreasures--;
     }
     
     public boolean isEmpty(){
        return (nVisibleTreasures==0 && nHiddenTreasures==0);
     }
}
