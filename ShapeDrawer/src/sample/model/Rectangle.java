package sample.model;

public class Rectangle extends DualDimension {

    private Point first;
    private Point second;
    private double length;
    private double width;

    public Rectangle(Point first, Point second) {
        this.first = first;
        this.second = second;
        calculateLength();
        calculateWidth();
        calculateCircuit();
        calculateField();
    }

    private void calculateLength(){ length=Math.sqrt(Math.pow(second.getX()-first.getX(),2)); }

    private void calculateWidth() { width=Math.sqrt(Math.pow(second.getY()-first.getY(),2)); }

    private void calculateCircuit() { circuit=length*2+width*2; }

    private void calculateField() { field=length*width; }

    public Point getFirst() { return first; }

    public double getLength() { return length; }

    public double getWidth() { return width; }

}
