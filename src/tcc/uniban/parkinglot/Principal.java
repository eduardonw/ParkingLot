/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.uniban.parkinglot;

import javax.swing.UIManager;
import tcc.uniban.parkinglot.visao.gui.GUIPrincipal;

/**
 *
 * @author eduardo
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
  
        GUIPrincipal guiPrincipal = new GUIPrincipal();
        guiPrincipal.setLocationRelativeTo(null);
        guiPrincipal.setVisible(true);
    }
}
