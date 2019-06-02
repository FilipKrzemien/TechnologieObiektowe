package sample.model;

public class Line extends SingleDimension {

    private Point a;
    private Point b;


    public Line(Point a, Point b) {
      this.a=a;
      this.b=b;
      calculateLength();
    }

    public Point getA() { return a; }

    public Point getB() { return b; }

    private void calculateLength(){ this.length=Math.sqrt(Math.pow(b.getX()-a.getX(),2)+Math.pow(b.getY()-a.getY(),2));}

}
