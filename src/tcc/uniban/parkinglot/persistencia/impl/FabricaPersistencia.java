/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.uniban.parkinglot.persistencia.impl;

import tcc.uniban.parkinglot.persistencia.IFabricaPersistencia;
import tcc.uniban.parkinglot.persistencia.IGatewayFuncionario;
import tcc.uniban.parkinglot.persistencia.IPesquisadorDeFuncionario;

/**
 *
 * @author eduardo
 */
public class FabricaPersistencia implements IFabricaPersistencia{

    @Override
    public IGatewayFuncionario getGatewayFuncionario() {
        return new GatewayFuncionario();
    }
    
    public IPesquisadorDeFuncionario getPesquisadorDeFuncionario(){
        return new PesquisadorDeFuncionario();
    }
    
}
