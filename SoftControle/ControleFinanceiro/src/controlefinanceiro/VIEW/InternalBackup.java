package controlefinanceiro.VIEW;

import java.io.File;
import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class InternalBackup extends javax.swing.JInternalFrame {

    public InternalBackup() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btBackup = new javax.swing.JButton();
        btRestore = new javax.swing.JButton();

        setClosable(true);
        setTitle("Backup ");

        btBackup.setText("Backup");
        btBackup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBackupActionPerformed(evt);
            }
        });

        btRestore.setText("Restore");
        btRestore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRestoreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(btBackup)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(btRestore)
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btRestore)
                    .addComponent(btBackup))
                .addGap(20, 20, 20))
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

    private void btBackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBackupActionPerformed
        // Seu código de backup aqui, sem alterações
        String host = "localhost";
        String port = "5432";
        String database = "controlefinanceirotest";
        String user = "postgres";
        String password = "admin";

        File directory = new File("C:\\SoftControle\\backup");
        if (!directory.exists()) {
            directory.mkdirs(); // Cria o diretório se não existir
        }

        ZoneId brasiliaTimeZone = ZoneId.of("America/Sao_Paulo");
        ZonedDateTime now = ZonedDateTime.now(brasiliaTimeZone);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy_HHmmss");
        String dateTimeString = now.format(formatter);

        String backupFileName = "bkp_" + database + "_" + dateTimeString + ".sql";
        String backupPath = "C:\\SoftControle\\backup\\" + backupFileName;

        try {
            String[] command = {
                "C:\\Program Files\\PostgreSQL\\13\\bin\\pg_dump.exe",
                "-h", host,
                "-p", port,
                "-U", user,
                "-F", "c",
                "-b",
                "-f", backupPath,
                database
            };

            ProcessBuilder processBuilder = new ProcessBuilder(command);
            processBuilder.environment().put("PGPASSWORD", password);

            processBuilder.redirectErrorStream(true); // Redireciona saída de erro para a saída de entrada

            Process process = processBuilder.start();

            process.waitFor(); // Aguarda a conclusão do processo

            // Verificar o código de retorno do processo para determinar se o backup foi bem-sucedido
            int exitCode = process.exitValue();
            if (exitCode == 0) {
                // Verificar se o arquivo de backup foi criado
                File backupFile = new File(backupPath);
                if (backupFile.exists()) {
                    JOptionPane.showMessageDialog(null, "Backup realizado com sucesso.");
                    System.out.println("Backup realizado com sucesso. Arquivo: " + backupFile.getAbsolutePath());
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao fazer o backup. O arquivo de backup não foi encontrado.");
                    System.out.println("Erro ao fazer o backup. O arquivo de backup não foi encontrado.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao fazer o backup. Código de retorno: " + exitCode);
                System.out.println("Erro ao fazer o backup. Código de retorno: " + exitCode);
            }

        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao fazer o backup.");
        }

    }//GEN-LAST:event_btBackupActionPerformed

    private void btRestoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRestoreActionPerformed
        String host = "localhost";
        String port = "5432";
        String database = "controlefinanceirotest";
        String user = "postgres";
        String password = "admin";
        // Caminho do diretório de restauração
        String restoreDirectory = "C:\\SoftControle\\backup";
        // Crie um diálogo de seleção de arquivo
        JFileChooser fileChooser = new JFileChooser(restoreDirectory);
        fileChooser.setDialogTitle("Selecione o arquivo de backup");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Arquivos de backup", "sql"));
        int userSelection = fileChooser.showOpenDialog(this);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            // Se o usuário selecionou um arquivo
            File backupFile = fileChooser.getSelectedFile();
            try {
                String[] command = {
                    "C:\\Program Files\\PostgreSQL\\13\\bin\\pg_restore.exe",
                    "-h", host,
                    "-p", port,
                    "-U", user,
                    "-d", database,
                    "-c", // Limpa o banco de dados antes de restaurar
                    backupFile.getAbsolutePath()
                };
                ProcessBuilder processBuilder = new ProcessBuilder(command);
                processBuilder.environment().put("PGPASSWORD", password);
                processBuilder.redirectErrorStream(true); // Redireciona saída de erro para a saída de entrada
                Process process = processBuilder.start();
                int exitCode = process.waitFor();
                if (exitCode == 0) {
                    JOptionPane.showMessageDialog(null, "Restauração realizada com sucesso.");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao restaurar o banco de dados.");
                }
            } catch (IOException | InterruptedException ex) {
                ex.printStackTrace();
                System.out.println("Erro: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btRestoreActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBackup;
    private javax.swing.JButton btRestore;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
