
package app;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Component;

import javax.swing.*;

public class ContactForm extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ContactForm.class.getName());
    private boolean bOnlyReqFields = false;
    private JLabel lblHint; //deklarirame che takuv etiket shte ima noe  null
    
    
//       private void clearFields() {
//    for (Component c : pnlContact.getComponents()) {
//        if (c instanceof JTextField t) {
//            t.setText("");
//        }
//    }
//}      
       
    public ContactForm() {
        initComponents();
        setLocationRelativeTo(null);
        cmbCountry.removeAllItems();
        String[] arrCountries = {"Bulgaria","Germany","France","Canada"};
        for(String c : arrCountries){
        cmbCountry.addItem(c);
            
        }
        //suzdavame go kato obekt, sushtestuva no ne se vijda
        lblHint = new JLabel("zaduljitelni: ime, familia, grad");
         pnlButtons.add(lblHint);
       //  lblHint.setSize(240,20);
        // int y= pnlContact.getHeight()- lblHint.getHeight() - 8;
        // lblHint.setLocation(8, y);
        setMinimumSize(new java.awt.Dimension(420, 320));
    }
    
private void clearFields() {
       txtFirstName.setText("");
       txtLastName.setText("");
              txtCity.setText("");
       cmbCountry.setSelectedIndex(0);
              txtEmail.setText("");

       lblStatus.setText("Ready!");

       }
                                                                       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        pnlContact = new javax.swing.JPanel();
        pnlFields = new javax.swing.JPanel();
        lblFirstName = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        lblLastName = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        lblCity = new javax.swing.JLabel();
        txtCity = new javax.swing.JTextField();
        lblCountry = new javax.swing.JLabel();
        cmbCountry = new javax.swing.JComboBox<>();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        pnlButtons = new javax.swing.JPanel();
        btnSample = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnswap = new javax.swing.JButton();
        lblStatus = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuContacts = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        mnuView = new javax.swing.JMenu();
        miToggleFields = new javax.swing.JMenuItem();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlContact.setLayout(new java.awt.BorderLayout());

        pnlFields.setLayout(new java.awt.GridLayout(5, 2, 6, 6));

        lblFirstName.setText("Име");
        pnlFields.add(lblFirstName);

        txtFirstName.addActionListener(this::txtFirstNameActionPerformed);
        pnlFields.add(txtFirstName);

        lblLastName.setText("Фамилия");
        pnlFields.add(lblLastName);

        txtLastName.setText(" ");
        txtLastName.addActionListener(this::txtLastNameActionPerformed);
        pnlFields.add(txtLastName);

        lblCity.setText("Град");
        pnlFields.add(lblCity);

        txtCity.setText(" ");
        pnlFields.add(txtCity);

        lblCountry.setText("Държава");
        pnlFields.add(lblCountry);

        cmbCountry.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbCountry.addActionListener(this::cmbCountryActionPerformed);
        pnlFields.add(cmbCountry);

        lblEmail.setText("Имейл");
        pnlFields.add(lblEmail);
        pnlFields.add(txtEmail);

        pnlContact.add(pnlFields, java.awt.BorderLayout.CENTER);

        pnlButtons.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btnSample.setText("Примерен Контакт");
        btnSample.addActionListener(this::btnSampleActionPerformed);
        pnlButtons.add(btnSample);

        btnClear.setText("clear");
        btnClear.addActionListener(this::btnClearActionPerformed);
        pnlButtons.add(btnClear);

        btnswap.setText("btn");
        btnswap.addActionListener(this::btnswapActionPerformed);
        pnlButtons.add(btnswap);

        pnlContact.add(pnlButtons, java.awt.BorderLayout.SOUTH);

        lblStatus.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        pnlContact.add(lblStatus, java.awt.BorderLayout.WEST);

        mnuContacts.setText("Контакти");

        jMenuItem1.setText("Razdelqne na ime");
        jMenuItem1.addActionListener(this::jMenuItem1ActionPerformed);
        mnuContacts.add(jMenuItem1);

        jMenuBar1.add(mnuContacts);

        mnuView.setText("Изглед");

        miToggleFields.setText("Показване само на задължителни полета");
        miToggleFields.addActionListener(this::miToggleFieldsActionPerformed);
        mnuView.add(miToggleFields);

        jMenuBar1.add(mnuView);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlContact, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlContact, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLastNameActionPerformed

    private void txtFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFirstNameActionPerformed

    private void btnSampleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSampleActionPerformed
        txtFirstName.setText("Omer");
        txtLastName.setText("Ereceb");
txtCity.setText("Burgas");
cmbCountry.setSelectedItem("Bulgaria");
txtEmail.setText("omerereceb@gmail.com");
txtLastName.setText(txtLastName.getText().toUpperCase());
// TODO add your handling code here:
    }//GEN-LAST:event_btnSampleActionPerformed
 
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        String name = txtFirstName.getText();
        try {
            String[] names = name.split(" ");
                    txtFirstName.setText(names[0]);
                    txtLastName.setText(names[1]);
                        } catch (Exception e) { lblStatus.setText("vivedete dve imena interval");
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void miToggleFieldsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miToggleFieldsActionPerformed

        if(bOnlyReqFields==false){
            lblCountry.setVisible(false);
lblEmail.setVisible(false);
cmbCountry.setVisible(false);
txtEmail.setVisible(false);
miToggleFields.setText("Pokaji nezadiljitelnite poleta");
bOnlyReqFields = true;
        }
        else {
            lblCountry.setVisible(true);
lblEmail.setVisible(true);
cmbCountry.setVisible(true);
txtEmail.setVisible(true);
miToggleFields.setText("Pokaji nezadiljitelnite poleta");
bOnlyReqFields = false;
        }
    }//GEN-LAST:event_miToggleFieldsActionPerformed

    private void btnswapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnswapActionPerformed
        String none = txtFirstName.getText();
        txtFirstName.setText(txtLastName.getText());
        txtLastName.setText(none);
     

        // TODO add your handling code here:
    }//GEN-LAST:event_btnswapActionPerformed

    private void cmbCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCountryActionPerformed
Object sel = cmbCountry.getSelectedItem();   
if(sel == null){
    lblStatus.setText("Nqma izbrana dirjava");
    
}
else{
    lblStatus.setText(sel.toString());
}
// TODO add your handling code here:
    }//GEN-LAST:event_cmbCountryActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
clearFields();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnClearActionPerformed
       
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
       FlatLightLaf.setup();
       
        
        java.awt.EventQueue.invokeLater(() -> new ContactForm().setVisible(true));
    }
                                                                                
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnSample;
    private javax.swing.JButton btnswap;
    private javax.swing.JComboBox<String> cmbCountry;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JLabel lblCity;
    private javax.swing.JLabel lblCountry;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JMenuItem miToggleFields;
    private javax.swing.JMenu mnuContacts;
    private javax.swing.JMenu mnuView;
    private javax.swing.JPanel pnlButtons;
    private javax.swing.JPanel pnlContact;
    private javax.swing.JPanel pnlFields;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    // End of variables declaration//GEN-END:variables
}
