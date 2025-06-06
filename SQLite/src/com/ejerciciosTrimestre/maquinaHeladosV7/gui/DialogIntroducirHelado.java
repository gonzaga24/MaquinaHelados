/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.ejerciciosTrimestre.maquinaHeladosV7.gui;

/**
 *
 * @author Silvana
 */
public class DialogIntroducirHelado extends javax.swing.JDialog {

    /**
     * Creates new form DialogIntroducirHelado
     */
    public DialogIntroducirHelado(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.padre = (Exec) parent;
        initComponents();
        setBounds(500, 250, 300, 400);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        textoAlusuario = new javax.swing.JLabel();
        posicionIntroducida = new javax.swing.JTextField();
        textoAlusuario1 = new javax.swing.JLabel();
        saborIntroducido = new javax.swing.JTextField();
        textoAlusuario2 = new javax.swing.JLabel();
        precioIntroducido = new javax.swing.JTextField();
        textoAlusuario3 = new javax.swing.JLabel();
        insertarHelado = new javax.swing.JButton();
        tipoIntroducido = new javax.swing.JTextField();
        fondo = new javax.swing.JLabel();

        jMenuItem1.setText("jMenuItem1");

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        getContentPane().setLayout(null);

        textoAlusuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textoAlusuario.setText("Introduzca la posición del helado");
        getContentPane().add(textoAlusuario);
        textoAlusuario.setBounds(24, 18, 229, 20);

        posicionIntroducida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                posicionIntroducidaKeyTyped(evt);
            }
        });
        getContentPane().add(posicionIntroducida);
        posicionIntroducida.setBounds(24, 50, 182, 22);

        textoAlusuario1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textoAlusuario1.setText("Introduzca el sabor del helado");
        getContentPane().add(textoAlusuario1);
        textoAlusuario1.setBounds(24, 90, 229, 20);
        getContentPane().add(saborIntroducido);
        saborIntroducido.setBounds(24, 122, 182, 22);

        textoAlusuario2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textoAlusuario2.setText("Introduzca el precio del helado");
        getContentPane().add(textoAlusuario2);
        textoAlusuario2.setBounds(24, 162, 229, 20);
        getContentPane().add(precioIntroducido);
        precioIntroducido.setBounds(24, 194, 182, 22);

        textoAlusuario3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textoAlusuario3.setText("Introduzca el tipo del helado");
        getContentPane().add(textoAlusuario3);
        textoAlusuario3.setBounds(24, 228, 229, 20);

        insertarHelado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        insertarHelado.setText("Insertar");
        insertarHelado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertarHeladoActionPerformed(evt);
            }
        });
        getContentPane().add(insertarHelado);
        insertarHelado.setBounds(60, 310, 87, 32);
        getContentPane().add(tipoIntroducido);
        tipoIntroducido.setBounds(24, 260, 182, 22);

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imgs/metal.jpg"))); // NOI18N
        getContentPane().add(fondo);
        fondo.setBounds(-13, -4, 410, 400);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void posicionIntroducidaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_posicionIntroducidaKeyTyped
        // TODO add your handling code here:
        if (posicionIntroducida.getText().length() >= 2) {
            evt.consume();
        }
    }//GEN-LAST:event_posicionIntroducidaKeyTyped

    private void insertarHeladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertarHeladoActionPerformed
        // TODO add your handling code here:
        //Igualar los valores del helado a los datos introducidos.
        //Cerrara la ventana
        try {
            this.padre.getMh().inputHelado(posicionIntroducida.getText(), saborIntroducido.getText(), Double.parseDouble(precioIntroducido.getText()), tipoIntroducido.getText());
            this.padre.rellenarTablaHelados();
            this.dispose();
        } catch (Exception ex) {
            this.padre.ventanaError(ex.toString());
        }
    }//GEN-LAST:event_insertarHeladoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DialogIntroducirHelado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogIntroducirHelado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogIntroducirHelado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogIntroducirHelado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogIntroducirHelado dialog = new DialogIntroducirHelado(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    private Exec padre;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fondo;
    private javax.swing.JButton insertarHelado;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JTextField posicionIntroducida;
    private javax.swing.JTextField precioIntroducido;
    private javax.swing.JTextField saborIntroducido;
    private javax.swing.JLabel textoAlusuario;
    private javax.swing.JLabel textoAlusuario1;
    private javax.swing.JLabel textoAlusuario2;
    private javax.swing.JLabel textoAlusuario3;
    private javax.swing.JTextField tipoIntroducido;
    // End of variables declaration//GEN-END:variables
}
