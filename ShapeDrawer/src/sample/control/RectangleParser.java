package sample.control;

import javafx.scene.shape.Shape;
import sample.model.Point;
import sample.model.Rectangle;
import sample.view.DrawRectangle;
import java.util.ArrayList;
import java.util.Arrays;

public class RectangleParser extends Parser {
    RectangleParser(ArrayList<Shape> children) {
        this.children=children;
        this.checker="rectangle";
        this.next=null;
    }

    @Override
    public void parseConcreteElement() {
        Double f[]=new Double[line.length];
        for(int i = 1; i<line.length; i++){
            f[i-1]=Double.parseDouble(line[i]);
        }
        Double a[] = Arrays.copyOfRange(f,0,f.length/2);
        Double b[] = Arrays.copyOfRange(f,f.length/2,f.length);
        try {
            Rectangle rec=new Rectangle(new Point(a),new Point(b));
            DrawRectangle draw= new DrawRectangle(rec);
            children.add(draw.getShape());
            System.out.println("Pyklo kwadrat :)");
        }
        catch(Exception e){
            System.out.println("Nie pyklo kwadrat:(");
        }

    }
}
