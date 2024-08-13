package ch11;

public class TryWithResourceExample {
    public static void main(String[] args) {
        try(MyResource res = new MyResource("A")) {

        } catch (Exception e) {
            System.out.println("예외 처리");
        }

        MyResource res = new MyResource("B");
        MyResource res2 = new MyResource("C");
        try(res; res2) {

        }catch (Exception e) {
            System.out.println("예외 처리!");
        }

    }
}
