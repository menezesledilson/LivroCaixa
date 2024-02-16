package financeiro.VIEW;

import Conexao.conexao;
import financeiro.DAO.BoletoDao;
import financeiro.MODEL.Boleto;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.time.LocalDate;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class frmBoleto extends javax.swing.JInternalFrame {

    public frmBoleto() {
        initComponents();
        carregaTabela();
        tamanhoTabela();
        desativarCampos();
        centralizarCampos();
        desativarBotao();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btNovo = new javax.swing.JButton();
        btGravar = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbBoleto = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        txtValor = new javax.swing.JTextField();
        txtDataVenc = new javax.swing.JFormattedTextField();
        cbxStatusPagamento = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtObs = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDataPag = new javax.swing.JFormattedTextField();
        btSalvarDae = new javax.swing.JButton();
        btAbrirDae = new javax.swing.JButton();

        setClosable(true);
        setTitle("Boletos");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setText("Descrição.:");

        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        btGravar.setText("Salvar");
        btGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGravarActionPerformed(evt);
            }
        });

        btEditar.setText("Alterar");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        tbBoleto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descrição", "R$", "Data venc.", "Data pag.", "Status", "Obs."
            }
        ));
        tbBoleto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbBoletoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbBoleto);

        jLabel2.setText("R$.:");

        jLabel3.setText("Data Venc.:");

        jLabel4.setText("Status Pag.:");

        try {
            txtDataVenc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        cbxStatusPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Pago", "Não Pago", "Pedente" }));

        jLabel5.setText("Obs.:");

        jLabel6.setText("Data Pag.:");

        try {
            txtDataPag.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btSalvarDae.setText("Salvar DAE");
        btSalvarDae.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarDaeActionPerformed(evt);
            }
        });

        btAbrirDae.setText("Abrir DAE");
        btAbrirDae.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAbrirDaeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btNovo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btGravar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btEditar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btExcluir)
                                .addGap(18, 18, 18)
                                .addComponent(btSalvarDae)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btAbrirDae)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDataVenc, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDataPag, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbxStatusPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtObs, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNovo)
                    .addComponent(btGravar)
                    .addComponent(btEditar)
                    .addComponent(btExcluir)
                    .addComponent(btSalvarDae)
                    .addComponent(btAbrirDae))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtDataVenc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtDataPag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(cbxStatusPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtObs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE))
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
  public void limparCampos() {
        txtDescricao.setText("");
        txtValor.setText("");
        txtDataVenc.setText("");
        cbxStatusPagamento.setSelectedItem("Selecione");
        txtDataPag.setText("");
        txtObs.setText("");
    }

    private void desativarCampos() {
        txtDescricao.setEnabled(false);
        txtValor.setEnabled(false);
        txtDataVenc.setEnabled(false);
        cbxStatusPagamento.setEnabled(false);
        txtDataPag.setEnabled(false);
        txtObs.setEnabled(false);

    }

    private void ativarCampos() {
        txtDescricao.setEnabled(true);
        txtValor.setEnabled(true);
        txtDataVenc.setEnabled(true);
        cbxStatusPagamento.setEnabled(true);
        txtDataPag.setEnabled(true);
        txtObs.setEnabled(true);
    }

    public void ativarBotao() {
        btGravar.setEnabled(true);
        btEditar.setEnabled(true);
        btExcluir.setEnabled(true);
    }

    public void desativarBotao() {
        btGravar.setEnabled(false);
        btEditar.setEnabled(false);
        btExcluir.setEnabled(false);
        btSalvarDae.setEnabled(false);
    }

    private void centralizarCampos() {
        txtDescricao.setHorizontalAlignment(SwingConstants.CENTER);
        txtValor.setHorizontalAlignment(SwingConstants.CENTER);
        txtDataVenc.setHorizontalAlignment(SwingConstants.CENTER);
        txtDataPag.setHorizontalAlignment(SwingConstants.CENTER);
        txtObs.setHorizontalAlignment(SwingConstants.CENTER);
    }
    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        ativarCampos();
        btGravar.setEnabled(true);
        btSalvarDae.setEnabled(true);
    }//GEN-LAST:event_btNovoActionPerformed
    private void tamanhoTabela() {
        tbBoleto.getColumnModel().getColumn(0).setPreferredWidth(100);
        tbBoleto.getColumnModel().getColumn(1).setPreferredWidth(50);
        tbBoleto.getColumnModel().getColumn(2).setPreferredWidth(50);
        tbBoleto.getColumnModel().getColumn(3).setPreferredWidth(50);
        tbBoleto.getColumnModel().getColumn(4).setPreferredWidth(50);
        tbBoleto.getColumnModel().getColumn(5).setPreferredWidth(200);
    }

    private void carregaTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tbBoleto.getModel();
        modelo.setNumRows(0);

        tamanhoTabela();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tbBoleto.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tbBoleto.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);

        try {
            Connection con = conexao.getConnection();
            PreparedStatement pstm;
            ResultSet rs;

            pstm = con.prepareStatement("SELECT * FROM boletos;");
            rs = pstm.executeQuery();

            NumberFormat currencyValor = NumberFormat.getCurrencyInstance();
            while (rs.next()) {

                modelo.addRow(new Object[]{
                    rs.getString("descricao"),
                    currencyValor.format(rs.getDouble("valor")),
                    rs.getString("datavencimento"),
                    rs.getString("datapagamento"),
                    rs.getString("statuspagamento"),
                    rs.getString("observacao"),});
            }

            conexao.closeConnection(con, pstm, rs);
        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados: " + ErroSql, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void btGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGravarActionPerformed
        Boleto c = new Boleto();
        BoletoDao dao = new BoletoDao();

        if (txtDescricao.getText().isEmpty() || txtValor.getText().isEmpty() || txtDataVenc.getText().isEmpty() || txtDataPag.getText().isEmpty()
                || cbxStatusPagamento.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de prosseguir.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String comissaoText = txtValor.getText().trim().replace(",", ".");
        double valorBoleto = Double.parseDouble(comissaoText);
        c.setValor(valorBoleto);

        c.setDescricao(txtDescricao.getText());
        c.setDataPagamento(txtDataPag.getText());
        c.setDataVencimento(txtDataVenc.getText());
        String statusPag = cbxStatusPagamento.getSelectedItem().toString();
        c.setStatusPag(statusPag);
        c.setObservacao(txtObs.getText());
        btGravar.setEnabled(false);
        dao.adicionar(c);
        carregaTabela();
        limparCampos();
        desativarCampos();
    }//GEN-LAST:event_btGravarActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        Boleto c = new Boleto();
        BoletoDao dao = new BoletoDao();

        int index = tbBoleto.getSelectedRow();
        c = dao.ListaBoleto().get(index);

        switch (JOptionPane.showConfirmDialog(null, " [--ALTERAÇÃO DE DADOS--] \n Dado Atual"
                + "\n Descrição:  " + c.getDescricao()
                + "\n R$: " + c.getValor()
                + "\n Data vencimento: " + c.getDataVencimento()
                + "\n Data pagamento: " + c.getDataPagamento()
                + "\n Status: " + c.getStatusPag()
                + "\n Obs: " + c.getObservacao()
                + "\n Será alterado "
                + "\n Descrição:  " + txtDescricao.getText()
                + "\n R$: " + txtValor.getText()
                + "\n Data vencimento: " + txtDataVenc.getText()
                + "\n Data pagamento: " + txtDataPag.getText()
                + "\n Status: " + cbxStatusPagamento.getSelectedIndex()
                + "\n Obs: " + txtObs.getText()
                + "\n Deseja realmente fazer alteração?",
                "Alteração de dados.  ", JOptionPane.YES_NO_OPTION)) {
            case 0:
                c.setDescricao(txtDescricao.getText());
                String valorText = txtValor.getText().trim().replace(",", ".");
                c.setValor(Double.parseDouble(valorText));
                c.setDataVencimento(txtDataVenc.getText());
                c.setDataPagamento(txtDataPag.getText());

                String statusPag = cbxStatusPagamento.getSelectedItem().toString();
                c.setStatusPag(statusPag);
                c.setObservacao(txtObs.getText());
                dao.alterar(c);
                carregaTabela();
                limparCampos();
                desativarCampos();
                btEditar.setEnabled(false);
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Nehuma exclusão foi feita.", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }//GEN-LAST:event_btEditarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        Boleto c = new Boleto();
        BoletoDao dao = new BoletoDao();

        int index = tbBoleto.getSelectedRow();
        c = dao.ListaBoleto().get(index);

        switch (JOptionPane.showConfirmDialog(null, "Deseja excluir o Produto ? \n "
                + "\n Descrição:  " + c.getDescricao()
                + "\n R$: " + c.getValor()
                + "\n Data vencimento: " + c.getDataVencimento()
                + "\n Data pagamento: " + c.getDataPagamento()
                + "\n Status: " + c.getStatusPag()
                + "\n Obs: " + c.getObservacao(),
                "Confirmação ", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
            case 0:
                dao.remover(c);
                carregaTabela();
                limparCampos();
                desativarCampos();
                btExcluir.setEnabled(false);
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Nehuma exclusão foi feita.", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void tbBoletoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbBoletoMouseClicked
        Boleto c = new Boleto();
        BoletoDao dao = new BoletoDao();

        int index = tbBoleto.getSelectedRow();
        c = dao.ListaBoleto().get(index);

        txtDescricao.setText(c.getDescricao());
        txtValor.setText(Double.toString(c.getValor()));
        txtDataVenc.setText(c.getDataVencimento());
        txtDataPag.setText(c.getDataPagamento());

        // Verifica se nenhum item foi selecionado
        if (cbxStatusPagamento.getSelectedIndex() == -1) {
            cbxStatusPagamento.addItem("Selecione");
            cbxStatusPagamento.addItem("Pago");
            cbxStatusPagamento.addItem("Não Pago");
            cbxStatusPagamento.addItem("Pendente");
        }

        txtObs.setText(c.getObservacao());
        btEditar.setEnabled(true);
        btExcluir.setEnabled(true);
        ativarCampos();
    }//GEN-LAST:event_tbBoletoMouseClicked

    private void btSalvarDaeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarDaeActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Escolha Arquivo PDF");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Arquivos PDF(*.pdf", "pdf"));

        int resultado = fileChooser.showOpenDialog(this);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File arquivoSelecionado = fileChooser.getSelectedFile();
            File directory = new File("C:\\SoftControl\\ControleFinanceiro\\dae");
            if (!directory.exists()) {
                directory.mkdirs(); // Cria o diretório se não existir
            }
            //Verifica se o arquivo tem extensão .pdf
            if (arquivoSelecionado.getName().toLowerCase().endsWith(".pdf")) {
                //Diretorio especifico
                File destino = new File("C:\\SoftControl\\ControleFinanceiro\\dae\\" + arquivoSelecionado.getName());
                try {
                    Files.copy(arquivoSelecionado.toPath(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING);

                    JOptionPane.showMessageDialog(this, "Aquivo salvo com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao  salvar o arquivo.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    ex.printStackTrace();
                }
            }

        }
    }//GEN-LAST:event_btSalvarDaeActionPerformed

    private void btAbrirDaeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAbrirDaeActionPerformed
        String diretorioDAE = "C:\\SoftControl\\ControleFinanceiro\\dae";
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();

                //Cria um seletor de arquivo
                JFileChooser fileChooser = new JFileChooser(diretorioDAE);
                fileChooser.setDialogTitle("Escolher Arquivo PDF");
                fileChooser.setFileFilter(new FileNameExtensionFilter("Arquivos PDF (*.pdf)", "pdf"));

                int resultado = fileChooser.showOpenDialog(this);

                if (resultado == JFileChooser.APPROVE_OPTION) {
                    File arquivoPDF = fileChooser.getSelectedFile();

                    //Verificar se o arquivo PDF é valido
                    if (arquivoPDF.exists() && arquivoPDF.isFile() && arquivoPDF.getName().toLowerCase().endsWith(".pdf")) {
                        desktop.open(arquivoPDF);
                    } else {

                    }
                } else {
                    // Se o usuário cancelou a escolha
                    JOptionPane.showMessageDialog(this, "Operação cancelada pelo usuário.", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                // Se a operação Desktop não é suportada
                JOptionPane.showMessageDialog(this, "A operação Desktop não é suportada nesta plataforma.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btAbrirDaeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAbrirDae;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btGravar;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSalvarDae;
    private javax.swing.JComboBox<String> cbxStatusPagamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbBoleto;
    private javax.swing.JFormattedTextField txtDataPag;
    private javax.swing.JFormattedTextField txtDataVenc;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtObs;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
