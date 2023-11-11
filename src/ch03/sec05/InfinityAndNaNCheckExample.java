package ch03.sec05;

public class InfinityAndNaNCheckExample {
	public static void main(String[] args) {
		
		int x = 5;
		double y = 0.0;
		double z = x / y;
		double z2 = x % y;
		
		System.out.println(z); // 실수 / 0은 Infinity!
		System.out.println(z2); // 실수 % 0은 NaN!
		
		if(Double.isInfinite(z) || Double.isNaN(z)) { // 해당 조건문으로 거를 수 있다.
			System.out.println("값 산출 불가!");
		} else {
			System.out.println(z + 2);
		}
	}
}
