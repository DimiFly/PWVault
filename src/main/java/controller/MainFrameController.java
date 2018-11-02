/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;
import logic.PWVaultModel;
import window.manager.WindowManager;

/**
 *
 * @author 5im16diwehrli
 */
public class MainFrameController implements Initializable {
    
    private PWVaultModel model;

    @FXML
    private TextField username, password;

    @FXML
    private void handleButtonQuit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void handleButtonAdd(ActionEvent event){
        WindowManager.stop("MainFrameStage");
        WindowManager.start("AddPwdStage");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
