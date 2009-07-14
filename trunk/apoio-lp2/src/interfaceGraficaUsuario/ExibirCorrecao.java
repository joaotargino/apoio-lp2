/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ExibirCorrecao.java
 *
 * Created on 14/07/2009, 03:29:18
 */
package interfaceGraficaUsuario;

import controle.DadosUsuarioEnum;
import controle.Sistema;
import controle.Submissao;
import java.awt.Color;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class ExibirCorrecao extends javax.swing.JFrame {

    private List<String> dadosUsuario;

    /** Creates new form ExibirCorrecao */
    public ExibirCorrecao() {
        initComponents();
    }

    public ExibirCorrecao(List<String> dadosUsuario) {
        initComponents();
        setTitle("Exibir Correcao");
        this.dadosUsuario = dadosUsuario;
        labelNotFound.setForeground(Color.red);
        labelNotFound.setVisible(false);
        painelExibir.setEnabled(false);
        painelExibir.setText(Sistema.getSubmissoesAluno(dadosUsuario.get(DadosUsuarioEnum.LOGIN.ordinal())));

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        campoIDExercicio = new javax.swing.JTextField();
        labelCorrecao = new javax.swing.JLabel();
        botaoVoltar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        textoQuestao = new javax.swing.JTextArea();
        botaoExibir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        painelExibir = new javax.swing.JTextPane();
        labelNotFound = new javax.swing.JLabel();
        labelIDExercicio = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 450));

        labelCorrecao.setText("Comentários e correções do exercício:");

        botaoVoltar.setText("Voltar");
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });

        textoQuestao.setColumns(20);
        textoQuestao.setEditable(false);
        textoQuestao.setRows(5);
        textoQuestao.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        textoQuestao.setMaximumSize(new java.awt.Dimension(1000, 1000));
        textoQuestao.setSelectionColor(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportView(textoQuestao);

        botaoExibir.setText("Exibir");
        botaoExibir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExibirActionPerformed(evt);
            }
        });

        painelExibir.setBackground(new java.awt.Color(240, 240, 240));
        painelExibir.setEditable(false);
        painelExibir.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        painelExibir.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        painelExibir.setMaximumSize(new java.awt.Dimension(200, 100));
        painelExibir.setSelectionColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(painelExibir);

        labelNotFound.setText("Exercício não encontrado");

        labelIDExercicio.setText("Informe o ID da Submissão: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelNotFound, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(636, 636, 636))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(labelIDExercicio)
                                .addGap(18, 18, 18)
                                .addComponent(campoIDExercicio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botaoExibir)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCorrecao)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(88, 88, 88))))
            .addGroup(layout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addComponent(botaoVoltar)
                .addContainerGap(472, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelNotFound)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelIDExercicio)
                    .addComponent(campoIDExercicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoExibir)
                    .addComponent(labelCorrecao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoVoltar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        dispose();
}//GEN-LAST:event_botaoVoltarActionPerformed

    private void botaoExibirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExibirActionPerformed
        try {
            Submissao sub = Sistema.getSubmissao(Integer.parseInt(campoIDExercicio.getText()));
            if (sub.getLogin().equalsIgnoreCase(dadosUsuario.get(DadosUsuarioEnum.LOGIN.ordinal()))) {
                textoQuestao.setText(sub.getComentario());
                textoQuestao.setVisible(true);
                labelNotFound.setVisible(false);
            }else{
                labelNotFound.setText("Você não tem permissão para acessar essa correção");
                labelNotFound.setVisible(true);
            }
        } catch (Exception e) {
            labelNotFound.setText("Submissao nao encontrada, verifique os dados!");
            labelNotFound.setVisible(true);

        }
}//GEN-LAST:event_botaoExibirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ExibirCorrecao().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoExibir;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JTextField campoIDExercicio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelCorrecao;
    private javax.swing.JLabel labelIDExercicio;
    private javax.swing.JLabel labelNotFound;
    private javax.swing.JTextPane painelExibir;
    private javax.swing.JTextArea textoQuestao;
    // End of variables declaration//GEN-END:variables
}