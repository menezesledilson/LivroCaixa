package controlefinanceiro.VIEW;

import controlefinanceiro.CONEXAO.conexao;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class InternalBuscaDiarioFinanceiroMensal extends javax.swing.JInternalFrame {

    public InternalBuscaDiarioFinanceiroMensal() {
        initComponents();
        desativarBotao();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btNovaPesquisa = new javax.swing.JButton();
        jDataInicial = new com.toedter.calendar.JDateChooser();
        jDataFinal = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btProcurarRegistro = new javax.swing.JButton();
        btImprimir = new javax.swing.JButton();
        btExcel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbFinanceiroMensal = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Diário Financeiro Mensal");

        btNovaPesquisa.setText("Nova Pesquisa");
        btNovaPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovaPesquisaActionPerformed(evt);
            }
        });

        jLabel1.setText("Data inicial");

        jLabel2.setText("Data Final");

        btProcurarRegistro.setText("Procurar Registro");
        btProcurarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProcurarRegistroActionPerformed(evt);
            }
        });

        btImprimir.setText("Imprimir");
        btImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImprimirActionPerformed(evt);
            }
        });

        btExcel.setText("Emitir Excel");
        btExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcelActionPerformed(evt);
            }
        });

        tbFinanceiroMensal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data hora", "Descrição", "Entrada", "Saida", "Observação"
            }
        ));
        jScrollPane1.setViewportView(tbFinanceiroMensal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btNovaPesquisa)
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btProcurarRegistro)
                .addGap(27, 27, 27)
                .addComponent(btImprimir)
                .addGap(18, 18, 18)
                .addComponent(btExcel)
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btNovaPesquisa)
                        .addComponent(btProcurarRegistro)
                        .addComponent(btImprimir)
                        .addComponent(jLabel1)
                        .addComponent(btExcel))
                    .addComponent(jDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel2)
                        .addComponent(jDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btProcurarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProcurarRegistroActionPerformed
        // Verificar se as datas inicial e final estão selecionadas
        if (jDataInicial.getDate() == null || jDataFinal.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione as datas inicial e final antes de realizar a pesquisa.", "Datas não Selecionadas", JOptionPane.WARNING_MESSAGE);
            return; // Abortar a operação se as datas não estiverem selecionadas
        }

        DefaultTableModel model = (DefaultTableModel) tbFinanceiroMensal.getModel();

        TableColumnModel columnModel = tbFinanceiroMensal.getColumnModel();

        columnModel.getColumn(0).setPreferredWidth(40);  // Largura em pixels
        columnModel.getColumn(1).setPreferredWidth(80);
        columnModel.getColumn(2).setPreferredWidth(20);
        columnModel.getColumn(3).setPreferredWidth(10);
        columnModel.getColumn(4).setPreferredWidth(100);

        // Criar um renderizador centralizado
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Aplicar o renderizador apenas à coluna datahora (índice 0)
        tbFinanceiroMensal.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);

        try (Connection con = conexao.getConnection()) {
            String sql = "SELECT * FROM livrocaixa WHERE (datahora BETWEEN ? AND ?) OR (datahora BETWEEN ? AND ?)";

            //Formatar o valor no campo jtable
            NumberFormat currencyValorEntrada = NumberFormat.getCurrencyInstance();
            NumberFormat currencyValorSaida = NumberFormat.getCurrencyInstance();

            // Armazene as datas de início e fim para uso posterior
            dataInicio = new java.sql.Timestamp(jDataInicial.getDate().getTime());
            dataFim = new java.sql.Timestamp(jDataFinal.getDate().getTime());

            try (PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setObject(1, new java.sql.Timestamp(jDataInicial.getDate().getTime()));
                pst.setObject(2, new java.sql.Timestamp(jDataFinal.getDate().getTime()));
                pst.setObject(3, new java.sql.Timestamp(jDataInicial.getDate().getTime()));
                pst.setObject(4, new java.sql.Timestamp(jDataFinal.getDate().getTime()));

                //linha para testar a consultar
                //  System.out.println("SQL: " + pst.toString());
                try (ResultSet rs = pst.executeQuery()) {
                    if (!rs.next()) {
                        //ResultSet está vazio, exibir mensagem
                        JOptionPane.showMessageDialog(this, "Consulta não encontrou dados com a data inicial e final fornecida.", "Sem Resultados", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        // Limpar todas as linhas existentes na tabela
                        model.setRowCount(0);
                        do {
                            Timestamp dataHora = rs.getTimestamp("datahora"); // Mova esta linha para dentro do do-while loop
                            // Formatar a data e hora para o formato brasileiro
                            SimpleDateFormat formatoBrasileiro = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                            String dataHoraFormatada = formatoBrasileiro.format(dataHora);

                            model.addRow(new Object[]{
                                dataHoraFormatada,
                                rs.getObject("descricao"),
                                currencyValorEntrada.format(rs.getDouble("entrada")),
                                currencyValorSaida.format(rs.getDouble("saida")),
                                rs.getString("observacao"),});
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
        btProcurarRegistro.setEnabled(false);
        btImprimir.setEnabled(true);
        btExcel.setEnabled(true);
    }//GEN-LAST:event_btProcurarRegistroActionPerformed

    private void btExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcelActionPerformed
        FileOutputStream excelFOU = null;
        BufferedOutputStream excelBOU = null;
        XSSFWorkbook excelJTableExporter = null;

        JFileChooser excelFileChooser = new JFileChooser("C:\\SoftControle\\ControleFinanceiro\\planilha");
        excelFileChooser.setDialogTitle("Save AS");

        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
        excelFileChooser.setFileFilter(fnef);
        int excelChooser = excelFileChooser.showSaveDialog(null);

        if (excelChooser == JFileChooser.APPROVE_OPTION) {
            excelJTableExporter = new XSSFWorkbook();
            XSSFSheet excelSheet = excelJTableExporter.createSheet("JTable Sheet");

            // Adiciona títulos das colunas à planilha
            DefaultTableModel model = (DefaultTableModel) tbFinanceiroMensal.getModel();
            int colCount = model.getColumnCount();
            XSSFRow titleRow = excelSheet.createRow(0);
            for (int j = 0; j < colCount; j++) {
                XSSFCell titleCell = titleRow.createCell(j);
                titleCell.setCellValue(model.getColumnName(j));
            }

            // Adiciona os dados da tabela à planilha
            int rowCount = model.getRowCount();
            for (int i = 0; i < rowCount; i++) {
                XSSFRow excelRow = excelSheet.createRow(i + 1); // +1 para evitar sobreposição com os títulos
                for (int j = 0; j < colCount; j++) {
                    XSSFCell exCell = excelRow.createCell(j);
                    Object cellValue = model.getValueAt(i, j);
                    if (cellValue != null) {
                        if (cellValue instanceof Number) {
                            // Insere o valor diretamente sem formatação específica
                            exCell.setCellValue(((Number) cellValue).doubleValue());
                        } else {
                            // Se não for número, mantém como texto
                            exCell.setCellValue(cellValue.toString());
                        }
                    } else {
                        exCell.setCellValue("");  // Ou você pode decidir como lidar com valores nulos
                    }
                }
            }

            // Define larguras personalizadas para cada coluna (ajuste conforme necessário)
            int[] columnWidths = {8000, 8000, 5000, 5000, 5000, 5000};
            for (int j = 0; j < colCount; j++) {
                excelSheet.setColumnWidth(j, columnWidths[j]);
            }

            try {
                // Obtém o arquivo selecionado
                File selectedFile = excelFileChooser.getSelectedFile();

                // Verifica se a extensão ".xlsx" já está presente no nome do arquivo
                String fileName = selectedFile.getName();
                if (!fileName.endsWith(".xlsx")) {
                    // Adiciona a extensão ".xlsx" ao nome do arquivo
                    selectedFile = new File(selectedFile.getAbsolutePath() + ".xlsx");
                }

                excelFOU = new FileOutputStream(selectedFile);
                excelBOU = new BufferedOutputStream(excelFOU);
                excelJTableExporter.write(excelBOU);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                Logger.getLogger(InternalDiarioFinanceiroAnual.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if (excelJTableExporter != null) {
                        excelJTableExporter.close();
                    }
                    if (excelBOU != null) {
                        excelBOU.close();
                    }
                    if (excelFOU != null) {
                        excelFOU.close();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        }
    }//GEN-LAST:event_btExcelActionPerformed

    private void btNovaPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovaPesquisaActionPerformed
        ativarBotao();
        jDataInicial.setDate(null);
        jDataFinal.setDate(null);
        btImprimir.setEnabled(false);
        btExcel.setEnabled(false);
    }//GEN-LAST:event_btNovaPesquisaActionPerformed
    private Timestamp dataInicio;
    private Timestamp dataFim;
    private void btImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImprimirActionPerformed
        Connection con = conexao.getConnection();
        //PreparedStatement pstm = null;
        try {
            String arq = "C:\\SoftControle\\ControleFinanceiro\\src\\controlefinanceiro\\Relatorio\\RelatorioPeriodoCaixa.jasper";
            Map<String, Object> parametros = new HashMap<>();

            // Use as datas de início e fim armazenadas como parâmetros
            if (dataInicio != null) {
                parametros.put("DataIn", new java.sql.Timestamp(dataInicio.getTime()));
            }
            if (dataFim != null) {
                parametros.put("DataFin", new java.sql.Timestamp(dataFim.getTime()));
            }

            JasperPrint jaspertPrint = JasperFillManager.fillReport(arq, parametros, con);
            JasperViewer view = new JasperViewer(jaspertPrint, false);
            view.setVisible(true);

        } catch (JRException ex) {
            System.out.println("Erro:" + ex);
        } finally {
            // Certifique-se de fechar a conexão
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        desativarBotao();
    }//GEN-LAST:event_btImprimirActionPerformed

    public void desativarBotao() {
        jDataInicial.setEnabled(false);
        jDataFinal.setEnabled(false);
        btExcel.setEnabled(false);
        btImprimir.setEnabled(false);
        btProcurarRegistro.setEnabled(false);
    }

    public void ativarBotao() {
        jDataInicial.setEnabled(true);
        jDataFinal.setEnabled(true);
        btProcurarRegistro.setEnabled(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btExcel;
    private javax.swing.JButton btImprimir;
    private javax.swing.JButton btNovaPesquisa;
    private javax.swing.JButton btProcurarRegistro;
    private com.toedter.calendar.JDateChooser jDataFinal;
    private com.toedter.calendar.JDateChooser jDataInicial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbFinanceiroMensal;
    // End of variables declaration//GEN-END:variables
}
