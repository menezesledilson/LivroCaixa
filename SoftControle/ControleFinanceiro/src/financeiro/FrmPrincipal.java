package financeiro;

import financeiro.View.frmLogin;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.WindowConstants;

public class FrmPrincipal {

    public static void main(String[] args) {
       frmLogin mm = new frmLogin();
     // frmMenu mm = new frmMenu();

        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {

        }
        mm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mm.setVisible(true);
    }

}
