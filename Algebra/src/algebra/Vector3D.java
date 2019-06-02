package algebra;

public abstract class Vector3D implements Algebra {
    protected double z;
    public Vector2D vector;

    abstract double skalarny(Vector other);
    abstract Algebra wektorowy(Vector other);

    @Override
    public double abs() { return 0; }

    public double getZ(){ return z; }
}
