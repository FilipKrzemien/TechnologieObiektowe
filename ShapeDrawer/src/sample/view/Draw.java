package sample.view;

import javafx.scene.shape.Shape;

public abstract class  Draw {

    protected Shape shape;
    abstract void drawShape();

    public Shape getShape(){
        return shape;
    }
}
