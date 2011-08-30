/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.uniban.parkinglot.modelo.controle;

import java.util.List;
import tcc.uniban.parkinglot.excecao.ParkingLotException;
import tcc.uniban.parkinglot.modelo.dominio.Funcionario;
import tcc.uniban.parkinglot.persistencia.IFabricaPersistencia;
import tcc.uniban.parkinglot.persistencia.IGatewayFuncionario;
import tcc.uniban.parkinglot.persistencia.IPesquisadorDeFuncionario;
import tcc.uniban.parkinglot.persistencia.impl.CriterioDePesquisa;
import tcc.uniban.parkinglot.persistencia.impl.CriterioDePesquisaContem;
import tcc.uniban.parkinglot.persistencia.impl.FabricaPersistencia;


/**
 *
 * @author eduardo
 */
public class ControleFuncionario {
    
    private IPesquisadorDeFuncionario pesquisador;
    
    public void gravarFuncionario(Funcionario funcionario) throws ParkingLotException{
        IFabricaPersistencia fabricaPersistencia = new FabricaPersistencia();
        IGatewayFuncionario gatewayFuncionario = fabricaPersistencia.getGatewayFuncionario();
        gatewayFuncionario.gravarFuncionario(funcionario);
    }
    
    public void adicionarCriterioDePesquisaIgualA(String campo, int valor) { 
        if (this.pesquisador == null) {
            this.criarPesquisador(); 
        }    
        pesquisador.adicionarCriterio(CriterioDePesquisa.igualA(campo, valor));
    }

    public void adicionarCriterioDePesquisaContem(String campo, String valor) { 
        if (this.pesquisador == null) {
            this.criarPesquisador(); 
        }    
        pesquisador.adicionarCriterio(CriterioDePesquisaContem.contem(campo, valor));
    }
    
    public List realizarPesquisa() throws ParkingLotException { 
        if (this.pesquisador == null) {
            this.criarPesquisador(); 
        }    
        return pesquisador.realizarPesquisa();
    }

    private void criarPesquisador() { 
        IFabricaPersistencia fabricaPersistencia = new FabricaPersistencia();
        this.pesquisador = fabricaPersistencia.getPesquisadorDeFuncionario();
    }
    
}
