/* encoding: utf-8
 */
package NapakalakiGame;

import java.util.Random;

public class Dice{
    
    private static Dice instance = null;
    
    private Dice(){
    }
    
    public static Dice getInstance(){
        if(instance==null)
            instance = new Dice();
        return instance;
    }
    
    public int nextNumber(){
        Random random=new Random();
        return random.nextInt(6)+1;
    }
}
