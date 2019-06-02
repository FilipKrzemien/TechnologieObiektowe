package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import sample.control.PointParser;
import sample.control.Reader;
import java.util.ArrayList;

public class Main extends Application {

    private ArrayList<Shape> children = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) throws Exception{
        PointParser pp=new PointParser(children);
        Reader r=new Reader(pp);
        Group root = new Group();
        root.getChildren().addAll(children);
        primaryStage.setTitle("Shapes");
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
