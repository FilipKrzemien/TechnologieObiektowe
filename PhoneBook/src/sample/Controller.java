package sample;

import javafx.scene.control.Label;

import java.util.ArrayList;

public class Controller {
    public Label label1;

    public void begin(ArrayList<Number> numberList) {
        StringBuilder result = new StringBuilder();
        for (Number n : numberList) {
            String temp = n.getNumber();
            NameFabric parent = n.getLocation();
            while (parent.getLocation() != null) {
                temp = parent.getName() + " " + temp;
                parent = parent.getLocation();
            }
            result.append(temp).append("\n");
        }
        label1.setText(result.toString());
    }

}
