/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GUISobre.java
 *
 * Created on 23/08/2011, 09:44:24
 */
package tcc.uniban.parkinglot.visao.gui;

import java.awt.Dimension;

/**
 *
 * @author eduardo
 */
public class GUISobre extends javax.swing.JInternalFrame {

    /** Creates new form GUISobre */
    public GUISobre() {
        initComponents();
    }
    
    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width)/2,
                         (d.height - this.getSize().height)/2);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lNomeDoAplicativo = new javax.swing.JLabel();
        lVersaoDoAplicativo = new javax.swing.JLabel();
        lAutorDoAplicativo = new javax.swing.JLabel();
        lDescricaoDoAplicativo = new javax.swing.JLabel();
        lLicencaDoAplicativo = new javax.swing.JLabel();
        tfAutores = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        taDescricao = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        taLicenca = new javax.swing.JTextArea();
        bFechar = new javax.swing.JButton();

        setClosable(true);
        setTitle("ParkingLot - Sobre");

        lNomeDoAplicativo.setText("ParkingLot");

        lVersaoDoAplicativo.setText("Versão 1.0");

        lAutorDoAplicativo.setText("Autores");

        lDescricaoDoAplicativo.setText("Descrição");

        lLicencaDoAplicativo.setText("Licença");

        tfAutores.setEditable(false);
        tfAutores.setText("Eduardo Santos, Diego Nascimento, Rodrigo Gomes, Jeferson Pereira, Leonardo Silva e Douglas Silva");

        taDescricao.setColumns(20);
        taDescricao.setEditable(false);
        taDescricao.setLineWrap(true);
        taDescricao.setRows(5);
        taDescricao.setText("Controle para gerenciamento de estacionamentos com ou sem serviços de lavagem.");
        taDescricao.setWrapStyleWord(true);
        jScrollPane1.setViewportView(taDescricao);

        taLicenca.setColumns(20);
        taLicenca.setEditable(false);
        taLicenca.setLineWrap(true);
        taLicenca.setRows(5);
        taLicenca.setText("Licença Publica da GNU (GNU General Public License), conforme publicada pela Free Software Foundation.");
        taLicenca.setWrapStyleWord(true);
        jScrollPane2.setViewportView(taLicenca);

        bFechar.setText("Fechar");
        bFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFecharActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(lVersaoDoAplicativo)
                            .add(lNomeDoAplicativo)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(lAutorDoAplicativo)
                                    .add(lDescricaoDoAplicativo)
                                    .add(lLicencaDoAplicativo))
                                .add(44, 44, 44)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE)
                                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE)
                                    .add(tfAutores, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE))))
                        .add(38, 38, 38))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(bFechar)
                        .add(354, 354, 354))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(lNomeDoAplicativo)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(lVersaoDoAplicativo)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lAutorDoAplicativo)
                    .add(tfAutores, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lDescricaoDoAplicativo)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 106, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lLicencaDoAplicativo)
                    .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 94, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(29, 29, 29)
                .add(bFechar)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void bFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFecharActionPerformed
    this.dispose();
}//GEN-LAST:event_bFecharActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bFechar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lAutorDoAplicativo;
    private javax.swing.JLabel lDescricaoDoAplicativo;
    private javax.swing.JLabel lLicencaDoAplicativo;
    private javax.swing.JLabel lNomeDoAplicativo;
    private javax.swing.JLabel lVersaoDoAplicativo;
    private javax.swing.JTextArea taDescricao;
    private javax.swing.JTextArea taLicenca;
    private javax.swing.JTextField tfAutores;
    // End of variables declaration//GEN-END:variables
}
