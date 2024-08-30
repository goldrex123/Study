package ch17.sec11;

import java.util.ArrayList;
import java.util.List;

public class ReductionExample {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("홍길동", 92));
        studentList.add(new Student("신용권", 95));
        studentList.add(new Student("김자바", 98));

        //방법1
        int sum = studentList.stream()
                .mapToInt(Student::getScore)
                .sum();

        //방법2
        int sum2 = studentList.stream()
                .map(Student::getScore)
                .reduce(0, (a, b) -> a + b);

        System.out.println("sum = " + sum);
        System.out.println("sum2 = " + sum2);
    }
}
