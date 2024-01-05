package Quiz.ch06;

public class number18 {
	private static number18 num = new number18();
	
	private number18() {}
	
	public static number18 getInstance() {
		return num;
	}
}
