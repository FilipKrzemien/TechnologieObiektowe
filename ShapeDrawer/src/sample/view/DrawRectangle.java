package sample.view;

import javafx.scene.paint.Color;
import sample.model.Point;
import sample.model.Rectangle;

public class DrawRectangle extends Draw {

    private Rectangle rec;
    public DrawRectangle(Rectangle rec) {
        this.rec=rec;
        drawShape();
    }

    @Override
    public void drawShape() {
        Point topLeft= rec.getFirst();
        this.shape= new javafx.scene.shape.Rectangle(topLeft.getX(),topLeft.getY(),rec.getWidth(),rec.getLength());
    }
}
