/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edunova.view;

import edunova.controller.ObradaDijete;
import edunova.controller.ObradaOdgovornaOsoba;
import edunova.model.Dijete;
import edunova.model.OdgovornaOsoba;
import edunova.util.EdunovaException;
import edunova.util.Pomocno;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Veky
 */
public class ProzorOdgovornaOsoba extends javax.swing.JFrame {

    private ObradaOdgovornaOsoba obrada;
    private ObradaDijete obradaDijete;
    private int selectedIndex;

    public ProzorOdgovornaOsoba() {
        initComponents();
        obrada = new ObradaOdgovornaOsoba();
        obradaDijete = new ObradaDijete();
        selectedIndex = 0;
        postavke();
        ucitaj();
    }

    private void ucitaj() {
        lstEntiteti.setModel(new IgraonicaListModel<>(obrada.read()));
        if (lstEntiteti.getModel().getSize() > 0) {
            lstEntiteti.setSelectedIndex(selectedIndex);
        }

    }

    private void postaviBrojDjece() {
    /*    DefaultListModel<ObradaOdgovornaOsoba> m = (DefaultListModel<ObradaOdgovornaOsoba>) lstDijeteOdgovornaOsoba.getModel();
        lblBrojDjece.setText(String.valueOf(m.size()));
    */}

    private void postavke() {
        setTitle(Pomocno.NAZIV_APLIKACIJE + " Odgovorne osobe");
        lstDijeteOdgovornaOsobe.setModel(new DefaultListModel<>());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstEntiteti = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        txtIme = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPrezime = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cmbRod = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtTelefon = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstDijeteOdgovornaOsobe = new javax.swing.JList<>();
        btnDodajDijete = new javax.swing.JButton();
        btnObrisiDijete = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtTraziDijete = new javax.swing.JTextField();
        btnTraziDijete = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstDjecaUBazi = new javax.swing.JList<>();
        btnDodaj = new javax.swing.JButton();
        btnPromjeni = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        lblBrojDjece = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Odgovorna Osoba");

        lstEntiteti.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstEntitetiValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstEntiteti);

        jLabel2.setText("Ime");

        jLabel3.setText("Prezime");

        jLabel4.setText("Email");

        jLabel5.setText("Rod");

        cmbRod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mama", "Tata", "Baka", "Djed", "Brat", "Sestra", "Rođak", "Ostali" }));

        jLabel6.setText("Broj telefona");

        jLabel7.setText("Odgovorni za dijete");

