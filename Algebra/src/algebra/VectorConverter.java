package algebra;

public class VectorConverter implements Algebra {

    private Vector2D vector;

    public VectorConverter(double angle, double length) {
        vector=new Vector2D(Math.cos(angle)*length,Math.sin(angle)*length);
    }

    @Override
    public double abs() {
        return vector.abs();
    }

    public Vector2D getVector() {
        return vector;
    }

    public double skalarny(Vector2D other) {
            return this.getX()*other.getX()+this.getY()*other.getY();
    }


    public double getX() {
        return vector.getX();
    }


    public double getY() {
        return vector.getY();
    }

}
