package sample;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class Chain {

    protected Chain next;
    protected Integer type;

    public Chain(Chain next) {
        this.next = next;
    }

    public void processRequest(HashMap<Integer ,byte[]> map) throws IOException {
        if(map.containsKey(type)){
            processConcreteRequest(map);
        }
        else {
            next.processRequest(map);
        }
    }

    protected abstract void processConcreteRequest(HashMap<Integer,byte[]> map) throws IOException;
}
