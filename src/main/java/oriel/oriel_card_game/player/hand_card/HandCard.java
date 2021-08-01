package oriel.oriel_card_game.player.hand_card;

import java.util.LinkedList;

import lombok.NonNull;
import lombok.ToString;
import oriel.oriel_card_game.card.Card;

@ToString
public class HandCard {

	private final LinkedList<Card> cardList = new LinkedList<Card>();

	public void add(@NonNull Card card) {
		this.cardList.add(card);
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

	public Card take(int index) {
		if (this.isIndexOutOfBounds(index)) {
			throw new NoSuchCardException();
		}

		return this.cardList.remove(index);
	}

	public boolean isEmpty() {
		return this.cardList.isEmpty();
	}

	private boolean isIndexOutOfBounds(int index) {
		return index < 0 || index >= this.cardList.size();
	}
}
