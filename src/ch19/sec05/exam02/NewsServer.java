package ch19.sec05.exam02;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewsServer {
    private static DatagramSocket datagramSocket = null;
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
        datagramSocket.close();
        executorService.shutdown();
        System.out.println("server closed");
    }

    public static void startServer() {
        Thread thread = new Thread(() -> {
            try {
                datagramSocket = new DatagramSocket(50001);

                System.out.println("[Server] starting...");

                while (true) {
                    DatagramPacket receivePacket = new DatagramPacket(new byte[1024], 1024);
                    datagramSocket.receive(receivePacket);

                    executorService.execute(() -> {
                        try {
                            String newsKind = new String(receivePacket.getData(), 0, receivePacket.getLength(), "UTF-8");

                            SocketAddress socketAddress = receivePacket.getSocketAddress();

                            for (int i = 0; i < 10; i++) {
                                String data = newsKind + ": 뉴스" + i;
                                byte[] bytes = data.getBytes(StandardCharsets.UTF_8);
                                DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length, socketAddress);
                                datagramSocket.send(packet);
                            }
                            } catch(IOException e){
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
