/*
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
 
    protected int getCombatLevel(){
        return this.getLevels();
    }
    
    protected int getOponentLevel(Monster m){
        return (m.getBadConsequence().getLevels()+m.getCombatLevelAgainstCultistPlayer());
    }
    
    protected boolean shouldConvert(){
        return false;
    }
    
    private Treasure giveMeATreasure(){
        
    }
    
    private boolean canYouGiveMeATreasure(){
        return false; //temporal
    }
    
    public static int getTotalCultistPlayers(){
        return totalCultistPlayers;
    }
}

