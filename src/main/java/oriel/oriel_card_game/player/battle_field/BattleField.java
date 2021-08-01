package oriel.oriel_card_game.player.battle_field;

import java.util.LinkedList;

import lombok.NonNull;
import lombok.ToString;
import oriel.oriel_card_game.card.Card;

@ToString
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

	public int cardCount() {
		return this.cardList.size();
	}

	public Card get(int index) {
		if (this.isIndexOutOfBounds(index)) {
			throw new NoSuchCardException();
		}

		return this.cardList.get(index);
	}

	private boolean isIndexOutOfBounds(int index) {
		return index < 0 || index >= this.cardList.size();
	}
}
