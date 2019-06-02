package sample.model;

public class Circle extends DualDimension {

    private Point middle;
    private double radius;

    public Circle(Point middle, double radius   ) {
        this.middle = middle;
        this.radius = radius;
        calculateCircuit();
        calculateField();
    }

    public Point getMiddle() { return middle; }

    public double getRadius() { return radius; }

    private void calculateCircuit(){ circuit=2*Math.PI*radius; }

    private void calculateField(){ field=Math.PI*radius*radius; }


}
