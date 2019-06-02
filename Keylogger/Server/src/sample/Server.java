package sample;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Server extends Thread {
    private Map<Integer, ServerThread> clients = new HashMap<>();
    private Controller ctrl;

    public Server(Controller ctrl) {
        this.ctrl = ctrl;
    }

    @Override
    public void run(){
        try {
            Socket socket;
            ServerSocket server = new ServerSocket(101, 5);
            while (true) {
                socket = server.accept();
                System.out.println("Polaczono");
                ServerThread client = new ServerThread(socket);
                client.start();
                clients.put(clients.size() + 1, client);
                newClientConnected();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void notifyClient(int key, int i) throws IOException {
        ServerThread t = clients.get(key);
        t.setState(i);
    }

    public void notifyAllClients(int i) throws IOException {
        for (ServerThread t : clients.values()) {
            t.setState(i);
        }

    }
    public void newClientConnected(){
        Set keys=clients.keySet();
        ArrayList<Integer> clientsKeys = new ArrayList<>(keys);
        System.out.println("siemnka");
        ctrl.showClients(clientsKeys);

    }
}
