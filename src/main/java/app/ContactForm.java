package app;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Image;
import javax.swing.*;

public class ContactForm extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ContactForm.class.getName());

    private boolean bOnlyReqFields = false;
    
    private JLabel lblHint; //декларираме, че такъв етикет ще има, но е null
    
    private DefaultComboBoxModel<String> countries;
    
    public ContactForm() {
        initComponents();
        setLocationRelativeTo(null);
        cmbCountry.removeAllItems();
        String[] arrCountries = {"България","Германия","Франция","Канада"};
//        for(String c : arrCountries){
//            cmbCountry.addItem(c);
//        }
        //създаваме го като обект, съществува, но не се вижда
        lblHint = new JLabel("Задължителни: име, фамилия, град");
        pnlButtons.add(lblHint);
        //lblHint.setSize(240,20);
        //int y = pnlContact.getHeight() - lblHint.getHeight() - 8; // …иначе getHeight() е 0
        //lblHint.setLocation(8, y); // долен ляв ъгъл
        countries = new DefaultComboBoxModel();
        cmbCountry.setModel(countries);
        for(String c : arrCountries){
            countries.addElement(c);
        }
        loadDefaultAvatar();
    }
    
    private void clearFields(){
        txtFirstName.setText("");
        txtLastName.setText("");
        txtCity.setText("");
        txtEmail.setText("");
        cmbCountry.setSelectedIndex(0);
        lblStatus.setText("Готово");
    }
    
    private ImageIcon scaled(Image image, int w, int h) {
        return new ImageIcon(image.getScaledInstance(w, h, Image.SCALE_SMOOTH));
    }
    
    private void loadDefaultAvatar() {
        java.net.URL url = getClass().getResource("/images/avatar.png");
        if (url == null) {
            lblStatus.setText("Липсва /images/avatar.png в target/classes");
            return;
        }
        lblPhoto.setIcon(scaled(new ImageIcon(url).getImage(), 120, 120));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        lblPhoto = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuContacts = new javax.swing.JMenu();
        miSplitName = new javax.swing.JMenuItem();
        miCountries = new javax.swing.JMenuItem();
        miRemoveCountry = new javax.swing.JMenuItem();
        miAddCountry = new javax.swing.JMenuItem();
        miPhoto = new javax.swing.JMenuItem();
        mnuView = new javax.swing.JMenu();
        miToggleFields = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(360, 360));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pnlContact.setLayout(new java.awt.BorderLayout());

        pnlFields.setLayout(new java.awt.GridLayout(5, 2, 6, 6));

        lblFirstName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblFirstName.setText("Име");
        pnlFields.add(lblFirstName);

        txtFirstName.addActionListener(this::txtFirstNameActionPerformed);
        pnlFields.add(txtFirstName);

        lblLastName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLastName.setText("Фамилия");
        pnlFields.add(lblLastName);
        pnlFields.add(txtLastName);

        lblCity.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCity.setText("Град");
        pnlFields.add(lblCity);
        pnlFields.add(txtCity);

        lblCountry.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCountry.setText("Държава");
        pnlFields.add(lblCountry);

        cmbCountry.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbCountry.addActionListener(this::cmbCountryActionPerformed);
        pnlFields.add(cmbCountry);

        lblEmail.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblEmail.setText("Имейл");
        pnlFields.add(lblEmail);
        pnlFields.add(txtEmail);

        pnlContact.add(pnlFields, java.awt.BorderLayout.NORTH);

        pnlButtons.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btnSample.setText("Примерен контакт");
        btnSample.addActionListener(this::btnSampleActionPerformed);
        pnlButtons.add(btnSample);

        btnClear.setText("Изчисти");
        btnClear.addActionListener(this::btnClearActionPerformed);
        pnlButtons.add(btnClear);

        pnlContact.add(pnlButtons, java.awt.BorderLayout.SOUTH);
        pnlContact.add(lblPhoto, java.awt.BorderLayout.LINE_END);

        getContentPane().add(pnlContact, java.awt.BorderLayout.CENTER);

        lblStatus.setText("Готово");
        getContentPane().add(lblStatus, java.awt.BorderLayout.SOUTH);

        mnuContacts.setText("Контакти");

        miSplitName.setText("Разделяне на име");
        miSplitName.addActionListener(this::miSplitNameActionPerformed);
        mnuContacts.add(miSplitName);

        miCountries.setText("Държави");
        miCountries.addActionListener(this::miCountriesActionPerformed);
        mnuContacts.add(miCountries);

        miRemoveCountry.setText("Изтриване на държава");
        miRemoveCountry.addActionListener(this::miRemoveCountryActionPerformed);
        mnuContacts.add(miRemoveCountry);

        miAddCountry.setText("Добави държава...");
        miAddCountry.addActionListener(this::miAddCountryActionPerformed);
        mnuContacts.add(miAddCountry);

        miPhoto.setText("Снимка...");
        miPhoto.addActionListener(this::miPhotoActionPerformed);
        mnuContacts.add(miPhoto);

        jMenuBar1.add(mnuContacts);

        mnuView.setText("Изглед");

        miToggleFields.setText("Показване само на задължителни полета");
        miToggleFields.addActionListener(this::miToggleFieldsActionPerformed);
        mnuView.add(miToggleFields);

        jMenuBar1.add(mnuView);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSampleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSampleActionPerformed
        txtFirstName.setText("Georgi");
        txtLastName.setText("Penchev");
        txtCity.setText("Varna");
        cmbCountry.setSelectedItem("България");
        txtEmail.setText("georgi.penchev@ue-varna.bg");
    }//GEN-LAST:event_btnSampleActionPerformed

    private void miSplitNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSplitNameActionPerformed
        String name = txtFirstName.getText(); //Ivan Ivanov
        try {
            String[] names = name.split(" ");
            //[0]->Ivan ; [1]->Ivanov
            txtFirstName.setText(names[0]);
            txtLastName.setText(names[1]);
        } catch (Exception e) {
            lblStatus.setText("Грешка: Въведете две имена през интервал");
        }
    }//GEN-LAST:event_miSplitNameActionPerformed

    private void miToggleFieldsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miToggleFieldsActionPerformed
        if(bOnlyReqFields == false){
            lblCountry.setVisible(false);
            lblEmail.setVisible(false);
            cmbCountry.setVisible(false);
            txtEmail.setVisible(false);
            miToggleFields.setText("Покажи незадължителните полета");
            bOnlyReqFields = true;
        }
        else{
            lblCountry.setVisible(true);
            lblEmail.setVisible(true);
            cmbCountry.setVisible(true);
            txtEmail.setVisible(true);
            miToggleFields.setText("Покажи само задължителните полета");
            bOnlyReqFields = false;
        }
    }//GEN-LAST:event_miToggleFieldsActionPerformed

    private void cmbCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCountryActionPerformed
        Object sel = cmbCountry.getSelectedItem();
        if(sel == null){
            lblStatus.setText("Няма избрана държава");
        }
        else{
            lblStatus.setText(sel.toString());
        }
    }//GEN-LAST:event_cmbCountryActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearFields();
    }//GEN-LAST:event_btnClearActionPerformed

    private void miCountriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCountriesActionPerformed
        String all = "";
        for (int i = 0; i < countries.getSize(); i++) {
            all += countries.getElementAt(i) + ", ";
        }
        lblStatus.setText("Държави (" + countries.getSize() + "): " + all);
    }//GEN-LAST:event_miCountriesActionPerformed

    private void miRemoveCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRemoveCountryActionPerformed
        countries.removeElement(cmbCountry.getSelectedItem());
    }//GEN-LAST:event_miRemoveCountryActionPerformed

    private void miAddCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAddCountryActionPerformed
        String country = JOptionPane.showInputDialog(this, "име на държава");
        if(country == null){
            System.out.println("null");
        }
        else if(country.trim().equals("")){
            JOptionPane.showMessageDialog(this, "Не е въведена държава", 
                    "Инфо",
                    JOptionPane.WARNING_MESSAGE);
        }
        else{
            cmbCountry.addItem(country.trim());
            cmbCountry.setSelectedItem(country.trim());
            JOptionPane.showMessageDialog(this, 
                    country.trim() + " е добавена успешно", 
                    "Инфо",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_miAddCountryActionPerformed

    // --- изход с въпрос ----------------------------------------------------
private boolean confirmExit() {
    return JOptionPane.showConfirmDialog(this, "Наистина ли искате да излезете?",
    "Изход", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)
    == JOptionPane.YES_OPTION;
}
    
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if(!confirmExit())
           
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        else
            setDefaultCloseOperation(EXIT_ON_CLOSE);
    }//GEN-LAST:event_formWindowClosing

    private void txtFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFirstNameActionPerformed

    private void miPhotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPhotoActionPerformed
    
String[] options = {
    "Готова икона",
    "От файл...",
    "Отказ"
};

int choice = JOptionPane.showOptionDialog(
    this,
    "Изберете снимка:",
    "Смяна на снимката",
    JOptionPane.DEFAULT_OPTION,
    JOptionPane.QUESTION_MESSAGE,
    null,
    options,
    options[0]
);

if (choice == 0) {
    loadDefaultAvatar();

} else if (choice == 1) {
    JFileChooser chooser = new JFileChooser();

    javax.swing.filechooser.FileNameExtensionFilter filter =
        new javax.swing.filechooser.FileNameExtensionFilter(
            "Images (*.png, *.jpg, *.jpeg)",
            "png", "jpg", "jpeg"
        );

    chooser.setFileFilter(filter);

    int result = chooser.showOpenDialog(this);

    if (result == JFileChooser.APPROVE_OPTION) {
        java.io.File file = chooser.getSelectedFile();

        ImageIcon icon = new ImageIcon(file.getAbsolutePath());

        if (icon.getIconWidth() == -1) {
            lblStatus.setText("");
            return;
        }

        lblPhoto.setIcon(
            scaled(icon.getImage(), 120, 120)
        );

        lblStatus.setText(file.getName());
    }
}


// TODO add your handling code here:
    }//GEN-LAST:event_miPhotoActionPerformed

    public static void main(String args[]) {
        FlatLightLaf.setup();
        java.awt.EventQueue.invokeLater(() -> new ContactForm().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnSample;
    private javax.swing.JComboBox<String> cmbCountry;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lblCity;
    private javax.swing.JLabel lblCountry;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblPhoto;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JMenuItem miAddCountry;
    private javax.swing.JMenuItem miCountries;
    private javax.swing.JMenuItem miPhoto;
    private javax.swing.JMenuItem miRemoveCountry;
    private javax.swing.JMenuItem miSplitName;
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
