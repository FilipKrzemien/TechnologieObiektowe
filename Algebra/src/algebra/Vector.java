package algebra;

public class Vector extends Vector3D {

    public Vector(double x,double y, double z) {
        this.vector=new Vector2D(x,y);
        this.z=z;
    }

    @Override
    public double skalarny(Vector other) {
        double newX=this.vector.getX()*other.vector.getX();
        double newY=this.vector.getY()*other.vector.getY();
        double newZ=this.z*other.getZ();
        return Math.sqrt(newX+newY+newZ);
    }

    @Override
    public Algebra wektorowy(Vector other) {
        double newX=this.vector.getY()*other.getZ()-this.z*other.vector.getY();
        double newY=this.vector.getX()*other.getZ()-this.z*other.vector.getX();
        double newZ=this.vector.getX()*other.vector.getY()-this.vector.getY()*other.vector.getX();
        return new Vector(newX,newY,newZ);
    }

    @Override
    public double abs() {
        return Math.sqrt(this.z*this.z+Math.pow(this.vector.getX(),2)+Math.pow(this.vector.getY(),2));
    }
}
