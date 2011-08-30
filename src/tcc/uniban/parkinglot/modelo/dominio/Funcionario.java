/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.uniban.parkinglot.modelo.dominio;

import tcc.uniban.parkinglot.excecao.ParkingLotException;

/**
 *
 * @author eduardo
 */
public class Funcionario {
    private long codigo = 0;
    private String nome;
    private String cpf;
    private String rg;
    private String endereco;
    private String telefoneFixo;
    private String telefoneCelular;
    private String login;
    private char[] senha;
    private int grupo;

    public Funcionario() {
        
    }

    /**
     * @return the codigo
     */
    public long getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) throws ParkingLotException {
        if (!this.isNomeValido(nome.trim())){
            throw new ParkingLotException("O nome do sócio deve ser informado!");
        }
        this.nome = nome;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the rg
     */
    public String getRg() {
        return rg;
    }

    /**
     * @param rg the rg to set
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the telefoneFixo
     */
    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    /**
     * @param telefoneFixo the telefoneFixo to set
     */
    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    /**
     * @return the telefoneCelular
     */
    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    /**
     * @param telefoneCelular the telefoneCelular to set
     */
    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) throws ParkingLotException {
        if (!this.isLoginValido(login.trim())) {
            throw new ParkingLotException("O login do funcionario deve ser informado!");
        }
        this.login = login;
    }

    /**
     * @return the senha
     */
    public char[] getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(char[] senha) throws ParkingLotException {
        this.senha = senha;
       
    }

    /**
     * @return the grupo
     */
    public int getGrupo() {
        return grupo;
    }

    /**
     * @param grupo the grupo to set
     */
    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }
    
    private boolean isNomeValido(String nome){
        if (nome == null || nome.length() == 0){
            return false;
        } else {
            return true;
        }
    }
    
    private boolean isLoginValido(String login){
        if (login == null || login.length() == 0){
            return false;
        } else {
            return true;
        }
    }
    
    private boolean isSenhaValida(String senha){
        if (senha == null || senha.length() < 6){
            return false;
        } else {
            return true;
        }
    }
    
    
}
