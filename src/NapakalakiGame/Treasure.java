/* encoding: utf-8
 */
package NapakalakiGame;

public class Treasure{
    
    private String name;
    private int bonus;  
    private TreasureKind type;
    
    public Treasure(String n, int bon, TreasureKind t){
        name=n;
        bonus=bon;
        type=t;
    }
    
    public String getName(){
        return name;
    }
    
    public int getBonus(){
        return bonus;
    }
    
    public TreasureKind getType(){
       return type;
    }
    
    public String toString(){
        return "Nombre: "+name+" Tipo: "+type+" Bonus: "+bonus;
    }
}
