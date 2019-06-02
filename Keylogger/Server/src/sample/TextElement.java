package sample;

import java.io.IOException;
import java.util.HashMap;

public class TextElement extends Chain {
    public TextElement(Chain next) {
        super(next);
        this.type=0;
    }

    @Override
    protected void processConcreteRequest(HashMap<Integer, byte[]> map) throws IOException {
        byte[] x=map.get(type);
        String s=new String(x);
        System.out.println("Przechwycony text: \n" + s);
    }
}
