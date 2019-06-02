package sample.control;

import javafx.scene.shape.Shape;
import sample.model.Point;
import java.util.ArrayList;

public class PointParser extends Parser {

    public PointParser(ArrayList<Shape> children) {
        this.children=children;
        this.checker="point";
        this.next=new CircleParser(children);
    }

    @Override
    public void parseConcreteElement() {

        Double f[]=new Double[line.length];
        for(int i = 1; i<line.length; i++){
            f[i-1]=Double.parseDouble(line[i]);
        }
        try {
            Point pt=new Point(f);
            System.out.println("Pyklo punkt:)");
        }
        catch(Exception e){
            System.out.println("Nie pyklo punkt :(");
        }
    }
}
