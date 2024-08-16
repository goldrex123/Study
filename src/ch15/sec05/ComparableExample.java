package ch15.sec05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparableExample {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();

        list.add(new Person("홍길동",45));
        list.add(new Person("김",20));
        list.add(new Person("아무개",30));

        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.age - o2.age;
            }
        });

        list.forEach(x -> {
            System.out.println(x.age);
        });
    }
}
