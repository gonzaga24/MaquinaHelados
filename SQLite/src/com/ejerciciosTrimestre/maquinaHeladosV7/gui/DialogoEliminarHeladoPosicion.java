/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.ejerciciosTrimestre.maquinaHeladosV7.gui;


/**
 *
 * @author Silvana
 */
public class DialogoEliminarHeladoPosicion extends javax.swing.JDialog {

    /**
     * Creates new form DialogReponerHelado
     */
    public DialogoEliminarHeladoPosicion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.padre = (Exec) parent;
        initComponents();
        setBounds(500, 250, 394, 314);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        confirmaciónHelado = new javax.swing.JDialog();
        textoConfirmación = new javax.swing.JLabel();
        botonSi = new javax.swing.JButton();
        botonNo = new javax.swing.JButton();
        textoAlUsuario = new javax.swing.JLabel();
        posicionIntroducida = new javax.swing.JTextField();
        eliminarHelado = new javax.swing.JButton();
        posicionCuatro = new javax.swing.JButton();
        posicionCinco = new javax.swing.JButton();
        posicionSeis = new javax.swing.JButton();
        posicionSiete = new javax.swing.JButton();
        posicionOcho = new javax.swing.JButton();
        posicionNueve = new javax.swing.JButton();
        posicionCero = new javax.swing.JButton();
        posicionUno = new javax.swing.JButton();
        posicionDos = new javax.swing.JButton();
        posicionTres = new javax.swing.JButton();
        borrarPosicion = new javax.swing.JButton();
        pantallaBotones = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        confirmaciónHelado.setAlwaysOnTop(true);
        confirmaciónHelado.setModal(true);
        confirmaciónHelado.setResizable(false);

        textoConfirmación.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textoConfirmación.setText("¿Esta seguro de que quiere eliminar el helado?");

