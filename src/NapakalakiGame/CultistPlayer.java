/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

/**
 *
 * @author Usuario
 */
public class CultistPlayer extends Player{
    
    private static int totalCultistPlayers=0;
    private Cultist myCultistCard;

    
    public CultistPlayer(Player p, Cultist c){
        super(p);
        this.myCultistCard=c;
        totalCultistPlayers++;
    }
    
   
    protected int getCombatLevel(){
        return 0; //temporal
    }
    
    protected int getOponentLevel(Monster m){
        return m.getBadConsequence().getLevels();
    }
    
    protected boolean shouldConvert(){
        return false; //temporal
    }
    
    private Treasure giveMeATreasure(){
        
    }
    
    private boolean canYouGiveMeATreasure(){
        return false; //temporal
    }
    
    public int getTotalCultistPlayers(){
        return totalCultistPlayers;
    }
}

