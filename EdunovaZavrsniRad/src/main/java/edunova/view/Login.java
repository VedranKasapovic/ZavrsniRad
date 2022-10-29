/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edunova.view;

import edunova.controller.ObradaDjelatnik;
import edunova.model.Djelatnik;
import edunova.util.Pomocno;
import java.awt.event.KeyEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Veky
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        postavke();
        cmbDjelatnik.getFocusCycleRootAncestor();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbDjelatnik = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtLozinka = new javax.swing.JPasswordField();
        btnPrijava = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Unesite tražene podatke"));

        jLabel1.setText("Djelatnik:");

        cmbDjelatnik.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cmbDjelatnikKeyTyped(evt);
            }
        });

        jLabel2.setText("Lozinka:");

        txtLozinka.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLozinkaKeyPressed(evt);
            }
        });

        btnPrijava.setText("Prijava");
        btnPrijava.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrijavaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 279, Short.MAX_VALUE))
                    .addComponent(cmbDjelatnik, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtLozinka)
                    .addComponent(btnPrijava, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbDjelatnik, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLozinka, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(btnPrijava, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbDjelatnikKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbDjelatnikKeyTyped
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txtLozinka.getPassword().length == 0) {
                return;
            }

        }
        autorizacija();

    }//GEN-LAST:event_cmbDjelatnikKeyTyped

    private void txtLozinkaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLozinkaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txtLozinka.getPassword().length == 0) {
                
                return;
            }
                        
            autorizacija();
        }
     }//GEN-LAST:event_txtLozinkaKeyPressed

    private void btnPrijavaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrijavaActionPerformed
        autorizacija();
    }//GEN-LAST:event_btnPrijavaActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrijava;
    private javax.swing.JComboBox<Djelatnik> cmbDjelatnik;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtLozinka;
    // End of variables declaration//GEN-END:variables

    private void postavke() {
        setTitle(Pomocno.NAZIV_APLIKACIJE + " autorizacija");
        txtLozinka.requestFocus();
        ucitajDjelatnike();
        cmbDjelatnik.setSelectedIndex(0);

    }

    private void ucitajDjelatnike() {
        DefaultComboBoxModel<Djelatnik> d
                = new DefaultComboBoxModel<>();
        for(Djelatnik dj : new ObradaDjelatnik().read() ){
            if(dj.isAktivan()){
                d.addElement(dj);
            }
        }
        
        cmbDjelatnik.setModel(d);
        txtLozinka.setText("admin");
    }

    private void autorizacija() {
        ObradaDjelatnik od = new ObradaDjelatnik();
        Djelatnik odabrani = (Djelatnik) cmbDjelatnik.getSelectedItem();
        Djelatnik d = od.autoriziraj(odabrani.getSifra(), txtLozinka.getPassword());
        if (d == null) {
            JOptionPane.showMessageDialog(rootPane, "Autorizacija nije uspjela");
            return;
        }
        Pomocno.djelatnik = d;
        new Izbornik().setVisible(true);
        dispose();

    }

}
// Popraviti listu da pokazuje samo aktivne članove