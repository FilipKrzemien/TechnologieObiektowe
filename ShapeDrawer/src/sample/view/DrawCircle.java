package sample.view;

import javafx.scene.paint.Color;
import sample.model.Circle;

public class DrawCircle extends Draw {

    private Circle a;

    public DrawCircle(Circle a) {
        this.a = a;
        drawShape();
    }

    @Override
    public void drawShape() {
        this.shape=new javafx.scene.shape.Circle(a.getMiddle().getX(),a.getMiddle().getY(),a.getRadius(),Color.BLUE);
    }

}
