package financeiro.VIEW.Fluxo;

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
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class frmDiarioVendaAnual extends javax.swing.JInternalFrame {

    public frmDiarioVendaAnual() {
        initComponents();
        carregaTabela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblSaldoComissao = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbVenda = new javax.swing.JTable();

        setClosable(true);
        setTitle("Venda Anual");

        lblSaldoComissao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblSaldoComissao.setText("Comissões acumuladas no mês");

        tbVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data Hora", "Data Venda", "Cliente", "Cel.", "Modelo", "Ano", "Placa", "Chassi", "Comissão", "Status"
            }
        ));
        tbVenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbVendaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbVenda);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1080, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSaldoComissao)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(lblSaldoComissao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void tamanhoTabela() {
        tbVenda.getColumnModel().getColumn(0).setPreferredWidth(150);
        tbVenda.getColumnModel().getColumn(1).setPreferredWidth(100);
        tbVenda.getColumnModel().getColumn(2).setPreferredWidth(250);
        tbVenda.getColumnModel().getColumn(3).setPreferredWidth(150);
        tbVenda.getColumnModel().getColumn(4).setPreferredWidth(150);
        tbVenda.getColumnModel().getColumn(6).setPreferredWidth(100);
        tbVenda.getColumnModel().getColumn(7).setPreferredWidth(190);
        tbVenda.getColumnModel().getColumn(8).setPreferredWidth(100);
        tbVenda.getColumnModel().getColumn(9).setPreferredWidth(100);
        tbVenda.setDefaultEditor(Object.class, null);
    }

    private void colunaTabela() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tbVenda.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tbVenda.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tbVenda.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        tbVenda.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
        tbVenda.getColumnModel().getColumn(7).setCellRenderer(centerRenderer);
        tbVenda.getColumnModel().getColumn(8).setCellRenderer(centerRenderer);
        tbVenda.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
    }

    private void carregaTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tbVenda.getModel();
        modelo.setNumRows(0);
        tamanhoTabela();
        colunaTabela();
        try {
            Connection con = conexao.getConnection();
            PreparedStatement pstm;
            ResultSet rs;

            String sqlSomaComissao = "SELECT SUM (comissao) AS totalcomissao FROM venda ";

            pstm = con.prepareStatement(sqlSomaComissao);
            rs = pstm.executeQuery();
            double totalcomissao = 0.0;

            if (rs.next()) {
                totalcomissao = rs.getDouble("totalcomissao");
            }

            lblSaldoComissao.setText(" Comissões acumuladas no ano. " + NumberFormat.getCurrencyInstance().format(totalcomissao));
            pstm = con.prepareStatement("SELECT datahora, cliente, celular, datavenda, nomecarro, anocarro, placacarro, chassicarro, pagamento, comissao, observacao FROM venda order by id DESC;");
            rs = pstm.executeQuery();

            NumberFormat currencyComissao = NumberFormat.getCurrencyInstance();

            while (rs.next()) {
                Timestamp dataHora = rs.getTimestamp("datahora");

                // Formatar a data e hora para o formato brasileiro
                SimpleDateFormat formatoBrasileiro = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                String dataHoraFormatada = formatoBrasileiro.format(dataHora);

                modelo.addRow(new Object[]{
                    dataHoraFormatada,
                    rs.getString("datavenda"),
                    rs.getString("cliente"),
                    rs.getString("celular"),
                    rs.getString("nomecarro"),
                    rs.getString("anocarro"),
                    rs.getString("placacarro"),
                    rs.getString("chassicarro"),
                    currencyComissao.format(rs.getDouble("comissao")),
                    rs.getString("pagamento"),
                    rs.getString("observacao"),});
            }

            conexao.closeConnection(con, pstm, rs);
        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados: " + ErroSql, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void tbVendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbVendaMouseClicked

    }//GEN-LAST:event_tbVendaMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblSaldoComissao;
    private javax.swing.JTable tbVenda;
    // End of variables declaration//GEN-END:variables
}
