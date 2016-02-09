/* encoding: utf-8
 */
package NapakalakiGame;

import java.util.*;
import GUI.Dice;
        
public class Player {
    
    private final int MAXLEVEL = 10;
    private String name;
    private int level;
    private boolean dead = true;
    private boolean canISteal = true;
    
    private ArrayList<Treasure> hiddenTreasures=null;
    private ArrayList<Treasure> visibleTreasures=null;
    private Player enemy=null;
    private BadConsequence pendingBadConsequence=null;
    
    public Player(String nombre){
        name=nombre;
        level=1;
        dead=true;
        canISteal=false;
        hiddenTreasures= new ArrayList();
        visibleTreasures = new ArrayList();
    }
    
    public Player(Player p){
        this.name=p.name;
        this.level=p.level;
        this.dead=p.dead;
        this.canISteal=p.canISteal;
        this.hiddenTreasures=p.hiddenTreasures;
        this.visibleTreasures=p.visibleTreasures;
    }
    
    public Player getEnemy(){
        return enemy;
    }
    
    public ArrayList<Treasure> getHiddenTreasures(){
        return hiddenTreasures;
    }
    
    public ArrayList<Treasure> getVisibleTreasures(){
        return visibleTreasures;
    }
    
    public String getName(){
        return name;
    }    
    
    private void bringToLife(){
        dead = false;
    }
    
    public int getCombatLevel(){
        int nivel_total=level;
           
        for(Treasure visibleTreasure : visibleTreasures) {
            nivel_total += visibleTreasure.getBonus();
        }
               
        return nivel_total;
    }
    
    private void incrementLevels(int i){
        level += i;
    }
    
    private void decrementLevels(int i){
        if((level-i)>=1)
            level -= i;
        else
            level=1;
    }
    
    private void setPendingBadConsequence(BadConsequence b){
      pendingBadConsequence=b;
    }
    
    public BadConsequence getPendingBadConsequence(){
      return pendingBadConsequence;
    }
    
    private void applyPrize(Monster m){
        int nLevels = m.getLevelsGained();
        incrementLevels(nLevels);
        int nTreasures = m.getTreasuresGained();
        if(nTreasures>0){
            CardDealer dealer = CardDealer.getInstance();
            for(int i=0; i<nTreasures; i++){
                Treasure treasure = dealer.nextTreasure();
                hiddenTreasures.add(treasure);
            }
        }
    }
    
    private void applyBadConsequence(Monster m){
        BadConsequence badConsequence = m.getBadConsequence();
        int nLevels = badConsequence.getLevels();
        decrementLevels(nLevels);
        BadConsequence pendingBad = badConsequence.adjustToFitTreasureLists(visibleTreasures, hiddenTreasures);
        setPendingBadConsequence(pendingBad);
    }
    
    private boolean canMakeTreasureVisible(Treasure t){
        TreasureKind type=t.getType();
        int tesoros_onehand=0;
       
        //HELMET
        if(type == TreasureKind.HELMET){
            for(Treasure treasure : visibleTreasures){
                if(treasure.getType() == TreasureKind.HELMET)
                    return false;
            }
            return true;
        }
        //ARMOR
        else if(type == TreasureKind.ARMOR){
            for(Treasure treasure : visibleTreasures){
                if(treasure.getType() == TreasureKind.ARMOR)
                    return false;
            }
            return true;
        }
        //ONEHAND
        else if(type == TreasureKind.ONEHAND){
            for(Treasure treasure : visibleTreasures){
                if(treasure.getType() == TreasureKind.ONEHAND)
                    tesoros_onehand++;
            }
            if(tesoros_onehand>1)
                return false;
            else{
                for(Treasure treasure : visibleTreasures){
                if(treasure.getType() == TreasureKind.BOTHHANDS)
                    return false;
                }
              return true;
            }
        }
        //BOTHHANDS
        else if(type == TreasureKind.BOTHHANDS){
            for(Treasure treasure : visibleTreasures){
                if(treasure.getType() == TreasureKind.BOTHHANDS || treasure.getType() == TreasureKind.ONEHAND)
                    return false;
            }
            return true;
        }
        //SHOE
        else{
            for(Treasure treasure : visibleTreasures){
                if(treasure.getType() == TreasureKind.SHOE)
                    return false;
            }
            return true;
        }
    }
    
