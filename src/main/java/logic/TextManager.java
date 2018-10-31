/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 5im16nivanderheide
 */
public class TextManager {
    
    BufferedReader storageReader;
    
    public TextManager(){
        FileReader fr = null;
        try {
            fr = new FileReader("/src/main/resources/text/storage.txt");
            storageReader = new BufferedReader(fr);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TextManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(TextManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    public boolean userExists(String username){
        String line = "";
        try {
            while((line = storageReader.readLine()) != null){
                if(line.split("|")[0].equals(username)){
                    return true;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(TextManager.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return false;
    }
    
    public String getPwdOfUser(String username){
        String line = "";
        try {
            while((line = storageReader.readLine()) != null){
                if(line.split("|")[0].equals(username)){
                    return line.split("|")[1];
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(TextManager.class.getName()).log(Level.SEVERE, null, ex);
        }          
        return "";
    }
   
}
