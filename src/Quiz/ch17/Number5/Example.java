package Quiz.ch17.Number5;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Example {
    public static void main(String[] args) {
        List<String> list = Arrays.asList(
                "This is a java book",
                "Lamda Expressions",
                "Java8 supports lambda expressions"
        );

        list.stream()
                .filter(x -> x.toLowerCase().contains("java"))
                .forEach(x -> System.out.println(x));
    }
}
