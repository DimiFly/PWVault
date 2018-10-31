/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author 5im16nivanderheide
 */
public class PwdConverter {

    public PwdConverter() {

    }

    public String hashPwd(String pwd) {
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            md.update(pwd.getBytes());
            byte[] digest = md.digest();
            return new String(digest);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return "";
    }

}
