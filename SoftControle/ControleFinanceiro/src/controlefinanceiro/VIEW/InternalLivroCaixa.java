package controlefinanceiro.VIEW;

import controlefinanceiro.CONEXAO.conexao;
import controlefinanceiro.DAO.LivroCaixaDao;
import controlefinanceiro.MODEL.LivroCaixa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class InternalLivroCaixa extends javax.swing.JInternalFrame {

    public InternalLivroCaixa() {
        initComponents();
        carregaTabela();
        desativarBotao();
        desativarCampo();
    }

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
        lblSaldoAtual = new javax.swing.JLabel();
        btAlterar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        lblSaldoAnterior = new javax.swing.JLabel();
        btNovo = new javax.swing.JButton();
        txtObs = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Registro Contábil");

        tbLivroCaixa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data hora", "Descrição", "Entrada", "Saida", "Observação"
            }
        ));
        tbLivroCaixa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbLivroCaixaMouseClicked(evt);
            }
        });
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

        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        jLabel8.setText("Obs");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtObs, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btNovo)
                                .addGap(19, 19, 19)
                                .addComponent(btEntrada)
                                .addGap(18, 18, 18)
                                .addComponent(btSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btAlterar)
                                .addGap(30, 30, 30)
                                .addComponent(btExcluir))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(58, 58, 58)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSaldoAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSaldoAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(101, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btEntrada)
                    .addComponent(btSaida)
                    .addComponent(btAlterar)
                    .addComponent(btExcluir)
                    .addComponent(btNovo)
                    .addComponent(lblSaldoAtual))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSaldoAnterior))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtObs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 423, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        LivroCaixa l = new LivroCaixa();
        LivroCaixaDao dao = new LivroCaixaDao();

        int index = tbLivroCaixa.getSelectedRow();

        l = dao.ListaLivroCaixa().get(index);

        switch (JOptionPane.showConfirmDialog(null, "Deseja excluir a Informação ? \n "
                + "\n Descrição:  " + l.getDescricao()
                + "\n Entrada R$: " + l.getEntrada()
                + "\n Saida R$: " + l.getSaida()
                + "\n Obs: " + l.getObservacao()
                + "\n Será alterado"
                + " \n Descrição: " + txtDescricao.getText()
                + "\n Entrada R$: " + txtEntrada.getText()
                + "\n Saida R$: " + txtSaida.getText()
                + "\n Obs: " + txtObs.getText(),
                "Confirmação ", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
            case 0:
                dao.remover(l);
                carregaTabela();
                limpaCampo();
                btExcluir.setEnabled(false);

                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Nehuma exclusão foi feita.", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                break;
        }
        btExcluir.setEnabled(false);
        btAlterar.setEnabled(true);
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        LivroCaixa l = new LivroCaixa();
        LivroCaixaDao dao = new LivroCaixaDao();

        int index = tbLivroCaixa.getSelectedRow();
        l = dao.ListaLivroCaixa().get(index);

        switch (JOptionPane.showConfirmDialog(null,
                "[--ALTERAÇÃO DE DADOS--] \n Dado Atual"
                + "\n Descrição:  " + l.getDescricao()
                + "\n Entrada R$: " + l.getEntrada()
                + "\n Saida R$: " + l.getSaida()
                + "\n Obs: " + l.getObservacao()
                + "\n Será alterado"
                + " \n Descrição: " + txtDescricao.getText()
                + "\n Entrada R$: " + txtEntrada.getText()
                + "\n Saida R$: " + txtSaida.getText()
                + "\n Obs: " + txtObs.getText()
                + "\n Deseja realmente fazer alteração?",
                "Alteração de dados.", JOptionPane.YES_NO_OPTION)) {
            case 0:
                double novaEntrada = Double.parseDouble(txtEntrada.getText());
                double novaSaida = Double.parseDouble(txtSaida.getText());

                // Define os novos valores
                l.setDescricao(txtDescricao.getText());
                l.setEntrada(novaEntrada);
                l.setSaida(novaSaida);
                l.setObservacao(txtObs.getText());

                dao.alterarLivroCaixa(l);

                carregaTabela();
                desativarCampo();
                btAlterar.setEnabled(false);
                //limpaCampo();
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Nenhuma alteração foi feita.",
                        "AVISO", JOptionPane.INFORMATION_MESSAGE);
                break;
        }

    }//GEN-LAST:event_btAlterarActionPerformed

    private void btSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaidaActionPerformed
        LivroCaixa l = new LivroCaixa();
        LivroCaixaDao dao = new LivroCaixaDao();

        String saidaText = txtSaida.getText().trim().replace(",", ".");
        try {
            double saida = Double.parseDouble(saidaText);
            l.setSaida(saida);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Formato de número incorreto. Por favor, insira um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (saidaText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, insira os dados.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        l.setDescricao(txtDescricao.getText());

        l.setEntrada(0.0);

        l.setObservacao(txtObs.getText());

        dao.saida(l);
        // limparTexto();
        carregaTabela();
        btEntrada.setEnabled(false);

        btExcluir.setEnabled(false);
        desativarCampo();
    }//GEN-LAST:event_btSaidaActionPerformed

    private void btEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEntradaActionPerformed

        LivroCaixa l = new LivroCaixa();
        LivroCaixaDao dao = new LivroCaixaDao();

        String entradaText = txtEntrada.getText().trim().replace(",", ".");
        try {
            double entrada = Double.parseDouble(entradaText);
            l.setEntrada(entrada);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Formato de número incorreto. Por favor, insira um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (entradaText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, insira os dados.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        l.setDescricao(txtDescricao.getText());
        l.setObservacao(txtObs.getText());
        l.setSaida(0.0);
        dao.entrada(l);
        // limparTexto();
        carregaTabela();
        btSaida.setEnabled(false);

        btExcluir.setEnabled(false);
        desativarCampo();
    }//GEN-LAST:event_btEntradaActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        ativarBotao();
        ativarCampo();
        limpaCampo();
    }//GEN-LAST:event_btNovoActionPerformed

    private void tbLivroCaixaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbLivroCaixaMouseClicked

        LivroCaixa l = new LivroCaixa();
        LivroCaixaDao dao = new LivroCaixaDao();

        int index = tbLivroCaixa.getSelectedRow();
        l = dao.ListaLivroCaixa().get(index);

        txtDescricao.setText(l.getDescricao());
        txtEntrada.setText(Double.toString(l.getEntrada()));
        txtSaida.setText(Double.toString(l.getSaida()));

        txtObs.setText(l.getObservacao());

        btAlterar.setEnabled(true);
        btExcluir.setEnabled(true);
        btSaida.setEnabled(false);
        btEntrada.setEnabled(false);
        ativarCampo();

    }//GEN-LAST:event_tbLivroCaixaMouseClicked

    private void limpaCampo() {
        txtDescricao.setText(" ");
        txtEntrada.setText(" ");

        txtSaida.setText(" ");
        txtObs.setText(" ");
    }

    private void ativarBotao() {
        btEntrada.setEnabled(true);
        btSaida.setEnabled(true);
        btExcluir.setEnabled(true);
    }

    private void desativarBotao() {
        btEntrada.setEnabled(false);
        btSaida.setEnabled(false);
        btAlterar.setEnabled(false);
        btExcluir.setEnabled(false);
    }

    private void ativarCampo() {
        txtDescricao.setEnabled(true);
        txtEntrada.setEnabled(true);
        txtObs.setEnabled(true);
        txtSaida.setEnabled(true);

    }

    private void desativarCampo() {
        txtDescricao.setEnabled(false);
        txtEntrada.setEnabled(false);
        txtSaida.setEnabled(false);
        txtObs.setEnabled(false);
    }

    private void tamanhoTabela() {
        tbLivroCaixa.getColumnModel().getColumn(0).setPreferredWidth(100);
        tbLivroCaixa.getColumnModel().getColumn(1).setPreferredWidth(150);
    }

    private void carregaTabela() {
        tamanhoTabela();

        DefaultTableModel modelo = (DefaultTableModel) tbLivroCaixa.getModel();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        tbLivroCaixa.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);

        try {
            Connection con = conexao.getConnection();
            PreparedStatement pstm;
            ResultSet rs;

            double saldoAtual = 0;
            double saldoAnterior = 0;

            // Obter o mês e o ano atual
            Calendar cal = Calendar.getInstance();
            int mesAtual = cal.get(Calendar.MONTH) + 1; // Adicione 1 porque o mês é baseado em zero
            int anoAtual = cal.get(Calendar.YEAR);

            pstm = con.prepareStatement("SELECT id, datahora, descricao, entrada, saida, observacao FROM livrocaixa WHERE EXTRACT(MONTH FROM datahora) = ? AND EXTRACT(YEAR FROM datahora) = ? order by id DESC;");
            pstm.setInt(1, mesAtual);
            pstm.setInt(2, anoAtual);
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

                // Atualiza os saldos dentro do loop
                saldoAnterior = saldoAtual;
                saldoAtual += (entrada - saida);
            }

            lblSaldoAtual.setText("Saldo atual " + NumberFormat.getCurrencyInstance().format(saldoAtual));
            lblSaldoAnterior.setText("Saldo anterior " + NumberFormat.getCurrencyInstance().format(saldoAnterior));

            conexao.closeConnection(con, pstm, rs);
        } catch (Exception ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados: " + ErroSql, "ERRO", JOptionPane.ERROR_MESSAGE);
        }

        /* private void carregaTabela() {
        tamanhoTabela();

        DefaultTableModel modelo = (DefaultTableModel) tbLivroCaixa.getModel();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        tbLivroCaixa.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);

        try {
            Connection con = conexao.getConnection();
            PreparedStatement pstm;
            ResultSet rs;

            double saldoAtual = 0;
            double saldoAnterior = 0;

            // Obter o mês e o ano atual
            Calendar cal = Calendar.getInstance();
            int mesAtual = cal.get(Calendar.MONTH) + 1; // Adicione 1 porque o mês é baseado em zero
            int anoAtual = cal.get(Calendar.YEAR);

            pstm = con.prepareStatement("SELECT id, datahora, descricao, entrada, saida, observacao FROM livrocaixa WHERE EXTRACT(MONTH FROM datahora) = ? AND EXTRACT(YEAR FROM datahora) = ?;");
            pstm.setInt(1, mesAtual);
            pstm.setInt(2, anoAtual);
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

                // Atualiza os saldos dentro do loop
                saldoAnterior = saldoAtual;
                saldoAtual += (entrada - saida);
            }

            // Reiniciar os saldos para o próximo mês
            saldoAtual = 0;
            saldoAnterior = 0;

            lblSaldoAtual.setText("Saldo atual " + NumberFormat.getCurrencyInstance().format(saldoAtual));
            lblSaldoAnterior.setText("Saldo anterior " + NumberFormat.getCurrencyInstance().format(saldoAnterior));

            conexao.closeConnection(con, pstm, rs);
        } catch (Exception ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados: " + ErroSql, "ERRO", JOptionPane.ERROR_MESSAGE);
        }*/
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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSaldoAnterior;
    private javax.swing.JLabel lblSaldoAtual;
    private javax.swing.JTable tbLivroCaixa;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtEntrada;
    private javax.swing.JTextField txtObs;
    private javax.swing.JTextField txtSaida;
    // End of variables declaration//GEN-END:variables
}
