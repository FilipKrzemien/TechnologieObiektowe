package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FileReader {
    private ArrayList<String> persondata = new ArrayList<>();
    private ArrayList<Number> numbers = new ArrayList<>();
    private NameFabric fabryka;
    private Controller ctrl;

    public FileReader(Controller ctrl) {
        this.ctrl=ctrl;
        fabryka = new NameFabric();
        try {
            BufferedReader br = new BufferedReader(new java.io.FileReader("data.txt"));
            String row;

            while ((row = br.readLine()) != null) {
                persondata.add(row);
            }
            split();
        } catch (IOException e) {
            System.out.println("Brak pliku");
            e.printStackTrace();
        }
    }

    private void split() {
        for (String s : persondata) {
            ArrayList<String> splited = new ArrayList<>(Arrays.asList(s.split(" ")));
            if (numbers.isEmpty()) {
                System.out.println("Wchodze do fabryki po raz pierwszy");
                fabryka.exists(splited, numbers);
            } else {
                for (int i = 0; i < numbers.size();i++) {
                    if (numbers.get(i).getNumber().equals(splited.get(splited.size() - 1))) {
                        System.out.println("Numer nie jest unikalny - nie dodaje");
                        break;
                    } else {
                        System.out.println("Wchodze do fabryki");
                        fabryka.exists(splited, numbers);
                        break;
                    }
                }
            ctrl.begin(numbers);
            }
        }
    }
}

