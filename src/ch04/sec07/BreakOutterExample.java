package ch04.sec07;

public class BreakOutterExample {

	public static void main(String[] args) {
		Outter : for(char upper = 'A'; upper <= 'Z'; upper++) {
			for(char lower = 'a'; lower <= 'z'; lower++) {
				System.out.println(upper + "-" + lower);
				if(lower=='g') {
					break Outter; // break할 반복문을 지정해 줄 수 있다
				}
			}
		}
		
		System.out.println("프로그램 실행 종료");
		
	}

}
