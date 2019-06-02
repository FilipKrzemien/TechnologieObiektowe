package sample.control;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reader {

    private ArrayList<String> shapes = new ArrayList<>();
    private PointParser pp;


    public Reader(PointParser pp) {
        this.pp = pp;
        try {
            BufferedReader br=new BufferedReader(new FileReader("shapes.txt"));
            String row;

            while((row=br.readLine()) !=null){
                shapes.add(row);
            }
            split();
        } catch (IOException e) {
            System.out.println("Brak pliku");
            e.printStackTrace();
        }

    }

    private void split() {

        for(String s : shapes){
            String[] splited =s.split(" ");
            pp.parseElement(splited);
        }

    }
}
