/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author 5im16nivanderheide
 */
public class PwdConverter {

    public PwdConverter() {

    }

    public String hashUserPwd(String pwd) {
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            md.update(pwd.getBytes());
            byte[] digest = md.digest();
            return byteToHex(digest);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    public String byteToHex(byte[] buffer) {
        String output = "";
        for (byte d : buffer) {
            String nextByte = Integer.toHexString(d & 0xFF).toLowerCase();
            if (nextByte.length() < 2) {
                nextByte = "0" + nextByte;
            }
            output += nextByte;
        }
        return output;
    }

    public String encryptPwd(String pwd, String key) {
        byte[] keyArray = key.getBytes();
        byte[] dataToSend = pwd.getBytes();
        Cipher c;
        try {
            c = Cipher.getInstance("AES");
            SecretKeySpec k = new SecretKeySpec(keyArray, "AES");
            c.init(Cipher.ENCRYPT_MODE, k);
            byte[] encryptedData = c.doFinal(dataToSend);
            return new String(encryptedData);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(PwdConverter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(PwdConverter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(PwdConverter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(PwdConverter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(PwdConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String decryptPwd(String pwd, String key) {
        byte[] keyArray = key.getBytes();
        byte[] encryptedData = pwd.getBytes();
        Cipher c;
        try {
            c = Cipher.getInstance("AES");SecretKeySpec k
                = new SecretKeySpec(keyArray, "AES");
        c.init(Cipher.DECRYPT_MODE, k);
        byte[] data = c.doFinal(encryptedData);
        return new String(data);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(PwdConverter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(PwdConverter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(PwdConverter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(PwdConverter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(PwdConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
