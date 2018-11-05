/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.HashMap;
import javafx.stage.Stage;

/**
 *
 * @author 5im16LuWipf
 */
public abstract class WindowManager {
    
    private static HashMap<String, Stage> windows;
    
    public static void setup() {
        windows = new HashMap<String, Stage>();
    }
    
    public static Stage getStage(String key) {
        return windows.get(key);
    }
    
    public static void createStage(String key) {
        windows.put(key, new Stage());
    }
    
    public static void putStage(String key, Stage stage) {
        windows.put(key, stage);
    }
    
    public static void start(String key) {
        windows.get(key).show();
    }
    
    public static void stop(String key) {
        windows.get(key).hide();
    }
}
