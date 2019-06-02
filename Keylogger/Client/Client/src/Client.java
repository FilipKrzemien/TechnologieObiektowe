import org.jnativehook.GlobalScreen;

import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;

public class Client {
    static Socket socket;
    static ObjectOutputStream os;
    public static void main(String[] args) throws IOException, AWTException {

        socket = new Socket("Filip-PC", 101);
        os = new ObjectOutputStream(socket.getOutputStream());
        Client cl = new Client();
        cl.createListener();

    }

    public static void sendData(HashMap<Integer, byte[]> data) throws IOException {
        System.out.println("Wysylam dane do serwera");
        os.writeObject(data);
        os.flush();
    }

    public void createListener() throws IOException, AWTException {
        ClientListener listener = new ClientListener();
        listener.start();
    }

    private class ClientListener extends Thread {

        private Context cont;

        public ClientListener() throws IOException, AWTException {
            this.cont=new Context();

        }

        public void run(){
            try {
                ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
                while (true) {

                    Integer i = (Integer) is.readObject();
                    if(i.equals(3)){
                        break;
                    }
                    System.out.println(i);
                    cont.setState(i);

                }
                Client.socket.close();
            } catch (IOException | ClassNotFoundException | AWTException e) {
                e.printStackTrace();
            }
        }
    }

}


