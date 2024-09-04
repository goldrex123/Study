package ch19.sec03.exam01;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerExample {
    private static ServerSocket serverSocket = null;

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

    public static void startServer() {
        Thread thread = new Thread(() -> {
            try {
                serverSocket = new ServerSocket(50001);
                System.out.println("[서버] 시작됨");

                while (true) {
                    System.out.println("\n[서버] 연결 요청을 기다림\n");

                    Socket socket = serverSocket.accept();

                    InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
                    System.out.println("[서버] " + isa.getHostName() + "의 연결 요청을 수락함");

                    socket.close();
                    System.out.println("[서버] " + isa.getHostName() + "의 연결을 끊음");
                }
            } catch (IOException e) {
                System.out.println("[서버] " + e.getMessage());
            }
        });
        thread.start();
    }

    public static void stopServer() {
        try {
            serverSocket.close();
            System.out.println("[서버] 종료됨");
        } catch (IOException e) {}
    }
}
