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

    private PwdConverter pwdConverter;
    private TextManager textManager;
    private User currentUser; 


    public PWVaultModel() {
        currentUser = new User();
        pwdConverter = new PwdConverter();
        textManager = new TextManager();
    }
    
    /////////////////////////////////// Login

    public boolean loginUser(String username, String pwd) {
        if (textManager.userExists(username)) {

            if (pwdConverter.hashUserPwd(pwd).equals(textManager.getPwdOfUser(username))) {
                currentUser.setUsername(username);
                
                System.out.println("User: " + username + " loged in!");
                return true;
            } else {
                System.out.println("wrong password");
            }
        } else {
            System.out.println("User: " + username + " doesn't exist!");
        }
        return false;
    }
    
    public void logout(){
        currentUser = new User();
    }
    
    /////////////////////////////////// Add User
    
    public void addUser(String username, String pwd) {
        if (!textManager.userExists(username)) {
            textManager.addUser(username, pwdConverter.hashUserPwd(pwd));
        } else {
            System.out.println("User" + username + " already exists!");
        }
    }
    
    /////////////////////////////////// Add pwd
    
    public void addPwdCategory(String category, String pwd, String key){
        textManager.addCategoryToUser(currentUser.getUsername(), category, pwdConverter.encryptPwd(pwd, key));
        
    }
    /////////////////////////////////// Maneframe
    
    public String getPwdOfCategory(String category, String key){
        return textManager.getPwdOfCathegoryOfUser(currentUser.getUsername(), category, key);
    }
    
    public ArrayList<String> getCategorys(){
        return textManager.getCategorysOfUser(currentUser.getUsername());
    }
}

