package ch19.sec05.exam01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EchoServer {
    private static ServerSocket serverSocket = null;
    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        System.out.println("-------------------------------");
        System.out.println("서버를 종료하려면 q 또는 Q를 입력하세요.");
        System.out.println("-------------------------------");

        startServer();

        Scanner scan = new Scanner(System.in);

        while (true) {
            String key = scan.nextLine();
            if (key.equalsIgnoreCase("q")) {
                break;
            }
        }
        scan.close();

        stopServer();
    }

    public static void stopServer() {
        try {
            serverSocket.close();
            executorService.shutdown();
        } catch (IOException e) {

        }
    }

    public static void startServer() {
        Thread thread = new Thread(() -> {
            try {
                serverSocket = new ServerSocket(50001);
                System.out.println("server started");

                while (true) {
                    Socket socket = serverSocket.accept();

                    executorService.execute(() -> {
                        try {
                            InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();

                            System.out.println("server - " + isa.getHostName() + "의 연결 요청을 수락함");

                            DataInputStream dis = new DataInputStream(socket.getInputStream());
                            String message = dis.readUTF();

                            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                            dos.writeUTF(message);
                            dos.flush();
                            System.out.println("server return message : " + message);

                            socket.close();
                            System.out.println("server connect closed");
                        } catch (IOException e) {
                        }
                    });
                }
            } catch (IOException e) {
                System.out.println("server error : " + e.getMessage());
            }
        });
        thread.start();
    }
}
