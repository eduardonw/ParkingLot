/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.uniban.parkinglot.visao.gui;

import javax.swing.JOptionPane;

/**
 *
 * @author eduardo
 */
public class GUIMensagem extends JOptionPane {
    public static void exibirMensagem(String mensagem, String titulo, boolean isErro) {
        int tipo;
        if (isErro) {
            tipo = JOptionPane.ERROR_MESSAGE;
        } else {
            tipo = JOptionPane.INFORMATION_MESSAGE;
        }
        
        showMessageDialog(null, mensagem, titulo, tipo);
    }
}
