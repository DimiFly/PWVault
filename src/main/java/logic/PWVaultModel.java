/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 *
 * @author 5im16nivanderheide
 */
public class PWVaultModel {
    
    private PwdConverter pwdConverter;
    private TextManager textManager;
    private User currentuser;
    
    public PWVaultModel(){
        pwdConverter = new PwdConverter();
        textManager = new TextManager();        
    }
    
    public boolean loginUser(String username, String pwd){
        if(textManager.userExists(username)){
            if(pwdConverter.hashPwd(pwd).equals(textManager.getPwdOfUser(username))){
                System.out.println("User: " + username + " loged in!");
                return true;
            }else{
                System.out.println("wrong password");
            }
        }else{
            System.out.println("User: " + username + " doesn't exist!");
        }
        return false;
    }
    
    public void addUser(String username, String pwd){
        if(!textManager.userExists(username)){
            textManager.addUser(username, pwdConverter.hashPwd(pwd));
        }else{
            System.out.println("User"+ username +" already exists!");
        }
    }
    
    public ArrayList<>{
    
}
    
}
