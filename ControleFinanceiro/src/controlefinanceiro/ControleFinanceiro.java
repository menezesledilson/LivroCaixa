 
package controlefinanceiro;

 
import controlefinanceiro.VIEW.frmPrincipal;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import util.PosicaoFormulario;

public class ControleFinanceiro {
   public static void main(String[] args) {
       frmPrincipal mm = new frmPrincipal();

        mm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mm.setVisible(true);
    }
    

}