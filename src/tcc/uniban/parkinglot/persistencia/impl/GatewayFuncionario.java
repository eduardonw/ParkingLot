/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.uniban.parkinglot.persistencia.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import tcc.uniban.parkinglot.excecao.ParkingLotException;
import tcc.uniban.parkinglot.modelo.dominio.Funcionario;
import tcc.uniban.parkinglot.modelo.dominio.constante.Constante;
import tcc.uniban.parkinglot.persistencia.IGatewayFuncionario;

/**
 *
 * @author eduardo
 */
public class GatewayFuncionario implements IGatewayFuncionario{
    
    private static final String SQL_INCLUIRFUNCIONARIO =
            "INSERT INTO funcionario " +
            "(nome, cpf, rg, telefonefixo, telefonecelular, login, senha, grupo) " +
            "VALUES (?,?,?,?,?,?,?,?)";

    @Override
    public void gravarFuncionario(Funcionario funcionario) throws ParkingLotException {
        if (funcionario.getCodigo() == Constante.NOVO){
            incluirFuncionario(funcionario);
        }
    }
    
    private void incluirFuncionario(Funcionario funcionario) throws ParkingLotException {
        if (funcionario == null){
            String mensagem = "Não foi informado funcionário a cadastrar.";
            throw new ParkingLotException(mensagem);
        }
        
        Connection con = null;
        PreparedStatement stmt = null;
        try{
            con = GerenciadorDeConexao.getConexao();
            stmt = con.prepareStatement(SQL_INCLUIRFUNCIONARIO);
            
            //stmt.setLong(1, 1);
            
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCpf());
            stmt.setString(3, funcionario.getRg());
            stmt.setString(4, funcionario.getTelefoneFixo());
            stmt.setString(5, funcionario.getTelefoneCelular());
            stmt.setString(6, funcionario.getLogin());
            String senha = String.copyValueOf(funcionario.getSenha());  
            stmt.setString(7, senha);
            stmt.setInt(8, funcionario.getGrupo());
            
            stmt.executeUpdate();
            
        } catch (SQLException exc) {
            StringBuffer mensagem = new StringBuffer("Não foi possível incluir"
                    + " o funcionario");
            mensagem.append("\nMotivo: " + exc.getMessage());
            throw new ParkingLotException(mensagem.toString());
            
        } /*catch (NullPointerException exc) {
            StringBuffer mensagem = new StringBuffer("Não foi possível incluir"
                    + " o funcionario");
            mensagem.append("\nMotivo: " + exc.getMessage());
            throw new ParkingLotException(mensagem.toString());
            
        }*/finally {
            GerenciadorDeConexao.closeConexao(con, stmt);
        }
    }
    
}
