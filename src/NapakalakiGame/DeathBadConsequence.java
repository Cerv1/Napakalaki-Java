/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;


public class DeathBadConsequence extends NumericBadConsequence{
    
    private boolean death;
    
    public DeathBadConsequence(String t){
        super(t, 0, 0, 0);
        death=true;
    }
       public boolean getDeath(){
        return death;
    }
    
}
