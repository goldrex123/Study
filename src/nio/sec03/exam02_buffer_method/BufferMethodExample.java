package nio.sec03.exam02_buffer_method;

import java.nio.ByteBuffer;

public class BufferMethodExample {
    public static void main(String[] args) {
        System.out.println("[7바이트 크기로 버퍼 생성]");
        ByteBuffer buffer = ByteBuffer.allocate(7);
        printStatue(buffer);

        buffer.put((byte) 10);
        buffer.put((byte) 11);
        System.out.println("[2바이트 저장 후]");
        printStatue(buffer);

        buffer.put((byte) 12);
        buffer.put((byte) 13);
        buffer.put((byte) 14);
        System.out.println("[3바이트 저장 후]");
        printStatue(buffer);

        buffer.flip();
        System.out.println("[filp() 실행 후]");
        printStatue(buffer);

        buffer.get(new byte[3]);
        System.out.println("[3byte read]");
        printStatue(buffer);

        buffer.mark();
        System.out.println("[buffer mark]");

        buffer.get(new byte[2]);
        System.out.println("[2byte read]");
        printStatue(buffer);

        buffer.reset();
        System.out.println("[position move to the mark]");
        printStatue(buffer);

        buffer.rewind();
        System.out.println("[buffer rewind()]");
        printStatue(buffer);

        buffer.clear();
        System.out.println("[buffer clear()]");
        printStatue(buffer);


    }

    static void printStatue(ByteBuffer buffer) {
        System.out.print("\tposition:" + buffer.position() + ", ");
        System.out.print("\tlimit:" + buffer.limit() + ", ");
        System.out.println("\tcapacity:" + buffer.capacity());
    }
}
