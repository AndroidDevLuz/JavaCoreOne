package lesson7_level2_chat.server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;


public class Server {
    private static final String PERSONAL_KEY = "/w";
    private List<ClientHandler> clients;
    private AuthService authService;

    public Server() {
        clients = new Vector<>();
        authService = new SimpleAuthService();
        ServerSocket server = null;
        Socket socket;

        final int PORT = 8189;

        try {
            server = new ServerSocket(PORT);
            System.out.println("Сервер запущен!");

            while (true) {
                socket = server.accept();
                System.out.println("Клиент подключился ");
                new ClientHandler(this, socket);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendMessage(String fullMsg, String userMsg){
        String key0 = null;
        String key1 = null;
        String[] stringKey = userMsg.split(" ");
        try {

            key0 = stringKey[0];
            key1 = stringKey[1];

        } catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }

        if(key0 !=null && key1 !=null && key0.contains(PERSONAL_KEY)){
            sendPersonalMessage(fullMsg,key1);
        } else{
            sendBroadcastMessage(fullMsg);
        }

    }

    private void sendPersonalMessage(String msg, String key) {
        for (ClientHandler c:clients) {
            if(c.getNick().contains(key)) {
                String[] message = msg.split(" ", 4);
                c.sendMsg(message[0]+" "+message[3]);
            }
        }
    }

    private void sendBroadcastMessage(String msg) {
        for (ClientHandler c:clients) {
            c.sendMsg(msg);
        }
    }

    public void subscribe(ClientHandler clientHandler){
        clients.add(clientHandler);
    }

    public void unsubscribe(ClientHandler clientHandler){
        clients.remove(clientHandler);
    }

    public AuthService getAuthService() {
        return authService;
    }
}
