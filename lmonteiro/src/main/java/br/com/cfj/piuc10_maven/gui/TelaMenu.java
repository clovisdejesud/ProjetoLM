package br.com.cfj.piuc10_maven.gui;

import br.com.cfj.piuc10_maven.gui.TelaListagemFamilia;
import br.com.cfj.piuc10_maven.gui.TelaCadIndividuo;
import java.awt.Color;

public class TelaMenu extends javax.swing.JFrame {

    public TelaMenu() {
        initComponents();

        btnCadFamilia.setBackground(Color.ORANGE);
        btnConsultaFamilia.setBackground(Color.ORANGE);
        btnCadIndividuo.setBackground(Color.ORANGE);
        btnConsultaIndividuo.setBackground(Color.ORANGE);
        btnListaFamilia.setBackground(Color.ORANGE);
        btnListaIndividuo.setBackground(Color.ORANGE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblCabecalho = new javax.swing.JLabel();
        lblCabecalhoDep = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnCadFamilia = new javax.swing.JButton();
        btnCadIndividuo = new javax.swing.JButton();
        btnConsultaIndividuo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnListaIndividuo = new javax.swing.JButton();
        btnListaFamilia = new javax.swing.JButton();
        btnConsultaFamilia = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(49, 49, 106));

        lblCabecalho.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblCabecalho.setText("C. E. C. DR. LUIZ MONTEIRO DE BARROS");

        lblCabecalhoDep.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        lblCabecalhoDep.setText("DEPARTAMENTO DE ASSISTÊNCIA SOCIAL");

        jPanel2.setBackground(new java.awt.Color(185, 196, 203));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, new java.awt.Color(0, 0, 0)));

        jLabel3.setBackground(new java.awt.Color(49, 49, 60));
        jLabel3.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(49, 49, 106));
        jLabel3.setText("MENU");

        btnCadFamilia.setBackground(new java.awt.Color(204, 204, 204));
        btnCadFamilia.setForeground(new java.awt.Color(0, 0, 0));
        btnCadFamilia.setText("Cadastro de Família");
        btnCadFamilia.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 7, 1, 1));
        btnCadFamilia.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCadFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadFamiliaActionPerformed(evt);
            }
        });

        btnCadIndividuo.setBackground(new java.awt.Color(204, 204, 204));
        btnCadIndividuo.setForeground(new java.awt.Color(0, 0, 0));
        btnCadIndividuo.setText("Cadastro de Indivíduo");
        btnCadIndividuo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 7, 1, 1));
        btnCadIndividuo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCadIndividuo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadIndividuoActionPerformed(evt);
            }
        });

        btnConsultaIndividuo.setBackground(new java.awt.Color(204, 204, 204));
        btnConsultaIndividuo.setForeground(new java.awt.Color(0, 0, 0));
        btnConsultaIndividuo.setText("Consulta Individuo");
        btnConsultaIndividuo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 7, 1, 1));
        btnConsultaIndividuo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnConsultaIndividuo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaIndividuoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Clique em uma opção");

        btnListaIndividuo.setBackground(new java.awt.Color(204, 204, 204));
        btnListaIndividuo.setForeground(new java.awt.Color(0, 0, 0));
        btnListaIndividuo.setText("Listagem Indivíduos");
        btnListaIndividuo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 7, 1, 1));
        btnListaIndividuo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnListaIndividuo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaIndividuoActionPerformed(evt);
            }
        });

        btnListaFamilia.setBackground(new java.awt.Color(204, 204, 204));
        btnListaFamilia.setForeground(new java.awt.Color(0, 0, 0));
        btnListaFamilia.setText("Listagem Família");
        btnListaFamilia.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 7, 1, 1));
        btnListaFamilia.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnListaFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaFamiliaActionPerformed(evt);
            }
        });

        btnConsultaFamilia.setBackground(new java.awt.Color(204, 204, 204));
        btnConsultaFamilia.setForeground(new java.awt.Color(0, 0, 0));
        btnConsultaFamilia.setText("Consulta Família");
        btnConsultaFamilia.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 7, 1, 1));
        btnConsultaFamilia.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnConsultaFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaFamiliaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(219, 219, 219)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnCadFamilia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCadIndividuo, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
                .addContainerGap(70, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnListaIndividuo, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                            .addComponent(btnListaFamilia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnConsultaIndividuo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                            .addComponent(btnConsultaFamilia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnConsultaFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(btnCadFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCadIndividuo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addComponent(btnConsultaIndividuo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnListaFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnListaIndividuo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(lblCabecalho, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(lblCabecalhoDep, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(85, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblCabecalho, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCabecalhoDep)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultaIndividuoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaIndividuoActionPerformed
        TelaConsultaIndividuo ind = new TelaConsultaIndividuo();
        ind.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnConsultaIndividuoActionPerformed

    private void btnCadIndividuoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadIndividuoActionPerformed
        TelaCadIndividuo individuo = new TelaCadIndividuo();
        individuo.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCadIndividuoActionPerformed

    private void btnCadFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadFamiliaActionPerformed
        TelaCadFamilia familia = new TelaCadFamilia();
        familia.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCadFamiliaActionPerformed

    private void btnListaIndividuoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaIndividuoActionPerformed
        TelaListagemIndividuo ind = new TelaListagemIndividuo();
        ind.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnListaIndividuoActionPerformed

    private void btnListaFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaFamiliaActionPerformed
        TelaListagemFamilia f = new TelaListagemFamilia();
        f.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnListaFamiliaActionPerformed

    private void btnConsultaFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaFamiliaActionPerformed
        TelaConsultaFamilia consulta = new TelaConsultaFamilia();
        consulta.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnConsultaFamiliaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadFamilia;
    private javax.swing.JButton btnCadIndividuo;
    private javax.swing.JButton btnConsultaFamilia;
    private javax.swing.JButton btnConsultaIndividuo;
    private javax.swing.JButton btnListaFamilia;
    private javax.swing.JButton btnListaIndividuo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblCabecalho;
    private javax.swing.JLabel lblCabecalhoDep;
    // End of variables declaration//GEN-END:variables
}
