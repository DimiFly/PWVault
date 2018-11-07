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
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 5im16nivanderheide
 */
public class TextManager {

    private BufferedReader userReader;
    private FileWriter userWriter;
    private BufferedReader pwdReader;
    private FileWriter pwdWriter;

    public TextManager() {
        initReaderWriter();
    }
    
    public BufferedReader getNewReader() throws FileNotFoundException{
        FileReader userfr = new FileReader("./src/main/resources/text/user.txt");
        return new BufferedReader(userfr);
    }
    
    public void initReaderWriter(){
        String[] contentUser = null;
        String[] contentPwds = null;

        FileReader userfr;
        FileReader pwdfr;        

        String line = "";
        try {
            userfr = new FileReader("./src/main/resources/text/user.txt");
            userReader = new BufferedReader(userfr);
            pwdfr = new FileReader("./src/main/resources/text/pwds.txt");
            pwdReader = new BufferedReader(pwdfr);
            while ((line = userReader.readLine()) != null) {
                contentUser = line.split("\\|");
                System.out.println(Arrays.toString(contentUser));
            }
            userReader.close();
            line = "";
            while ((line = pwdReader.readLine()) != null) {
                contentPwds = line.split("\\|");
            }
            pwdReader.close();
        } catch (IOException ex) {
            Logger.getLogger(TextManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            userWriter = new FileWriter("./src/main/resources/text/user.txt");
            pwdWriter = new FileWriter("./src/main/resources/text/pwds.txt");
        } catch (IOException ex) {
            Logger.getLogger(TextManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {

            userWriter = new FileWriter("./src/main/resources/text/user.txt");
            for (int i = 0; i < contentUser.length; i++) {
                userWriter.write(contentUser[i] + "|");
            }
            userWriter.flush();
            contentUser = null;

            pwdWriter = new FileWriter("./src/main/resources/text/pwds.txt");
            for (int i = 0; i < contentPwds.length; i++) {
                pwdWriter.write(contentPwds[i] + "|");
            }
            pwdWriter.flush();
            contentPwds = null;

        } catch (IOException ex) {
            Logger.getLogger(TextManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean userExists(String username) {
        //initReaderWriter();
        String line = "";
        try {
            userReader = getNewReader();
            while ((line = userReader.readLine()) != null) {
                if (line.split("\\|")[0].equals(username)) {
                    return true;
                }
            }
            userReader.close();
        } catch (IOException ex) {
            Logger.getLogger(TextManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public String getPwdOfUser(String username) {
        initReaderWriter();
        String line = "";
        try {
            while ((line = userReader.readLine()) != null) {
                if (line.split("\\|")[0].equals(username)) {
                    return line.split("\\|")[1];
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(TextManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public void addUser(String username, String pwd) {
        initReaderWriter();
        try {
            BufferedReader reader = getNewReader();
            
            userWriter.write(username + "|" + pwd);
            userWriter.flush();
        } catch (IOException ex) {
            Logger.getLogger(TextManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<String> getCategorysOfUser(String username) {
        initReaderWriter();
        if (userExists(username)) {
            ArrayList<String> categorys = new ArrayList<String>();
            String line = "";
            try {
                while ((line = pwdReader.readLine()) != null) {
                    if (line.split("\\|")[0].equals(username)) {
                        categorys.add(line.split("\\|")[1]);
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(TextManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            return categorys;
        }
        return null;
    }

    public String getPwdOfCategoryOfUser(String username, String category, String key) {
        initReaderWriter();
        try {
            String line = "";
            while ((line = pwdReader.readLine()) != null) {
                if (line.split("\\|")[0].equals(username) && line.split("|")[1].equals(category)) {
                    return line.split("\\|")[2];
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
