/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package financeiro.UTIL;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

public class PosicaoFormulario {
    
     public void abrirFormulario(JInternalFrame janela, JDesktopPane desktop) {
        int lDesk = desktop.getWidth();
        int aDesk = desktop.getHeight();
        int lIFrame = janela.getWidth();
        int aIFrame = janela.getHeight();
        janela.setLocation(lDesk / 2 - lIFrame / 2, aDesk / 2 - aIFrame / 2);
        desktop.add(janela);
        janela.setVisible(true);
    }
    
}
