package br.com.cfj.piuc10_maven.gui;

import br.com.cfj.piuc10_maven.persistencia.CadIndividuo;
import br.com.cfj.piuc10_maven.persistencia.CadIndividuoDAO;
import br.com.cfj.piuc10_maven.persistencia.Helper;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;


public class TelaListagemIndividuo extends javax.swing.JFrame {

    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtCPF;
    private javax.swing.JTextField txtIdade;
    private javax.swing.JTextField txtTelefone;
    private javax.swing.JTextField txtNomeFamilia;
    private javax.swing.JTextField txtEscolaridade;
    private javax.swing.JTextField txtTrabalha;
    private javax.swing.JTextField txtObs;
    private Helper individuoHelper;
    private Set<Integer> linhasEditadas = new HashSet<>();
    private javax.swing.JScrollPane jScrollPanel;
    private boolean pesquisarClicado = false;
    private boolean updating = false;

    public TelaListagemIndividuo() {
        initComponents();
        individuoHelper = new Helper();

        jPanel3 = new JPanel();
        jPanel3.setSize(800, 50);
        jPanel3.setLayout(new GridLayout(3, 1));
        lblCabecalho.setForeground(Color.WHITE);
        lblCabecalhoDep.setForeground(Color.WHITE);
        btnVoltar.setBackground(Color.ORANGE);
        btnPesquisar.setBackground(Color.ORANGE);

        try {
            configurarTabela();
            individuoHelper.carregarDadosIndividuo((DefaultTableModel) tblIndividuo.getModel());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar os dados" + e.getMessage());
            e.printStackTrace();
        }
    }

    private void configurarTabela() {
        TableColumn ID = tblIndividuo.getColumnModel().getColumn(0);
        ID.setMinWidth(40);
        ID.setMaxWidth(40);
        ID.setPreferredWidth(40);

        TableColumn Nome = tblIndividuo.getColumnModel().getColumn(1);
        Nome.setMinWidth(150);
        Nome.setMaxWidth(150);
        Nome.setPreferredWidth(150);

        TableColumn CPF = tblIndividuo.getColumnModel().getColumn(2);
        CPF.setMinWidth(100);
        CPF.setMaxWidth(100);
        CPF.setPreferredWidth(100);

        TableColumn Idade = tblIndividuo.getColumnModel().getColumn(3);
        Idade.setMinWidth(50);
        Idade.setMaxWidth(50);
        Idade.setPreferredWidth(50);

        TableColumn Telefone = tblIndividuo.getColumnModel().getColumn(4);
        Telefone.setMinWidth(100);
        Telefone.setMaxWidth(100);
        Telefone.setPreferredWidth(100);

        TableColumn Familia = tblIndividuo.getColumnModel().getColumn(5);
        Familia.setMinWidth(80);
        Familia.setMaxWidth(80);
        Familia.setPreferredWidth(80);

    }

    private void pesquisar(List<CadIndividuo> listaIndividuo) {
        updating = true;
        try {
            DefaultTableModel model = (DefaultTableModel) tblIndividuo.getModel();
            model.setRowCount(0);

            for (CadIndividuo ind : listaIndividuo) {
                int idade = CadIndividuo.calcularIdade(ind.getDataNasc());
                model.addRow(new Object[]{
                    ind.getId(),
                    ind.getNome(),
                    ind.getCpf(),
                    idade,
                    ind.getTelefone(),
                    ind.getNomeFamilia(),
                    ind.getEscolaridade(),
                    ind.getTrabalha(),
                    ind.getObs()

                });
            }
        } finally {
            updating = false;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblCabecalho = new javax.swing.JLabel();
        lblCabecalhoDep = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblIndividuo = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnVoltar = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        filtroIndividuo = new javax.swing.JTextField();

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(49, 49, 106));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 423));

        lblCabecalho.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblCabecalho.setText("C. E. C. DR. LUIZ MONTEIRO DE BARROS");

        lblCabecalhoDep.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        lblCabecalhoDep.setText("DEPARTAMENTO DE ASSISTÊNCIA SOCIAL");

        tblIndividuo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "CPF", "Idade", "Telefone", "Familia", "Escolaridade", "Trabalha", "Obs"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblIndividuo);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(240, 240, 240)
                                .addComponent(lblCabecalho, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(261, 261, 261)
                                .addComponent(lblCabecalhoDep, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblCabecalho, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCabecalhoDep)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );

        jPanel3.setPreferredSize(new java.awt.Dimension(782, 50));

        btnVoltar.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Yellow"));
        btnVoltar.setForeground(new java.awt.Color(0, 0, 0));
        btnVoltar.setText("<<Voltar");
        btnVoltar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnPesquisar.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Yellow"));
        btnPesquisar.setForeground(new java.awt.Color(0, 0, 0));
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(btnVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                .addGap(317, 317, 317)
                .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 20, Short.MAX_VALUE))
        );

        jLabel7.setBackground(new java.awt.Color(49, 49, 106));
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Digite Nome ");
        jLabel7.setOpaque(true);

        filtroIndividuo.setToolTipText("Digite o nome a ser pesquisado");
        filtroIndividuo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtroIndividuoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(filtroIndividuo, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(filtroIndividuo)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 782, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(172, 172, 172))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)
                .addGap(86, 86, 86))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void filtroIndividuoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtroIndividuoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filtroIndividuoActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed

        TelaMenu menu = new TelaMenu();
        menu.setVisible(true);
        dispose();

    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        try {
            String filtro = filtroIndividuo.getText();
            CadIndividuoDAO dao = new CadIndividuoDAO();
            List<CadIndividuo> listaIndividuo = dao.pesquisar(filtro);
            pesquisar(listaIndividuo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        pesquisarClicado = true;
    }//GEN-LAST:event_btnPesquisarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaListagemIndividuo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaListagemIndividuo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaListagemIndividuo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaListagemIndividuo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaListagemIndividuo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JTextField filtroIndividuo;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCabecalho;
    private javax.swing.JLabel lblCabecalhoDep;
    private javax.swing.JTable tblIndividuo;
    // End of variables declaration//GEN-END:variables
}
