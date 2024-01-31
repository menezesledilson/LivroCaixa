package controlefinanceiro.VIEW;

import controlefinanceiro.CONEXAO.conexaoBancoDados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class InternalDiarioFinanceiroAnual extends javax.swing.JInternalFrame {
    public InternalDiarioFinanceiroAnual() {
        initComponents();
        carregaTabela();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblSaldoAtual = new javax.swing.JLabel();
        btImprimir = new javax.swing.JButton();
        btExcel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDiarioAnual = new javax.swing.JTable();
        lblSaldoAnterior = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Diário Financeiro Anual");

        lblSaldoAtual.setText("Saldo anual");

        btImprimir.setText("Imprimir");

        btExcel.setText("Emitir Excel");

        tbDiarioAnual.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data hora", "Descrição", "Entrada", "Data Entrada", "Saida", "Data Saida"
            }
        ));
        jScrollPane1.setViewportView(tbDiarioAnual);

        lblSaldoAnterior.setText(" Saldo Anterior");

        jLabel1.setText("Saldo Atual.:");

        jLabel2.setText("Saldo Anterior.:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btImprimir)
                        .addGap(18, 18, 18)
                        .addComponent(btExcel)
                        .addGap(90, 90, 90)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(lblSaldoAtual)
                        .addGap(53, 53, 53)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblSaldoAnterior)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btImprimir)
                    .addComponent(lblSaldoAtual)
                    .addComponent(btExcel)
                    .addComponent(lblSaldoAnterior)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                .addContainerGap())
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

 private void carregaTabela() {

        DefaultTableModel modelo = (DefaultTableModel) tbDiarioAnual.getModel();

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        tbDiarioAnual.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tbDiarioAnual.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tbDiarioAnual.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        try {
            Connection con = conexaoBancoDados.getConnection();
            PreparedStatement pstm;
            ResultSet rs;

            Calendar cal = Calendar.getInstance();
            int mesAtual = cal.get(Calendar.MONTH) + 1;

            double saldoAtual = 0;
            double saldoAnterior = 0;
            pstm = con.prepareStatement("SELECT datahora, descricao, entrada,dataentrada, saida, datasaida FROM livrocaixa ORDER BY datahora ASC;");
            rs = pstm.executeQuery();

            NumberFormat currencyEntrada = NumberFormat.getCurrencyInstance();
            NumberFormat currencySaida = NumberFormat.getCurrencyInstance();
            modelo.setNumRows(0);
            while (rs.next()) {
                Timestamp dataHora = rs.getTimestamp("datahora");
                int mesDataHora = dataHora.toLocalDateTime().getMonthValue();

                if (mesDataHora != mesAtual) {
                    modelo.setNumRows(0);

                    lblSaldoAtual.setText("R$: 0.00");
                    lblSaldoAnterior.setText("0");

                    saldoAtual = 0;
                    saldoAnterior = 0;
                    // Atualiza o mês atual
                    mesAtual = mesDataHora;
                }
                // Calcula o saldoAtual para a linha atual
                double entrada = rs.getDouble("entrada");
                double saida = rs.getDouble("saida");
                //exibi o saldo anterior
                saldoAnterior = saldoAtual;
                saldoAtual += (entrada - saida);

                modelo.addRow(new Object[]{
                    dataHora,
                    rs.getString("descricao"),
                    currencyEntrada.format(entrada),
                    rs.getDate("dataentrada"),
                    currencySaida.format(saida),
                    rs.getDate("datasaida"),
                    currencySaida.format(saldoAtual)
                });
                // Atualiza os rótulos dentro do loop
                lblSaldoAtual.setText(currencySaida.format(saldoAtual));
                lblSaldoAnterior.setText(currencyEntrada.format(saldoAnterior));
            }
            conexaoBancoDados.closeConnection(con, pstm, rs);
        } catch (Exception ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados: " + ErroSql, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btExcel;
    private javax.swing.JButton btImprimir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSaldoAnterior;
    private javax.swing.JLabel lblSaldoAtual;
    private javax.swing.JTable tbDiarioAnual;
    // End of variables declaration//GEN-END:variables
}