    private int howManyVisibleTreasures(TreasureKind tKind){
        int total=0;
        for (Treasure visibleTreasure : visibleTreasures) {
            if (tKind == visibleTreasure.getType()) {
                total++;
            }
        }       
        return total;
    }
    
    private void dieIfNoTreasures(){
        if(hiddenTreasures.isEmpty() && visibleTreasures.isEmpty()){
            dead=true;
            level=1;
        }
    }
    
    public boolean isDead(){
        return dead;
    }

 
    public ArrayList<Treasure> getHiddenTreasuresList(){
        return hiddenTreasures;
    }
    
    public ArrayList<Treasure> getVisibleTreasuresList(){
        return visibleTreasures;
    }
    
    public CombatResult combat(Monster m){
        int myLevel = this.getCombatLevel();
        int monsterLevel =this.getOponentLevel(m);
        if(myLevel > monsterLevel){
            applyPrize(m);
            if(getLevels()>=MAXLEVEL)
                return CombatResult.WINGAME;
            else
                return CombatResult.WIN;
        }   
        else if(shouldConvert())
                return CombatResult.LOSEANDCONVERT;
        else{
            applyBadConsequence(m);
            return CombatResult.LOSE;
        }
    }
    
    public void makeTreasureVisible(Treasure t){
        boolean canI = canMakeTreasureVisible(t);
        if(canI){
            visibleTreasures.add(t);
            hiddenTreasures.remove(t);
        }
    }
    
    public void discardVisibleTreasure(Treasure t){
        visibleTreasures.remove(t);
        if((pendingBadConsequence!=null)&&(!pendingBadConsequence.isEmpty()))
            pendingBadConsequence.substractVisibleTreasure(t);
        
        dieIfNoTreasures();
    }
    
    public void discardHiddenTreasure(Treasure t){
        hiddenTreasures.remove(t);
        if((pendingBadConsequence!=null)&&(!pendingBadConsequence.isEmpty()))
            pendingBadConsequence.substractHiddenTreasure(t);
        
        dieIfNoTreasures();
    }
    
    public boolean validState(){        
        if(pendingBadConsequence == null)
            return true;
        else{
            System.out.println(pendingBadConsequence.toString());
            return (pendingBadConsequence.isEmpty() && hiddenTreasures.size()<=4);
        }
        }
        
    
    public void initTreasures(){
        CardDealer dealer = CardDealer.getInstance();
        Dice dice = Dice.getInstance();
        bringToLife();
        
        Treasure treasure = dealer.nextTreasure();
        hiddenTreasures.add(treasure);
        
        int number = dice.nextNumber();
        if(number>1){
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }
        if(number==6){
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }
    }
    
    public int getLevels(){
        return level;
    }
    
    public Treasure stealTreasure(){
        Treasure treasure;
        boolean canI = canISteal();
        boolean canYou = enemy.canYouGiveMeATreasure();
        if(canI && canYou){
            treasure = enemy.giveMeATreasure();
            hiddenTreasures.add(treasure);
            haveStolen();
            return treasure;
        }
        else
            return null;
    }
    
    public void setEnemy(Player enemy){
        this.enemy=enemy;
    }
    
    private Treasure giveMeATreasure(){
        int number = hiddenTreasures.size();
        int indice = (int) (Math.random()*number);
        Treasure robado=hiddenTreasures.get(indice);
        hiddenTreasures.remove(indice);
        return (robado);
    }
    
    public boolean canISteal(){
        return canISteal;
    }
    
    private boolean canYouGiveMeATreasure(){
        boolean can_you=true;
        if(hiddenTreasures.isEmpty())
             can_you = false;
         
        return can_you;
    }
    
    private void haveStolen(){
        canISteal=false;
    }
    
    public void discardAllTreasures(){
        ArrayList<Treasure>tV=new ArrayList(visibleTreasures);
        ArrayList<Treasure>tH=new ArrayList(hiddenTreasures);
        
        for(Treasure tesoro : tV)
            discardVisibleTreasure(tesoro);
        for(Treasure tesoro : tH)
            discardHiddenTreasure(tesoro);
    }
    
    protected int getOponentLevel(Monster m){
        return m.getCombatLevel();
    }
    
    protected boolean shouldConvert(){
        Dice dado = Dice.getInstance();
        if(dado.nextNumber()==1) 
            return true;
        else
            return false;
    }

    public String toString(){
        return name+"  CombatLevel -> ["+Integer.toString(getCombatLevel())+"]     PlayerLevel -> ["+Integer.toString(level)+"]";
    }
}
