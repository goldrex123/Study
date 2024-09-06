package nio.sec03.exam01_create_buffer;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;

// 자바 힙 메모리에 nio 생성
public class NonDirectBufferExample {
    public static void main(String[] args) {
        ByteBuffer buffer1 = ByteBuffer.allocate(100);
        System.out.println(buffer1);
        System.out.println();

        IntBuffer buffer2 = IntBuffer.allocate(100);
        System.out.println(buffer2);
        System.out.println();

        byte[] array3 = {10, 20};
        ByteBuffer buffer3 = ByteBuffer.wrap(array3);
        System.out.println(buffer3 + ", ");
        System.out.println(Arrays.toString(buffer3.array()));
        System.out.println();

        char[] array4 = "This is Java".toCharArray();
        CharBuffer buffer4 = CharBuffer.wrap(array4);
        System.out.println(buffer4);
        System.out.println(Arrays.toString(buffer4.array()));
    }
}
