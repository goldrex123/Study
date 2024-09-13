package ch02.sec12;

import java.util.Arrays;

public class HexToIntExample {
    public static void main(String[] args) {
        int a = 01010;
        int[] arr = new int[2];

        System.out.println(Integer.parseInt(Integer.toOctalString(a),8));

        arr[0] = Integer.parseInt(Integer.toOctalString(a));

        System.out.println(Arrays.toString(arr));
        System.out.println(Integer.parseInt("1010",2));

//        System.out.println(Integer.toHexString(13));
//        System.out.println(Integer.toOctalString(13));
    }
}
