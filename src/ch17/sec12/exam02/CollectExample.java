package ch17.sec12.exam02;


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

        Map<String, List<Student>> collect = list.stream()
                .collect(Collectors.groupingBy(s -> s.getSex()));

        List<Student> male = collect.get("남");
        male.stream().forEach(s -> System.out.println(s.getName()));

        System.out.println();
        List<Student> female = collect.get("여");
        male.stream().forEach(s -> System.out.println(s.getName()));

    }
}
