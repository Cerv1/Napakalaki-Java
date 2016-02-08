/* encoding: utf-8
 */
package NapakalakiGame;

public class Monster{
   
    private String name;
    private int combat_level; 
    private Prize prize;
    private BadConsequence badConsequence;
    private int levelChangeAgainstCultistPlayer=0;
   
    public Monster(String n, int l, BadConsequence bc, Prize p, int lC){
        name=n;
        combat_level=l;
        badConsequence=bc;
        prize=p;
        levelChangeAgainstCultistPlayer=lC;
    }
 
    public String getName(){
        return name;
    }
    
    public int getCombatLevel(){
        return combat_level;
    }
 
    public BadConsequence getBadConsequence(){
        return badConsequence;
    }
   
    public int getLevelsGained(){
        return prize.getLevel();
    }
    
    public int getTreasuresGained(){
        return prize.getTreasures();
    }
    
    public Prize getPrize(){
      return prize;
    }
    
    public int getCombatLevelAgainstCultistPlayer(){
        return (this.getCombatLevel()+levelChangeAgainstCultistPlayer);
    }
    
    public String toString(){
        return  "\nName = "+ name
                + "\nCombatLevel = " + Integer.toString(combat_level) 
                +  "\n---REWARD---" + prize.toString()
                +  "\n---BAD CONSEQUENCE---\n" + badConsequence.toString();                
    }  
}
