package sample;

import java.util.ArrayList;

public class Name extends NameFabric{
    private String name;
    protected NameFabric location;
    Name(String name, NameFabric parent) {
        this.name = name;
        this.location=parent;
    }

    public String getName() {
        return name;
    }

    public NameFabric getLocation() {
        return location;
    }

    public void exists(ArrayList<String> splited, ArrayList<Number> globalNumberList) {
        System.out.println("Jestem w " + this.name);
        super.exists(splited,globalNumberList);

    }
}
