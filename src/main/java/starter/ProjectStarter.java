/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import window.manager.WindowManager;

/**
 * @author 5im16diwehrli
 */
public class ProjectStarter extends Application {


    public void start(Stage loginStage) throws Exception {
        WindowManager.setup();
        WindowManager.putStage("LoginStage", loginStage);
        
        Parent loginRoot = FXMLLoader.load(getClass().getClassLoader().getResource("gui/FXMLDocumentLogIn.fxml"));
        Scene loginScene = new Scene(loginRoot);
        loginStage.setScene(loginScene);
        loginStage.setMaxHeight(505);
        loginStage.setMinHeight(505);
        loginStage.setMaxWidth(350);
        loginStage.setMinWidth(350);
        
        
        Stage mainFrameStage = new Stage();
        Parent mainFrameRoot = FXMLLoader.load(getClass().getClassLoader().getResource("gui/FXMLDocumentMainFrame.fxml"));
        Scene mainFrameScene = new Scene(mainFrameRoot);
        mainFrameStage.setScene(mainFrameScene);
        mainFrameStage.setMaxHeight(505);
        mainFrameStage.setMinHeight(505);
        mainFrameStage.setMaxWidth(350);
        mainFrameStage.setMinWidth(350);        
        WindowManager.putStage("MainFrameStage", mainFrameStage);
        
        Stage addPwdStage = new Stage();
        Parent addPwdRoot = FXMLLoader.load(getClass().getClassLoader().getResource("gui/FXMLDocumentAddPwd.fxml"));
        Scene addPwdeScene = new Scene(addPwdRoot);
        addPwdStage.setScene(mainFrameScene);
        addPwdStage.setMaxHeight(505);
        addPwdStage.setMinHeight(505);
        addPwdStage.setMaxWidth(350);
        addPwdStage.setMinWidth(350);        
        WindowManager.putStage("AddPwdStage", addPwdStage);
                
        WindowManager.start("LoginStage");

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
