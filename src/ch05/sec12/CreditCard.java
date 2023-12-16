package ch05.sec12;

import java.util.Arrays;
import java.util.List;

public enum CreditCard {
	SHINHAN("신한", Arrays.asList("Mr.Life 카드", "Deep Dream 카드", "Deep Oil 카드")),
    KB("국민", Arrays.asList("톡톡D 카드", "티타늄 카드", "다담 카드")),
    NH("농협", Arrays.asList("올바른 FLEX 카드", "테이크 5 카드", "NH 올원 파이카드"));

    private final String Enterprise;
    private final List<String> cards;

    CreditCard(String name, List<String> cards) {
        this.Enterprise = name;
        this.cards = cards;
    }

	public String getEnterprise() {
		return Enterprise;
	}

	public List<String> getCards() {
		return cards;
	}
    
	String getCard(String cardName) {
		return Arrays.stream(CreditCard.values())
		.filter(x -> x.getCards().contains(cardName))
		.findFirst().orElse(null).getEnterprise();
	}
}
