/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SubmeterExercicio.java
 *
 * Created on 13/07/2009, 21:59:10
 */

package interfaceGraficaUsuario;

import controle.*;
import disciplina.Exercicio;
import java.awt.Color;
import java.io.File;
import java.util.List;
import javax.swing.JFileChooser;

/**
 *
 * @author Administrador
 */
public class SubmeterExercicio extends javax.swing.JFrame {
    public String caminho;
    private List<String> dadosUsuario;

    /** Creates new form SubmeterExercicio */
    public SubmeterExercicio() {
        initComponents();
    }

     public SubmeterExercicio(List<String> dadosUsuario) {
        initComponents();
        labelMensagem.setVisible(false);
        this.dadosUsuario = dadosUsuario;
        setTitle("Submeter Exercicio");
        exibicaoExercicios.setVisible(true);
        exibicaoExercicios.setText(Sistema.listaDeExercicios());
        exibicaoExercicios.setEnabled(false);
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        idExercicio = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        abrir = new javax.swing.JButton();
        pesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        exibicaoExercicios = new javax.swing.JTextArea();
        sair = new javax.swing.JButton();
        submeter = new javax.swing.JButton();
        caminhoArquivo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        labelMensagem = new javax.swing.JLabel();
        pesquisarTodos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        idExercicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idExercicioActionPerformed(evt);
            }
        });

        jLabel1.setText("Id do Exercicio");

        abrir.setText("Abrir");
        abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirActionPerformed(evt);
            }
        });

        pesquisar.setText("Pesquisar");
        pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarActionPerformed(evt);
            }
        });

        exibicaoExercicios.setColumns(20);
        exibicaoExercicios.setRows(5);
        exibicaoExercicios.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        exibicaoExercicios.setSelectionColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(exibicaoExercicios);

        sair.setText("Sair");
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });

        submeter.setText("Submeter");
        submeter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submeterActionPerformed(evt);
            }
        });

        jLabel2.setText("Caminho");

        labelMensagem.setText("mensagem");

        pesquisarTodos.setText("Exibir Todos");
        pesquisarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarTodosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(idExercicio, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pesquisar)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(caminhoArquivo, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(abrir))
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelMensagem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 189, Short.MAX_VALUE)
                        .addComponent(submeter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sair))
                    .addComponent(pesquisarTodos, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idExercicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(abrir)
                    .addComponent(pesquisar)
                    .addComponent(caminhoArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pesquisarTodos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sair)
                    .addComponent(submeter)
                    .addComponent(labelMensagem))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirActionPerformed
        JFileChooser open = new JFileChooser();
        open.setVisible(true);
        int op = open.showOpenDialog(this);
        if (op == JFileChooser.APPROVE_OPTION) {
            File arq = open.getSelectedFile();
            caminho = arq.getAbsolutePath();
            caminhoArquivo.setText(caminho);
        }
    }//GEN-LAST:event_abrirActionPerformed

    private void idExercicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idExercicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idExercicioActionPerformed

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        dispose();
    }//GEN-LAST:event_sairActionPerformed

    private void submeterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submeterActionPerformed
        String login = dadosUsuario.get(DadosUsuarioEnum.LOGIN.ordinal());
        if (Sistema.enviarSubmissao(login, caminho , Integer.parseInt(idExercicio.getText()))) {
            labelMensagem.setText("Exercicio submetido com sucesso!");
            labelMensagem.setForeground(Color.blue);
        } else {
            labelMensagem.setText("Nao foi possivel submeter o exercicio!");
            labelMensagem.setForeground(Color.red);
        }
        labelMensagem.setVisible(true);
    }//GEN-LAST:event_submeterActionPerformed

    private void pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarActionPerformed
        Exercicio exercicio = null;
        try {
        exercicio = Sistema.getExercicio(Integer.parseInt(idExercicio.getText()));
        } catch(NumberFormatException e) {
        }
        if (exercicio != null)
            exibicaoExercicios.setText(Sistema.exibirQuestoes(exercicio));
    }//GEN-LAST:event_pesquisarActionPerformed

    private void pesquisarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarTodosActionPerformed
        exibicaoExercicios.setText(Sistema.listaDeExercicios());
    }//GEN-LAST:event_pesquisarTodosActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SubmeterExercicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abrir;
    private javax.swing.JTextField caminhoArquivo;
    private javax.swing.JTextArea exibicaoExercicios;
    private javax.swing.JTextField idExercicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelMensagem;
    private javax.swing.JButton pesquisar;
    private javax.swing.JButton pesquisarTodos;
    private javax.swing.JButton sair;
    private javax.swing.JButton submeter;
    // End of variables declaration//GEN-END:variables

}
