import java.util.Scanner;

public class NameChanger {

    private BasicFile file;

    public NameChanger(BasicFile file) {
        this.file = file;
    }

    public void rename(Catalog temp) {
        System.out.println("Podaj nowa nazwe.");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        if (Main.isTaken(temp, name)) {
            System.out.println("Nazwa zajeta.");
            rename(temp);
        } else {
            file.setName(name);
            temp.show();
            Main.begin(temp);
        }

    }
}
