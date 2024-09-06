package nio.sec03.exam01_create_buffer;

import java.nio.ByteBuffer;

// 운영 체제에 버퍼 생성
public class DirectBufferExample {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(100);
        System.out.println(byteBuffer);

    }
}
