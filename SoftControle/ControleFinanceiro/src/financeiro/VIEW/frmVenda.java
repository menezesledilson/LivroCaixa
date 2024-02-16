package financeiro.VIEW;

import Conexao.conexao;
import financeiro.DAO.VendaDao;
import financeiro.MODEL.Vendas;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class frmVenda extends javax.swing.JInternalFrame {

    public frmVenda() {
        initComponents();
        carregaTabela();
        tamanhoTabela();
        desativarCampos();
        CentralizarCampos();
        desativarBotao();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btNovo = new javax.swing.JButton();
        btGravar = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCelular = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDataVenda = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbxAno = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbxPagamento = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtObs = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtComissao = new javax.swing.JTextField();
        lblSaldoComissao = new javax.swing.JLabel();
        btSalvarPdf = new javax.swing.JButton();
        btAbrirPDF = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbVenda = new javax.swing.JTable();
        txtPlaca = new javax.swing.JFormattedTextField();
        txtChassi = new javax.swing.JFormattedTextField();
        jSeparator1 = new javax.swing.JSeparator();

        setClosable(true);
        setResizable(true);
        setTitle("Controle de vendas");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

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

        jLabel1.setText("Nome.:");

        txtCliente.setNextFocusableComponent(txtCelular);

        jLabel2.setText("Cel.:");

        try {
            txtCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)# ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCelular.setNextFocusableComponent(txtDataVenda);

        jLabel3.setText("Data venda.:");

        try {
            txtDataVenda.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataVenda.setNextFocusableComponent(cbxPagamento);

        jLabel4.setText("Modelo.:");

        jLabel5.setText("Ano.:");

        cbxAno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "2069", "2068", "2067", "2066", "2065", "2064", "2063", "2062", "2061", "2060", "2059", "2058", "2057", "2056", "2055", "2054", "2053", "2052", "2051", "2050", "2049", "2048", "2047", "2046", "2045", "2044", "2043", "2042", "2041", "2040", "2039", "2038", "2037", "2036", "2035", "2034", "2033", "2032", "2031", "2030", "2029", "2028", "2027", "2026", "2025", "2024", "2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", " " }));
        cbxAno.setNextFocusableComponent(txtChassi);

        jLabel6.setText("Placa.:");

        jLabel7.setText("Chassi.:");

        jLabel8.setText("Status Pag.:");

        cbxPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "PIX", "À Vista", "Transf. Bancária" }));
        cbxPagamento.setNextFocusableComponent(txtComissao);

        jLabel9.setText("Obs.:");

        txtObs.setNextFocusableComponent(btGravar);

        jLabel10.setText("Comissão.:");

        txtComissao.setNextFocusableComponent(txtModelo);

        lblSaldoComissao.setText("Comissao");

        btSalvarPdf.setText("Salvar CRLV");
        btSalvarPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarPdfActionPerformed(evt);
            }
        });

        btAbrirPDF.setText("Abrir CRLV");
        btAbrirPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAbrirPDFActionPerformed(evt);
            }
        });

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

        try {
            txtPlaca.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("UUU-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtChassi.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("****.****.****.*****")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(jLabel2)
                                        .addGap(12, 12, 12)
                                        .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btNovo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btGravar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btEditar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btExcluir)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btSalvarPdf)
                                        .addGap(18, 18, 18)
                                        .addComponent(btAbrirPDF)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel8)
                                        .addGap(12, 12, 12)
                                        .addComponent(cbxPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel10)
                                        .addGap(12, 12, 12)
                                        .addComponent(txtComissao, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(96, 96, 96)
                                        .addComponent(lblSaldoComissao))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(6, 6, 6)
                                .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel5)
                                .addGap(12, 12, 12)
                                .addComponent(cbxAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addGap(12, 12, 12)
                                .addComponent(txtChassi, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel9)
                                .addGap(12, 12, 12)
                                .addComponent(txtObs, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 35, Short.MAX_VALUE))
                    .addComponent(jSeparator1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNovo)
                    .addComponent(btGravar)
                    .addComponent(btEditar)
                    .addComponent(btExcluir)
                    .addComponent(btSalvarPdf)
                    .addComponent(lblSaldoComissao)
                    .addComponent(btAbrirPDF))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtComissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addComponent(jLabel1))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel6))
                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbxAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel7))
                    .addComponent(txtChassi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtObs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void tbVendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbVendaMouseClicked
        ativarCampos();

        Vendas c = new Vendas();
        VendaDao dao = new VendaDao();

        int index = tbVenda.getSelectedRow();
        c = dao.listaVenda().get(index);

        txtCliente.setText(c.getNomeCliente());
        txtCelular.setText(c.getCelular());
        txtDataVenda.setText(c.getDataVenda());

        txtChassi.setText(c.getChassi());
        txtModelo.setText(c.getModelCarro());
        txtPlaca.setText(c.getPlacaCarro());

        txtComissao.setText(Double.toString(c.getComissao()));
        txtObs.setText(c.getObservacao());

        // Verifica se nenhum item foi selecionado
        if (cbxPagamento.getSelectedIndex() == -1) {
            cbxPagamento.addItem("Selecione");
            cbxPagamento.addItem("PIX");
            cbxPagamento.addItem("À Vista");
            cbxPagamento.addItem("Transf. Bancária");
        }

        cbxAno.addItem(String.valueOf(c.getAnoCarro()));
        // Define o ano selecionado como uma string
        cbxAno.setSelectedItem(String.valueOf(c.getAnoCarro()));

        btEditar.setEnabled(true);
        btExcluir.setEnabled(true);
        btNovo.setEnabled(false);
    }//GEN-LAST:event_tbVendaMouseClicked

    private void btAbrirPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAbrirPDFActionPerformed
        String diretorioCRLV = "C:\\SoftControl\\ControleFinanceiro\\crlv";
        try {
            // Verifica se a plataforma suporta a operação Desktop
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();

                // Cria um seletor de arquivo
                JFileChooser fileChooser = new JFileChooser(diretorioCRLV);
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
    }//GEN-LAST:event_btAbrirPDFActionPerformed

    private void btSalvarPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarPdfActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Escolha Arquivo PDF");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Arquivos PDF(*.pdf)", "pdf"));

        int resultado = fileChooser.showOpenDialog(this);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File arquivoSelecionado = fileChooser.getSelectedFile();
            File directory = new File("C:\\SoftControl\\ControleFinanceiro\\crlv");
            if (!directory.exists()) {
                directory.mkdirs(); // Cria o diretório se não existir
            }

            // Verifica se o arquivo tem extensão .pdf
            if (arquivoSelecionado.getName().toLowerCase().endsWith(".pdf")) {
                // Diretório específico "c:\control\crlv"
                File destino = new File("C:\\SoftControl\\ControleFinanceiro\\crlv\\" + arquivoSelecionado.getName());
                try {
                    Files.copy(arquivoSelecionado.toPath(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING);

                    JOptionPane.showMessageDialog(this, "Arquivo salvo com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao  salvar o arquivo.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

                    ex.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_btSalvarPdfActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        Vendas c = new Vendas();
        VendaDao dao = new VendaDao();

        int index = tbVenda.getSelectedRow();
        c = dao.listaVenda().get(index);

        switch (JOptionPane.showConfirmDialog(null, "Deseja excluir o Produto ? \n "
                + "\n Cliente:  " + c.getNomeCliente()
                + "\n Celular: " + c.getCelular()
                + "\n Data venda: " + c.getDataVenda()
                + "\n Status: " + c.getStatus()
                + "\n Comissão: " + c.getComissao()
                + "\n Modelo: " + c.getModelCarro()
                + "\n Placa: " + c.getPlacaCarro()
                + "\n Ano: " + c.getAnoCarro()
                + "\n Chassi: " + c.getChassi(),
                "Confirmação ", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
            case 0:
                dao.remover(c);
                carregaTabela();
                limparCampos();
                desativarCampos();
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Nehuma exclusão foi feita.", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        Vendas c = new Vendas();
        VendaDao dao = new VendaDao();

        int index = tbVenda.getSelectedRow();
        c = dao.listaVenda().get(index);

        switch (JOptionPane.showConfirmDialog(null, " [--ALTERAÇÃO DE DADOS--] \n Dado Atual"
                + "\n Cliente:  " + c.getNomeCliente()
                + "\n Celular: " + c.getCelular()
                + "\n Data venda: " + c.getDataVenda()
                + "\n Status: " + c.getStatus()
                + "\n Comissão: " + c.getComissao()
                + "\n Modelo: " + c.getModelCarro()
                + "\n Placa: " + c.getPlacaCarro()
                + "\n Ano: " + c.getAnoCarro()
                + "\n Chassi: " + c.getChassi()
                + "\n Será alterado "
                + "\n Cliente:  " + txtCliente.getText()
                + "\n Celular: " + txtCelular.getText()
                + "\n Data venda: " + txtDataVenda.getText()
                + "\n Status: " + cbxPagamento.getSelectedItem()
                + "\n Comissão: " + txtComissao.getText()
                + "\n Modelo: " + txtModelo.getText()
                + "\n Placa: " + txtPlaca.getText()
                + "\n Ano: " + cbxAno.getSelectedItem()
                + "\n Chassi: " + txtChassi.getText()
                + "\n Deseja realmente fazer alteração?",
                "Alteração de dados.  ", JOptionPane.YES_NO_OPTION)) {
            case 0:
                c.setNomeCliente(txtCliente.getText());
                c.setCelular(txtCelular.getText());
                c.setDataVenda(txtDataVenda.getText());
                String statusPag = cbxPagamento.getSelectedItem().toString();
                c.setStatus(statusPag);
                String comissaoText = txtComissao.getText().trim().replace(",", ".");
                c.setComissao(Double.parseDouble(comissaoText));
                c.setModelCarro(txtModelo.getText());
                c.setPlacaCarro(txtPlaca.getText());
                String anoCar = cbxAno.getSelectedItem().toString();
                c.setAnoCarro(Integer.valueOf(anoCar));
                c.setChassi(txtChassi.getText());

                dao.alterar(c);
                carregaTabela();
                limparCampos();
                desativarCampos();
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Nehuma exclusão foi feita.", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }//GEN-LAST:event_btEditarActionPerformed

    private void btGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGravarActionPerformed
        Vendas c = new Vendas();
        VendaDao dao = new VendaDao();

        if (txtCliente.getText().isEmpty() || txtCelular.getText().isEmpty() || txtDataVenda.getText().isEmpty()
                || cbxPagamento.getSelectedItem() == null || txtModelo.getText().isEmpty() || txtPlaca.getText().isEmpty()
                || cbxAno.getSelectedItem() == null || txtChassi.getText().isEmpty() || txtComissao.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de prosseguir.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String comissaoText = txtComissao.getText().trim().replace(",", ".");
        double comissao = Double.parseDouble(comissaoText);
        c.setComissao(comissao);
        c.setNomeCliente(txtCliente.getText());
        c.setCelular(txtCelular.getText());
        c.setDataVenda(txtDataVenda.getText());
        c.setModelCarro(txtModelo.getText().toUpperCase());
        c.setObservacao(txtObs.getText());
        String statusPag = cbxPagamento.getSelectedItem().toString();
        c.setStatus(statusPag);
        String anoCarro = cbxAno.getSelectedItem().toString();
        int anoCarroInt = Integer.parseInt(anoCarro);
        c.setAnoCarro(anoCarroInt);
        c.setPlacaCarro(txtPlaca.getText().toUpperCase());
        c.setChassi(txtChassi.getText().toUpperCase());

        dao.adicionar(c);
        carregaTabela();
        limparCampos();
        desativarCampos();
    }//GEN-LAST:event_btGravarActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        ativarCampos();
        btSalvarPdf.setEnabled(true);
        btGravar.setEnabled(true);
    }//GEN-LAST:event_btNovoActionPerformed
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

        // Configurar a tabela como não editável
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
    }
// Inicializado com um valor impossível para garantir a zeragem na primeira iteração
    private int mesAnterior = -1;
    private double comissaoAcumulada = 0.00;

    private void carregaTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tbVenda.getModel();
        modelo.setNumRows(0);

        tamanhoTabela();
        colunaTabela();

        try {
            Connection con = conexao.getConnection();
            PreparedStatement pstm;
            ResultSet rs;
            //Obter o mês atual
            int mesAtual = LocalDate.now().getMonthValue();
            //Verificar se houve uma mudança de mês
            if (mesAtual != mesAnterior) {
                //zerar a comissão acumulada quando mudar de mês
                comissaoAcumulada = 0.0;
                mesAnterior = mesAtual;
            }
            String sqlSomaComissao = "SELECT SUM (comissao) AS totalcomissao FROM venda WHERE EXTRACT(MONTH FROM datahora) = ?";

            pstm = con.prepareStatement(sqlSomaComissao);
            pstm.setInt(1, mesAtual);
            rs = pstm.executeQuery();

            double totalcomissao = 0.0;
            if (rs.next()) {
                totalcomissao = rs.getDouble("totalcomissao");
            }
            lblSaldoComissao.setText(" Comissões acumuladas no mês " + NumberFormat.getCurrencyInstance().format(totalcomissao));

            pstm = con.prepareStatement("SELECT datahora, cliente, celular, datavenda, nomecarro, anocarro, placacarro, chassicarro, pagamento, comissao, observacao FROM venda order by id DESC;");
            rs = pstm.executeQuery();

            NumberFormat currencyComissao = NumberFormat.getCurrencyInstance();

            while (rs.next()) {
                Timestamp dataHora = rs.getTimestamp("datahora");
                int mesDataHora = dataHora.toLocalDateTime().getMonthValue();
                // Formatar a data e hora para o formato brasileiro
                SimpleDateFormat formatoBrasileiro = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                String dataHoraFormatada = formatoBrasileiro.format(dataHora);

                // Somar a comissão apenas se estiver no mesmo mês
                if (mesDataHora == mesAtual) {
                    comissaoAcumulada += rs.getDouble("comissao");
                }
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

    public void limparCampos() {
        txtCliente.setText("");
        txtCelular.setText("");
        txtDataVenda.setText("");
        cbxPagamento.setSelectedItem("Selecione");
        cbxAno.setSelectedItem("Selecione");
        txtModelo.setText("");
        txtChassi.setText("");
        txtPlaca.setText("");
        txtComissao.setText("");
        txtObs.setText("");
    }

    private void desativarCampos() {
        txtCliente.setEnabled(false);
        txtCelular.setEnabled(false);
        txtDataVenda.setEnabled(false);
        cbxPagamento.setEnabled(false);
        txtModelo.setEnabled(false);
        txtChassi.setEnabled(false);
        cbxAno.setEnabled(false);
        txtPlaca.setEnabled(false);
        txtComissao.setEnabled(false);
        txtObs.setEnabled(false);
    }

    private void ativarCampos() {
        txtCliente.setEnabled(true);
        txtCelular.setEnabled(true);
        txtDataVenda.setEnabled(true);
        cbxPagamento.setEnabled(true);
        txtModelo.setEnabled(true);
        txtChassi.setEnabled(true);
        cbxAno.setEnabled(true);
        txtPlaca.setEnabled(true);
        txtComissao.setEnabled(true);
        txtObs.setEnabled(true);
    }

    public void ativarBotao() {
        btGravar.setEnabled(true);
        btEditar.setEnabled(true);
        btExcluir.setEnabled(true);
        btSalvarPdf.setEnabled(true);
    }

    public void desativarBotao() {
        btGravar.setEnabled(false);
        btEditar.setEnabled(false);
        btExcluir.setEnabled(false);
        btSalvarPdf.setEnabled(false);
    }

    private void CentralizarCampos() {
        txtCliente.setHorizontalAlignment(SwingConstants.CENTER);
        txtCelular.setHorizontalAlignment(SwingConstants.CENTER);
        txtDataVenda.setHorizontalAlignment(SwingConstants.CENTER);
        txtModelo.setHorizontalAlignment(SwingConstants.CENTER);
        txtChassi.setHorizontalAlignment(SwingConstants.CENTER);
        txtPlaca.setHorizontalAlignment(SwingConstants.CENTER);
        txtComissao.setHorizontalAlignment(SwingConstants.CENTER);
        txtObs.setHorizontalAlignment(SwingConstants.CENTER);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAbrirPDF;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btGravar;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSalvarPdf;
    private javax.swing.JComboBox<String> cbxAno;
    private javax.swing.JComboBox<String> cbxPagamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblSaldoComissao;
    private javax.swing.JTable tbVenda;
    private javax.swing.JFormattedTextField txtCelular;
    private javax.swing.JFormattedTextField txtChassi;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtComissao;
    private javax.swing.JFormattedTextField txtDataVenda;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtObs;
    private javax.swing.JFormattedTextField txtPlaca;
    // End of variables declaration//GEN-END:variables
}
