package sample.control;


import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import sample.model.Circle;
import sample.model.Point;
import sample.view.DrawCircle;

import java.util.ArrayList;

public class CircleParser extends Parser {



    CircleParser(ArrayList<Shape> children) {
        this.children=children;
        this.checker = "circle";
        this.next = new LineParser(children);
    }

    @Override
    public void parseConcreteElement() {
        Double f[]=new Double[line.length];
        double r=1.;
        for(Integer i=1;i<line.length;i++){
            if(i.equals(line.length-1)) r=Double.parseDouble(line[i]);
            else f[i-1]=Double.parseDouble(line[i]);
        }
        try {
            Circle cr= new Circle(new Point(f),r);
            DrawCircle draw = new DrawCircle(cr);
            children.add(draw.getShape());
            System.out.println("Pyklo kolko :)");
        }
        catch(Exception e){
            System.out.println("nie pyklo kolko :(");
        }
    }
}
