/* encoding: utf-8
 */
package NapakalakiGame;

import static java.lang.StrictMath.min;
import java.util.*;

public class BadConsequence{
    static  final int MAXTREASURES=10;
    private String text;
    private int levels;
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    private boolean death;
    
    private ArrayList<TreasureKind> specificHiddenTreasures;
    private ArrayList<TreasureKind> specificVisibleTreasures;
    
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
    
    public int getNVisibleTreasures(){
        return nVisibleTreasures;
    }
    
    public int getNHiddenTreasures(){
        return nHiddenTreasures;
    }
    
    public ArrayList<TreasureKind> getSpecificHiddenTreasures(){
        return specificHiddenTreasures;
    }
    
    public ArrayList<TreasureKind> getSpecificVisibleTreasures(){
        return specificVisibleTreasures;
    }
    
    public void substractVisibleTreasure(Treasure t){
        if(nHiddenTreasures == -1 && nVisibleTreasures == -1){
            for(int i=0; i<specificVisibleTreasures.size(); i++){
                if(t.getType() == specificVisibleTreasures.get(i))
                    specificVisibleTreasures.remove(i);
            }
        }
        else
            nVisibleTreasures--;
    }
    
    public void substractHiddenTreasure(Treasure t){
        if(nHiddenTreasures == -1 && nVisibleTreasures == -1){
            for(int i=0; i<specificHiddenTreasures.size(); i++){
                if(t.getType() == specificHiddenTreasures.get(i))
                    specificHiddenTreasures.remove(i);
            }
        }
        else
            nHiddenTreasures--;
    }
    
    public BadConsequence(String texto, int niveles, int nVisible, int nHidden){
        levels=niveles;
        text=texto;
        death=false;
        nVisibleTreasures=nVisible;
        nHiddenTreasures=nHidden;
        specificHiddenTreasures = new ArrayList();
        specificVisibleTreasures = new ArrayList();       
    }
     
    public BadConsequence(String texto, int niveles, ArrayList<TreasureKind> v, ArrayList<TreasureKind> h){
        text=texto;
        levels=niveles;
        death=false;
        nVisibleTreasures=nHiddenTreasures=-1;
        specificHiddenTreasures = new ArrayList(h);
        specificVisibleTreasures = new ArrayList(v);        
    }
       
    public BadConsequence(String texto, boolean muerte){   
        text=texto;
        death=muerte;
        nVisibleTreasures=MAXTREASURES;
        nHiddenTreasures=MAXTREASURES;
        specificHiddenTreasures = new ArrayList();
        specificVisibleTreasures = new ArrayList();
    }
   
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){
        BadConsequence bcAjustado;
        
        if(specificVisibleTreasures == null && specificHiddenTreasures == null){
            int nVisible = (v.size() > nVisibleTreasures ? nVisibleTreasures : v.size());
            int nHidden = (h.size() > nHiddenTreasures ? nHiddenTreasures : h.size());
            bcAjustado = new BadConsequence(text, 0, nVisible,nHidden);
        }
        else{
            
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
            bcAjustado = new BadConsequence(text, 0, listaAjustadaVisibles, listaAjustadaHidden);
            
        }
        return bcAjustado;
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