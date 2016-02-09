/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import NapakalakiGame.Napakalaki;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JFrame;


public class PlayerNamesCapture extends javax.swing.JDialog{

    ArrayList<String> names = new ArrayList();
    Napakalaki napakalaki = Napakalaki.getInstance();
    NapakalakiView napakalakiModel = new NapakalakiView();
    
    /**
     * Creates new form PlayerNamesCapture
     */
    public PlayerNamesCapture(JFrame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.addWindowListener (new WindowAdapter(){
            @Override
            public void windowClosing (WindowEvent e){
                System.exit(0);
            }
         });
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    L_Player2 = new javax.swing.JLabel();
    name2 = new javax.swing.JTextField();
    L_Player3 = new javax.swing.JLabel();
    L_Player1 = new javax.swing.JLabel();
    name1 = new javax.swing.JTextField();
    name3 = new javax.swing.JTextField();
    B_Play = new javax.swing.JButton();
    B_Cancel = new javax.swing.JButton();
    L_Title = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

    L_Player2.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
    L_Player2.setText("Player 2: ");

    name2.setName(""); // NOI18N

    L_Player3.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
    L_Player3.setText("Player 3: ");

    L_Player1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
    L_Player1.setText("Player 1: ");

    name1.setName(""); // NOI18N

    name3.setName(""); // NOI18N

    B_Play.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    B_Play.setText("Play!");
    B_Play.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        B_PlayActionPerformed(evt);
      }
    });

    B_Cancel.setText("Cancel");
    B_Cancel.setToolTipText("");
    B_Cancel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        B_CancelActionPerformed(evt);
      }
    });

    L_Title.setFont(new java.awt.Font("Lobster Two", 1, 40)); // NOI18N
    L_Title.setForeground(new java.awt.Color(202, 23, 29));
    L_Title.setText("napakalakiGame");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(51, 51, 51)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(L_Player2)
            .addComponent(L_Player1))
          .addComponent(L_Player3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGap(229, 229, 229)
            .addComponent(B_Play, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(103, 103, 103)
            .addComponent(B_Cancel))
          .addGroup(layout.createSequentialGroup()
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(name2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(name1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(name3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(70, 70, 70)
            .addComponent(L_Title, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap(118, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(B_Play, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(L_Title, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                  .addComponent(name1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(L_Player1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                  .addComponent(L_Player2)
                  .addComponent(name2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(L_Player3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(name3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(14, 14, 14)
            .addComponent(B_Cancel)))
        .addContainerGap(25, Short.MAX_VALUE))
    );

    L_Player2.getAccessibleContext().setAccessibleName("Player2");
    L_Player2.getAccessibleContext().setAccessibleDescription("");
    name2.getAccessibleContext().setAccessibleName("TF2");
    name2.getAccessibleContext().setAccessibleDescription("");
    L_Player3.getAccessibleContext().setAccessibleName("Player3");
    name3.getAccessibleContext().setAccessibleName("TF3");
    B_Play.getAccessibleContext().setAccessibleName("B_Play");
    B_Cancel.getAccessibleContext().setAccessibleName("B_Cancel");

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void B_PlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_PlayActionPerformed
      names.add(name1.getText());
      names.add(name2.getText());
      names.add(name3.getText());
      this.dispose();
    }//GEN-LAST:event_B_PlayActionPerformed

// Cancel
    private void B_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_CancelActionPerformed
      System.exit(0);
    }//GEN-LAST:event_B_CancelActionPerformed

    public ArrayList<String> getNames(){
        this.setVisible(true);
        return names;
    }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton B_Cancel;
  private javax.swing.JButton B_Play;
  private javax.swing.JLabel L_Player1;
  private javax.swing.JLabel L_Player2;
  private javax.swing.JLabel L_Player3;
  private javax.swing.JLabel L_Title;
  private javax.swing.JTextField name1;
  private javax.swing.JTextField name2;
  private javax.swing.JTextField name3;
  // End of variables declaration//GEN-END:variables
}
