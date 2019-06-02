package algebra;

public class Vector2D implements Algebra {
    private double x;
    private double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() { return x; }

    public double getY() { return y; }

    @Override
    public double abs(){
        return Math.sqrt(x*x+y*y);
    }

    public double skalarny(Vector2D other) {
        return this.getX()*other.getX()+this.getY()*other.getY();
    }
}
