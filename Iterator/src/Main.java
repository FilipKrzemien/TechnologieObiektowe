import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<int[]> collection = new ArrayList<>();
        QuickSort quick = new QuickSort();
        HeapSort heap = new HeapSort();
        Context cnt = new Context();
        fillArray(collection);
        //System.out.println(collection);
        IntIterator iter = new IntIterator(collection);
        System.out.println("tablice przed posortowaniem");
        printCollection(collection);
        programLoop(collection, quick, heap, cnt, iter);
        System.out.println("tablice po posortowaniu");
        printCollection(collection);

    }

    private static void programLoop(ArrayList<int[]> collection,QuickSort quick, HeapSort heap, Context cnt, IntIterator iter) {
        Scanner sc = new Scanner(System.in);
        int i;
        while (iter.hasNext()) {
            System.out.println("Wybierz metode sortowania: \n" +
                    "1.quick 2.heap");
            i = Integer.parseInt(sc.nextLine());
            switch (i) {
                case 1:
                    cnt.setSort(quick);
                    break;
                case 2:
                    cnt.setSort(heap);
                    break;
                default:
                    System.out.println("Bladne dane");
                    continue;
            }
            cnt.sort((int[]) iter.next());
        }
    }

    private static void printCollection(ArrayList<int[]> collection) {
        for (int i = 0; i < 10; i++) {
            int[] tmp = collection.get(i);
            for (int j = 0; j < 10; j++)
                System.out.print(tmp[j] + " ");
            System.out.println();
        }
    }

    private static void fillArray(ArrayList<int[]> collection) {
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            int[] tmp = new int[10];
            for (int j = 0; j < 10; j++) {
                tmp[j] = rand.nextInt(30);
            }
            collection.add(tmp);
        }
    }

}