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

/**
 * @author 5im16diwehrli
 */
public class LoginStarter extends Application {


    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("gui/FXMLDocumentLogIn.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setMaxHeight(505);
        stage.setMinHeight(505);
        stage.setMaxWidth(350);
        stage.setMinWidth(350);
        stage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
