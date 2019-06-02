import java.util.Scanner;

public class TextFile extends BasicFile {

    private String content = "";

    TextFile(String name, Catalog parent, int depth) {
        super(name, parent, depth);
        this.identifier = "[F]";
    }

    public String getContent() {
        return content;

    }

    public void setContent(String content) {
        this.content = content;
    }

    public void show() {
        System.out.println("Zawartosc pliku " + this.getName() + ":");
        if (this.getContent().equals("")) {
            System.out.println("Plik jest pusty");
        } else {
            System.out.println("\n" + this.content + "\n");
        }
        System.out.println("Co chcesz zrobic?\n" +
                "1.Nadpisz zawartosc\n" +
                "2.Dopisz do pliku\n" +
                "3.Wyjdz");
        Scanner sc = new Scanner(System.in);
        String i = sc.nextLine();
        String cnt;
        switch (i) {
            case "1":
                System.out.println("Podaj nowa zawartosc");
                cnt = sc.nextLine();
                setContent(cnt);
                show();
                break;
            case "2":
                System.out.println("Podaj nowa linie");
                cnt = getContent();
                String temp2 = sc.nextLine();
                cnt = cnt + temp2;
                setContent(cnt);
                show();
                break;
            case "3":
                parent.show();
                Main.begin(parent);
                break;
            default:
                System.out.println("Bledny input.\n");
                show();
                break;
        }
    }

}
