package controlefinanceiro.VIEW;

import controlefinanceiro.CONEXAO.conexaoBancoDados;
import controlefinanceiro.DAO.LivroCaixaDao;
import controlefinanceiro.MODEL.LivroCaixa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class InternalLivroCaixa extends javax.swing.JInternalFrame {

    public InternalLivroCaixa() {
        initComponents();
        carregaTabela();
    }
    private final SimpleDateFormat sdfC = new SimpleDateFormat("dd-MM-yyyy");
    private final SimpleDateFormat sdfE = new SimpleDateFormat("dd-MM-yyyy");

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbLivroCaixa = new javax.swing.JTable();
        btEntrada = new javax.swing.JButton();
        btSaida = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtEntrada = new javax.swing.JTextField();
        txtSaida = new javax.swing.JTextField();
        txtDataEntrada = new javax.swing.JFormattedTextField();
        txtDataSaida = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblSaldoAtual = new javax.swing.JLabel();
        btAlterar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        lblSaldoAnterior = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btNovo = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Registro Contábil");

        tbLivroCaixa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data hora", "Descrição", "Entrada", "Data Entrada", "Saida", "Data Saida"
            }
        ));
        jScrollPane1.setViewportView(tbLivroCaixa);

        btEntrada.setText("Entrada");
        btEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEntradaActionPerformed(evt);
            }
        });

        btSaida.setText("Saida");
        btSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaidaActionPerformed(evt);
            }
        });

        jLabel1.setText("Descrição.:");

        jLabel2.setText("Entrada.:");

        jLabel3.setText("Saida.:");

        try {
            txtDataEntrada.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtDataSaida.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel4.setText("Data ");

        jLabel5.setText("Data ");

        lblSaldoAtual.setText("0.0");

        btAlterar.setText("Alterar");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        lblSaldoAnterior.setText("0.0");

        jLabel6.setText("Saldo anterior.:");

        jLabel7.setText("Saldo atual.:");

        btNovo.setText("Novo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtEntrada)
                                    .addComponent(txtSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDataSaida)
                                    .addComponent(txtDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(177, 177, 177)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblSaldoAnterior))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btNovo)
                                .addGap(19, 19, 19)
                                .addComponent(btEntrada)
                                .addGap(18, 18, 18)
                                .addComponent(btSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btAlterar)
                                .addGap(30, 30, 30)
                                .addComponent(btExcluir)
                                .addGap(47, 47, 47)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblSaldoAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 146, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btEntrada)
                    .addComponent(btSaida)
                    .addComponent(btAlterar)
                    .addComponent(btExcluir)
                    .addComponent(btNovo)
                    .addComponent(jLabel7)
                    .addComponent(lblSaldoAtual))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(lblSaldoAnterior))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        LivroCaixa l = new LivroCaixa();
        LivroCaixaDao dao = new LivroCaixaDao();

        int index = tbLivroCaixa.getSelectedRow();

        l = dao.ListaLivroCaixa().get(index);

        switch (JOptionPane.showConfirmDialog(null, "Deseja excluir a Informção ? \n "
            + "\n Descrição:  " + l.getDescricao()
            + "\n Entrada R$: " + l.getEntrada()
            + "\n Data entrada R$: " + l.getDataEntrada()
            + "\n Saida R$: " + l.getSaida()
            + "\n Data Saida: " + l.getDataSaida()
            + "\n Será alterado"
            + " \n Descrição: " + txtDescricao.getText()
            + "\n Entrada R$: " + txtEntrada.getText()
            + "\n Data Entrada R$: " + txtDataEntrada.getText()
            + "\n Saida R$: " + txtSaida.getText()
            + "\n Data Saida R$: " + txtDataSaida.getText(),
            "Confirmação ", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
        case 0:
        dao.remover(l);
        carregaTabela();
        //  limparTexto();
        break;
        case 1:
        JOptionPane.showMessageDialog(null, "Nehuma exclusão foi feita.", "AVISO", JOptionPane.INFORMATION_MESSAGE);
        break;
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        /*    LivroCaixa l = new LivroCaixa();
        LivroCaixaDao dao = new LivroCaixaDao();

        int index = tbLivroCaixa.getSelectedRow();
        l = dao.ListaLivroCaixa().get(index);

        switch (JOptionPane.showConfirmDialog(null,
            "[--ALTERAÇÃO DE DADOS--] \n Dado Atual"
            + "\n Descrição:  " + l.getDescricao()
            + "\n Entrada R$: " + l.getEntrada()
            + "\n Data Entrada R$: " + l.getDataEntrada()
            + "\n Saida R$: " + l.getSaida()
            + "\n Data Saida R$: " + l.getDataSaida()
            + "\n Será alterado"
            + " \n Descrição: " + txtDescricao.getText()
            + "\n Entrada R$: " + txtEntrada.getText()
            + "\n Data Entrada R$: " + txtDataEntrada.getText()
            + "\n Saida R$: " + txtSaida.getText()
            + "\n Data Saida R$: " + txtDataSaida.getText()
            + "\n Deseja realmente fazer alteração?",
            "Alteração de dados.", JOptionPane.YES_NO_OPTION)) {
        case 0:
        double novaEntrada = Double.parseDouble(txtEntrada.getText());
        double novaSaida = Double.parseDouble(txtSaida.getText());
        // Verifica se houve alteração na entrada
        if (novaEntrada != l.getEntrada()) {
            l.setEntrada(novaEntrada);
            dao.entrada(l);
        }
        // Verifica se houve alteração na saída
        if (novaSaida != l.getSaida()) {
            l.setSaida(novaSaida);
            dao.saida(l);
        }
        carregaTabela();
        //limparTexto();
        break;
        case 1:
        JOptionPane.showMessageDialog(null, "Nenhuma alteração foi feita.",
            "AVISO", JOptionPane.INFORMATION_MESSAGE);
        break;
        }*/
    }//GEN-LAST:event_btAlterarActionPerformed

    private void btSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaidaActionPerformed
        LivroCaixa l = new LivroCaixa();
        LivroCaixaDao dao = new LivroCaixaDao();

        String saidaText = txtSaida.getText().trim();
        if (saidaText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, insira os dados de saída.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        l.setDescricao(txtDescricao.getText());
        l.setSaida(Double.parseDouble(txtSaida.getText()));
        l.setEntrada(0.0);

        try {
            java.util.Date dataFormatada = sdfE.parse(txtDataSaida.getText());
            java.sql.Date dataSQL = new java.sql.Date(dataFormatada.getTime());
            l.setDataSaida(dataSQL);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Formato de data incorreto. Por favor, insira a data no formato correto (dd-MM-yyyy).", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        dao.saida(l);
        // limparTexto();
        carregaTabela();
    }//GEN-LAST:event_btSaidaActionPerformed

    private void btEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEntradaActionPerformed

        LivroCaixa l = new LivroCaixa();
        LivroCaixaDao dao = new LivroCaixaDao();

        String entradaText = txtEntrada.getText().trim();

        if (entradaText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, insira os dados de saída.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        l.setDescricao(txtDescricao.getText());
        l.setEntrada(Double.parseDouble(txtEntrada.getText()));
        l.setSaida(0.0);

        try {
            java.util.Date dataFormatada = sdfC.parse(txtDataEntrada.getText());
            java.sql.Date dataSQL = new java.sql.Date(dataFormatada.getTime());
            l.setDataEntrada(dataSQL);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Formato de data incorreto. Por favor, insira a data no formato correto (dd-MM-yyyy).", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        dao.entrada(l);
        // limparTexto();
        carregaTabela();
    }//GEN-LAST:event_btEntradaActionPerformed

    private void carregaTabela() {

        DefaultTableModel modelo = (DefaultTableModel) tbLivroCaixa.getModel();

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        tbLivroCaixa.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tbLivroCaixa.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tbLivroCaixa.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
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
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btEntrada;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSaida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSaldoAnterior;
    private javax.swing.JLabel lblSaldoAtual;
    private javax.swing.JTable tbLivroCaixa;
    private javax.swing.JFormattedTextField txtDataEntrada;
    private javax.swing.JFormattedTextField txtDataSaida;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtEntrada;
    private javax.swing.JTextField txtSaida;
    // End of variables declaration//GEN-END:variables
}