        botonSi.setText("Si");
        botonSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSiActionPerformed(evt);
            }
        });

        botonNo.setText("No");
        botonNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout confirmaciónHeladoLayout = new javax.swing.GroupLayout(confirmaciónHelado.getContentPane());
        confirmaciónHelado.getContentPane().setLayout(confirmaciónHeladoLayout);
        confirmaciónHeladoLayout.setHorizontalGroup(
            confirmaciónHeladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(confirmaciónHeladoLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(botonSi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 185, Short.MAX_VALUE)
                .addComponent(botonNo)
                .addGap(70, 70, 70))
            .addGroup(confirmaciónHeladoLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(textoConfirmación, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        confirmaciónHeladoLayout.setVerticalGroup(
            confirmaciónHeladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(confirmaciónHeladoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(textoConfirmación)
                .addGap(18, 18, 18)
                .addGroup(confirmaciónHeladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonSi)
                    .addComponent(botonNo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        confirmaciónHelado.setSize(400, 200);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        getContentPane().setLayout(null);

        textoAlUsuario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textoAlUsuario.setText("Introduzca la posición del helado");
        getContentPane().add(textoAlUsuario);
        textoAlUsuario.setBounds(53, 28, 301, 25);

        posicionIntroducida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                posicionIntroducidaKeyTyped(evt);
            }
        });
        getContentPane().add(posicionIntroducida);
        posicionIntroducida.setBounds(119, 71, 139, 33);

        eliminarHelado.setText("Eliminar");
        eliminarHelado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarHeladoActionPerformed(evt);
            }
        });
        getContentPane().add(eliminarHelado);
        eliminarHelado.setBounds(130, 240, 137, 33);

        posicionCuatro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imgs/n4.png"))); // NOI18N
        posicionCuatro.setContentAreaFilled(false);
        posicionCuatro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                posicionCuatroActionPerformed(evt);
            }
        });
        getContentPane().add(posicionCuatro);
        posicionCuatro.setBounds(275, 138, 40, 30);

        posicionCinco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imgs/n5.png"))); // NOI18N
        posicionCinco.setContentAreaFilled(false);
        posicionCinco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                posicionCincoActionPerformed(evt);
            }
        });
        getContentPane().add(posicionCinco);
        posicionCinco.setBounds(110, 185, 40, 30);

        posicionSeis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imgs/n6.png"))); // NOI18N
        posicionSeis.setContentAreaFilled(false);
        posicionSeis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                posicionSeisActionPerformed(evt);
            }
        });
        getContentPane().add(posicionSeis);
        posicionSeis.setBounds(150, 185, 40, 30);

        posicionSiete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imgs/n7.png"))); // NOI18N
        posicionSiete.setContentAreaFilled(false);
        posicionSiete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                posicionSieteActionPerformed(evt);
            }
        });
        getContentPane().add(posicionSiete);
        posicionSiete.setBounds(190, 185, 40, 30);

        posicionOcho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imgs/n8.png"))); // NOI18N
        posicionOcho.setContentAreaFilled(false);
        posicionOcho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                posicionOchoActionPerformed(evt);
            }
        });
        getContentPane().add(posicionOcho);
        posicionOcho.setBounds(230, 185, 40, 30);

        posicionNueve.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imgs/n9.png"))); // NOI18N
        posicionNueve.setContentAreaFilled(false);
        posicionNueve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                posicionNueveActionPerformed(evt);
            }
        });
        getContentPane().add(posicionNueve);
        posicionNueve.setBounds(270, 185, 40, 30);

        posicionCero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imgs/n0.png"))); // NOI18N
        posicionCero.setContentAreaFilled(false);
        posicionCero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                posicionCeroActionPerformed(evt);
            }
        });
        getContentPane().add(posicionCero);
        posicionCero.setBounds(110, 138, 40, 30);

        posicionUno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imgs/n1.png"))); // NOI18N
        posicionUno.setContentAreaFilled(false);
        posicionUno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                posicionUnoActionPerformed(evt);
            }
        });
        getContentPane().add(posicionUno);
        posicionUno.setBounds(154, 138, 40, 30);

        posicionDos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imgs/n2.png"))); // NOI18N
        posicionDos.setContentAreaFilled(false);
        posicionDos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                posicionDosActionPerformed(evt);
            }
        });
        getContentPane().add(posicionDos);
        posicionDos.setBounds(195, 138, 40, 30);

        posicionTres.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imgs/n3.png"))); // NOI18N
        posicionTres.setContentAreaFilled(false);
        posicionTres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                posicionTresActionPerformed(evt);
            }
        });
        getContentPane().add(posicionTres);
        posicionTres.setBounds(232, 138, 42, 30);

        borrarPosicion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imgs/delete.png"))); // NOI18N
        borrarPosicion.setContentAreaFilled(false);
        borrarPosicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarPosicionActionPerformed(evt);
            }
        });
        getContentPane().add(borrarPosicion);
        borrarPosicion.setBounds(60, 160, 40, 30);

        pantallaBotones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imgs/espacio botones.png"))); // NOI18N
        getContentPane().add(pantallaBotones);
        pantallaBotones.setBounds(20, 50, 360, 250);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imgs/metal.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-10, -10, 420, 290);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void eliminarHeladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarHeladoActionPerformed
        // TODO add your handling code here:
        //Al darle a reponer el helado se le pedira una confirmación:
        
        //Si el usuario no esta seguro volvera a la ventana de pedir la posición
        if (!posicionIntroducida.getText().isEmpty()) {
            confirmaciónHelado.setVisible(true);
        }
    }//GEN-LAST:event_eliminarHeladoActionPerformed

    private void posicionCuatroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_posicionCuatroActionPerformed
        // TODO add your handling code here:
        introducirPosicion("4");
    }//GEN-LAST:event_posicionCuatroActionPerformed

    private void posicionCincoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_posicionCincoActionPerformed
        // TODO add your handling code here:
        introducirPosicion("5");
    }//GEN-LAST:event_posicionCincoActionPerformed

    private void posicionSeisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_posicionSeisActionPerformed
        // TODO add your handling code here:
        introducirPosicion("6");
    }//GEN-LAST:event_posicionSeisActionPerformed

    private void posicionSieteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_posicionSieteActionPerformed
        // TODO add your handling code here:
        introducirPosicion("7");
    }//GEN-LAST:event_posicionSieteActionPerformed

    private void posicionOchoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_posicionOchoActionPerformed
        // TODO add your handling code here:
        introducirPosicion("8");
    }//GEN-LAST:event_posicionOchoActionPerformed

    private void posicionNueveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_posicionNueveActionPerformed
        // TODO add your handling code here:
        introducirPosicion("9");
    }//GEN-LAST:event_posicionNueveActionPerformed

    private void posicionCeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_posicionCeroActionPerformed
        // TODO add your handling code here:
        introducirPosicion("0");
    }//GEN-LAST:event_posicionCeroActionPerformed

    private void posicionUnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_posicionUnoActionPerformed
        // TODO add your handling code here:
        introducirPosicion("1");
    }//GEN-LAST:event_posicionUnoActionPerformed

    private void posicionDosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_posicionDosActionPerformed
        // TODO add your handling code here:
        introducirPosicion("2");
    }//GEN-LAST:event_posicionDosActionPerformed

    private void posicionTresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_posicionTresActionPerformed
        // TODO add your handling code here:
        introducirPosicion("3");
    }//GEN-LAST:event_posicionTresActionPerformed

    private void borrarPosicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarPosicionActionPerformed
        // TODO add your handling code here:
        posicionIntroducida.setText("");
    }//GEN-LAST:event_borrarPosicionActionPerformed

    private void posicionIntroducidaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_posicionIntroducidaKeyTyped
        // TODO add your handling code here:
        if (posicionIntroducida.getText().length() >= 2) {
            evt.consume();
        }
    }//GEN-LAST:event_posicionIntroducidaKeyTyped

    private void botonSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSiActionPerformed
        try {
            // TODO add your handling code here:
            //Eliminar el helado y volver a la venta principal
            this.padre.getMh().eliminarHelado(posicionIntroducida.getText());
            this.padre.rellenarTablaHelados();
            confirmaciónHelado.dispose();
            this.dispose();
        } catch (Exception ex) {
            confirmaciónHelado.dispose();
            padre.ventanaError(ex.toString());
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_botonSiActionPerformed

    private void botonNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNoActionPerformed
        // TODO add your handling code here:
        //Volver atras
        confirmaciónHelado.dispose();
    }//GEN-LAST:event_botonNoActionPerformed

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
            java.util.logging.Logger.getLogger(DialogoEliminarHeladoPosicion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogoEliminarHeladoPosicion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogoEliminarHeladoPosicion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogoEliminarHeladoPosicion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogoEliminarHeladoPosicion dialog = new DialogoEliminarHeladoPosicion(new javax.swing.JFrame(), true);
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
    
    public void introducirPosicion(String posicion) {
        if (posicionIntroducida.getText().length() < 2) {
            posicionIntroducida.setText(posicionIntroducida.getText() + posicion);
        }
    }
           
    private Exec padre;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton borrarPosicion;
    private javax.swing.JButton botonNo;
    private javax.swing.JButton botonSi;
    private javax.swing.JDialog confirmaciónHelado;
    private javax.swing.JButton eliminarHelado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel pantallaBotones;
    private javax.swing.JButton posicionCero;
    private javax.swing.JButton posicionCinco;
    private javax.swing.JButton posicionCuatro;
    private javax.swing.JButton posicionDos;
    private javax.swing.JTextField posicionIntroducida;
    private javax.swing.JButton posicionNueve;
    private javax.swing.JButton posicionOcho;
    private javax.swing.JButton posicionSeis;
    private javax.swing.JButton posicionSiete;
    private javax.swing.JButton posicionTres;
    private javax.swing.JButton posicionUno;
    private javax.swing.JLabel textoAlUsuario;
    private javax.swing.JLabel textoConfirmación;
    // End of variables declaration//GEN-END:variables
}
