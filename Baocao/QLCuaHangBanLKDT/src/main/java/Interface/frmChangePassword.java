/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;

import Controllers.DangNhapController;
import java.awt.event.KeyEvent;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class frmChangePassword extends javax.swing.JFrame {

    private DangNhapController dangNhapController;
    private String TaiKhoan;
    private String MatKhau;

    /**
     * Creates new form TrangChu
     */
    public frmChangePassword(String TK, String MK) {
        initComponents();
        dangNhapController = new DangNhapController();
        this.TaiKhoan = TK;
        this.MatKhau = MK;
    }

    /**
     * Creates new form frmChangePassword
     */
    public frmChangePassword() {
        initComponents();
        dangNhapController = new DangNhapController();
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
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtReWriteMK = new javax.swing.JPasswordField();
        txtNewMK = new javax.swing.JPasswordField();
        txtMK = new javax.swing.JPasswordField();
        txtTK = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        cbxHienMK = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đổi mật khẩu");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ĐỔI MẬT KHẨU");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Tài khoản");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Mật khẩu");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Mật khẩu mới");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Nhập lại mật khẩu mới");

        txtReWriteMK.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtReWriteMKKeyPressed(evt);
            }
        });

        txtNewMK.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNewMKKeyPressed(evt);
            }
        });

        txtMK.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMKKeyPressed(evt);
            }
        });

        txtTK.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTKKeyPressed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(102, 204, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("Đổi");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnThoat.setBackground(new java.awt.Color(255, 102, 102));
        btnThoat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.setBorder(null);
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        cbxHienMK.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxHienMK.setText("Hiện mật khẩu");
        cbxHienMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxHienMKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtReWriteMK, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNewMK, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMK, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTK, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(cbxHienMK)))
                .addContainerGap(142, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(177, 177, 177))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTK, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMK, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNewMK, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtReWriteMK, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(cbxHienMK)
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        DoiMatKhau();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
        this.dispose();
        TrangChu trangChu = new TrangChu(TaiKhoan, MatKhau);
        trangChu.setLocationRelativeTo(null);
        trangChu.setVisible(true);
    }//GEN-LAST:event_btnThoatActionPerformed

    private void cbxHienMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxHienMKActionPerformed
        // TODO add your handling code here:
        if (cbxHienMK.isSelected() == true) {
            txtMK.setEchoChar((char) 0);
            txtNewMK.setEchoChar((char) 0);
            txtReWriteMK.setEchoChar((char) 0);
        } else {
            txtMK.setEchoChar('*');
            txtNewMK.setEchoChar('*');
            txtReWriteMK.setEchoChar('*');
        }
    }//GEN-LAST:event_cbxHienMKActionPerformed

    private void txtTKKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTKKeyPressed
        // TODO add your handling code here: 
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtMK.requestFocus();
        }
    }//GEN-LAST:event_txtTKKeyPressed

    private void txtMKKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMKKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtNewMK.requestFocus();
        }
    }//GEN-LAST:event_txtMKKeyPressed

    private void txtNewMKKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNewMKKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtReWriteMK.requestFocus();
        }
    }//GEN-LAST:event_txtNewMKKeyPressed

    private void txtReWriteMKKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtReWriteMKKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            DoiMatKhau();
        }
    }//GEN-LAST:event_txtReWriteMKKeyPressed

    private String EncryptPassword(String strToEncrypt, String myKey) throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        MessageDigest sha = MessageDigest.getInstance("SHA-1");
        byte[] key = myKey.getBytes("UTF-8");
        key = sha.digest(key);
        key = Arrays.copyOf(key, 16);
        SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
    }

    public static String DecryptPassword(String strToDecrypt, String myKey) throws UnsupportedEncodingException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException {
        MessageDigest sha = MessageDigest.getInstance("SHA-1");
        byte[] key = myKey.getBytes("UTF-8");
        key = sha.digest(key);
        key = Arrays.copyOf(key, 16);
        SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
    }

    public void DoiMatKhau() {
        try {
            if (txtTK.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập tên đăng nhập", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (txtMK.getPassword().equals("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập mật khẩu", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (txtNewMK.getPassword().equals("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập mật khẩu mới", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (txtReWriteMK.getPassword().equals("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập lại mật khẩu mới", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }

            boolean check = dangNhapController.DangNhapHeThong(txtTK.getText(), EncryptPassword(String.valueOf(txtMK.getPassword()), "hieusen123"));
            if (check == true) {
                if (txtNewMK.getText().equals(txtReWriteMK.getText())) {
                    boolean change = dangNhapController.ChangPassword(txtTK.getText(), EncryptPassword(String.valueOf(txtMK.getPassword()), "hieusen123"),
                            EncryptPassword(String.valueOf(txtNewMK.getPassword()), "hieusen123"));
                    if (change == true) {
                        JOptionPane.showMessageDialog(this, "Đổi mật khẩu thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Mật khẩu nhập lại không chính xác", "Thông báo", JOptionPane.ERROR_MESSAGE);
                    txtReWriteMK.requestFocus();
                }

            } else {
                JOptionPane.showMessageDialog(this, "Tài khoản hoặc mật khẩu không chính xác", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Đổi mật khẩu thất bại" + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);

        }
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
            java.util.logging.Logger.getLogger(frmChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmChangePassword fChangePassword = new frmChangePassword();
                fChangePassword.setLocationRelativeTo(null);
                fChangePassword.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThoat;
    private javax.swing.JCheckBox cbxHienMK;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtMK;
    private javax.swing.JPasswordField txtNewMK;
    private javax.swing.JPasswordField txtReWriteMK;
    private javax.swing.JTextField txtTK;
    // End of variables declaration//GEN-END:variables
}
