package sample;

import java.util.ArrayList;

public class LastName extends Name{
    private ArrayList<Number> number=new ArrayList<>();
    private ArrayList<Number> globalNumberList;
    public LastName(String name,String number,ArrayList<Number> globalNumberList,NameFabric parent) {
        super(name,parent);
        this.globalNumberList=globalNumberList;
        addNumber(number);
    }

    public void addNumber(String number)
    {
        Number nmbr=new Number(number, this);
        this.number.add(nmbr);
        this.globalNumberList.add(nmbr);
        }
}
