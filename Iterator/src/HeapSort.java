public class HeapSort extends Sort {

    @Override
    public void sort(int tab[]) {
        int n = tab.length;
        this.array = tab;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, n, i);


        for (int i = n - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }
    }

    void heapify(int tab[], int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;


        if (l < n && tab[l] > tab[largest])
            largest = l;


        if (r < n && tab[r] > tab[largest])
            largest = r;


        if (largest != i) {
            int swap = tab[i];
            tab[i] = tab[largest];
            tab[largest] = swap;


            heapify(tab, n, largest);
        }
    }
}
