/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.uniban.parkinglot.persistencia.impl;

/**
 *
 * @author eduardo
 */
public class CriterioDePesquisaContem extends CriterioDePesquisa {

    public CriterioDePesquisaContem(String nomeDoCampo, String valor) {
        super(nomeDoCampo, valor);
    }
    
    public String gerarSQL(){
        return "UPPER (" + this.campo + ") LIKE UPPER ('%" + this.valor + "%')";
    }
    
}
