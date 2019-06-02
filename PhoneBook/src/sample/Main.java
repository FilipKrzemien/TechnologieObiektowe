package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root=loader.load();
        Controller ctrl=loader.getController();
        FileReader read=new FileReader(ctrl);
        primaryStage.setTitle("Ksiazka telefoniczna");
        primaryStage.setScene(new Scene(root, 300, 350));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
