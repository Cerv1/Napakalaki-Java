/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;
import GUI.NapakalakiView;
import GUI.Dice;
/**
 *
 * @author cervi
 */
public class NewGame {
        
       public static void main(String[] args){
           Napakalaki game=Napakalaki.getInstance();
           NapakalakiView napakalakiView = new NapakalakiView();
           Dice.createInstance(napakalakiView);
           napakalakiView.setNapakalaki(game);
           napakalakiView.setVisible(true);y
       }
}