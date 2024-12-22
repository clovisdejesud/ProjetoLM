package br.com.cfj.piuc10_maven.gui;

import br.com.cfj.piuc10_maven.persistencia.CadFamilia;
import br.com.cfj.piuc10_maven.persistencia.CadFamiliaDAO;
import br.com.cfj.piuc10_maven.persistencia.JPAUtil;
import jakarta.persistence.EntityManager;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class TelaListagemFamilia extends javax.swing.JFrame {

    private Set<Integer> linhasEditadas;

    private javax.swing.JTextField txtNomeFamilia;
    private javax.swing.JTextField txtNrIndividuo;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtObs;
    private javax.swing.JScrollPane jScrollPanel;
    private boolean pesquisarClicado = false;
    private boolean updating = false;
    private CadFamilia familiaAlterar = null;

    public TelaListagemFamilia() {
        initComponents();
        carregarDados();

        jPanel3 = new JPanel();
        jPanel3.setSize(800, 50);
        jPanel3.setLayout(new GridLayout(3, 1));
        lblCabecalho.setForeground(Color.WHITE);
        lblCabecalhoDep.setForeground(Color.WHITE);
        btnPesquisar.setBackground(Color.ORANGE);
        btnExcluir.setBackground(Color.ORANGE);
        btnAlterar.setBackground(Color.ORANGE);
        btnVoltar.setBackground(Color.ORANGE);

        txtNomeFamilia = new javax.swing.JTextField();
        txtNrIndividuo = new javax.swing.JTextField();
        txtEndereco = new javax.swing.JTextField();
        txtObs = new javax.swing.JTextField();

        add(txtNomeFamilia);
        add(txtNrIndividuo);
        add(txtEndereco);
        add(txtObs);

        linhasEditadas = new HashSet<>();

        try {
            configurarTabela();
            carregarDados();

            tblFamilia.getModel().addTableModelListener(event -> {
                if (event.getType() == TableModelEvent.UPDATE) {
                    int row = event.getFirstRow();
                    DefaultTableModel model = (DefaultTableModel) tblFamilia.getModel();

                    CadFamilia familia = new CadFamilia();
                    familia.setId((Integer) model.getValueAt(row, 0));
                    familia.setNomeFamilia((String) model.getValueAt(row, 1));
                    familia.setNrFamilia(Integer.parseInt(model.getValueAt(row, 2).toString()));
                    familia.setEndereco((String) model.getValueAt(row, 3));
                    familia.setObs((String) model.getValueAt(row, 4));

                    linhasEditadas.add(row);

                    System.out.println("Linha editada: " + row + ", Dados: " + familia);
                }
            });

            tblFamilia.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    int selectedRow = tblFamilia.getSelectedRow();
                    if (selectedRow != -1) {
                        DefaultTableModel model = (DefaultTableModel) tblFamilia.getModel();
                        txtNomeFamilia.setText((String) model.getValueAt(selectedRow, 1));
                        txtNrIndividuo.setText(model.getValueAt(selectedRow, 2).toString());
                        txtEndereco.setText((String) model.getValueAt(selectedRow, 3));
                        txtObs.setText((String) model.getValueAt(selectedRow, 4));
                    }
                }
            });

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar os dados" + e.getMessage());
            e.printStackTrace();
        }

    }

    private boolean verificarModificacaoNaTabela(int row) {
        return linhasEditadas.contains(row);
    }

    private boolean verificarConexao() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            List<?> result = em.createNativeQuery("SELECT nomeFamilia FROM cadfamilia WHERE id = 20").getResultList();
            return !result.isEmpty();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao CONECTAR" + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            JPAUtil.closeEtityManager();
        }
    }

    private void configurarTabela() {
        TableColumn ID = tblFamilia.getColumnModel().getColumn(0);
        ID.setMinWidth(40);
        ID.setMaxWidth(40);
        ID.setPreferredWidth(40);

        TableColumn Familia = tblFamilia.getColumnModel().getColumn(1);
        Familia.setPreferredWidth(20);

        TableColumn NrIndividuo = tblFamilia.getColumnModel().getColumn(2);
        NrIndividuo.setMinWidth(80);
        NrIndividuo.setMaxWidth(80);
        NrIndividuo.setPreferredWidth(80);

        TableColumn Endereco = tblFamilia.getColumnModel().getColumn(3);
        Endereco.setPreferredWidth(100);
    }

    private void carregarDados() {
        updating = true;
        try {
            CadFamiliaDAO dao = new CadFamiliaDAO();
            List<CadFamilia> listaFamilia = dao.listarTodas();
            DefaultTableModel model = (DefaultTableModel) tblFamilia.getModel();
            model.setRowCount(0);

            for (CadFamilia familia : listaFamilia) {
                model.addRow(new Object[]{
                    familia.getId(),
                    familia.getNomeFamilia(),
                    familia.getNrFamilia(),
                    familia.getEndereco(),
                    familia.getObs()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar os dados: " + e.getMessage());
        }
    }

    private void pesquisar(List<CadFamilia> listaFamilia) {
        updating = true;
        try {
            DefaultTableModel model = (DefaultTableModel) tblFamilia.getModel();
            model.setRowCount(0);

            for (CadFamilia familia : listaFamilia) {
                model.addRow(new Object[]{
                    familia.getId(),
                    familia.getNomeFamilia(),
                    familia.getNrFamilia(),
                    familia.getEndereco(),
                    familia.getObs()

                });
            }
        } finally {
            updating = false;
        }
    }

    private void alterarDados() {
        if (linhasEditadas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum linha editada");
            return;
        }
        try {
            CadFamiliaDAO dao = new CadFamiliaDAO();
            DefaultTableModel model = (DefaultTableModel) tblFamilia.getModel();

            for (Integer row : linhasEditadas) {
                CadFamilia f = new CadFamilia();
                f.setId((Integer) model.getValueAt(row, 0));
                f.setNomeFamilia((String) model.getValueAt(row, 1));

                Object nrIndividuosObj = model.getValueAt(row, 2);
                if (nrIndividuosObj instanceof Integer) {
                    f.setNrFamilia((Integer) nrIndividuosObj);
                } else {
                    try {
                        f.setNrFamilia(Integer.parseInt(nrIndividuosObj.toString()));
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Insira um número válido!");
                    }
                }
                f.setEndereco((String) model.getValueAt(row, 3));
                f.setObs((String) model.getValueAt(row, 4));

                dao.update(f);
            }

            JOptionPane.showMessageDialog(this, "Alteração salvas com sucesso");

            linhasEditadas.clear();
            carregarDados();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar as alterações" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
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
        tblFamilia = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnVoltar = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        filtroFamilia = new javax.swing.JTextField();

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
        setMaximumSize(getMaximumSize());
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(49, 49, 106));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 423));

        lblCabecalho.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblCabecalho.setText("C. E. C. DR. LUIZ MONTEIRO DE BARROS");

        lblCabecalhoDep.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        lblCabecalhoDep.setText("DEPARTAMENTO DE ASSISTÊNCIA SOCIAL");

        tblFamilia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Família", "Nr. Indivíduos", "Endereço", "Obs"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblFamilia);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(lblCabecalho, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(129, 129, 129)
                                .addComponent(lblCabecalhoDep, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 382, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2)))
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
            .addGap(0, 0, Short.MAX_VALUE)
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

        btnExcluir.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Yellow"));
        btnExcluir.setForeground(new java.awt.Color(0, 0, 0));
        btnExcluir.setText("Excluir");
        btnExcluir.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnAlterar.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Yellow"));
        btnAlterar.setForeground(new java.awt.Color(0, 0, 0));
        btnAlterar.setText("Alterar");
        btnAlterar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125)
                .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 20, Short.MAX_VALUE))
        );

        filtroFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtroFamiliaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(filtroFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(filtroFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 782, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 744, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(46, 46, 46))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void filtroFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtroFamiliaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filtroFamiliaActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        try {
            CadFamiliaDAO dao = new CadFamiliaDAO();
            DefaultTableModel model = (DefaultTableModel) tblFamilia.getModel();

            for (Integer row : linhasEditadas) {
                CadFamilia familia = new CadFamilia();
                familia.setId((Integer) model.getValueAt(row, 0));
                familia.setNomeFamilia((String) model.getValueAt(row, 1));
                familia.setNrFamilia(Integer.parseInt(model.getValueAt(row, 2).toString()));
                familia.setEndereco((String) model.getValueAt(row, 3));
                familia.setObs((String) model.getValueAt(row, 4));

                dao.update(familia);
            }

            linhasEditadas.clear();
            JOptionPane.showMessageDialog(this, "Dados atualizados");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar " + e.getMessage(), "Erro ", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        if (pesquisarClicado) {
            carregarDados();
            pesquisarClicado = false;
        } else {
            TelaMenu menu = new TelaMenu();
            menu.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        try {
            if (tblFamilia.getSelectedRow() >= 0) {

                Object idObj = tblFamilia.getValueAt(tblFamilia.getSelectedRow(), 0);
                String id = idObj != null ? idObj.toString() : "";
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja mesmo excluir o registro " + id + "?");
                if (resposta == JOptionPane.YES_NO_OPTION) {
                    CadFamiliaDAO dao = new CadFamiliaDAO();
                    dao.excluir(Integer.parseInt(id));
                    JOptionPane.showMessageDialog(this, "Registro excluído com sucesso");

                    btnPesquisarActionPerformed(evt);
                }

            } else {
                JOptionPane.showMessageDialog(this, "Selecione um registro");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocorreu uma falha:\n" + e.getMessage());
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed

        alterarDados();

    }//GEN-LAST:event_btnAlterarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaListagemFamilia.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaListagemFamilia.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaListagemFamilia.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaListagemFamilia.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaListagemFamilia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JTextField filtroFamilia;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCabecalho;
    private javax.swing.JLabel lblCabecalhoDep;
    private javax.swing.JTable tblFamilia;
    // End of variables declaration//GEN-END:variables
}
