/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.uniban.parkinglot.persistencia;

import tcc.uniban.parkinglot.excecao.ParkingLotException;
import tcc.uniban.parkinglot.modelo.dominio.Funcionario;

/**
 *
 * @author eduardo
 */
public interface IGatewayFuncionario {
    public abstract void gravarFuncionario(Funcionario funcionario) throws ParkingLotException;
    
}
