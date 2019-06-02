package sample;

import algebra.Algebra;
import algebra.Vector2D;
import algebra.VectorConverter;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class Controller2 extends Ctrl{

    public TextField firstUpper;
    public TextField firstLower;
    public TextField secondUpper;
    public TextField secondLower;
    public Label lengthFirst;
    public Label lengthSecond;
    public Label scalar;
    public CheckBox checkFirst;
    public CheckBox checkSecond;


    public void calculate(){
        Vector2D vector1;
        Vector2D vector2;
        double x1=Double.parseDouble(firstUpper.getText());
        double y1=Double.parseDouble(firstLower.getText());
        double x2=Double.parseDouble(secondUpper.getText());
        double y2=Double.parseDouble(secondLower.getText());
        if(checkFirst.isSelected()){
            vector1= new VectorConverter(x1,y1).getVector();
        }
        else{
            vector1= new Vector2D(x1,y1);
        }
        if(checkSecond.isSelected()){
            vector2=new VectorConverter(x2,y2).getVector();
        }
        else{
            vector2=new Vector2D(x2,y2);
        }
        double skalarny=vector1.skalarny(vector2);
        double l1=round(vector1.abs());
        double l2=round(vector2.abs());
        show(l1,l2,skalarny);
    }

    private void show(double l1, double l2, double skalarny) {
        lengthFirst.setText("Value:"+l1);
        lengthSecond.setText("Value"+l2);
        scalar.setText("Value"+skalarny);
    }


}
