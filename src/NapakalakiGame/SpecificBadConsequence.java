/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import static java.lang.StrictMath.min;
import java.util.ArrayList;


public class SpecificBadConsequence extends BadConsequence{

    private ArrayList<TreasureKind> specificHiddenTreasures;
    private ArrayList<TreasureKind> specificVisibleTreasures;
    
    public SpecificBadConsequence(String t,  int nivel, ArrayList<TreasureKind> sH, ArrayList<TreasureKind> sV){
        super(t,nivel);
        specificHiddenTreasures=sH;
        specificVisibleTreasures=sV;
        
    }
        
    public ArrayList<TreasureKind> getSpecificHiddenTreasures(){
        return specificHiddenTreasures;
    }
    
    public ArrayList<TreasureKind> getSpecificVisibleTreasures(){
        return specificVisibleTreasures;
    }
    
    public void substractHiddenTreasure(Treasure t){
        if(specificHiddenTreasures!=null){
            for(int i=0; i<specificHiddenTreasures.size(); i++){
                if(t.getType() == specificHiddenTreasures.get(i))
                    specificHiddenTreasures.remove(i);
            }
        }
    }
      
    public void substractVisibleTreasure(Treasure t){
        if(specificVisibleTreasures!=null){
            for(int i=0; i<specificVisibleTreasures.size(); i++){
                if(t.getType() == specificVisibleTreasures.get(i))
                    specificVisibleTreasures.remove(i);
            }
        }
    }
     
    public boolean isEmpty(){
        return (specificVisibleTreasures.isEmpty() && specificHiddenTreasures.isEmpty());
    }
    
    public SpecificBadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){
        SpecificBadConsequence bcAjustado;
 
            ArrayList<TreasureKind> listaAjustadaVisibles = new ArrayList();
            ArrayList<TreasureKind> listaAjustadaHidden = new ArrayList();
            
            for(TreasureKind tKind : TreasureKind.values()){
                int jugador = 0, badC = 0;
                
                for(TreasureKind t : specificVisibleTreasures){
                    if(t == tKind)
                        badC++;
                }
                
                for(Treasure t : v){
                    if(t.getType() == tKind)
                        jugador++;
                }
                
                for(int i = 0; i< min(jugador,badC); i++)
                    listaAjustadaVisibles.add(tKind);
            
                jugador = 0;
                badC = 0;
            
                for(TreasureKind t : specificHiddenTreasures){
                    if(t == tKind)
                        badC++;
                }
                
                for(Treasure t : h){
                    if(t.getType() == tKind)
                        jugador++;
                }
                
                for(int i = 0; i< min(jugador,badC); i++)
                    listaAjustadaHidden.add(tKind);
            }
            
            bcAjustado = new SpecificBadConsequence(getText(), 0, listaAjustadaVisibles, listaAjustadaHidden);
                  
        return bcAjustado;
    }
    
}
