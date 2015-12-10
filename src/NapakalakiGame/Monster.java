/* encoding: utf-8
 */
package NapakalakiGame;

public class Monster{
   
    private String name;
    private int combat_level; 
    private Prize prize;
    private BadConsequence badConsequence;
   
    public Monster(String nombre, int nivel, BadConsequence mr, Prize recompensa){
        name=nombre;
        combat_level=nivel;
        prize=recompensa;
        badConsequence=mr;
    }
 
    public String getName(){
        return name;
    }
    
    public int getCombatLevel(){
        return combat_level;
    }
 
    public BadConsequence getBadConsequence() {
        return badConsequence;
    }
   
    public int getLevelsGained(){
        return prize.getLevel();
    }
    
    public int getTreasuresGained(){
        return prize.getTreasures();
    }
    
    public String toString(){
        return  "\nName = "+ name
                + "\nCombatLevel = " + Integer.toString(combat_level) 
                +  "\n---REWARD---" + prize.toString()
                +  "\n---BAD CONSEQUENCE---\n" + badConsequence.toString();                
    }  
}
