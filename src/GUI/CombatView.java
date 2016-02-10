/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import NapakalakiGame.CombatResult;


public class CombatView extends javax.swing.JPanel {
    
    public CombatView() {
        initComponents();
        L_LOSE.setVisible(false);
        L_WIN.setVisible(false);
        L_LOSEANDCONVERT.setVisible(false);
        L_WINGAME.setVisible(false);
        repaint();
    }
    
    public void setCombatView(CombatResult cr){
        if(cr==CombatResult.LOSE){
            L_LOSE.setVisible(true);
            L_WIN.setVisible(false);
            L_LOSEANDCONVERT.setVisible(false);
        }
        else if(cr==CombatResult.WIN){
            L_WIN.setVisible(true);
            L_LOSE.setVisible(false);
            L_LOSEANDCONVERT.setVisible(false);
        }
        else if(cr==CombatResult.LOSEANDCONVERT){
            L_LOSEANDCONVERT.setVisible(true);
            L_WIN.setVisible(false);
            L_LOSE.setVisible(false);
        }
        else{
          L_WINGAME.setVisible(true);
          delay();
          System.exit(0);
        }
        
        repaint();
        revalidate();
    }
    
    public static void delay(){
        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){}
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    L_LOSE = new javax.swing.JLabel();
    L_LOSEANDCONVERT = new javax.swing.JLabel();
    L_WIN = new javax.swing.JLabel();
    L_WINGAME = new javax.swing.JLabel();

    L_LOSE.setFont(new java.awt.Font("Comfortaa", 1, 20)); // NOI18N
    L_LOSE.setForeground(new java.awt.Color(207, 16, 16));
    L_LOSE.setText("¡Has perdido el combate!");

    L_LOSEANDCONVERT.setFont(new java.awt.Font("Comfortaa", 1, 20)); // NOI18N
    L_LOSEANDCONVERT.setForeground(new java.awt.Color(253, 105, 4));
    L_LOSEANDCONVERT.setText("¡Te conviertes en sectario!");

    L_WIN.setFont(new java.awt.Font("Comfortaa", 1, 20)); // NOI18N
    L_WIN.setForeground(new java.awt.Color(46, 64, 208));
    L_WIN.setText("¡Has ganado el combate!");

    L_WINGAME.setFont(new java.awt.Font("Comfortaa", 1, 20)); // NOI18N
    L_WINGAME.setForeground(new java.awt.Color(40, 207, 16));
    L_WINGAME.setText("¡Has ganado la partida!");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(L_LOSEANDCONVERT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addComponent(L_WINGAME, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addComponent(L_LOSE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addComponent(L_WIN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(L_LOSE)
        .addGap(5, 5, 5)
        .addComponent(L_WIN)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(L_LOSEANDCONVERT, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(L_WINGAME, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    L_LOSE.getAccessibleContext().setAccessibleName("L_LOSE");
    L_LOSEANDCONVERT.getAccessibleContext().setAccessibleName("L_LOSEANDCONVERT");
    L_WIN.getAccessibleContext().setAccessibleName("L_WIN");
    L_WINGAME.getAccessibleContext().setAccessibleName("L_WINGAME");
  }// </editor-fold>//GEN-END:initComponents


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel L_LOSE;
  private javax.swing.JLabel L_LOSEANDCONVERT;
  private javax.swing.JLabel L_WIN;
  private javax.swing.JLabel L_WINGAME;
  // End of variables declaration//GEN-END:variables
}
