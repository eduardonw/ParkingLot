/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.uniban.parkinglot.persistencia;

import java.util.List;
import tcc.uniban.parkinglot.excecao.ParkingLotException;
import tcc.uniban.parkinglot.persistencia.impl.CriterioDePesquisa;

/**
 *
 * @author eduardo
 */
public interface IPesquisadorDeFuncionario {

    void adicionarCriterio(CriterioDePesquisa criterio);

    List realizarPesquisa() throws ParkingLotException;
    
}
