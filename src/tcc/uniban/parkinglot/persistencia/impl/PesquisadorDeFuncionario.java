/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.uniban.parkinglot.persistencia.impl;

import tcc.uniban.parkinglot.persistencia.IPesquisadorDeFuncionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tcc.uniban.parkinglot.excecao.ParkingLotException;
import tcc.uniban.parkinglot.modelo.dominio.Funcionario;

/**
 *
 * @author eduardo
 */
public class PesquisadorDeFuncionario implements IPesquisadorDeFuncionario {
    private List criterios = new ArrayList();
    
    @Override
    public void adicionarCriterio(CriterioDePesquisa criterio){
        this.criterios.add(criterio);
    }
    
    private String gerarClausulaWhere() { 
        StringBuffer clausulaWhere = new StringBuffer(); 
        if (criterios.size() != 0) {
            clausulaWhere.append(" WHERE "); 
            Iterator iterator = criterios.iterator(); 
            while (iterator.hasNext()) {
                if (clausulaWhere.length() != 7) { 
                    clausulaWhere.append(" OR ");
                } 
                CriterioDePesquisa criterio = (CriterioDePesquisa) iterator.next(); 
                clausulaWhere.append(criterio.gerarSQL());
            } 
        }   
        return clausulaWhere.toString();
    }
    
    private List encontrarFuncionariosOnde(String clausulaWhere) throws ParkingLotException { 
        String sql = "SELECT * FROM funcionario" + clausulaWhere;

        Connection con = null; 
        PreparedStatement stmt = null; 
        ResultSet rs = null; 
        List resultado = new ArrayList(); 
        try {
            con = GerenciadorDeConexao.getConexao(); 
            stmt = con.prepareStatement(sql); 
            rs = stmt.executeQuery(); 
            while (rs.next()) {
                Funcionario funcionario = criarFuncionario(rs); 
                resultado.add(funcionario);
            } 
        } catch (SQLException exc) {
            StringBuffer mensagem = new StringBuffer("Não foi possível realizar a consulta.");
            mensagem.append("\nMotivo: " + exc.getMessage());
            throw new ParkingLotException(mensagem.toString()); 
        } finally {
            GerenciadorDeConexao.closeConexao(con, stmt, rs); return resultado;
        }
    }
    
    private Funcionario criarFuncionario(ResultSet rs) throws ParkingLotException{
        Funcionario funcionario = new Funcionario();
        
        try{
            funcionario.setCodigo(rs.getLong("codigo"));
            funcionario.setNome(rs.getString("nome"));
            funcionario.setCpf(rs.getString("cpf"));
            funcionario.setRg(rs.getString("rg"));
            funcionario.setTelefoneFixo(rs.getString("telefonefixo"));
            funcionario.setTelefoneCelular(rs.getString("telefonecelular"));
            funcionario.setLogin(rs.getString("login"));
            char[] senha = rs.getString("senha").toCharArray();
            funcionario.setSenha(senha);
            funcionario.setGrupo(rs.getInt("grupo"));
        } catch (SQLException exc){
            StringBuffer mensagem = new StringBuffer("Não foi possivel obter os dados");
            mensagem.append("\nMotivo: " + exc.getMessage());
            throw new ParkingLotException(mensagem.toString());
        }
        return funcionario;
    }
    
    @Override
    public List realizarPesquisa() throws ParkingLotException{
        String clausulaWhere = this.gerarClausulaWhere();
        return encontrarFuncionariosOnde(clausulaWhere);
    }
    
}