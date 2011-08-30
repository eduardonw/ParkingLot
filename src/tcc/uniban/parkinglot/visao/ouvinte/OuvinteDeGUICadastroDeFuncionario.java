/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.uniban.parkinglot.visao.ouvinte;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import tcc.uniban.parkinglot.excecao.ParkingLotException;
import tcc.uniban.parkinglot.modelo.controle.ControleFuncionario;
import tcc.uniban.parkinglot.modelo.dominio.Funcionario;
import tcc.uniban.parkinglot.visao.gui.GUICadastroDeFuncionario;
import tcc.uniban.parkinglot.visao.gui.GUIMensagem;

/**
 *
 * @author eduardo
 */
public class OuvinteDeGUICadastroDeFuncionario {
    private GUICadastroDeFuncionario guiCadastroDeFuncionario;

    public OuvinteDeGUICadastroDeFuncionario(GUICadastroDeFuncionario guiCadastroDeFuncionario) {
        this.guiCadastroDeFuncionario = guiCadastroDeFuncionario;
        guiCadastroDeFuncionario.bGravarFuncionarioAddActionListener(new OuvinteGravarFuncionario());
    }
    
    class OuvinteGravarFuncionario implements ActionListener {
        public void actionPerformed(ActionEvent e){
            Funcionario funcionario;
            try{
                funcionario = guiCadastroDeFuncionario.getFuncionario();
                ControleFuncionario controle = new ControleFuncionario();
                controle.gravarFuncionario(funcionario);
                GUIMensagem.exibirMensagem("Funcionário gravado com sucesso!", 
                        "ParkingLot - Funcionário", false);
                guiCadastroDeFuncionario.limparCampos();
            } catch (ParkingLotException ex){
                GUIMensagem.exibirMensagem(ex.getMessage(), "ParkingLot - funcionário", true);
            }
        }
    }
}
