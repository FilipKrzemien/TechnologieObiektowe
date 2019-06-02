import java.util.Scanner;

import static java.lang.System.exit;

public class Main {

    static Catalog glowny = new Catalog("Glowny", null, 0);

    public static void main(String[] args) {

        glowny.putInList("Katalog 1", "1");
        glowny.putInList("Katalog 2", "1");
        glowny.putInList("Katalog 3", "1");
        glowny.putInList("Plik 1", "2");
        glowny.putInList("Plik 2", "2");
        glowny.putInList("Plik 3", "2");

        ((Catalog) glowny.getItem("Katalog 1")).putInList("Katalog 1", "1");
        ((Catalog) glowny.getItem("Katalog 1")).putInList("Plik 1", "2");
        ((Catalog) glowny.getItem("Katalog 2")).putInList("Katalog 1", "1");
        ((Catalog) glowny.getItem("Katalog 2")).putInList("Plik 1", "2");
        ((Catalog) glowny.getItem("Katalog 3")).putInList("Katalog 1", "1");
        ((Catalog) glowny.getItem("Katalog 3")).putInList("Plik 1", "2");

        glowny.show();
        begin(glowny);
    }

    static void begin(Catalog temp) {

        System.out.println("\nCo chcesz zrobic?\n" +
                "1.Otworz katalog/plik\t" +
                "2.Usun katalog/plik\t" +
                "3.Dodaj nowy katalog/plik\t" +
                "4.Zmien nazwe pliku\t" +
                "5.Wroc do katalogu glownego\t" +
                "6.Wejdz wyzej\t" +
                "7.Rysuj drzewo\t" +
                "8.Wyjdz");
        Scanner scanner = new Scanner(System.in);
        String name;
        String i = scanner.nextLine();
        switch (i) {
            case "1":
                if (temp.getContent().isEmpty()) {
                    System.out.println("Katalog jest pusty\n\n");
                    temp.show();
                    begin(temp);
                    break;
                } else {

                    System.out.println("Podaj nazwe");
                    name = scanner.nextLine();
                    open(temp, name);
                    break;
                }

            case "2":
                if (temp.getContent().isEmpty()) {
                    System.out.println("Katalog jest pusty\n\n");
                    temp.show();
                    begin(temp);
                    break;
                } else {

                    System.out.println("Podaj nazwe");
                    name = scanner.nextLine();
                    remove(temp, name);
                    break;
                }

            case "3":
                System.out.println("Podaj nazwe");
                name = scanner.nextLine();
                add(temp, name);
                break;
            case "4":
                System.out.println("Podaj nazwe");
                name = scanner.nextLine();
                NameChanger proxy = new NameChanger(temp.getItem(name));
                proxy.rename(temp);
                break;
            case "5":
                glowny.show();
                begin(glowny);
                break;

            case "6":
                temp.goUp();
                break;

            case "7":
                temp.tree();
                break;

            case "8":
                System.out.println("Pa pa :)");
                exit(0);

            default:
                System.out.println("Bledny input\n\n");
                temp.show();
                begin(temp);
                break;
        }
    }

    private static void remove(Catalog temp, String name) {

        try {
            BasicFile f = temp.getItem(name);
            temp.removeElement(f);
        } catch (Exception e) {
            System.out.println("Brak pliku o podanej nazwie\n\n");
            temp.show();
            begin(temp);
        }
    }


    private static void add(Catalog temp, String name) {

        boolean taken = isTaken(temp, name);
        if (taken) {
            System.out.println("W katalogu istnieje juz plik o takiej nazwie.\n\n");
            temp.show();
            begin(temp);
        } else {
            temp.addItem(name);
            temp.show();
            begin(temp);
        }

    }

    public static boolean isTaken(Catalog temp, String name) {
        boolean taken = false;
        for (BasicFile x : temp.getContent()) {
            if (x.getName().equals(name)) {
                taken = true;
            }
        }
        return taken;
    }

    private static void open(Catalog temp, String name) {
        try {
            BasicFile f = temp.getItem(name);
            f.show();
        } catch (Exception e) {
            System.out.println("Brak pliku o podanej nazwie\n\n");
            temp.show();
            begin(temp);
        }
    }


}
