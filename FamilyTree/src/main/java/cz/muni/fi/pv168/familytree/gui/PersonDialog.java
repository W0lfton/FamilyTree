/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pv168.familytree.gui;

import cz.muni.fi.pv168.familytree.GenderType;
import cz.muni.fi.pv168.familytree.PeopleManagerImpl;
import cz.muni.fi.pv168.familytree.Person;
import cz.muni.fi.pv168.familytree.ServiceFailureException;
import static cz.muni.fi.pv168.familytree.gui.FamilyTreeGUI.log;
import java.util.concurrent.ExecutionException;
import javax.sql.DataSource;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 *
 * @author brani
 */
public class PersonDialog extends javax.swing.JDialog {
    
    private Person p;
    private DataSource ds;
    private java.util.ResourceBundle bundle;

    /**
     * Creates new form PersonDialog
     * @param parent
     * @param modal
     */
    public PersonDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public PersonDialog(java.awt.Frame parent, boolean modal, DataSource ds, Person p, java.util.ResourceBundle bundle) {
        this(parent, modal);
        this.ds = ds;
        this.p = p;
        this.bundle = bundle;
        if (p == null) {
            return;
        }
        nameField.setText(p.getName());
        birthDateChooser.setDate(java.sql.Date.valueOf(p.getDateOfBirth()));
        placeOfBirthField.setText(p.getPlaceOfBirth());
        if (p.getDateOfDeath() != null) {
            deathDateChooser.setDate(java.sql.Date.valueOf(p.getDateOfDeath()));
        }
        if (p.getPlaceOfDeath() != null) {
            placeOfDeathField.setText(p.getPlaceOfDeath());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        genderButtonGroup = new javax.swing.ButtonGroup();
        varInputPanel = new javax.swing.JPanel();
        nameField = new javax.swing.JTextField();
        maleRadioButton = new javax.swing.JRadioButton();
        femaleRadioButton = new javax.swing.JRadioButton();
        birthDateChooser = new com.toedter.calendar.JDateChooser();
        placeOfBirthField = new javax.swing.JTextField();
        deathDateChooser = new com.toedter.calendar.JDateChooser();
        placeOfDeathField = new javax.swing.JTextField();
        varLabelsPanel = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        genderLabel = new javax.swing.JLabel();
        dateOfBirthLabel = new javax.swing.JLabel();
        placeOfBirthLabel = new javax.swing.JLabel();
        dateOfDeathLabel = new javax.swing.JLabel();
        placeOfDeathLabel = new javax.swing.JLabel();
        buttonsSplitPane = new javax.swing.JSplitPane();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        genderButtonGroup.add(maleRadioButton);
        maleRadioButton.setSelected(true);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("localization"); // NOI18N
        maleRadioButton.setText(bundle.getString("maleRadioButton")); // NOI18N

        genderButtonGroup.add(femaleRadioButton);
        femaleRadioButton.setText(bundle.getString("femaleRadioButton")); // NOI18N

        javax.swing.GroupLayout varInputPanelLayout = new javax.swing.GroupLayout(varInputPanel);
        varInputPanel.setLayout(varInputPanelLayout);
        varInputPanelLayout.setHorizontalGroup(
            varInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(varInputPanelLayout.createSequentialGroup()
                .addComponent(maleRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(femaleRadioButton)
                .addGap(0, 8, Short.MAX_VALUE))
            .addComponent(deathDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(placeOfBirthField)
            .addComponent(birthDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(nameField)
            .addComponent(placeOfDeathField, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        varInputPanelLayout.setVerticalGroup(
            varInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(varInputPanelLayout.createSequentialGroup()
                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(varInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(femaleRadioButton)
                    .addComponent(maleRadioButton))
                .addGap(15, 15, 15)
                .addComponent(birthDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(placeOfBirthField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deathDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(placeOfDeathField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        nameLabel.setText(bundle.getString("nameLabel")); // NOI18N

        genderLabel.setText(bundle.getString("genderLabel")); // NOI18N

        dateOfBirthLabel.setText(bundle.getString("dateOfBirthLabel")); // NOI18N

        placeOfBirthLabel.setText(bundle.getString("placeOfBirthLabel")); // NOI18N

        dateOfDeathLabel.setText(bundle.getString("dateOfDeathLabel")); // NOI18N

        placeOfDeathLabel.setText(bundle.getString("placeOfDeathLabel")); // NOI18N

        javax.swing.GroupLayout varLabelsPanelLayout = new javax.swing.GroupLayout(varLabelsPanel);
        varLabelsPanel.setLayout(varLabelsPanelLayout);
        varLabelsPanelLayout.setHorizontalGroup(
            varLabelsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(varLabelsPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(varLabelsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateOfBirthLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(genderLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nameLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(placeOfBirthLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dateOfDeathLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(placeOfDeathLabel, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        varLabelsPanelLayout.setVerticalGroup(
            varLabelsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(varLabelsPanelLayout.createSequentialGroup()
                .addComponent(nameLabel)
                .addGap(25, 25, 25)
                .addComponent(genderLabel)
                .addGap(23, 23, 23)
                .addComponent(dateOfBirthLabel)
                .addGap(25, 25, 25)
                .addComponent(placeOfBirthLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dateOfDeathLabel)
                .addGap(21, 21, 21)
                .addComponent(placeOfDeathLabel)
                .addGap(5, 5, 5))
        );

        buttonsSplitPane.setBorder(null);
        buttonsSplitPane.setDividerSize(0);

        okButton.setText(bundle.getString("okButton")); // NOI18N
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        buttonsSplitPane.setLeftComponent(okButton);

        cancelButton.setText(bundle.getString("cancelButton")); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        buttonsSplitPane.setRightComponent(cancelButton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(buttonsSplitPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(varLabelsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(varInputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(varInputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(varLabelsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonsSplitPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void validate(Person p) throws IllegalArgumentException {
        String please = bundle.getString("pleaseFill");
        if (p.getName().length() == 0) {
            throw new IllegalArgumentException(please + bundle.getString("nameLabel"));
        }
        if (p.getPlaceOfBirth().isEmpty()) {
            throw new IllegalArgumentException(please + bundle.getString("placeOfBirthLabel"));
        }
        if (p.getDateOfBirth() == null) {
            throw new IllegalArgumentException(please + bundle.getString("dateOfBirthLabel"));
        }
        if ((p.getDateOfDeath() == null) != (p.getPlaceOfDeath() == null)) {
            throw new IllegalArgumentException(please + bundle.getString("bothDeath"));
        }
        if (p.getDateOfDeath() != null && p.getDateOfBirth().isAfter(p.getDateOfDeath())) {
            throw new IllegalArgumentException(bundle.getString("bornAfterDeath"));
        }
    }
    
    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        try{
            Person p2 = new Person();
            p2.setName(nameField.getText());
            if(maleRadioButton.isSelected())
                p2.setGender(GenderType.MAN);
            else
                p2.setGender(GenderType.WOMAN);

            p2.setPlaceOfBirth(placeOfBirthField.getText());
            java.util.Date date = birthDateChooser.getDate();
            p2.setDateOfBirth(date != null ? new java.sql.Date(date.getTime()).toLocalDate() : null);

            p2.setPlaceOfDeath( !placeOfDeathField.getText().isEmpty() ?  placeOfDeathField.getText() : null);
            date = deathDateChooser.getDate();
            p2.setDateOfDeath(date != null ? new java.sql.Date(date.getTime()).toLocalDate() : null);
            
            validate(p2);
            
            if (p == null) {
                p = p2;
                new createPersonSwingWorker().execute();
            } else {
                p2.setId(p.getId());
                p = p2;
                new updatePersonSwingWorker().execute();
            }
            this.setVisible(false);
        } catch (IllegalArgumentException ex) {
            log.error("Failed to validate Person: ", ex);
            JOptionPane.showMessageDialog(this, ex.getMessage(), bundle.getString("error"), JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_okButtonActionPerformed

    private class createPersonSwingWorker extends SwingWorker<Boolean, Void> {

        @Override
        protected Boolean doInBackground() throws Exception {
            try {
                new PeopleManagerImpl(ds).createPerson(p);
                return false;
            } catch(ServiceFailureException ex) {
                log.error("Failed to create Person: ", ex);
                return true;
            }
        }
        
        @Override
        protected void done() {
            try {
                if (get()) {
                    JOptionPane.showMessageDialog(null, bundle.getString("createPersonFail"), bundle.getString("error"), JOptionPane.ERROR_MESSAGE);
                } else {
                    log.info("Successfully created person in database.");
                    updateGUI();
                }
            } catch(InterruptedException | ExecutionException ex) {
                log.error("Failed to create Person: ", ex);
            }
        }
    }
    
    private class updatePersonSwingWorker extends SwingWorker<Boolean, Void> {

        @Override
        protected Boolean doInBackground() throws Exception {
            try {
                new PeopleManagerImpl(ds).updatePerson(p);
                return false;
            } catch(ServiceFailureException ex) {
                log.error("Failed to update Person: ", ex);
                return true;
            }
        }
        
        @Override
        protected void done() {
            try {
                if (get()) {
                    JOptionPane.showMessageDialog(null, bundle.getString("updatePersonFail"), bundle.getString("error"), JOptionPane.ERROR_MESSAGE);
                } else {
                    log.info("Succesfully updated person in database.");
                    updateGUI();
                }
            } catch(InterruptedException | ExecutionException ex) {
                log.error("Failed to update Person: ", ex);
            }
        }
    }
    
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void updateGUI() {
        ((FamilyTreeGUI)this.getParent()).updateGUI();
    }
    
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
            java.util.logging.Logger.getLogger(PersonDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PersonDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PersonDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PersonDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            PersonDialog dialog = new PersonDialog(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser birthDateChooser;
    private javax.swing.JSplitPane buttonsSplitPane;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel dateOfBirthLabel;
    private javax.swing.JLabel dateOfDeathLabel;
    private com.toedter.calendar.JDateChooser deathDateChooser;
    private javax.swing.JRadioButton femaleRadioButton;
    private javax.swing.ButtonGroup genderButtonGroup;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JRadioButton maleRadioButton;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton okButton;
    private javax.swing.JTextField placeOfBirthField;
    private javax.swing.JLabel placeOfBirthLabel;
    private javax.swing.JTextField placeOfDeathField;
    private javax.swing.JLabel placeOfDeathLabel;
    private javax.swing.JPanel varInputPanel;
    private javax.swing.JPanel varLabelsPanel;
    // End of variables declaration//GEN-END:variables
}
