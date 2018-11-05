/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 *
 * @author Niklas
 */
public abstract class UserManager {
    
    private static User user;
    
    public UserManager(){
        user = new User();
    }
    
    public static void setUser(String username, String pwd) {
        user = new User(username, pwd);
    }
    
    public static User getUser(){
        return user;
    }
    
    public static void logout(){
        user = new User();
    }
    
}
