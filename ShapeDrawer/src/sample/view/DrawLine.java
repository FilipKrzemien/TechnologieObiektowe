package sample.view;
import sample.model.Line;
import sample.model.Point;

public class DrawLine extends Draw {

    private Line a;

    public DrawLine(Line a) {
        this.a = a;
        drawShape();
    }

    @Override
    public void drawShape() {
        Point first=a.getA();
        Point second=a.getB();
        this.shape=new javafx.scene.shape.Line(first.getX() ,first.getY(),second.getX(),second.getY());
    }

}
