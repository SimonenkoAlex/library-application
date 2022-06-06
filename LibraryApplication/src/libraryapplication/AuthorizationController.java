package libraryapplication;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class AuthorizationController extends javax.swing.JFrame {
    private DatabaseHandler connect;
    private RegistrationController registration;
    
    public AuthorizationController() {
        initComponents();
        connect = new DatabaseHandler();
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {  
        connect.destroy(); 
    } 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelTitle = new javax.swing.JPanel();
        LabelTitle = new javax.swing.JLabel();
        PanelMain = new javax.swing.JPanel();
        PanelForm = new javax.swing.JPanel();
        PanelExtra = new javax.swing.JPanel();
        PanelLabel = new javax.swing.JPanel();
        LabelLogin = new javax.swing.JLabel();
        LabelEmpty1 = new javax.swing.JLabel();
        LabelPassword = new javax.swing.JLabel();
        LabelEmpty2 = new javax.swing.JLabel();
        PanelTextField = new javax.swing.JPanel();
        TextLogin = new javax.swing.JFormattedTextField();
        LabelHint1 = new javax.swing.JLabel();
        TextPassword = new javax.swing.JPasswordField();
        LabelHint2 = new javax.swing.JLabel();
        PanelButton = new javax.swing.JPanel();
        BtnEntry = new javax.swing.JButton();
        BtnRegistration = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Авторизация");
        setPreferredSize(new java.awt.Dimension(500, 400));
        setResizable(false);
        getContentPane().setLayout(new java.awt.BorderLayout(0, 2));

        PanelTitle.setBackground(new java.awt.Color(204, 204, 0));
        PanelTitle.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 40));

        LabelTitle.setFont(new java.awt.Font("GungsuhChe", 2, 24)); // NOI18N
        LabelTitle.setText("Библиотека \"ОмГТУ\"");
        PanelTitle.add(LabelTitle);

        getContentPane().add(PanelTitle, java.awt.BorderLayout.PAGE_START);

        PanelMain.setBackground(new java.awt.Color(255, 255, 153));
        PanelMain.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 30));

        PanelForm.setBackground(new java.awt.Color(255, 255, 153));
        PanelForm.setLayout(new javax.swing.BoxLayout(PanelForm, javax.swing.BoxLayout.Y_AXIS));

        PanelExtra.setBackground(new java.awt.Color(255, 255, 153));
        PanelExtra.setLayout(new javax.swing.BoxLayout(PanelExtra, javax.swing.BoxLayout.X_AXIS));

        PanelLabel.setBackground(new java.awt.Color(255, 255, 153));
        PanelLabel.setLayout(new java.awt.GridLayout(4, 0));

        LabelLogin.setFont(new java.awt.Font("Gungsuh", 1, 24)); // NOI18N
        LabelLogin.setText("Логин");
        PanelLabel.add(LabelLogin);
        PanelLabel.add(LabelEmpty1);

        LabelPassword.setFont(new java.awt.Font("Gungsuh", 1, 24)); // NOI18N
        LabelPassword.setText("Пароль");
        PanelLabel.add(LabelPassword);
        PanelLabel.add(LabelEmpty2);

        PanelExtra.add(PanelLabel);

        PanelTextField.setBackground(new java.awt.Color(255, 255, 153));
        PanelTextField.setLayout(new java.awt.GridLayout(4, 0));

        try {
            TextLogin.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("+7(###)###-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        TextLogin.setPreferredSize(new java.awt.Dimension(300, 30));
        PanelTextField.add(TextLogin);

        LabelHint1.setFont(new java.awt.Font("Gungsuh", 2, 14)); // NOI18N
        LabelHint1.setForeground(new java.awt.Color(255, 51, 51));
        LabelHint1.setText("* введите номер телефона");
        PanelTextField.add(LabelHint1);
        PanelTextField.add(TextPassword);

        LabelHint2.setFont(new java.awt.Font("Gungsuh", 2, 14)); // NOI18N
        LabelHint2.setForeground(new java.awt.Color(255, 51, 51));
        LabelHint2.setText("* количество символов более 8");
        PanelTextField.add(LabelHint2);

        PanelExtra.add(PanelTextField);

        PanelForm.add(PanelExtra);

        PanelButton.setBackground(new java.awt.Color(255, 255, 153));
        PanelButton.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        BtnEntry.setFont(new java.awt.Font("Gungsuh", 0, 18)); // NOI18N
        BtnEntry.setText("Войти");
        BtnEntry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEntryActionPerformed(evt);
            }
        });
        PanelButton.add(BtnEntry);

        BtnRegistration.setFont(new java.awt.Font("Gungsuh", 0, 18)); // NOI18N
        BtnRegistration.setText("Регистрация");
        BtnRegistration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegistrationActionPerformed(evt);
            }
        });
        PanelButton.add(BtnRegistration);

        PanelForm.add(PanelButton);

        PanelMain.add(PanelForm);

        getContentPane().add(PanelMain, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BtnEntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEntryActionPerformed
        String loginText = TextLogin.getText().trim();
        String loginPassword = TextPassword.getText().trim();
        if (!loginText.equals("") && !loginPassword.equals("")) {
            loginUser(loginText, loginPassword);
        }
        else {
            JOptionPane.showMessageDialog(this, "Логин и/или пароль не был введён!");
        }
    }//GEN-LAST:event_BtnEntryActionPerformed

    private void BtnRegistrationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegistrationActionPerformed
        try {
            registration = new RegistrationController(connect.getDbConnection());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AuthorizationController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AuthorizationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtnRegistrationActionPerformed

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
            java.util.logging.Logger.getLogger(AuthorizationController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AuthorizationController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AuthorizationController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AuthorizationController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AuthorizationController().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEntry;
    private javax.swing.JButton BtnRegistration;
    private javax.swing.JLabel LabelEmpty1;
    private javax.swing.JLabel LabelEmpty2;
    private javax.swing.JLabel LabelHint1;
    private javax.swing.JLabel LabelHint2;
    private javax.swing.JLabel LabelLogin;
    private javax.swing.JLabel LabelPassword;
    private javax.swing.JLabel LabelTitle;
    private javax.swing.JPanel PanelButton;
    private javax.swing.JPanel PanelExtra;
    private javax.swing.JPanel PanelForm;
    private javax.swing.JPanel PanelLabel;
    private javax.swing.JPanel PanelMain;
    private javax.swing.JPanel PanelTextField;
    private javax.swing.JPanel PanelTitle;
    private javax.swing.JFormattedTextField TextLogin;
    private javax.swing.JPasswordField TextPassword;
    // End of variables declaration//GEN-END:variables

    private void loginUser(String loginText, String loginPassword) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
