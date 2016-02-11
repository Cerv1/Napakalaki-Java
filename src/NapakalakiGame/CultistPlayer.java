/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;


public class CultistPlayer extends Player{
    
    private static int totalCultistPlayers=0;
    private Cultist myCultistCard;

    
    public CultistPlayer(Player p, Cultist c){
        super(p);
        this.myCultistCard=c;
        totalCultistPlayers++;
    }
    
   
    public int getCombatLevel(){
        int combatLevel=(int) (0.2*this.getLevels());
        combatLevel+=this.getLevels();
        combatLevel+=this.myCultistCard.getGainedLevels()*totalCultistPlayers;
        return combatLevel;
    }
    
    protected int getOponentLevel(Monster m){
        return (m.getBadConsequence().getLevels()+m.getCombatLevelAgainstCultistPlayer());
    }
    
    protected boolean shouldConvert(){
        return false;
    }
    
    private Treasure giveMeATreasure(){
        int number = this.getVisibleTreasuresList().size();
        int indice = (int) (Math.random()*number);
        Treasure robado=this.getVisibleTreasuresList().get(indice);
        this.getVisibleTreasuresList().remove(indice);
        return robado;
    }
    
    private boolean canYouGiveMeATreasure(){
        return getVisibleTreasuresList().isEmpty();
    }
    
    public static int getTotalCultistPlayers(){
        return totalCultistPlayers;
    }
}

