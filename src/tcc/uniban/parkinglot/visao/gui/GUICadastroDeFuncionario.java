/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GUICadastroDeSocio.java
 *
 * Created on 24/08/2011, 14:50:46
 */
package tcc.uniban.parkinglot.visao.gui;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import tcc.uniban.parkinglot.excecao.ParkingLotException;
import tcc.uniban.parkinglot.modelo.dominio.Funcionario;
import tcc.uniban.parkinglot.modelo.dominio.constante.Constante;
import tcc.uniban.parkinglot.modelo.dominio.constante.GrupoDeFuncionario;

/**
 *
 * @author eduardo
 */
public class GUICadastroDeFuncionario extends javax.swing.JInternalFrame {

    private Funcionario funcionario;
    
    /** Creates new form GUICadastroDeSocio */
    public GUICadastroDeFuncionario() {
        initComponents();
        for (GrupoDeFuncionario grupo : GrupoDeFuncionario.values()){
            cbGrupo.addItem(grupo.name());
        }
    }
    
    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation (15 + (d.width - this.getSize().width) / 5, 15 + (d.height -
                this.getSize().height) / 5);
    }
    
    public Funcionario getFuncionario() throws ParkingLotException {
        int grupo = cbGrupo.getSelectedIndex();
        if (grupo == 0){
            throw new ParkingLotException("Não foi informado o grupo do funcionário");
        } else {
            funcionario.setGrupo(grupo - 1);
        }
        
        String nome = tfNome.getText();
        if (nome == null || nome.trim().equals("")){
            tfNome.requestFocus();
            throw new ParkingLotException("Não foi informado o nome do funcionário");
        } else {
            funcionario.setNome(nome);
        }
        
        String cpf = tfCpf.getText();
        if (cpf == null || cpf.trim().equals("")){
            tfCpf.requestFocus();
            throw new ParkingLotException("Não foi informado o CPF do funcionário");
        } else {
            funcionario.setCpf(cpf);
        }
        
        String rg = tfRg.getText();
        if (rg == null || rg.trim().equals("")){
            tfRg.requestFocus();
            throw new ParkingLotException("Não foi informado o RG do funcionário");
        } else {
            funcionario.setRg(rg);
        }
        
        String login = tfLogin.getText();
        if (login == null || login.trim().equals("")){
            tfLogin.requestFocus();
            throw new ParkingLotException("Não foi informado o Login do funcionário");
        } else {
            funcionario.setLogin(login);
        }
        
        char[] senha = csSenha.getPassword();
        if (senha.length < 6){
            csSenha.requestFocus();
            throw new ParkingLotException("A senha deve ter pelo menos 6 caracteres");
        } else {
            funcionario.setSenha(senha);
        }
        
        funcionario.setTelefoneFixo(tfTelefoneFixo.getText());
        funcionario.setTelefoneCelular(tfTelefoneCelular.getText());
        
        
        return funcionario;
               
    }
    
    public void exibeDadosDoFuncionario() {
        limparCampos();
        
        if (funcionario.getCodigo() != Constante.NOVO) {
            cbGrupo.setSelectedIndex(funcionario.getGrupo() + 1);
            tfNome.setText(funcionario.getNome());
            tfCpf.setText(funcionario.getCpf());
            tfRg.setText(funcionario.getRg());
            tfTelefoneFixo.setText(funcionario.getTelefoneFixo());
            tfTelefoneCelular.setText(funcionario.getTelefoneCelular());
            tfLogin.setText(funcionario.getLogin());
            
            String senha = String.copyValueOf(funcionario.getSenha());
            csSenha.setText(senha);
        }
    }
    
    public void setFuncionario(Funcionario funcionario){
        this.funcionario = funcionario;
        this.exibeDadosDoFuncionario();
    }
    
    public void bGravarFuncionarioAddActionListener(ActionListener ouvinte){
        bGravarFuncionario.addActionListener(ouvinte);
    }
    
    public void limparCampos(){
        cbGrupo.setSelectedIndex(0);
        tfNome.setText(null);
        tfCpf.setText(null);
        tfRg.setText(null);
        tfTelefoneFixo.setText(null);
        tfTelefoneCelular.setText(null);
        tfLogin.setText(null);
        csSenha.setText(null);
                
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pDadosFuncionario = new javax.swing.JPanel();
        lGrupo = new javax.swing.JLabel();
        cbGrupo = new javax.swing.JComboBox();
        lNome = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        lCpf = new javax.swing.JLabel();
        tfCpf = new javax.swing.JFormattedTextField();
        lRg = new javax.swing.JLabel();
        tfRg = new javax.swing.JFormattedTextField();
        lTelefoneFixo = new javax.swing.JLabel();
        lTelefoneCelular = new javax.swing.JLabel();
        tfTelefoneFixo = new javax.swing.JFormattedTextField();
        tfTelefoneCelular = new javax.swing.JFormattedTextField();
        lLogin = new javax.swing.JLabel();
        lSenha = new javax.swing.JLabel();
        tfLogin = new javax.swing.JTextField();
        csSenha = new javax.swing.JPasswordField();
        bGravarFuncionario = new javax.swing.JButton();
        bLimpar = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();

        setClosable(true);
        setTitle("ParkingLot");

        pDadosFuncionario.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Funcionário"));

        lGrupo.setText("Grupo");

        cbGrupo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione..." }));

        lNome.setText("Nome");

        lCpf.setText("CPF");

        try {
            tfCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCpfActionPerformed(evt);
            }
        });

        lRg.setText("RG");

        try {
            tfRg.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lTelefoneFixo.setText("Telefone fixo");

        lTelefoneCelular.setText("Telefone celular");

        try {
            tfTelefoneFixo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            tfTelefoneCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lLogin.setText("Login");

        lSenha.setText("Senha");

        tfLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfLoginActionPerformed(evt);
            }
        });

        csSenha.setText("jPasswordField1");

        org.jdesktop.layout.GroupLayout pDadosFuncionarioLayout = new org.jdesktop.layout.GroupLayout(pDadosFuncionario);
        pDadosFuncionario.setLayout(pDadosFuncionarioLayout);
        pDadosFuncionarioLayout.setHorizontalGroup(
            pDadosFuncionarioLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pDadosFuncionarioLayout.createSequentialGroup()
                .add(pDadosFuncionarioLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(pDadosFuncionarioLayout.createSequentialGroup()
                        .add(10, 10, 10)
                        .add(pDadosFuncionarioLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(pDadosFuncionarioLayout.createSequentialGroup()
                                .add(pDadosFuncionarioLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(lCpf)
                                    .add(lTelefoneFixo)
                                    .add(lLogin)
                                    .add(tfCpf, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                    .add(tfTelefoneFixo))
                                .add(18, 18, 18)
                                .add(pDadosFuncionarioLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(lRg)
                                    .add(lTelefoneCelular)
                                    .add(tfRg, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                                    .add(tfTelefoneCelular)))
                            .add(tfLogin, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 186, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(lSenha)
                            .add(csSenha, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 150, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(pDadosFuncionarioLayout.createSequentialGroup()
                        .add(9, 9, 9)
                        .add(pDadosFuncionarioLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(lNome)
                            .add(lGrupo)
                            .add(cbGrupo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(tfNome, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 575, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pDadosFuncionarioLayout.setVerticalGroup(
            pDadosFuncionarioLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pDadosFuncionarioLayout.createSequentialGroup()
                .add(lGrupo)
                .add(4, 4, 4)
                .add(cbGrupo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(lNome)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(tfNome, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(pDadosFuncionarioLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lCpf)
                    .add(lRg))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(pDadosFuncionarioLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(tfCpf, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(tfRg, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(pDadosFuncionarioLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lTelefoneFixo)
                    .add(lTelefoneCelular))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(pDadosFuncionarioLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(tfTelefoneFixo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(tfTelefoneCelular, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(lLogin)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(tfLogin, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(lSenha)
                .add(1, 1, 1)
                .add(csSenha, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        bGravarFuncionario.setText("Gravar");

        bLimpar.setText("Limpar");
        bLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLimparActionPerformed(evt);
            }
        });

        bCancelar.setText("Cancelar");
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(pDadosFuncionario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 605, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createSequentialGroup()
                        .add(bGravarFuncionario)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(bLimpar)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 396, Short.MAX_VALUE)
                        .add(bCancelar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(pDadosFuncionario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(bGravarFuncionario)
                    .add(bLimpar)
                    .add(bCancelar))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void tfCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCpfActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_tfCpfActionPerformed

private void tfLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfLoginActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_tfLoginActionPerformed

private void bLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLimparActionPerformed
    limparCampos();
}//GEN-LAST:event_bLimparActionPerformed

private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
    this.dispose();
}//GEN-LAST:event_bCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bGravarFuncionario;
    private javax.swing.JButton bLimpar;
    private javax.swing.JComboBox cbGrupo;
    private javax.swing.JPasswordField csSenha;
    private javax.swing.JLabel lCpf;
    private javax.swing.JLabel lGrupo;
    private javax.swing.JLabel lLogin;
    private javax.swing.JLabel lNome;
    private javax.swing.JLabel lRg;
    private javax.swing.JLabel lSenha;
    private javax.swing.JLabel lTelefoneCelular;
    private javax.swing.JLabel lTelefoneFixo;
    private javax.swing.JPanel pDadosFuncionario;
    private javax.swing.JFormattedTextField tfCpf;
    private javax.swing.JTextField tfLogin;
    private javax.swing.JTextField tfNome;
    private javax.swing.JFormattedTextField tfRg;
    private javax.swing.JFormattedTextField tfTelefoneCelular;
    private javax.swing.JFormattedTextField tfTelefoneFixo;
    // End of variables declaration//GEN-END:variables
}