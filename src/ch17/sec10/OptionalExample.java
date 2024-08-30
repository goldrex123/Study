package ch17.sec10;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class OptionalExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        // 에러 발생 --> NoSuchElementException
//        double asDouble = list
//                .stream()
//                .mapToInt(Integer::intValue)
//                .average()
//                .getAsDouble();

        // 방법 1
        OptionalDouble average = list.stream()
                .mapToInt(Integer::intValue)
                .average();

        if(average.isPresent()) {
            System.out.println("방법1 평균 : " + average.getAsDouble());
        } else {
            System.out.println("방법 1 평균 : 0.0");
        }

        //방법 2
        double v = list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
        System.out.println("방법2 평균 : " + v);

        //방법 3
        list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .ifPresent(x -> System.out.println("방법3 평균 : " + x));
    }
}
