package controlefinanceiro;

import controlefinanceiro.VIEW.frmPrincipal;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.WindowConstants;

public class ControleFinanceiro {

    public static void main(String[] args) {
        frmPrincipal mm = new frmPrincipal();

        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            mm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            mm.setVisible(true);
        }

    }
}
