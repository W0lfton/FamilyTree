/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pv168.familytree.gui;

import cz.muni.fi.pv168.familytree.Marriage;
import cz.muni.fi.pv168.familytree.MarriageCatalogImpl;
import cz.muni.fi.pv168.familytree.PeopleManagerImpl;
import cz.muni.fi.pv168.familytree.Person;
import cz.muni.fi.pv168.familytree.ServiceFailureException;
import static cz.muni.fi.pv168.familytree.gui.FamilyTreeGUI.log;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.sql.DataSource;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 *
 * @author Peter
 */
public class MarriageDialog extends javax.swing.JDialog {

    private DataSource dataSource;
    private Marriage marriage;
    private List<Person> list;
    private java.util.ResourceBundle bundle;
    
    /**
     * Creates new form MarriageDialog
     * @param parent
     * @param modal
     */
    public MarriageDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public MarriageDialog(java.awt.Frame parent, boolean modal, DataSource dataSource, Marriage marriage, List<Person> peopleList, java.util.ResourceBundle bundle) {
        this(parent, modal);
        this.dataSource = dataSource;
        this.marriage = marriage;
        this.bundle = bundle;
        list = peopleList;
        for (Person person : list) {
            spouse1ComboBox.addItem(person.getName());
            spouse2ComboBox.addItem(person.getName());
        }
        if (marriage != null) {
            spouse1ComboBox.setSelectedItem(marriage.getSpouse1().getName());
            spouse2ComboBox.setSelectedItem(marriage.getSpouse2().getName());
            fromDateChooser.setDate(java.sql.Date.valueOf(marriage.getFrom()));
            if (marriage.getTo() != null)
                toDateChooser.setDate(java.sql.Date.valueOf(marriage.getTo()));
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

        jPanel1 = new javax.swing.JPanel();
        spouse1Label = new javax.swing.JLabel();
        spouse2Label = new javax.swing.JLabel();
        fromLabel = new javax.swing.JLabel();
        toLabel = new javax.swing.JLabel();
        spouse1ComboBox = new javax.swing.JComboBox<>();
        spouse2ComboBox = new javax.swing.JComboBox<>();
        fromDateChooser = new com.toedter.calendar.JDateChooser();
        toDateChooser = new com.toedter.calendar.JDateChooser();
        jSplitPane1 = new javax.swing.JSplitPane();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Marriage");
        setResizable(false);

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("localization"); // NOI18N
        spouse1Label.setText(bundle.getString("spouse1Label")); // NOI18N
        spouse1Label.setToolTipText("");

        spouse2Label.setText(bundle.getString("spouse2Label")); // NOI18N

        fromLabel.setText(bundle.getString("fromLabel")); // NOI18N

        toLabel.setText(bundle.getString("toLabel")); // NOI18N

        spouse2ComboBox.setToolTipText("");

        jSplitPane1.setBorder(null);
        jSplitPane1.setDividerLocation(-1);
        jSplitPane1.setDividerSize(0);

        okButton.setText(bundle.getString("okButton")); // NOI18N
        okButton.setPreferredSize(new java.awt.Dimension(70, 32));
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        jSplitPane1.setLeftComponent(okButton);

        cancelButton.setText(bundle.getString("cancelButton")); // NOI18N
        cancelButton.setPreferredSize(new java.awt.Dimension(70, 32));
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        jSplitPane1.setRightComponent(cancelButton);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(spouse1Label)
                        .addComponent(spouse2Label))
                    .addComponent(fromLabel)
                    .addComponent(toLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spouse1ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fromDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(toDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spouse2ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(spouse1ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spouse1Label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(spouse2ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spouse2Label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fromDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fromLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(toDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(toLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        Marriage marriage = new Marriage();
        try {
            marriage.setSpouse1(list.get(spouse1ComboBox.getSelectedIndex()));
            marriage.setSpouse2(list.get(spouse2ComboBox.getSelectedIndex()));
            java.util.Date date = fromDateChooser.getDate();
            marriage.setFrom(date != null ? new java.sql.Date(date.getTime()).toLocalDate() : null);
            date = toDateChooser.getDate();
            marriage.setTo(date != null ? new java.sql.Date(date.getTime()).toLocalDate() : null);
            validateMarriage(marriage);
            if (this.marriage == null) {
                //create
                this.marriage = marriage;
                new createMarriageSwingWorker().execute();
            } else {
                //update
                marriage.setId(this.marriage.getId());
                this.marriage = marriage;
                new updateMarriageSwingWorker().execute();
            }
            setVisible(false);
        } catch(IllegalArgumentException ex) {
            log.error("Failed to validate Marriage", ex);
            JOptionPane.showMessageDialog(this, ex.getMessage(), bundle.getString("warning"), JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void validateMarriage(Marriage marriage) {
        
        if (marriage.getFrom() == null) {
            throw new IllegalArgumentException(bundle.getString("marriageFromNull"));
        }
        if(marriage.getSpouse1().equals(marriage.getSpouse2())) {
            throw new IllegalArgumentException(bundle.getString("sameSpouses"));
        }
        if(marriage.getSpouse1().getDateOfBirth().isAfter(marriage.getFrom().minusYears(MarriageCatalogImpl.ACCEPTED_AGE_FOR_MARRIAGE))) {
            throw new IllegalArgumentException(bundle.getString("spouseTooYoung") + "(1)");
        }
        if(marriage.getSpouse2().getDateOfBirth().isAfter(marriage.getFrom().minusYears(MarriageCatalogImpl.ACCEPTED_AGE_FOR_MARRIAGE))) {
            throw new IllegalArgumentException(bundle.getString("spouseTooYoung") + "(2)");
        }
        if(marriage.getSpouse1().getDateOfDeath() != null
                && marriage.getSpouse1().getDateOfDeath().isBefore(marriage.getFrom())) {
            throw new IllegalArgumentException(bundle.getString("spouseDead") + "(1)");
        }
        if(marriage.getSpouse2().getDateOfDeath() != null
                && marriage.getSpouse2().getDateOfDeath().isBefore(marriage.getFrom())) {
            throw new IllegalArgumentException(bundle.getString("spouseDead") + "(2)");
        }
        if(marriage.getTo() != null && marriage.getTo().isBefore(marriage.getFrom())) {
            throw new IllegalArgumentException(bundle.getString("toFromDates"));
        }
    }
    
    private class createMarriageSwingWorker extends SwingWorker<Boolean, Void> {

        @Override
        protected Boolean doInBackground() throws Exception {
            try {
                new MarriageCatalogImpl(dataSource, new PeopleManagerImpl(dataSource)).createMarriage(marriage);
                return false;
            } catch(ServiceFailureException | IllegalArgumentException ex) {
                log.error("Failed to create Marriage", ex);
                return true;
            }
        }
        
        @Override
        protected void done() {
            try {
                if (get()) {
                    JOptionPane.showMessageDialog(null, bundle.getString("createMarriageFail"), bundle.getString("error"), JOptionPane.ERROR_MESSAGE);
                } else {
                    log.info("Sucessfully created Marriage in database");
                    updateGUI();
                }
            } catch(InterruptedException | ExecutionException ex) {
                log.error("Failed to create Marriage", ex);
            }
        }
    }
    
    private class updateMarriageSwingWorker extends SwingWorker<Integer, Void> {

        @Override
        protected Integer doInBackground() throws Exception {
            try {
                new MarriageCatalogImpl(dataSource, new PeopleManagerImpl(dataSource)).updateMarriage(marriage);
                return 0;
            } catch(ServiceFailureException | IllegalArgumentException ex) {
                log.error("Failed to update Marriage", ex);
                return 1;
            }
        }
        
        @Override
        protected void done() {
            try {
                if (get() == 1) {
                    JOptionPane.showMessageDialog(null, bundle.getString("updateMarriageFail"), bundle.getString("error"), JOptionPane.ERROR_MESSAGE);
                } else {
                    log.info("Sucessfully created Marriage in database");
                    updateGUI();
                }
            } catch(InterruptedException | ExecutionException ex) {
                log.error("Failed to update Marriage", ex);
            }
        }
    }
    
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
            java.util.logging.Logger.getLogger(MarriageDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MarriageDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MarriageDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MarriageDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MarriageDialog dialog = new MarriageDialog(new javax.swing.JFrame(), true);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private com.toedter.calendar.JDateChooser fromDateChooser;
    private javax.swing.JLabel fromLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JButton okButton;
    private javax.swing.JComboBox<String> spouse1ComboBox;
    private javax.swing.JLabel spouse1Label;
    private javax.swing.JComboBox<String> spouse2ComboBox;
    private javax.swing.JLabel spouse2Label;
    private com.toedter.calendar.JDateChooser toDateChooser;
    private javax.swing.JLabel toLabel;
    // End of variables declaration//GEN-END:variables
}
