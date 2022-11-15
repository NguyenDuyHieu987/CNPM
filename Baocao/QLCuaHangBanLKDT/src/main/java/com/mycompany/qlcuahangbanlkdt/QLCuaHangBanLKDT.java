/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.qlcuahangbanlkdt;

import Interface.DangNhap;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author ddom6
 */
public class QLCuaHangBanLKDT {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        DangNhap dangNhap;
        try {
            dangNhap = new DangNhap();
            dangNhap.setVisible(true);
        } catch (UnsupportedEncodingException | InvalidKeyException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(QLCuaHangBanLKDT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
