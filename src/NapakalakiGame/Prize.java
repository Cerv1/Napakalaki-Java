/* encoding: utf-8
 */
package NapakalakiGame;

public class Prize{
    
    private int treasures;
    private int level;
    
    public Prize(int tesoros, int nivel){
        treasures=tesoros;
        level=nivel;
    }
    
    public int getTreasures(){
        return treasures;
    }
    
    public int getLevel(){
        return level;
    }
    
    public String toString(){
        return "\nTreasures = " + Integer.toString(treasures)
                + "\nlevels = " + Integer.toString(level);
    }
}
