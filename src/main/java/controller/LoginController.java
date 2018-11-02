/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import logic.PWVaultModel;
import window.manager.WindowManager;

/**
 *
 * @author 5im16diwehrli
 */
public class LoginController implements Initializable {

    private PWVaultModel model;
    
    @FXML
    private TextField username, password;


    @FXML
    private void handleButtonLogin(ActionEvent event) {
        System.out.println("logging in: "+username.getText());
        model.loginUser(username.getText(), password.getText());
        WindowManager.stop("LoginStage");
        WindowManager.start("MainFrameStage");        
    }

    @FXML
    private void handleButtonAdd(ActionEvent event){
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        model = new PWVaultModel();
    }

}
