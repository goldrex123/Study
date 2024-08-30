package Quiz.ch17.Number7;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Example {
    public static void main(String[] args) {

        List<Member> list = Arrays.asList(
                new Member("홍길동", "개발자"),
                new Member("홍길감", "디자이너"),
                new Member("신용권", "개발자")
        );

        List<Member> developer = list.stream()
                .filter(x -> x.getJob().equals("개발자"))
                .collect(Collectors.toList());

        developer.stream().forEach(x -> System.out.println(x.getName()));
    }
}
