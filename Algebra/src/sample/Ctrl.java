package sample;

public abstract class Ctrl {


    protected double round(double temp) {
        temp*=100;
        temp=Math.round(temp);
        temp/=100;
        return temp;
    }

    public void switchScene(){
        Main.switchScene();
    }


}
