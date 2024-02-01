package controlefinanceiro.VIEW;

import controlefinanceiro.CONEXAO.conexaoBancoDados;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.parser.DTDConstants;
import static org.apache.commons.math3.fitting.leastsquares.LeastSquaresFactory.model;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.excelant.ExcelAntEvaluateCell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;

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

        btExcel.setText("Exporta Excel");
        btExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcelActionPerformed(evt);
            }
        });

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
            DefaultTableModel model = (DefaultTableModel) tbDiarioAnual.getModel();
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
    public class DateRenderer extends DefaultTableCellRenderer {

        final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        @Override
        public void setValue(Object value) {
            if (value instanceof Date) {
                value = dateFormat.format((Date) value);
            }
            super.setValue(value);
        }
    }

    private void carregaTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tbDiarioAnual.getModel();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        DateRenderer dateRenderer = new DateRenderer();

        tbDiarioAnual.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tbDiarioAnual.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);

        try {
            Connection con = conexaoBancoDados.getConnection();
            PreparedStatement pstm;
            ResultSet rs;

        //    Calendar cal = Calendar.getInstance();
          //  int mesAtual = cal.get(Calendar.MONTH) + 1;

            double saldoAtual = 0;
            double saldoAnterior = 0;
            pstm = con.prepareStatement("SELECT datahora, descricao, entrada, dataentrada, saida, datasaida FROM livrocaixa ORDER BY datahora ASC;");
            rs = pstm.executeQuery();

            NumberFormat currencyEntrada = NumberFormat.getCurrencyInstance();
            NumberFormat currencySaida = NumberFormat.getCurrencyInstance();
            modelo.setNumRows(0);

            while (rs.next()) {
                Timestamp dataHora = rs.getTimestamp("datahora");
                int mesDataHora = dataHora.toLocalDateTime().getMonthValue();
/*
                if (mesDataHora != mesAtual) {
                    modelo.setNumRows(0);
                    lblSaldoAtual.setText("R$: 0.00");
                    lblSaldoAnterior.setText("0");
                    saldoAtual = 0;
                    saldoAnterior = 0;
                    mesAtual = mesDataHora; // Atualiza o mês atual
                }*/

                double entrada = rs.getDouble("entrada");
                double saida = rs.getDouble("saida");

                // Verifica se as datas não são nulas antes de formatá-las
                String dataEntradaFormatted = (rs.getDate("dataentrada") != null) ? dateRenderer.dateFormat.format(rs.getDate("dataentrada")) : "";
                String dataSaidaFormatted = (rs.getDate("datasaida") != null) ? dateRenderer.dateFormat.format(rs.getDate("datasaida")) : "";

                // Adiciona a linha à tabela
                modelo.addRow(new Object[]{
                    dateRenderer.dateFormat.format(dataHora),
                    rs.getString("descricao"),
                    currencyEntrada.format(entrada),
                    dataEntradaFormatted,
                    currencySaida.format(saida),
                    dataSaidaFormatted,
                    currencySaida.format(saldoAtual)
                });
                // Atualiza os saldos dentro do loop
                saldoAnterior = saldoAtual;
                saldoAtual += (entrada - saida);
            }
            // Atualiza os rótulos dentro do loop
            lblSaldoAtual.setText(currencySaida.format(saldoAtual));
            lblSaldoAnterior.setText(currencyEntrada.format(saldoAnterior));
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
