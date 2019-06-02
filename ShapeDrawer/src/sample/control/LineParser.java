package sample.control;

import javafx.scene.shape.Shape;
import sample.model.Line;
import sample.model.Point;
import sample.view.DrawLine;
import java.util.ArrayList;
import java.util.Arrays;

public class LineParser extends Parser {

    LineParser(ArrayList<Shape> children) {
        this.checker="line";
        this.next= new RectangleParser(children);
        this.children=children;
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
            Line ln=new Line(new Point(a),new Point(b));
            DrawLine draw= new DrawLine(ln);
            children.add(draw.getShape());
            System.out.println("Pyklo linia :)");
        }
        catch(Exception e){
            System.out.println("Nie pyklo linia:(");
        }
    }
}
