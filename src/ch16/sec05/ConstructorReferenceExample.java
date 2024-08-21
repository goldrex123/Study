package ch16.sec05;

public class ConstructorReferenceExample {
    public static void main(String[] args) {
        Person person = new Person();

        Member member1 = person.getMember1(Member::new);
        System.out.println(member1);
        System.out.println();

        Member member2 = person.getMember2(Member::new);
        System.out.println(member2);
    }
}
