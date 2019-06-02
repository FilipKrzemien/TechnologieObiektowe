package sample;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;

public class ServerThread extends Thread {

    private Socket socket;
    private ObjectOutputStream os;
    private ObjectInputStream is;
    private boolean killed;
    public ServerThread(Socket socket) throws IOException {
        this.socket = socket;
        this.os=  new ObjectOutputStream(socket.getOutputStream());
        killed=false;

    }

    @Override
    public void run() {

        try {
            this.is = new ObjectInputStream(socket.getInputStream());
            while(true){

                HashMap<Integer,byte[]> map= (HashMap<Integer,byte[]>)is.readObject();
                getDataFromClient(map);
                if(killed){
                    break;
                }
            }
            socket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();

        }

    }

    private void getDataFromClient(HashMap<Integer ,byte[]> map) throws IOException {
        Main.textParse.processRequest(map);
    }

    public void setState(Integer i) throws IOException {
        os.writeObject(i);
        os.flush();

    }
}
