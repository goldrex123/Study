package ch19.sec07;

import org.json.JSONObject;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServer {
    ServerSocket serverSocket;
    ExecutorService threadPool = Executors.newFixedThreadPool(100);

    Map<String, SocketClient> chatRoom = Collections.synchronizedMap(new HashMap<>());

    public static void main(String[] args) {
        try {
            ChatServer chatServer = new ChatServer();
            chatServer.start();

            System.out.println("-------------------------------");
            System.out.println("서버를 종료하려면 q 또는 Q를 입력하세요.");
            System.out.println("-------------------------------");


            Scanner scan = new Scanner(System.in);

            while (true) {
                String key = scan.nextLine();
                if (key.equalsIgnoreCase("q")) {
                    break;
                }
            }

            scan.close();
            chatServer.stop();
        } catch (IOException e) {
            System.out.println("server error : " + e.getMessage());
        }
    }

    public void start() throws IOException {
        serverSocket = new ServerSocket(50001);
        System.out.println("[server] started");

        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    SocketClient sc = new SocketClient(this, socket);
                } catch (IOException e) {
                }
            }
        });

        thread.start();
    }

    public void addSocketClient(SocketClient socketClient) {
        String key = socketClient.chatName + "@" + socketClient.clientIp;
        chatRoom.put(key, socketClient);
        System.out.println("입장: " + key);
        System.out.println("현재 채팅자 수: " + chatRoom.size() + "\n");
    }

    public void removeSocketClient(SocketClient socketClient) {
        String key = socketClient.chatName + "@" + socketClient.clientIp;
        chatRoom.remove(key);
        System.out.println("나감 : " + key);
        System.out.println("현재 채팅자 수 : " + chatRoom.size() + "\n");
    }

    public void sendToAll(SocketClient sender, String message) {
        JSONObject root = new JSONObject();
        root.put("clientIp", sender.clientIp);
        root.put("chatName", sender.chatName);
        root.put("message", message);

        String json = root.toString();

        Collection<SocketClient> socketClients = chatRoom.values();
        for (SocketClient sc : socketClients) {
            if (sc == sender) continue;
            sc.send(json);
        }
    }

    public void stop() {
        try {
            serverSocket.close();
            threadPool.shutdownNow();
            chatRoom.values().forEach(SocketClient::close);
            System.out.println("server closed");
        } catch (IOException e) {
        }
    }
}
