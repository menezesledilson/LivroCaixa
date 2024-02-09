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
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class InternalDiarioFinanceiroAnual extends javax.swing.JInternalFrame {

    public InternalDiarioFinanceiroAnual() {
        initComponents();
        carregaTabela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblSaldoSaida = new javax.swing.JLabel();
        btImprimir = new javax.swing.JButton();
        btExcel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDiarioAnual = new javax.swing.JTable();
        lblSaldoEntrada = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Diário Financeiro Anual");

        lblSaldoSaida.setText("Total de saidas no ano");

        btImprimir.setText("Imprimir");
        btImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImprimirActionPerformed(evt);
            }
        });

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
                "Data hora", "Descrição", "Entrada", "Saida", "Observação"
            }
        ));
        jScrollPane1.setViewportView(tbDiarioAnual);

        lblSaldoEntrada.setText("Total de entradas no ano");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 803, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btImprimir)
                .addGap(18, 18, 18)
                .addComponent(btExcel)
                .addGap(46, 46, 46)
                .addComponent(lblSaldoEntrada)
                .addGap(72, 72, 72)
                .addComponent(lblSaldoSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btImprimir)
                    .addComponent(btExcel)
                    .addComponent(lblSaldoEntrada)
                    .addComponent(lblSaldoSaida))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE))
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

    private void btImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImprimirActionPerformed
        Connection con = conexao.getConnection();
        //PreparedStatement pstm = null;
        try {
            String arq = "C:\\SoftControle\\ControleFinanceiro\\src\\controlefinanceiro\\Relatorio\\RelatorioCaixa.jasper";
            Map<String, Object> parametros = new HashMap<>();

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
    }//GEN-LAST:event_btImprimirActionPerformed

    private void tamanhoTabela() {
        tbDiarioAnual.getColumnModel().getColumn(0).setPreferredWidth(100);
        tbDiarioAnual.getColumnModel().getColumn(1).setPreferredWidth(150);
    }
    // private int mesAnterior = -1; // Inicializa com um valor que não representa um mês válido

    private void carregaTabela() {
        tamanhoTabela();

        DefaultTableModel modelo = (DefaultTableModel) tbDiarioAnual.getModel();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        tbDiarioAnual.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        //  tbLivoCaixa.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        //   tbLivoCaixa.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);

        // Configurar a tabela como não editável
        tbDiarioAnual.setDefaultEditor(Object.class, null);

        try {
            Connection con = conexao.getConnection();
            PreparedStatement pstm;
            ResultSet rs;

            double somaEntrada = 0;
            double somaSaida = 0;

            /*   Calendar cal = Calendar.getInstance();
            int mesAtual = cal.get(Calendar.MONTH) + 1;//mês
            // int anoAtual = cal.get(Calendar.YEAR); // ano

            if (mesAtual != mesAnterior) {
                modelo.setNumRows(0); // Limpa a tabela se o mês mudou
                mesAnterior = mesAtual; // Atualiza o mês anterior
            }*/
            pstm = con.prepareStatement("SELECT id, datahora, descricao, entrada, saida,observacao FROM livrocaixa order by id DESC;");
            //pstm.setInt(1, mesAtual);
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
                    //   rs.getString("dataHora"),

                    rs.getString("descricao"),
                    currencyEntrada.format(entrada),
                    currencySaida.format(saida),
                    rs.getString("observacao"),});

                somaEntrada += entrada;
                somaSaida += saida;

                //liquido = somaEntrada - somaSaida;
            }

            lblSaldoEntrada.setText("Total de entradas no ano " + NumberFormat.getCurrencyInstance().format(somaEntrada));
            lblSaldoSaida.setText("Total de saidas no ano  " + NumberFormat.getCurrencyInstance().format(somaSaida));

            conexao.closeConnection(con, pstm, rs);
        } catch (Exception ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados: " + ErroSql, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btExcel;
    private javax.swing.JButton btImprimir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSaldoEntrada;
    private javax.swing.JLabel lblSaldoSaida;
    private javax.swing.JTable tbDiarioAnual;
    // End of variables declaration//GEN-END:variables
}
