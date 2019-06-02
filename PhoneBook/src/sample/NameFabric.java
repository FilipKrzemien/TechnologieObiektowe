package sample;

import java.util.ArrayList;


public class NameFabric {
    private ArrayList<Name> names = new ArrayList<>();

    public String getName() { return "Fabryka"; }

    public NameFabric getLocation(){
        return null;
    }
    public void exists(ArrayList<String> splited,ArrayList<Number> numbers) {
        boolean happend = false;
        if (splited.size() > 2) {
            for (Name n : names) {
                if (n.getName().equals(splited.get(0))) {
                    System.out.println("takie imie juz istnieje " + splited.get(0));
                    splited.remove(0);
                    n.exists(splited,numbers);
                    happend = true;
                    break;
                }
            }
            if (!happend) {
                System.out.println("Dodaje nowe imie " + splited.get(0));
                names.add(new Name(splited.get(0),this));
                splited.remove(0);
                Name n = names.get(names.size() - 1);
                n.exists(splited,numbers);
            }
        } else if (splited.size() == 2) {
            for (int i=0;i<names.size();i++) {
                if (names.get(i).getName().equals(splited.get(0))) {
                    System.out.println("takie nazwisko juz istnieje " +
                            splited.get(0) +" Dodaje numer " + splited.get(1));
                    LastName k= (LastName) names.get(i);
                    k.addNumber(splited.get(1));
                    happend = true;
                    break;
                }
            }
            if (!happend) {
                System.out.println("Dodaje nowe nazwisko " + splited.get(0) + " O numerze " + splited.get(1));
                names.add(new LastName(splited.get(0), splited.get(1), numbers,this));
            }
        } else {
            System.out.println("cos poszlo nie tak");
        }
    }
}

