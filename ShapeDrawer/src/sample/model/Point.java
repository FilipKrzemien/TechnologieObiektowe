package sample.model;



public class Point extends SingleDimension {

    private double x;
    private double y;

    public Point(Double[] f) {
        this.x = f[0]+250;
        this.y = f[1]+250;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

}
