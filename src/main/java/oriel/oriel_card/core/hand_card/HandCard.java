package oriel.oriel_card.core.hand_card;

import java.util.LinkedList;
import java.util.stream.Stream;

import lombok.NonNull;
import oriel.oriel_card.core.card.Card;

public class HandCard {

	private final LinkedList<Card> cardList = new LinkedList<Card>();
	
	public void add(@NonNull Card card) {
		this.cardList.add(card);
	}
	
	public Stream<Card> stream() {
		return this.cardList.stream();
	}
	
	public int getCardCount() {
		return this.cardList.size();
	}
	
	public Card get(int index) {
		return this.cardList.get(index);
	}
	
	public Card take(int index) {
		return this.cardList.remove(index);
	}
	
	public boolean isEmpty() {
		return this.cardList.isEmpty();
	}
}
