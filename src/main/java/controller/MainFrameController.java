/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import logic.PWVaultModel;
import logic.UserManager;
import logic.WindowManager;

/**
 *
 * @author 5im16diwehrli
 */
public class MainFrameController implements Initializable {
    
    private PWVaultModel model;

    @FXML
    private Label output;

    @FXML
    private MenuButton menu;

    public void fillMenu(){
        PWVaultModel model = new PWVaultModel();
        model.getCategories();
    }

    @FXML
    private void handleButtonQuit(ActionEvent event) {
        System.exit(0);
    }



    @FXML
    private void handleButtonAdd(ActionEvent event){
        WindowManager.stop("MainFrameStage");
        WindowManager.start("AddPwdStage");
    }
    
    @FXML
    private void handleButtonLogout(ActionEvent event){
        UserManager.logout();
        WindowManager.stop("MainFrameStage");
        WindowManager.start("LoginStage");      
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
