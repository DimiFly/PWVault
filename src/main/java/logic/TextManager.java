/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 5im16nivanderheide
 */
public class TextManager {

    BufferedReader userReader;
    FileWriter userWriter;
    BufferedReader pwdReader;
    FileWriter pwdWriter;

    public TextManager() {
        ArrayList<String> contentUser = new ArrayList<String>();
        ArrayList<String> contentPwds = new ArrayList<String>();

        FileReader userfr = null;
        FileReader pwdfr = null;
        try {
            userfr = new FileReader("E:\\PWVault\\PWVault\\src\\main\\resources\\text\\user.txt");
            userReader = new BufferedReader(userfr);
            pwdfr = new FileReader("E:\\PWVault\\PWVault\\src\\main\\resources\\text\\pwds.txt");
            pwdReader = new BufferedReader(pwdfr);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TextManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        String line = "";
        try {
            while ((line = userReader.readLine()) != null) {
                contentUser.add(line);
            }
            line = "";
            while ((line = pwdReader.readLine()) != null) {
                contentPwds.add(line);
            }
        } catch (IOException ex) {
            Logger.getLogger(TextManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            userWriter = new FileWriter("E:\\PWVault\\PWVault\\src\\main\\resources\\text\\user.txt");
            for (String user : contentUser) {
                userWriter.write(user+"\n");
            }
            userWriter.flush();
            contentUser = null;
            pwdWriter = new FileWriter("E:\\PWVault\\PWVault\\src\\main\\resources\\text\\pwds.txt");
            for (String pwd : contentPwds) {
                pwdWriter.write(pwd+"\n");
            }
            pwdWriter.flush();
            contentPwds = null;
        } catch (IOException ex) {
            Logger.getLogger(TextManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean userExists(String username) {
        String line = "";
        try {
            while ((line = userReader.readLine()) != null) {
                if (line.split("|")[0].equals(username)) {
                    return true;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(TextManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public String getPwdOfUser(String username) {
        String line = "";
        try {
            while ((line = userReader.readLine()) != null) {
                if (line.split("|")[0].equals(username)) {
                    return line.split("|")[1];
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(TextManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public void addUser(String username, String pwd) {
        try {
            userWriter.write(username + "|" + pwd);
            userWriter.flush();
        } catch (IOException ex) {
            Logger.getLogger(TextManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<String> getCategorysOfUser(String username) {
        if (userExists(username)) {
            ArrayList<String> categorys = new ArrayList<String>();
            String line = "";
            try {
                while ((line = pwdReader.readLine()) != null) {
                    if (line.split("|")[0].equals(username)) {
                        categorys.add(line.split("|")[1]);
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(TextManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            return categorys;
        }
        return null;
    }

    public String getPwdOfCathegoryOfUser(String username, String category, String key) {
        try {
            String line = "";
            while ((line = pwdReader.readLine()) != null) {
                if (line.split("|")[0].equals(username) && line.split("|")[1].equals(category)) {
                    return line.split("|")[2];
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(TextManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public void addCategoryToUser(String username, String category, String pwd) {
        try {
            pwdWriter.write(username + "|" + category + "|" + pwd);
            pwdWriter.flush();
        } catch (IOException ex) {
            Logger.getLogger(TextManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
