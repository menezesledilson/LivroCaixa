package financeiro.VIEW.Fluxo;

import Conexao.conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.text.NumberFormat;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class frmCaixaAnual extends javax.swing.JInternalFrame {

    public frmCaixaAnual() {
        initComponents();
        carregaTabela();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblSaldoSaida = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDiarioAnual = new javax.swing.JTable();
        lblSaldoEntrada = new javax.swing.JLabel();
        lblLiquido = new javax.swing.JLabel();
        lblLiquidoMes = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Caixa Anual");

        lblSaldoSaida.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblSaldoSaida.setText("Total de saidas no ano");

        tbDiarioAnual.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data hora", "Descrição", "Entrada", "Saida", "Observação"
            }
        ));
        jScrollPane1.setViewportView(tbDiarioAnual);

        lblSaldoEntrada.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblSaldoEntrada.setText("Total de entradas no ano");

        lblLiquido.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblLiquido.setText("Total liquido Anual");

        lblLiquidoMes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblLiquidoMes.setText("Total liquido Mensal");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSaldoEntrada)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblSaldoSaida)
                .addGap(18, 18, 18)
                .addComponent(lblLiquido)
                .addGap(18, 18, 18)
                .addComponent(lblLiquidoMes)
                .addGap(203, 203, 203))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 912, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSaldoEntrada)
                    .addComponent(lblSaldoSaida)
                    .addComponent(lblLiquido)
                    .addComponent(lblLiquidoMes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
        tbDiarioAnual.getColumnModel().getColumn(1).setPreferredWidth(200);
        tbDiarioAnual.getColumnModel().getColumn(2).setPreferredWidth(30);
        tbDiarioAnual.getColumnModel().getColumn(3).setPreferredWidth(30);
        tbDiarioAnual.getColumnModel().getColumn(4).setPreferredWidth(200);
    }

    private void carregaTabela() {
        tamanhoTabela();
        DefaultTableModel modelo = (DefaultTableModel) tbDiarioAnual.getModel();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();

        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        tbDiarioAnual.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tbDiarioAnual.setDefaultEditor(Object.class, null);

        try {
            Connection con = conexao.getConnection();
            PreparedStatement pstm;
            ResultSet rs;

            double somaEntrada = 0;
            double somaSaida = 0;
            double liquido = 0;
            double liquidoMes = 0;

            pstm = con.prepareStatement("SELECT id, datahora, descricao, entrada, saida,observacao FROM livrocaixa order by id DESC;");
            rs = pstm.executeQuery();

            NumberFormat currencyEntrada = NumberFormat.getCurrencyInstance();
            NumberFormat currencySaida = NumberFormat.getCurrencyInstance();
            modelo.setNumRows(0);

            while (rs.next()) {
                Timestamp dataHora = rs.getTimestamp("datahora");

                // Formatar a data e hora para o formato brasileiro
                SimpleDateFormat formatoBrasileiro = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                String dataHoraFormatada = formatoBrasileiro.format(dataHora);

                double entrada = rs.getDouble("entrada");
                double saida = rs.getDouble("saida");

                modelo.addRow(new Object[]{
                    dataHoraFormatada,
                    rs.getString("descricao"),
                    currencyEntrada.format(entrada),
                    currencySaida.format(saida),
                    rs.getString("observacao"),});

                somaEntrada += entrada;
                somaSaida += saida;

                liquido = somaEntrada - somaSaida;
                liquidoMes = liquido / 12;
            }

            lblSaldoEntrada.setText("Total de entradas no ano " + NumberFormat.getCurrencyInstance().format(somaEntrada));
            lblSaldoSaida.setText("Total de saidas no ano  " + NumberFormat.getCurrencyInstance().format(somaSaida));
            lblLiquido.setText("Saldo Liquido anual  " + NumberFormat.getCurrencyInstance().format(liquido));
            lblLiquidoMes.setText("Saldo Liquido mensal  " + NumberFormat.getCurrencyInstance().format(liquidoMes));
            conexao.closeConnection(con, pstm, rs);
        } catch (Exception ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados: " + ErroSql, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLiquido;
    private javax.swing.JLabel lblLiquidoMes;
    private javax.swing.JLabel lblSaldoEntrada;
    private javax.swing.JLabel lblSaldoSaida;
    private javax.swing.JTable tbDiarioAnual;
    // End of variables declaration//GEN-END:variables
}
