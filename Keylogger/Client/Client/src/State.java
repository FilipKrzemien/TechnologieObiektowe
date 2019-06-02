
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;

public abstract class State {

    protected Context context;
    protected HashMap<Integer,byte[]> result;

    public State(Context context) {
        this.context = context;
        result= new HashMap<>();
    }



    abstract void doAction() throws AWTException, IOException;

    public void end() throws IOException {
        ;
    }
}
