import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Catalog extends BasicFile {

    private List<BasicFile> content = new ArrayList<>();

    Catalog(String name, Catalog parent, int depth) {
        super(name, parent, depth);
        this.identifier = "[K]";

    }

    public String getIdentifier() {
        return identifier;
    }

    List<BasicFile> getContent() {
        return content;
    }

    BasicFile getItem(String name) {
        BasicFile item = null;

        for (BasicFile x : getContent()) {
            if (x.getName().equals(name)) {
                item = x;
            }
        }
        return item;
    }

    void addItem(String nazwa) {
        System.out.println("Jaki obiekt chcesz utworzyć? " +
                "\n Wpisz: " +
                "\n1. aby stworzyć nowy katalog," +
                "\n2. aby stworzyć nowy plik ");
        Scanner in = new Scanner(System.in);
        String i = in.nextLine();
        putInList(nazwa, i);
    }

    void putInList(String nazwa, String in) {
        switch (in) {
            case "1":
                getContent().add(new Catalog(nazwa, this, this.depth + 1));
                break;
            case "2":
                getContent().add(new TextFile(nazwa, this, this.depth + 1));
                break;
            default:
                System.out.println("Bledny input");
                break;

        }
    }
        void removeElement (BasicFile f){
            getContent().remove(f);
            System.out.println("Usuniento\n\n");
            this.show();
            Main.begin(this);
        }

        public void show () {

            if (getContent().isEmpty())
                System.out.println("Katalog " + this.getName() + " jest pusty");
            else {
                System.out.println("Zawartosc katalogu: " + this.getName());
                getContent().forEach((x) -> System.out.print(x.getIdentifier() + x.getName() + "\t"));
            }
            Main.begin(this);
        }

        public void tree () {
            for (BasicFile f : getContent()) {
                for (int i = 0; i < getDepth(); i++)
                    System.out.print("\t");

                System.out.println(f.getName());
                if (f instanceof Catalog)
                    ((Catalog) f).tree();
            }
        }

    }
