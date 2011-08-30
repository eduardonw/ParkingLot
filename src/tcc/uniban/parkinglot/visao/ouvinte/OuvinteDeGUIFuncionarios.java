/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.uniban.parkinglot.visao.ouvinte;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.List;
import tcc.uniban.parkinglot.excecao.ParkingLotException;
import tcc.uniban.parkinglot.modelo.controle.ControleFuncionario;
import tcc.uniban.parkinglot.visao.gui.GUIFuncionario;
import tcc.uniban.parkinglot.visao.gui.GUIMensagem;

/**
 *
 * @author eduardo
 */
public class OuvinteDeGUIFuncionarios {
    private GUIFuncionario guiFuncionario;
    
    public OuvinteDeGUIFuncionarios(GUIFuncionario guiFuncionario){
        this.guiFuncionario = guiFuncionario;
        this.guiFuncionario.bPesquisarFuncionarioAddActionListener(new OuvintePesquisarFuncionario());
    }
    
       
    class OuvintePesquisarFuncionario implements ActionListener {
        

        public void actionPerformed(ActionEvent e) { 
            try {
                ControleFuncionario controle = new ControleFuncionario(); 
                String nomeDoFuncionario = guiFuncionario.getNome(); 
                if (nomeDoFuncionario != null && !nomeDoFuncionario.trim().equals("")) {
                    controle.adicionarCriterioDePesquisaContem("nome", nomeDoFuncionario);
                } 
                List funcionarios = controle.realizarPesquisa(); 
                if(funcionarios.size() > 0){
                    guiFuncionario.exibirFuncionario(funcionarios);
                } else {
                    StringBuffer mensagem = new StringBuffer(); 
                    mensagem.append("Não há funcionários cadastrados ou que"); 
                    mensagem.append("\natendam ao critério informado."); 
                    GUIMensagem.exibirMensagem(mensagem.toString(), "Cadastro de Funcionário", true);
                }
            } catch (ParkingLotException ex) {
                    GUIMensagem.exibirMensagem(ex.getMessage(), "ParkingLot - Funcionários", true);
            }
        }
    }
}
