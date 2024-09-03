package ch18.sec10;

import java.io.*;
import java.util.Arrays;

public class ObjectInputOutputStreamExample {
    public static void main(String[] args)  {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("temp/object.dat"));

            Member m1 = new Member("fall", "단풍이");
            Product p1 = new Product("노트북", 1500000);

            int[] arr1 = {1, 2, 3};

            oos.writeObject(m1);
            oos.writeObject(p1);
            oos.writeObject(arr1);

            oos.flush();
            oos.close();

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("temp/object.dat"));

            Member member = (Member) ois.readObject();
            Product product = (Product) ois.readObject();
            int[] arr2 = (int[]) ois.readObject();

            System.out.println(member);
            System.out.println("product = " + product);
            System.out.println("arr2 = " + Arrays.toString(arr2));
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
