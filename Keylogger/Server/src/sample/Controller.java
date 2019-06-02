package sample;

import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Controller {
    public Button all;
    public Button single;
    public ChoiceBox<String> stat;
    public ChoiceBox<Integer> clientId;
    private Server server;


    public void initialize(){
        server= new Server(this);
        server.start();
        ArrayList<String> list=new ArrayList<>();
        list.add("Idle");
        list.add("Listen");
        list.add("Screen");
        list.add("Zamknij");
        stat.setItems(FXCollections.observableList(list));
    }
    public void showClients(ArrayList<Integer> list){
        clientId.setItems(FXCollections.observableList(list));

    }

    public void notifyConcrete() throws IOException {
        String s=stat.getValue();
        int i = prepare(s);
        server.notifyClient(clientId.getValue(),i);
    }

    private int prepare(String s) {
        int i = 0;
        switch (s) {
            case "Idle":
                i = 0;
                break;
            case "Listen":
                i = 1;
                break;
            case "Screen":
                i = 2;
                break;
            case "Zamknij":
                i=3;
                break;
        }
        return i;
    }

    public void notifyAllClients() throws IOException {
        String s=stat.getValue();
        int i = prepare(s);
        server.notifyAllClients(i);
    }
}
