package sample;

import algebra.Vector;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller extends Ctrl{
    public TextField firstX;
    public TextField firstY;
    public TextField firstZ;
    public TextField secondX;
    public TextField secondY;
    public TextField secondZ;
    public Label vectorProduct;
    public Label scalarProduct;


    public void calculate(){
        double x1=Double.parseDouble(firstX.getText());
        double y1=Double.parseDouble(firstY.getText());
        double z1=Double.parseDouble(firstZ.getText());
        double x2=Double.parseDouble(secondX.getText());
        double y2=Double.parseDouble(secondY.getText());
        double z2=Double.parseDouble(secondZ.getText());
        Vector first = new Vector(x1,y1,z1);
        Vector second = new Vector(x2,y2,z2);
        double scalar=round(first.skalarny(second));
        Vector result= (Vector) first.wektorowy(second);
        show(scalar,result);
    }

    private void show(double scalar, Vector result) {
        double x=result.vector.getX();
        double y=result.vector.getY();
        double z=result.getZ();
        vectorProduct.setText("Vector["+x+","+y+","+z+"]");
        scalarProduct.setText(String.valueOf(scalar));
    }



}
