/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;


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
    
    @Override
    public void substractVisibleTreasure(Treasure t){
        nVisibleTreasures--;
    }
     
   @Override
    public void substractHiddenTreasure(Treasure t){
        nHiddenTreasures--;
    }
     
    @Override
    public boolean isEmpty(){
        return (nVisibleTreasures==0 && nHiddenTreasures==0);
    }

    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h) {
        int nVis, nHid;
        
        if(nVisibleTreasures>v.size())
            nVis=v.size();
        else
            nVis=nVisibleTreasures;
        
        if(nHiddenTreasures>h.size())
            nHid=h.size();
        else
            nHid=nHiddenTreasures;
       
        
        BadConsequence bcAjustado = new NumericBadConsequence(getText(),0, nVis, nHid);
        return bcAjustado;
    }
    
    @Override 
    public String toString(){
        String info=super.toString();
        info+= "\nNúmero de tesoros visibles: " + nVisibleTreasures + ""
                +"\nNúmero de tesoros ocultos: " + nHiddenTreasures +"\n";
        return info;
    }
}
