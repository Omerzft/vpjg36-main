
package app;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
public class ContactListForm extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ContactListForm.class.getName());
    private final List<Contact> contacts;
    private DefaultListModel<Contact> listModel;
    
    public ContactListForm(List<Contact> contacts) {
        initComponents();
        this.contacts=contacts; //this.contacts e ukazatel kum sushtiq masiv
        setLocationRelativeTo(null);
        listModel = new DefaultListModel();
        lstContacts.setModel(listModel);
        show(this.contacts);
    }
    
private void show(List<Contact> data) {
 listModel.clear();
 for (Contact c : data) {
 listModel.addElement(c);
 }
 lblCount.setText("Показани: " + listModel.getSize()
 + " от " + contacts.size());
}
private String selectedCity() {
 if (rbSofia.isSelected()) return "София";
 if (rbPlovdiv.isSelected()) return "Пловдив";
 if (rbVarna.isSelected()) return "Варна";
 return null; // „Всички“
}
private void applyFilter() {
 String city = selectedCity();
 List<Contact> result = new ArrayList<>();
 for (Contact c : contacts) {
    if (city == null || c.getCity().equalsIgnoreCase(city)) {
        result.add(c);
        }
 }
 show(result);
}
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgCity = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstContacts = new javax.swing.JList<>();
        lblCount = new javax.swing.JLabel();
        lblDetails = new javax.swing.JLabel();
        rbAll = new javax.swing.JRadioButton();
        rbSofia = new javax.swing.JRadioButton();
        rbPlovdiv = new javax.swing.JRadioButton();
        rbVarna = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Контакти-Списък");

        jScrollPane1.setViewportView(lstContacts);

        lblCount.setText("jLabel1");

        lblDetails.setText("jLabel2");

        bgCity.add(rbAll);
        rbAll.setSelected(true);
        rbAll.setText("Всички");
        rbAll.addActionListener(this::rbAllActionPerformed);

        bgCity.add(rbSofia);
        rbSofia.setText("София");
        rbSofia.addActionListener(this::rbSofiaActionPerformed);

        bgCity.add(rbPlovdiv);
        rbPlovdiv.setText("Пловдив");
        rbPlovdiv.addActionListener(this::rbPlovdivActionPerformed);

        bgCity.add(rbVarna);
        rbVarna.setText("Варна");
        rbVarna.addActionListener(this::rbVarnaActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDetails)
                    .addComponent(lblCount)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbAll)
                            .addComponent(rbSofia)
                            .addComponent(rbPlovdiv)
                            .addComponent(rbVarna, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(rbAll)
                        .addGap(18, 18, 18)
                        .addComponent(rbSofia)
                        .addGap(18, 18, 18)
                        .addComponent(rbPlovdiv)
                        .addGap(18, 18, 18)
                        .addComponent(rbVarna))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCount)
                .addGap(18, 18, 18)
                .addComponent(lblDetails)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAllActionPerformed
applyFilter();        // TODO add your handling code here:
    }//GEN-LAST:event_rbAllActionPerformed

    private void rbPlovdivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbPlovdivActionPerformed
applyFilter();          // TODO add your handling code here:
    }//GEN-LAST:event_rbPlovdivActionPerformed

    private void rbSofiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSofiaActionPerformed
applyFilter();          // TODO add your handling code here:
    }//GEN-LAST:event_rbSofiaActionPerformed

    private void rbVarnaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbVarnaActionPerformed
applyFilter();          // TODO add your handling code here:
    }//GEN-LAST:event_rbVarnaActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgCity;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCount;
    private javax.swing.JLabel lblDetails;
    private javax.swing.JList<Contact> lstContacts;
    private javax.swing.JRadioButton rbAll;
    private javax.swing.JRadioButton rbPlovdiv;
    private javax.swing.JRadioButton rbSofia;
    private javax.swing.JRadioButton rbVarna;
    // End of variables declaration//GEN-END:variables
}
