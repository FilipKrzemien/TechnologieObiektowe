package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static  Stage window;
    public static Scene first;
    public static Scene second;
    @Override
    public void start(Stage primaryStage) throws Exception{
        window=primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Parent root2= FXMLLoader.load(getClass().getResource("sample2.fxml"));
        window.setTitle("Algebra");
        first=new Scene(root, 670, 450);
        second=new Scene(root2,670,450);
        window.setScene(first);
        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public static void switchScene(){
        if(window.getScene().equals(first)){
            window.setScene(second);
        }
        else window.setScene(first);
    }
}
