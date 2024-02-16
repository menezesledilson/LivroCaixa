package financeiro.VIEW.Mensal;

import financeiro.VIEW.Fluxo.*;
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
import java.time.LocalDate;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class frmCaixaMensal extends javax.swing.JInternalFrame {

    public frmCaixaMensal() {
        initComponents();
        desativarBotao();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblSaldoSaida = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDiarioMensal = new javax.swing.JTable();
        lblSaldoEntrada = new javax.swing.JLabel();
        lblLiquido = new javax.swing.JLabel();
        lblLiquidoMes = new javax.swing.JLabel();
        btPesquisa = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jDataInicial = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jDataFinal = new com.toedter.calendar.JDateChooser();
        btProcurar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Caixa Mensal");

        lblSaldoSaida.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblSaldoSaida.setText("Total de saidas no ano");

        tbDiarioMensal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data hora", "Descrição", "Entrada", "Saida", "Observação"
            }
        ));
        jScrollPane1.setViewportView(tbDiarioMensal);

        lblSaldoEntrada.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblSaldoEntrada.setText("Total de entradas no ano");

        lblLiquido.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblLiquido.setText("Total liquido Anual");

        lblLiquidoMes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblLiquidoMes.setText("Total liquido Mensal");

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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btPesquisa)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btProcurar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(lblSaldoEntrada)
                        .addGap(18, 18, 18)
                        .addComponent(lblSaldoSaida)
                        .addGap(18, 18, 18)
                        .addComponent(lblLiquido)
                        .addGap(18, 18, 18)
                        .addComponent(lblLiquidoMes)))
                .addContainerGap(221, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btPesquisa)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addComponent(jDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btProcurar)
                        .addGap(3, 3, 3)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSaldoEntrada)
                    .addComponent(lblSaldoSaida)
                    .addComponent(lblLiquido)
                    .addComponent(lblLiquidoMes))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 public void desativarBotao() {
        jDataInicial.setEnabled(false);
        jDataFinal.setEnabled(false);
        btProcurar.setEnabled(false);
    }
    private void btPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisaActionPerformed
        ativarBotao();
        jDataInicial.setDate(null);
        jDataFinal.setDate(null);

    }//GEN-LAST:event_btPesquisaActionPerformed
    public void ativarBotao() {
        jDataInicial.setEnabled(true);
        jDataFinal.setEnabled(true);
        btProcurar.setEnabled(true);
    }
    private Timestamp dataInicio;
    private Timestamp dataFim;

    private void btProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProcurarActionPerformed
        // Verificar se as datas inicial e final estão selecionadas
        if (jDataInicial.getDate() == null || jDataFinal.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione as datas inicial e final antes de realizar a pesquisa.", "Datas não Selecionadas", JOptionPane.WARNING_MESSAGE);
            return; // Abortar a operação se as datas não estiverem selecionadas
        }
        // Configurar a tabela como não editável e ajustar larguras das colunas
        tbDiarioMensal.setDefaultEditor(Object.class, null);
        DefaultTableModel modelo = (DefaultTableModel) tbDiarioMensal.getModel();
        TableColumnModel columnModel = tbDiarioMensal.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(5);  // Largura em pixels
        columnModel.getColumn(1).setPreferredWidth(100);
        columnModel.getColumn(2).setPreferredWidth(10);
        columnModel.getColumn(3).setPreferredWidth(10);
        columnModel.getColumn(4).setPreferredWidth(120);
        // Criar um renderizador centralizado
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tbDiarioMensal.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);

        try (Connection con = conexao.getConnection();
                PreparedStatement pstmBuscarVendas = con.prepareStatement("SELECT * FROM livrocaixa WHERE (datahora BETWEEN ? AND ?) OR (datahora BETWEEN ? AND ?)");) {
            java.sql.Timestamp dataInicio = new java.sql.Timestamp(jDataInicial.getDate().getTime());
            java.sql.Timestamp dataFim = new java.sql.Timestamp(jDataFinal.getDate().getTime());

            pstmBuscarVendas.setTimestamp(1, dataInicio);
            pstmBuscarVendas.setTimestamp(2, dataFim);
            pstmBuscarVendas.setTimestamp(3, dataInicio);
            pstmBuscarVendas.setTimestamp(4, dataFim);

            try (ResultSet rs = pstmBuscarVendas.executeQuery()) {
                double somaEntrada = 0;
                double somaSaida = 0;
                double liquido = 0;
                double liquidoMes = 0;

                NumberFormat currencyEntrada = NumberFormat.getCurrencyInstance();
                NumberFormat currencySaida = NumberFormat.getCurrencyInstance();
                modelo.setNumRows(0);
                while (rs.next()) {
                    Timestamp dataHora = rs.getTimestamp("datahora");
                    SimpleDateFormat formatoBrasileiro = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                    String dataHoraFormatada = formatoBrasileiro.format(dataHora);

                    double entrada = rs.getDouble("entrada");
                    double saida = rs.getDouble("saida");

                    modelo.addRow(new Object[]{
                        dataHoraFormatada,
                        rs.getString("descricao"),
                        currencyEntrada.format(entrada),
                        currencySaida.format(saida),
                        rs.getString("observacao")
                    });
                    somaEntrada += entrada;
                    somaSaida += saida;
                }
                liquido = somaEntrada - somaSaida;
                liquidoMes = liquido / 12;  

                lblSaldoEntrada.setText("Total de entradas no mês " + NumberFormat.getCurrencyInstance().format(somaEntrada));
                lblSaldoSaida.setText("Total de saidas no mês  " + NumberFormat.getCurrencyInstance().format(somaSaida));
                lblLiquido.setText("Saldo Liquido mensal  " + NumberFormat.getCurrencyInstance().format(liquido));
                lblLiquidoMes.setText("Saldo Liquido mensal  " + NumberFormat.getCurrencyInstance().format(liquidoMes));
            } catch (SQLException ErroSql) {
                JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados: " + ErroSql, "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        jDataInicial.setEnabled(false);
        jDataFinal.setEnabled(false);
        btProcurar.setEnabled(false);

    }//GEN-LAST:event_btProcurarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btPesquisa;
    private javax.swing.JButton btProcurar;
    private com.toedter.calendar.JDateChooser jDataFinal;
    private com.toedter.calendar.JDateChooser jDataInicial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLiquido;
    private javax.swing.JLabel lblLiquidoMes;
    private javax.swing.JLabel lblSaldoEntrada;
    private javax.swing.JLabel lblSaldoSaida;
    private javax.swing.JTable tbDiarioMensal;
    // End of variables declaration//GEN-END:variables
}
