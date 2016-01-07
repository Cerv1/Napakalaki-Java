/* encoding: utf-8
 */
package NapakalakiGame;

import java.util.*;

public class Napakalaki{
    
    private static Napakalaki instance = null;
    
    private Player currentPlayer;
    private int currentPlayerIndex;
    private ArrayList<Player> players;
    private CardDealer dealer;
    private Monster currentMonster;
        
    public static Napakalaki getInstance(){
        if(instance==null)
            instance=new Napakalaki();
        return instance;
    }
 
    private Napakalaki(){
        currentPlayer=null;
        currentPlayerIndex=0;
        players=new ArrayList();
        dealer=CardDealer.getInstance();
        currentMonster=null;
    }
    
    private void initPlayers(ArrayList<String> names){
        for(String name : names){
            Player aux = new Player(name);
            players.add(aux);
        }
    }
    
    private Player nextPlayer(){       
        int x;
        Player nextPlayer;
        if(currentPlayer==null){
            Random random = new Random();
            x = random.nextInt(this.players.size());
        }
        else{
            currentPlayerIndex = this.players.indexOf(currentPlayer);
            if(currentPlayerIndex == players.size()-1)
                x=0;
            else{
                x=currentPlayerIndex+1;
            }
        }
        nextPlayer=players.get(x);
        this.currentPlayer=nextPlayer;
        return this.currentPlayer;
    }
    
    private boolean nextTurnIsAllowed(){
        if(currentPlayer==null)
            return true;
        else  
            return currentPlayer.validState();
    }
    
    private void setEnemies(){
        Random random = new Random();
        boolean distinto=false;
        for(int i=0; i<players.size(); i++){   
            int pos = random.nextInt(players.size());
            if(pos == i){
                while(!distinto){
                    pos=random.nextInt(players.size());
                    if(pos != i)
                        distinto=true;
                }    
            } 
            players.get(i).setEnemy(players.get(pos));
        }
    }
   
    public CombatResult developCombat(){
        CombatResult resultado = currentPlayer.combat(currentMonster);
        if(resultado==CombatResult.LOSEANDCONVERT){
            CultistPlayer newCultistPlayer = new CultistPlayer(currentPlayer, dealer.nextCultist());
            currentPlayer=newCultistPlayer;
            //Falta cambiarlo del enemies.
        }
        dealer.giveMonsterBack(currentMonster);
        return resultado;
    }
    
    public void discardVisibleTreasures(ArrayList<Treasure> treasures){
        for(Treasure tesoro : treasures){
            currentPlayer.discardVisibleTreasure(tesoro);
            dealer.giveTreasureBack(tesoro);
        }
    }   
    
    public void discardHiddenTreasures(ArrayList<Treasure> treasures){
        for(Treasure tesoro : treasures){
            currentPlayer.discardHiddenTreasure(tesoro);
            dealer.giveTreasureBack(tesoro);
        }   
    }
    
    public void makeTreasuresVisible(Treasure[] treasures){
        for(Treasure tesoro : treasures){
            currentPlayer.makeTreasureVisible(tesoro);
        }
    }
    
    public void initGame(ArrayList<String> players){
        initPlayers(players);
        setEnemies();
        dealer.initCards();
        nextTurn();
    }
    
    public Player getCurrentPlayer(){
        return currentPlayer;
    }
    
    public Monster getCurrentMonster(){
        return currentMonster;
    }
    
    public boolean nextTurn(){
        boolean stateOK = nextTurnIsAllowed();
        if(stateOK){
            currentMonster = dealer.nextMonster();
            currentPlayer = nextPlayer();      
            boolean dead = currentPlayer.isDead();
            if(dead)
                currentPlayer.initTreasures();
        }
        return stateOK;
    }
    
    public boolean endOfGame(CombatResult result){
        boolean resultado=false;
        if(result==CombatResult.WINGAME)
            resultado=true;
        return resultado;
    }    
}
