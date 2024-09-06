package nio.sec03.exam03_convert_buffer;

import java.awt.*;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class ByteBufferToStringExample {
    public static void main(String[] args) {
        Charset charset = Charset.forName("UTF-8");

        String data = "안녕하세요";

        ByteBuffer encode = charset.encode(data);
        System.out.println(encode);



        data = charset.decode(encode).toString();
        System.out.println(data);
    }
}
