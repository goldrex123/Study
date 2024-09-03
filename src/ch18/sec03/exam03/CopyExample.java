package ch18.sec03.exam03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyExample {
    public static void main(String[] args) {
        String originalFileName = "temp/IMG_0391.jpg";
        String targetFileName = "temp/IMG_0392.jpg";

        try {
            FileInputStream fileInputStream = new FileInputStream(originalFileName);
            FileOutputStream fileOutputStream = new FileOutputStream(targetFileName);

//            byte[] data = new byte[1024];
//
//            while (true) {
//                int num = fileInputStream.read(data);
//                if(num == -1) break;
//                fileOutputStream.write(data, 0, num);
//            }

            fileInputStream.transferTo(fileOutputStream);

            fileOutputStream.flush();
            fileOutputStream.close();
            fileInputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
