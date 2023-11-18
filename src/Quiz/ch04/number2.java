package Quiz.ch04;

public class number2 {

	public static void main(String[] args) {
		String grade = "B";
		
		int score = switch (grade) {
			case "A"  -> 100; //java 12부터 사용가능
			case "B" -> {
				int result = 100-20;
				yield result; //java 13부터 사용 가능
			}
			default -> 60;
		};
		
		System.out.println(score);
	}

}