        lstDijeteOdgovornaOsobe.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstDijeteOdgovornaOsobeValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lstDijeteOdgovornaOsobe);

        btnDodajDijete.setText("<");
        btnDodajDijete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajDijeteActionPerformed(evt);
            }
        });

        btnObrisiDijete.setText(">");
        btnObrisiDijete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiDijeteActionPerformed(evt);
            }
        });

        jLabel8.setText("Djeca u bazi");

        btnTraziDijete.setText("Traži");
        btnTraziDijete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraziDijeteActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(lstDjecaUBazi);

        btnDodaj.setText("Dodaj");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        btnPromjeni.setText("Promjeni");
        btnPromjeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromjeniActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obriši");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(btnPromjeni, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtIme)
                                        .addComponent(txtPrezime)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtEmail)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cmbRod, 0, 126, Short.MAX_VALUE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTelefon))
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblBrojDjece, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(btnTraziDijete))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnDodajDijete, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnObrisiDijete, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTraziDijete, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel8))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblBrojDjece, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(txtTraziDijete, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jLabel3)
                                .addGap(9, 9, 9)
                                .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbRod, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(btnTraziDijete)
                                            .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(67, 67, 67)
                                                .addComponent(btnDodajDijete, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnObrisiDijete, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(34, 34, 34)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnPromjeni, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(btnDodaj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnObrisi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lstEntitetiValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstEntitetiValueChanged
        if (evt.getValueIsAdjusting() || lstEntiteti.getSelectedValue() == null) {
            return;
        }
        obrada.setEntitet(lstEntiteti.getSelectedValue());
        popuniView();
    }//GEN-LAST:event_lstEntitetiValueChanged

    private void lstDijeteOdgovornaOsobeValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstDijeteOdgovornaOsobeValueChanged
        if (evt.getValueIsAdjusting() || lstDijeteOdgovornaOsobe.getSelectedValue() == null) {
            return;
        }
    }//GEN-LAST:event_lstDijeteOdgovornaOsobeValueChanged

    private void btnTraziDijeteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraziDijeteActionPerformed
        List<Dijete> djeca = obradaDijete.read(txtTraziDijete.getText().trim());
        lstDjecaUBazi.setModel(new IgraonicaListModel<>(djeca));
        if (djeca.isEmpty()) {
            txtTraziDijete.requestFocus();
            return;

        }

        try {
            lstDjecaUBazi.setSelectedIndex(0);
        } catch (Exception e) {
        }
        lstDjecaUBazi.requestFocus(); 
                
    }//GEN-LAST:event_btnTraziDijeteActionPerformed

    private void btnDodajDijeteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajDijeteActionPerformed

        DefaultListModel<Dijete> m = (DefaultListModel<Dijete>) lstDijeteOdgovornaOsobe.getModel();
        for (Dijete d : lstDjecaUBazi.getSelectedValuesList()) {
            m.addElement(kreirajDijete(obrada.getEntitet(), d));
        }
        lstDijeteOdgovornaOsobe.repaint();
        postaviBrojDjece();
    }//GEN-LAST:event_btnDodajDijeteActionPerformed

    private void btnObrisiDijeteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiDijeteActionPerformed
      /*  DefaultListModel<OdgovornaOsoba> m
                = (DefaultListModel<OdgovornaOsoba>) lstDijeteOdgovornaOsobe.getModel();
        for (OdgovornaOsoba oo : lstDijeteOdgovornaOsobe.getSelectedValuesList()) {
            m.removeElement(oo);
        }
        lstDijeteOdgovornaOsobe.repaint();
        postaviBrojDjece();*/
    }//GEN-LAST:event_btnObrisiDijeteActionPerformed

    private void btnPromjeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromjeniActionPerformed
        if(lstEntiteti.getSelectedValue()==null || obrada.getEntitet()== null){
            JOptionPane.showMessageDialog(rootPane, "Prvo odaberite odgovornu osobu!");
            return;
        }
        popuniModel();
        try {
            obrada.update();
            ucitaj();
        } catch (EdunovaException e) {
            obrada.refresh();
            JOptionPane.showMessageDialog(rootPane, e.getPoruka());
        }
        
    }//GEN-LAST:event_btnPromjeniActionPerformed

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        obrada.setEntitet(new OdgovornaOsoba());
        popuniModel();
        try {
            obrada.create();
            ucitaj();
        } catch (EdunovaException e) {
            JOptionPane.showMessageDialog(rootPane,
                    e.getPoruka());
            if(lstEntiteti.getSelectedIndex()>=0){
                obrada.setEntitet(lstEntiteti.getSelectedValue());
            }
        }
        
    }                           

    
    private Dijete kreirajDijete(OdgovornaOsoba entitet, Dijete d) {
        List<Dijete> dijete=new ArrayList<>();
        d.getOdgovorneOsobe().add(entitet);
        return d;
                
        }
    private void popuniModel() {
        var e = obrada.getEntitet();
        e.setIme(txtIme.getText());
        e.setPrezime(txtPrezime.getText());
        e.setEmail(txtEmail.getText());
        e.setTelefon(txtTelefon.getText());
        e.setRod(cmbRod.getSelectedItem().toString());
    }//GEN-LAST:event_btnDodajActionPerformed

    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnDodajDijete;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnObrisiDijete;
    private javax.swing.JButton btnPromjeni;
    private javax.swing.JButton btnTraziDijete;
    private javax.swing.JComboBox<String> cmbRod;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblBrojDjece;
    private javax.swing.JList<Dijete> lstDijeteOdgovornaOsobe;
    private javax.swing.JList<Dijete> lstDjecaUBazi;
    private javax.swing.JList<OdgovornaOsoba> lstEntiteti;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtPrezime;
    private javax.swing.JTextField txtTelefon;
    private javax.swing.JTextField txtTraziDijete;
    // End of variables declaration//GEN-END:variables

    private void popuniView() {
 var e = obrada.getEntitet();
        txtIme.setText(e.getIme());
        txtPrezime.setText(e.getPrezime());
        txtEmail.setText(e.getEmail());
        txtTelefon.setText(e.getTelefon());
        cmbRod.setSelectedItem(e.getRod());
       // lstDijeteOdgovornaOsobe.setModel(new IgraonicaListModel<>(e.getDjeca()));
    }

}

