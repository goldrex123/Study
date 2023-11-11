package ch02.sec12;

public class PrintfExample {
    public static void main(String[] args) {
        int value = 123;
        System.out.printf("상품의 가격 : %d원\n", value); // 123원 
        System.out.printf("상품의 가격 : %6d원\n", value); //   123원 <-앞에 빈자리를 공백으로
        System.out.printf("상품의 가격 : %-6d원\n", value);//123    원 <-뒤에 빈자리를 공백으로
        System.out.printf("상품의 가격 : %06d원\n", value);//000123원 <- 앞에빈자리를 0으로

        double area = 3.14159 * 10 * 10;
        System.out.printf("반지름이 %d인 원의 넓이: %10.2f\n", 10, area); //     314.16<- 10자리 (소수점 최대 2자리) 
    }
}