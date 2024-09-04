package ch19.sec03.exam02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class EchoClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 50001);
            System.out.println("[클라이언트] 연결 성공");

            String message = "나는 자바가 좋아~";
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF(message);
            dos.flush();
            System.out.println("[client] 데이터 보냄 : " + message);

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            String readData = dis.readUTF();
            System.out.println("[client] 데이터 받음 : " + readData);

            socket.close();
            System.out.println("[클라이언트] 연결 끊음");
        } catch (IOException e) {
            //해당 포트의 서버에 연결할 수 없는 경우
        }
    }
}
