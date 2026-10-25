
package app;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
public class ContactListForm extends javax.swing.JFrame {
    
    private boolean shortView = false;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ContactListForm.class.getName());
    private final List<Contact> contacts;
    private DefaultListModel<Contact> listModel;
    private Timer refreshTimer;
 private String[] COLUMNS = {"Име","Фамилия","Град","Държава","Имейл"};
    private DefaultTableModel tableModel = new DefaultTableModel(COLUMNS, 0)
    {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // нито една клетка няма да се редактира
        }
    };
    private List<Contact> shown; //ще пази видимите елементи в таблицата
    
    public ContactListForm(List<Contact> contacts) {
    initComponents();
    this.contacts = contacts;
    setLocationRelativeTo(null);
    listModel = new DefaultListModel<>();
    lstContacts.setModel(listModel);
    tblContacts.setModel(tableModel);
    tblContacts.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    applyFilter();
    refreshTimer = new Timer(5000, e -> applyFilter());
    refreshTimer.start();
}
    
private void show(List<Contact> data) {
    shown = data;
    listModel.clear();
    tableModel.setRowCount(0);   // this line is missing in your code
    for (Contact c : data) {
        listModel.addElement(c);
       
        
        if(shortView){tableModel.addRow(new String[]{ c.getFirstName(), c.getLastName()});
    }else{tableModel.addRow(c.getProperties());
        }
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
  contacts.sort((a, b) ->
          a.getLastName().compareToIgnoreCase(b.getLastName()));
 for (Contact c : contacts) {
  boolean cityOk = city == null || c.getCity().equalsIgnoreCase(city);
boolean emailOk = !chkEmail.isSelected() || !c.getEmail().isBlank();
if (cityOk && emailOk) {
 result.add(c);
}

        
 }
 show(result);
}
   
    private Contact selected() {
        int row = tblContacts.getSelectedRow();
        if (row < 0) { // −1: нищо не е маркирано
            lblCount.setText("Маркирайте контакт.");
            return null;
        }
        Contact c = shown.get(row);
        return c;
    }
    private void deleteSelected() {
        Contact c = selected();
        if (c == null) return;
        int answer = JOptionPane.showConfirmDialog(this,
            "Да изтрия ли " + c + "?", "Изтриване",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (answer == JOptionPane.YES_OPTION) {
            //изтриваме обекта от масива с данни
            contacts.remove(c);
            applyFilter(); //презареждаме данните в таблицата и листа
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgCity = new javax.swing.ButtonGroup();
        popRow = new javax.swing.JPopupMenu();
        miDetails = new javax.swing.JMenuItem();
        miDelete = new javax.swing.JMenuItem();
        miNew = new javax.swing.JMenuItem();
        miShortView = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstContacts = new javax.swing.JList<>();
        lblCount = new javax.swing.JLabel();
        lblDetails = new javax.swing.JLabel();
        rbAll = new javax.swing.JRadioButton();
        rbSofia = new javax.swing.JRadioButton();
        rbPlovdiv = new javax.swing.JRadioButton();
        rbVarna = new javax.swing.JRadioButton();
        btnDelete = new javax.swing.JButton();
        chkEmail = new javax.swing.JCheckBox();
        btnReload = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblContacts = new javax.swing.JTable();
        btnDelete1 = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        CSVBtn = new javax.swing.JButton();

        miDetails.setText("Подробности");
        miDetails.addActionListener(this::miDetailsActionPerformed);
        popRow.add(miDetails);

        miDelete.setText("Изтрий");
        miDelete.addActionListener(this::miDeleteActionPerformed);
        popRow.add(miDelete);

        miNew.setText("Нов контакт");
        miNew.addActionListener(this::miNewActionPerformed);
        popRow.add(miNew);

        miShortView.setText("Кратък изглед");
        miShortView.addActionListener(this::miShortViewActionPerformed);
        popRow.add(miShortView);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Контакти-Списък");

        lstContacts.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        lstContacts.addListSelectionListener(this::lstContactsValueChanged);
        jScrollPane1.setViewportView(lstContacts);

        lblCount.setText("jLabel1");

        lblDetails.setText("Подробности");

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

        btnDelete.setText("Изтрий");
        btnDelete.addActionListener(this::btnDeleteActionPerformed);

        chkEmail.setText("Само с имейл");

        btnReload.setText("Презареди");
        btnReload.addActionListener(this::btnReloadActionPerformed);

        tblContacts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblContacts.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        tblContacts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblContactsMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblContactsMousePressed(evt);
            }
        });
        tblContacts.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblContactsKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblContacts);

        btnDelete1.setText("Изтрий маркирания ред");
        btnDelete1.addActionListener(this::btnDelete1ActionPerformed);

        btnSearch.setText("Търси");
        btnSearch.addActionListener(this::btnSearchActionPerformed);

        CSVBtn.setText("Запази като CSV");
        CSVBtn.addActionListener(this::CSVBtnActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCount)
                            .addComponent(lblDetails, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnReload, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbAll)
                    .addComponent(rbSofia)
                    .addComponent(rbPlovdiv)
                    .addComponent(rbVarna, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete)
                    .addComponent(chkEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnDelete1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CSVBtn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDelete1)
                            .addComponent(CSVBtn)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(rbAll)
                                .addGap(18, 18, 18)
                                .addComponent(rbSofia)
                                .addGap(18, 18, 18)
                                .addComponent(rbPlovdiv)
                                .addGap(18, 18, 18)
                                .addComponent(rbVarna)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chkEmail)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDelete))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCount)
                            .addComponent(btnReload))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDetails)
                            .addComponent(btnSearch))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

    private void lstContactsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstContactsValueChanged
        if (evt.getValueIsAdjusting()) return; // изборът още се мени
