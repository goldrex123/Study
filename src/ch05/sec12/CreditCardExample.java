package ch05.sec12;

import java.util.Arrays;

public class CreditCardExample {
	public static void main(String[] args) {
		CreditCard card = CreditCard.SHINHAN;
		
		String cards = card.getCard("티타늄 카드");
		
		System.out.println(cards);
		//		Arrays.stream(card.values()).forEach(x -> {
//			System.out.println(x);
//		});
		
	}
}
