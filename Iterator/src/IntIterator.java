import java.util.ArrayList;


public class IntIterator implements Iterator {

    private ArrayList<int[]> collection;
    private int currentIndex;
    public IntIterator(ArrayList<int[]> collection) {
        this.collection = collection;
        this.currentIndex=0;
    }

    @Override
    public boolean hasNext() {
        if (currentIndex >= collection.size() || collection.get(currentIndex) == null){
            return false;
        }
        return true;
    }

    @Override
    public Object next() {
        if (hasNext())
        {
            return collection.get(currentIndex++);
        }
        return null;
    }

    public int[] getCurrent(){
        return collection.get(currentIndex);
    }
}