Contact c = lstContacts.getSelectedValue(); // Contact, не String
if (c == null) return; 
String email = c.getEmail().isBlank() ? "без имейл" : c.getEmail();
lblDetails.setText(c.getFirstName() + " " + c.getLastName() + ", "
 + c.getCity() + ", " + c.getCountry() + ", " + email);
        // TODO add your handling code here:
    }//GEN-LAST:event_lstContactsValueChanged

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
      List<Contact> selected = lstContacts.getSelectedValuesList();
if (selected.isEmpty()) {
 lblCount.setText("Маркирайте контакт.");
 return;
}
int answer = JOptionPane.showConfirmDialog(this,
 "Да се изтрият ли " + selected.size() + " контакта?", "Изтриване",
 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
if (answer == JOptionPane.YES_OPTION) {contacts.removeAll(selected);
applyFilter();

 // TODO 2: изтрийте от данните и прерисувайте
}  // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadActionPerformed
applyFilter();        // TODO add your handling code here:
    }//GEN-LAST:event_btnReloadActionPerformed

    private void tblContactsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblContactsKeyPressed
      if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            deleteSelected();
        } // TODO add your handling code here:
    }//GEN-LAST:event_tblContactsKeyPressed

    private void tblContactsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblContactsMousePressed
            if(SwingUtilities.isRightMouseButton(evt) == false)
            return;
        //връща индекса на реда, натиснат с десния бутон на мишката
        int row = tblContacts.rowAtPoint(evt.getPoint());
        tblContacts.setRowSelectionInterval(row, row);
        popRow.show(evt.getComponent(), evt.getX(), evt.getY());
        // TODO add your handling code here:
    }//GEN-LAST:event_tblContactsMousePressed

    private void miDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miDetailsActionPerformed
showDetails();        // TODO add your handling code here:
    }//GEN-LAST:event_miDetailsActionPerformed

    private void miDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miDeleteActionPerformed
       deleteSelected();  // TODO add your handling code here:
    }//GEN-LAST:event_miDeleteActionPerformed

    private void miNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miNewActionPerformed
newContact();        // TODO add your handling code here:
    }//GEN-LAST:event_miNewActionPerformed

    private void btnDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete1ActionPerformed
  
int[] rows = tblContacts.getSelectedRows();
if(rows.length == 0){
JOptionPane.showMessageDialog(this, "nothing is selected", "nothing", JOptionPane.INFORMATION_MESSAGE);
return;}
List<Contact> toDelete = new ArrayList<>();
for (int viewRow : rows) {
    int modelRow = tblContacts.convertRowIndexToModel(viewRow);
   toDelete.add( shown.get( modelRow) );
}

int answer = JOptionPane.showConfirmDialog(this, "Изтриване на " + toDelete.size() + " контакта?", "Потвърждение", JOptionPane.YES_NO_OPTION);
if (answer == JOptionPane.YES_OPTION) {
 contacts.removeAll(toDelete);
 applyFilter();
}


// TODO add your handling code here:
    }//GEN-LAST:event_btnDelete1ActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
String input = JOptionPane.showInputDialog(this, "Въведено име"); 
if(input != null){
    boolean found = false;
        input=input.trim().toLowerCase();
                for( Contact c : contacts){
                    String word =  c.getFirstName();
                    String wordt = c.getLastName();
                    boolean ok = word.toLowerCase().contains(input);
                   boolean okt = wordt.toLowerCase().contains(input);
                    
                  if (ok || okt){
                       int modelRow = shown.indexOf(c);
                     found=true;
    if (modelRow == -1) { JOptionPane.showMessageDialog(this, "Съществува, но филтърът го крие",
            "търсене", JOptionPane.WARNING_MESSAGE);
       
    } else {
        int viewRow = tblContacts.convertRowIndexToView(modelRow);
       tblContacts.setRowSelectionInterval( viewRow,viewRow ); // select this row in tblContacts
    }
    
    break;
    
                }
                }if(!found){
        JOptionPane.showMessageDialog(this, "няма съществуващ контакт с името",
            "търсене", JOptionPane.WARNING_MESSAGE);
    }
                }    
