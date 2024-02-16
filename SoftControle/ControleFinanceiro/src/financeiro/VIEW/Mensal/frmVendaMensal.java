package financeiro.VIEW.Mensal;

import financeiro.VIEW.Fluxo.*;
import Conexao.conexao;
import financeiro.VIEW.frmVenda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class frmVendaMensal extends javax.swing.JInternalFrame {

    public frmVendaMensal() {
        initComponents();
        desativarBotao();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblSaldoComissao = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbVendaMensal = new javax.swing.JTable();
        btPesquisa = new javax.swing.JButton();
        jDataInicial = new com.toedter.calendar.JDateChooser();
        jDataFinal = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btProcurar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Demonstrativo Mensal");
        setToolTipText("");

        lblSaldoComissao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblSaldoComissao.setText("Comissões acumuladas no mês");

        tbVendaMensal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data Venda", "Cliente", "Cel.", "Modelo", "Ano", "Placa", "Chassi", "Comissão", "Status"
            }
        ));
        tbVendaMensal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbVendaMensalMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbVendaMensal);

        btPesquisa.setText("Nova Pesquisa");
        btPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisaActionPerformed(evt);
            }
        });

        jLabel1.setText("Data Inicial");

        jLabel2.setText("Data Final");

        btProcurar.setText("Procurar ");
        btProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProcurarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1138, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btPesquisa)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btProcurar)
                .addGap(40, 40, 40)
                .addComponent(lblSaldoComissao)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDataFinal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btProcurar)
                        .addComponent(lblSaldoComissao))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1)
                        .addComponent(btPesquisa))
                    .addComponent(jDataInicial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
  public void desativarBotao() {
        jDataInicial.setEnabled(false);
        jDataFinal.setEnabled(false);
        btProcurar.setEnabled(false);
    }

    private void tbVendaMensalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbVendaMensalMouseClicked

    }//GEN-LAST:event_tbVendaMensalMouseClicked
    private Timestamp dataInicio;
    private Timestamp dataFim;

    private int mesAnterior = -1;
    private double comissaoAcumulada = 0.00;

    private void btProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProcurarActionPerformed
        // Verificar se as datas inicial e final estão selecionadas
        if (jDataInicial.getDate() == null || jDataFinal.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione as datas inicial e final antes de realizar a pesquisa.", "Datas não Selecionadas", JOptionPane.WARNING_MESSAGE);
            return;
        }
        // Configurar a tabela como não editável
        tbVendaMensal.setDefaultEditor(Object.class, null);

        DefaultTableModel model = (DefaultTableModel) tbVendaMensal.getModel();

        TableColumnModel columnModel = tbVendaMensal.getColumnModel();

        columnModel.getColumn(0).setPreferredWidth(40);  // Largura em pixels
        columnModel.getColumn(1).setPreferredWidth(100);
        columnModel.getColumn(2).setPreferredWidth(80);
        columnModel.getColumn(3).setPreferredWidth(100);
        columnModel.getColumn(4).setPreferredWidth(5);
        columnModel.getColumn(5).setPreferredWidth(25);
        columnModel.getColumn(6).setPreferredWidth(100);
        columnModel.getColumn(7).setPreferredWidth(50);
        columnModel.getColumn(8).setPreferredWidth(100);

        // Criar um renderizador centralizado
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        DefaultTableModel modelo = (DefaultTableModel) tbVendaMensal.getModel();
        modelo.setNumRows(0);

        tbVendaMensal.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tbVendaMensal.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tbVendaMensal.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        tbVendaMensal.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        tbVendaMensal.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);

        try (Connection con = conexao.getConnection()) {
            int mesAtual = LocalDate.now().getMonthValue();

            java.sql.Timestamp dataInicio = new java.sql.Timestamp(jDataInicial.getDate().getTime());
            java.sql.Timestamp dataFim = new java.sql.Timestamp(jDataFinal.getDate().getTime());

            // Consulta SQL para obter a soma da comissão para o mês da pesquisa e para as vendas dentro do intervalo de datas
            String sqlSomaComissaoPesquisa = "SELECT SUM(comissao) AS totalcomissao FROM venda WHERE EXTRACT(MONTH FROM datahora) = ? AND (datahora BETWEEN ? AND ?)";
            String sqlBuscarVendas = "SELECT * FROM venda WHERE (datahora BETWEEN ? AND ?) OR (datahora BETWEEN ? AND ?)";

            try (PreparedStatement pstmSomaComissao = con.prepareStatement(sqlSomaComissaoPesquisa);
                    PreparedStatement pstmBuscarVendas = con.prepareStatement(sqlBuscarVendas)) {
                pstmSomaComissao.setInt(1, jDataInicial.getCalendar().get(Calendar.MONTH) + 1);
                pstmSomaComissao.setTimestamp(2, dataInicio);
                pstmSomaComissao.setTimestamp(3, dataFim);

                ResultSet rsComissao = pstmSomaComissao.executeQuery();

                double totalComissaoPesquisa = 0.0;
                if (rsComissao.next()) {
                    totalComissaoPesquisa = rsComissao.getDouble("totalcomissao");
                }

                lblSaldoComissao.setText(" Comissões acumuladas no mês da pesquisa: " + NumberFormat.getCurrencyInstance().format(totalComissaoPesquisa));

                pstmBuscarVendas.setTimestamp(1, dataInicio);
                pstmBuscarVendas.setTimestamp(2, dataFim);
                pstmBuscarVendas.setTimestamp(3, dataInicio);
                pstmBuscarVendas.setTimestamp(4, dataFim);

                try (ResultSet rs = pstmBuscarVendas.executeQuery()) {
                    if (!rs.next()) {
                        JOptionPane.showMessageDialog(this, "Consulta não encontrou dados com a data inicial e final fornecida.", "Sem Resultados", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        model.setRowCount(0);
                        do {
                            model.addRow(new Object[]{
                                rs.getString("datavenda"),
                                rs.getString("cliente"),
                                rs.getString("celular"),
                                rs.getString("nomecarro"),
                                rs.getString("anocarro"),
                                rs.getString("placacarro"),
                                rs.getString("chassicarro"),
                                NumberFormat.getCurrencyInstance().format(rs.getDouble("comissao")),
                                rs.getString("pagamento"),
                                rs.getString("observacao")
                            });
                        } while (rs.next());
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        jDataInicial.setEnabled(false);
        jDataFinal.setEnabled(false);
        btProcurar.setEnabled(false);
    }//GEN-LAST:event_btProcurarActionPerformed
    public void ativarBotao() {
        jDataInicial.setEnabled(true);
        jDataFinal.setEnabled(true);
        btProcurar.setEnabled(true);
    }
    private void btPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisaActionPerformed
        ativarBotao();
        jDataInicial.setDate(null);
        jDataFinal.setDate(null);
        lblSaldoComissao.setText("");
    }//GEN-LAST:event_btPesquisaActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btPesquisa;
    private javax.swing.JButton btProcurar;
    private com.toedter.calendar.JDateChooser jDataFinal;
    private com.toedter.calendar.JDateChooser jDataInicial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblSaldoComissao;
    private javax.swing.JTable tbVendaMensal;
    // End of variables declaration//GEN-END:variables
}
