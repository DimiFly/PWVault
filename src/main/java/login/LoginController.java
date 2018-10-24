/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.awt.Color;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author 5im16diwehrli
 */
public class LoginController implements Initializable {

    private DecimalFormat df = new DecimalFormat("#.0");
    @FXML
    private Label output;
    @FXML
    private TextField gewicht, groesse;

    private Double bmi;

    @FXML
    private void handleButtonCalculate(ActionEvent event) {

        Double weight = Double.parseDouble(gewicht.getText());
        Double height = Double.parseDouble(groesse.getText());
        bmi = weight / (height * height);
        output.setText(df.format(bmi));
        if (bmi > 18.5 && bmi < 30) {
            output.setStyle("-fx-background-color: green;");
        }else if(bmi > 16.5 && bmi < 18.6 || bmi > 29.9 && bmi < 32.1){
            output.setStyle("-fx-background-color: orange;");
        }else{
            output.setStyle("-fx-background-color: red;");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
