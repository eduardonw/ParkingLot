/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.uniban.parkinglot.persistencia.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import tcc.uniban.parkinglot.excecao.ParkingLotException;

/**
 *
 * @author eduardo
 */
class GerenciadorDeConexao {
    private static String driver;
    private static String url;
    
    private static void init() throws ParkingLotException{
        Properties properties = new Properties();
        FileInputStream arquivoDePropriedades = null;
        try{
            arquivoDePropriedades = new FileInputStream("database.properties");
            properties.load(arquivoDePropriedades);
            driver = properties.getProperty("jdbc.driver");
            url = properties.getProperty("jdbc.url");
            
            Class.forName(driver);
        } catch (FileNotFoundException exc) {
            StringBuffer mensagem = new StringBuffer("Não foi possível conectar"
                    + "com o banco de dados");
            mensagem.append("\nMotivo: " + exc.getMessage());
            throw new ParkingLotException(mensagem.toString());
        } catch (IOException exc) {
            StringBuffer mensagem = new StringBuffer("Não foi possível conectar"
                    + "com o banco de dados");
            mensagem.append("\nMotivo: " + exc.getMessage());
            throw new ParkingLotException(mensagem.toString());
        } catch (ClassNotFoundException exc) {
            StringBuffer mensagem = new StringBuffer("Não foi possível conectar"
                    + "com o banco de dados");
            mensagem.append("\nMotivo: " + exc.getMessage());
            throw new ParkingLotException(mensagem.toString());
        }
    }
    
    static Connection getConexao() throws ParkingLotException {
        try{
            init();
            return DriverManager.getConnection(url);
        } catch (SQLException exc) {
            StringBuffer mensagem = new StringBuffer("Não foi possível estabelecer"
                    + "conexão com o banco de dados");
            mensagem.append("\nMotivo: " + exc.getMessage());
            throw new ParkingLotException(mensagem.toString());
        }
    }
    
    static void closeConexao(Connection con) throws ParkingLotException{
        closeConexao(con, null, null);
    }
    
    static void closeConexao(Connection con, PreparedStatement stmt) throws ParkingLotException{
        closeConexao(con, stmt, null);
    }
    
    static void closeConexao(Connection con, PreparedStatement stmt, ResultSet rs) throws
            ParkingLotException{
        try{
            if (rs!= null){
                rs.close();
            }
            
            if (stmt != null){
                stmt.close();
            }
            
            if (con != null){
                con.close();
            }
        } catch (SQLException exc) {
            StringBuffer mensagem = new StringBuffer("Não foi possível finalizar"
                    + "a conexão com o banco de dados");
            mensagem.append("\nMotivo: " + exc.getMessage());
            throw new ParkingLotException(mensagem.toString());
        }
    }
    
}
