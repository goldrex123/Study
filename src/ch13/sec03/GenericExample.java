package ch13.sec03;

public class GenericExample {
    public static <T> Box<T> boxing(T t) {
        Box<T> box = new Box<>();
        box.setT(t);
        return box;
    }

    public static void main(String[] args) {
        Box<Integer> boxing = boxing(100);
        int intValue = boxing.getT();
        System.out.println(intValue);

        Box<String> box2 = boxing("홍");
        String msg = box2.getT();
        System.out.println(msg);
    }
}
