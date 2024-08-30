package ch17.sec12.exam03;

import ch17.sec12.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectExample {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("홍길동", "남", 92));
        list.add(new Student("김수영", "여", 93));
        list.add(new Student("김자바", "남", 94));
        list.add(new Student("오해영", "여", 95));
        list.add(new Student("아무개", "남", 96));

        Map<String, Double> collect = list.stream()
                .collect(Collectors.groupingBy(
                                s -> s.getSex(),
                                Collectors.averagingDouble(s -> s.getScore())
                        )
                );

        System.out.println(collect);
    }
}
