package sample.control;

import javafx.scene.shape.Shape;

import java.util.ArrayList;

abstract class Parser {

    Parser next;
    String checker;
    String[] line;
    ArrayList<Shape> children;

    void parseElement(String[] line) {
        this.line=line;
        if (line[0].equals(checker)) parseConcreteElement();
        else{
            try{ next.parseElement(line); }
            catch(Exception e){ System.out.println("Failed parsing"); }
        }
    }

    public abstract void parseConcreteElement();

}
