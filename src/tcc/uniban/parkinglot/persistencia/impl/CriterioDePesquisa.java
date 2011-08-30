/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.uniban.parkinglot.persistencia.impl;

/**
 *
 * @author eduardo
 */
public class CriterioDePesquisa {
    protected String operadorSQL;
    protected String campo;
    protected Object valor;
    
    protected CriterioDePesquisa(String operadorSQL, String nomeDoCampo, Object valor){
        this.operadorSQL = operadorSQL;
        this.campo = nomeDoCampo;
        this.valor = valor;
    }
    
    protected CriterioDePesquisa(String nomeDoCampo, Object valor){
        this.campo = nomeDoCampo;
        this.valor = valor;
    }
    
    public static CriterioDePesquisa igualA(String nomeDoCampo, int valor){
        return CriterioDePesquisa.igualA(nomeDoCampo,new Integer (valor));
    }
    
    public static CriterioDePesquisa igualA(String nomeDoCampo, Object valor){
        return new CriterioDePesquisa("=", nomeDoCampo, valor);
    }
    
    public static CriterioDePesquisa contem(String nomeDoCampo, String valor){
        return new CriterioDePesquisaContem(nomeDoCampo, valor);
    }
    
    public String gerarSQL(){
        return campo + operadorSQL + valor;
    }
    
    
}
