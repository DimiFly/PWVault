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
        try {
            userWriter = new FileWriter("/src/main/resources/text/user.txt");
            pwdWriter = new FileWriter("/src/main/resources/text/pwds.txt");
        } catch (IOException ex) {
            Logger.getLogger(TextManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        FileReader userfr = null;
        FileReader pwdfr = null;
        try {
            userfr = new FileReader("/src/main/resources/text/user.txt");
            userReader = new BufferedReader(userfr);
            pwdfr = new FileReader("/src/main/resources/text/pwds.txt");
            userReader = new BufferedReader(pwdfr);
        } catch (FileNotFoundException ex) {
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
            pwdWriter.write(username+"|"+category+"|"+pwd);
            pwdWriter.flush();
        } catch (IOException ex) {
            Logger.getLogger(TextManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
