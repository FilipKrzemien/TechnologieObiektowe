import java.util.List;

public class Context {

    private Sort sort;

    public Context() {
    }

    public void setSort(Sort s) {
        this.sort = s;
    }

    public void sort(int tab[]) {
        sort.sort(tab);
    }
}
