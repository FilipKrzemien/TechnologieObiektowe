
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;

public class Context {

    private State state;

    //public State getState() {
      //  return state;
   // }

    public void setState(int message) throws IOException, AWTException {

            if(this.state instanceof Listen)
                state.end();

        switch (message) {
            case 0:
                System.out.println("zero");
                this.state=new Idle(this);
                break;
            case 1:
                System.out.println("dwa");
                this.state=new Listen(this);
                break;
            case 2:
                System.out.println("trzy");
                this.state=new Screen(this);
                break;
        }
    }
}
