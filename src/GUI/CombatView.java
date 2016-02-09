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
        L_WINGAME.setVisible(false);
        
    }
    
    public void setCombatView(CombatResult cr){
        if(cr==CombatResult.LOSE){
            L_LOSE.setVisible(true);
            repaint();
            delay();
            L_LOSE.setVisible(false);
            repaint();
        }
        else if(cr==CombatResult.WIN){
            L_WIN.setVisible(true);
            L_LOSE.setVisible(false);
            L_WINGAME.setVisible(false);         
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
        L_WINGAME = new javax.swing.JLabel();
        L_WIN = new javax.swing.JLabel();
        L_WINGAME1 = new javax.swing.JLabel();

        L_LOSE.setFont(new java.awt.Font("Comfortaa", 1, 25)); // NOI18N
        L_LOSE.setForeground(new java.awt.Color(207, 16, 16));
        L_LOSE.setText("¡Has perdido el combate!");

        L_WINGAME.setFont(new java.awt.Font("Comfortaa", 1, 25)); // NOI18N
        L_WINGAME.setForeground(new java.awt.Color(207, 16, 16));
        L_WINGAME.setText("¡Te conviertes en secatior!");

        L_WIN.setFont(new java.awt.Font("Comfortaa", 1, 25)); // NOI18N
        L_WIN.setForeground(new java.awt.Color(207, 16, 16));
        L_WIN.setText("¡Has ganado el combate!");

        L_WINGAME1.setFont(new java.awt.Font("Comfortaa", 1, 25)); // NOI18N
        L_WINGAME1.setForeground(new java.awt.Color(207, 16, 16));
        L_WINGAME1.setText("¡Has ganado la partida!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(L_LOSE)
                    .addComponent(L_WIN)
                    .addComponent(L_WINGAME, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(L_WINGAME1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(L_LOSE)
                .addGap(5, 5, 5)
                .addComponent(L_WIN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(L_WINGAME, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(L_WINGAME1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel L_LOSE;
    private javax.swing.JLabel L_WIN;
    private javax.swing.JLabel L_WINGAME;
    private javax.swing.JLabel L_WINGAME1;
    // End of variables declaration//GEN-END:variables
}
