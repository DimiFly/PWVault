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
import logic.PWVaultModel;
import logic.WindowManager;

/**
 *
 * @author 5im16diwehrli
 */
public class AddPwdController implements Initializable {
    
    private PWVaultModel model;

    @FXML
    private void handleButtonBack(ActionEvent event) {
        WindowManager.start("MainFrameStage");
        WindowManager.stop("AddPwdStage");
        
    }

    @FXML
    private void handleButtonAdd(ActionEvent event){
        //TODO
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