// TODO add your handling code here:
    }//GEN-LAST:event_btnSearchActionPerformed

    private void tblContactsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblContactsMouseClicked
if(evt.getClickCount() ==2 )
{ int viewRow = tblContacts.rowAtPoint(evt.getPoint());
        if(viewRow >=0){
            int modelRow = tblContacts.convertRowIndexToModel(viewRow);
            Contact c = shown.get(modelRow);
            JOptionPane.showMessageDialog(this, c.getProperties(), "Подробности", JOptionPane.INFORMATION_MESSAGE);
}

}     // TODO add your handling code here:
    }//GEN-LAST:event_tblContactsMouseClicked

    private void CSVBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CSVBtnActionPerformed
     StringBuilder sb = new StringBuilder();
for (Contact c : shown) {
    sb.append( c.getFirstName()+","+c.getLastName()+","+c.getCity() +","+c.getCountry()+","+c.getEmail()).append("\n");
}

try {
    Files.writeString(Path.of("contacts.csv"), sb.toString());
  JOptionPane.showMessageDialog(this, "saved " + Path.of("contacts.csv").toAbsolutePath(), "message", JOptionPane.INFORMATION_MESSAGE);
} catch (IOException ex) {
   JOptionPane.showMessageDialog(this, "error", "message", JOptionPane.ERROR_MESSAGE);
}   // TODO add your handling code here:
    }//GEN-LAST:event_CSVBtnActionPerformed

    private void miShortViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miShortViewActionPerformed
    shortView = !shortView;
if (shortView) {
tableModel.setColumnIdentifiers(new String[]{ "Име", "Фамилия"  });
} else {
     tableModel.setColumnIdentifiers(new String[]{   "Име", "Фамилия","Град","Държава","Имейл"});
}
show(shown);  // TODO add your handling code here:
    }//GEN-LAST:event_miShortViewActionPerformed

    private void showDetails() {
        Contact c = selected();
        if (c == null) return;
        String email = c.getEmail().isBlank() ? "без имейл" : c.getEmail();
        //в момента toString връща име, фамилия и град
        lblDetails.setText(c.toString() + " " + c.getCountry() + " " + email);
    }
    
    private void newContact() {
        JTextField txtFirstName = new JTextField();
        JTextField txtLastName = new JTextField();
        JTextField txtCity = new JTextField();
        JTextField txtCountry = new JTextField();
        JTextField txtEmail = new JTextField();
        Object[] content = {"Име:", txtFirstName, "Фамилия:", txtLastName,
            "Град:", txtCity, "Държава:", txtCountry,
            "Имейл:", txtEmail
        };
        int answer = JOptionPane.showConfirmDialog(this, content, "Нов контакт",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (answer != JOptionPane.OK_OPTION) return; // Cancel или X
        if (txtFirstName.getText().isBlank() || txtLastName.getText().isBlank()
            || txtCity.getText().isBlank()) 
        {
            JOptionPane.showMessageDialog(this, "Име, фамилия и град са задължителни.",
            "Непълни данни", JOptionPane.WARNING_MESSAGE);
            return;
        }
            Contact c = new Contact(
                txtFirstName.getText().trim(), txtLastName.getText().trim(),
                txtCity.getText().trim(), txtCountry.getText().trim(),
                txtEmail.getText().trim()
            );
            contacts.add(c);
            applyFilter();
            int row = shown.indexOf(c);
            if (row >= 0) tblContacts.setRowSelectionInterval(row, row);
            else lblCount.setText("Добавен, но филтърът го крие.");
        }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CSVBtn;
    private javax.swing.ButtonGroup bgCity;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDelete1;
    private javax.swing.JButton btnReload;
    private javax.swing.JButton btnSearch;
    private javax.swing.JCheckBox chkEmail;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCount;
    private javax.swing.JLabel lblDetails;
    private javax.swing.JList<Contact> lstContacts;
    private javax.swing.JMenuItem miDelete;
    private javax.swing.JMenuItem miDetails;
    private javax.swing.JMenuItem miNew;
    private javax.swing.JMenuItem miShortView;
    private javax.swing.JPopupMenu popRow;
    private javax.swing.JRadioButton rbAll;
    private javax.swing.JRadioButton rbPlovdiv;
    private javax.swing.JRadioButton rbSofia;
    private javax.swing.JRadioButton rbVarna;
    private javax.swing.JTable tblContacts;
    // End of variables declaration//GEN-END:variables
}
