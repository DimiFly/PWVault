/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.ArrayList;

/**
 * @author 5im16nivanderheide
 */
public class PWVaultModel {

    private PwdManager pwdConverter;
    private TextManager textManager;

    public PWVaultModel() {
        pwdConverter = new PwdManager();
        textManager = new TextManager();
    }
    
    /////////////////////////////////// Login

    public boolean loginUser(String username, String pwd) {
        User currentUser = new User();
        if (textManager.userExists(username)) {         
                currentUser.setUsername(username);
                UserManager.setUser(username, pwd);
                System.out.println("User: " + username + " loged in!");
                return true;           
        } else {
            System.out.println("User: " + username + " doesn't exist!");
        }
        return false;
    }
    
    public void logout(){
        UserManager.setUser("", "");
    }
    
    /////////////////////////////////// Add User
    
    public void addUser(String username, String pwd) {
        if (!textManager.userExists(username)) {
            textManager.addUser(username, pwd);
            UserManager.setUser(username, pwd);
            WindowManager.stop("LoginStage");
            WindowManager.start("MainFrameStage");
        } else {
            System.out.println("User" + username + " already exists!");
        }
    }
    
    /////////////////////////////////// Add pwd
    
    public void addPwdCategory(String category, String pwd){
        textManager.addCategoryToUser(UserManager.getUser().getUsername(), category, pwd);
        
    }
    
    /////////////////////////////////// Maneframe
    
    public String getPwdOfCategory(String username, String category, String key){
        return (String) textManager.getPwdOfCategoryOfUser(UserManager.getUser().getUsername(), category, key);
    }
    
    public ArrayList<String> getCategorys(){
        return textManager.getCategorysOfUser(UserManager.getUser().getUsername());
    }

    public PwdManager getPwdConverter() {
        return pwdConverter;
    }

    public void setPwdConverter(PwdManager pwdConverter) {
        this.pwdConverter = pwdConverter;
    }

    public TextManager getTextManager() {
        return textManager;
    }

    public void setTextManager(TextManager textManager) {
        this.textManager = textManager;
    }
}

