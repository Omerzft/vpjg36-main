package app;
import javax.swing.Timer;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Image;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

public class ContactForm extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ContactForm.class.getName());
    private boolean bOnlyReqFields = false;
    private JLabel lblHint; //декларираме, че такъв етикет ще има, но е null
    private DefaultComboBoxModel<String> countries;
    private final List<Contact> contacts = new ArrayList<>();
    private Color normalBg;
    private Timer statusTimer;
    
    public ContactForm() {
        
        initComponents();
        statusTimer = new Timer(3000, e -> lblStatus.setText("Готово."));
statusTimer.setRepeats(false);
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
        normalBg = txtFirstName.getBackground();
        addSamples();
    }
    
    private void clearFields(){
        txtFirstName.setText("");
        txtLastName.setText("");
        txtCity.setText("");
        txtEmail.setText("");
        cmbCountry.setSelectedIndex(0);
        lblStatus.setText("Готово");
    loadDefaultAvatar();
    }
    
    private ImageIcon scaled(Image image, int w, int h) {
        return new ImageIcon(image.getScaledInstance(w, h, Image.SCALE_SMOOTH));
    }
    
    private void loadDefaultAvatar() {
        java.net.URL url = getClass().getResource("/images/avatar.png");
        if (url == null) {
            showStatus("Липсва /images/avatar.png в target/classes");
            return;
        }
        lblPhoto.setIcon(scaled(new ImageIcon(url).getImage(), 120, 120));
    }
private boolean reject(JTextField field, String message) {
 field.setBackground(Color.RED);
 field.requestFocus();
 JOptionPane.showMessageDialog(this, message, "Непълни данни",
 JOptionPane.WARNING_MESSAGE);
 return false;
}
private boolean formIsValid() {
 JTextField[] fields = {txtFirstName, txtLastName, txtCity, txtEmail};
 for (JTextField f : fields) {
 f.setBackground(normalBg); // първо назад към нормалното
 }
 if (txtFirstName.getText().isBlank())
 return reject(txtFirstName, "Името е задължително.");
 if (txtLastName.getText().isBlank())
 return reject(txtLastName, "Фамилията е задължителна.");
 if (txtCity.getText().isBlank())
 return reject(txtCity, "Градът е задължителен.");
 String email = txtEmail.getText().trim();
 if (!email.isEmpty()) { // празен имейл е разрешен
 int at = email.indexOf('@');
 if (at < 1 || email.indexOf('.', at) < 0)
 return reject(txtEmail, "Имейлът трябва да има @ и точка след него.");
 }
 return true;
}
private void addSamples() {
 contacts.add(new Contact("Мария", "Петрова", "София",
    "България", "m.petrova@example.bg"));
 contacts.add(new Contact("Георги", "Иванов", "София",
     "България", ""));
 contacts.add(new Contact("Елена", "Димитрова", "Пловдив",
    "България", "e.dimitrova@example.bg"));
 contacts.add(new Contact("Николай", "Тодоров", "Пловдив",
    "България", ""));
 contacts.add(new Contact("Анна", "Стоянова", "Варна",
    "България", "a.stoyanova@example.bg"));
 contacts.add(new Contact("Петър", "Колев", "Варна",
    "България", "p.kolev@example.bg"));
 contacts.add(new Contact("Ивана", "Николова", "Бургас",
    "България", "i.nikolova@example.bg"));
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
        btnAdd = new javax.swing.JButton();
        lblPhoto = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuContacts = new javax.swing.JMenu();
        miSplitName = new javax.swing.JMenuItem();
        miCountries = new javax.swing.JMenuItem();
        miRemoveCountry = new javax.swing.JMenuItem();
        miAddCountry = new javax.swing.JMenuItem();
        miPhoto = new javax.swing.JMenuItem();
        miList = new javax.swing.JMenuItem();
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
        cmbCountry.addItemListener(this::cmbCountryItemStateChanged);
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

        btnAdd.setText("Добави в списъка");
        btnAdd.addActionListener(this::btnAddActionPerformed);
        pnlButtons.add(btnAdd);

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

        miList.setText("Списък с контакти...");
        miList.addActionListener(this::miListActionPerformed);
        mnuContacts.add(miList);

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
        showStatus("Примерен контакт е добавен.", 1000);
    }//GEN-LAST:event_btnSampleActionPerformed

    private void miSplitNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSplitNameActionPerformed
        String name = txtFirstName.getText(); //Ivan Ivanov
        try {
            String[] names = name.split(" ");
            //[0]->Ivan ; [1]->Ivanov
            txtFirstName.setText(names[0]);
            txtLastName.setText(names[1]);
        } catch (Exception e) {
            showStatus("Грешка: Въведете две имена през интервал");
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
            showStatus("Няма избрана държава");
        }
        else{
            showStatus(sel.toString());
        }
    }//GEN-LAST:event_cmbCountryActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
   int response = JOptionPane.showConfirmDialog(this,"Да изчистя ли всички полета?",
        "Потвърждение", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
   if(response == JOptionPane.YES_OPTION){
   clearFields();
   showStatus("Полетата са изчистени.");}
   else{
           showStatus("Отказано.");
           }
  

    }//GEN-LAST:event_btnClearActionPerformed

    private void miCountriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCountriesActionPerformed
        String all = "";
        for (int i = 0; i < countries.getSize(); i++) {
            all += countries.getElementAt(i) + ", ";
        }
        showStatus("Държави (" + countries.getSize() + "): " + all);
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
    Object[] options= {"Излез", "Остани"};
   int choice= JOptionPane.showOptionDialog(this, "Наистина ли искате да излезете?","Изход", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null,options,options[1]);
return choice ==0;
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
            showStatus("");
            return;
        }

        lblPhoto.setIcon(
            scaled(icon.getImage(), 120, 120)
        );

        showStatus(file.getName());
    }
}


// TODO add your handling code here:
    }//GEN-LAST:event_miPhotoActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
     
 if (!formIsValid()) return;
 Contact c = new Contact(
 txtFirstName.getText().trim(), txtLastName.getText().trim(),
 txtCity.getText().trim(), cmbCountry.getSelectedItem().toString(),
 txtEmail.getText().trim());
 contacts.add(c);
 clearFields();
 JOptionPane.showMessageDialog(this, "Добавен: " + c + ". Общо: " + contacts.size() +
".");
 showStatus("Контактът е добавен ", 5000);
  // TODO add your handling code here:
    }//GEN-LAST:event_btnAddActionPerformed

    private void miListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miListActionPerformed
     new ContactListForm(contacts).setVisible(true);   // TODO add your handling code here:
    }//GEN-LAST:event_miListActionPerformed

    private void cmbCountryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCountryItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCountryItemStateChanged

    public static void main(String args[]) {
        FlatLightLaf.setup();
        java.awt.EventQueue.invokeLater(() -> new ContactForm().setVisible(true));
    }
 private void showStatus(String text, int ms) {
    lblStatus.setText(text);
    statusTimer.setInitialDelay(ms);
    statusTimer.restart();
}

private void showStatus(String text) {
    showStatus(text, 3000);
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
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
    private javax.swing.JMenuItem miList;
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
