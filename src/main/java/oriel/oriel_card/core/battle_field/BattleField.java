package oriel.oriel_card.core.battle_field;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import lombok.NonNull;
import oriel.oriel_card.core.card.Card;

public class BattleField {

	private final LinkedList<Card> cardList = new LinkedList<>();
	
	public void put(@NonNull Card card) {
		this.cardList.add(card);
	}

	public void remove(Card card) {
		this.cardList.remove(card);
	}
	
	public boolean isEmpty() {
		return this.cardList.isEmpty();
	}
	
	public List<Card> toList() {
		return Collections.unmodifiableList(this.cardList);
	}
	
	public int getCardCount() {
		return this.cardList.size();
	}
	
	public Card get(int index) {
		return this.cardList.get(index);
	}
}
