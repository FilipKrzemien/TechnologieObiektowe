package sample;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

public class PictureElement extends Chain {


    public PictureElement(Chain next) {
        super(next);
        this.type=1;
    }

    @Override
    protected void processConcreteRequest(HashMap<Integer, byte[]> map) throws IOException {
        byte[] x=map.get(type);
        Random rand = new Random();
        ByteArrayInputStream input_stream= new ByteArrayInputStream(x);
        BufferedImage final_buffered_image = ImageIO.read(input_stream);
        ImageIO.write(final_buffered_image , "jpg", new File("final_file" + rand.nextInt(10000) + ".jpg") );
    }
}
