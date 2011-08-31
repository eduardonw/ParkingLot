/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.uniban.parkinglot.modelo.controle;

import tcc.uniban.parkinglot.excecao.ParkingLotException;
import tcc.uniban.parkinglot.modelo.dominio.Funcionario;
import tcc.uniban.parkinglot.persistencia.IFabricaPersistencia;
import tcc.uniban.parkinglot.persistencia.IGatewayFuncionario;
import tcc.uniban.parkinglot.persistencia.impl.FabricaPersistencia;

/**
 *
 * @author eduardo
 */
public class ControleFuncionario {
    public void gravarFuncionario(Funcionario funcionario) throws ParkingLotException{
        IFabricaPersistencia fabricaPersistencia = new FabricaPersistencia();
        IGatewayFuncionario gatewayFuncionario = fabricaPersistencia.getGatewayFuncionario();
        gatewayFuncionario.gravarFuncionario(funcionario);
    }
    
    public void excluirFuncionario(Funcionario funcionario) throws ParkingLotException{
        IFabricaPersistencia fabricaPersistencia = new FabricaPersistencia();
        IGatewayFuncionario gatewayFuncionario = fabricaPersistencia.getGatewayFuncionario();
        gatewayFuncionario.excluirFuncionario(funcionario);
    }
}
