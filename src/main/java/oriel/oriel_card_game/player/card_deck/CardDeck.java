package oriel.oriel_card_game.player.card_deck;

import java.util.Collections;
import java.util.List;

import lombok.AllArgsConstructor;
import oriel.oriel_card_game.card.Card;

/**
 * デッキ.
 */
@AllArgsConstructor
public class CardDeck {

	private final List<Card> cardList;

	public Card draw() {
		if (this.isEmpty()) {
			throw new NoCardException();
		}

		return this.cardList.remove(0);
	}

	public boolean isEmpty() {
		return this.cardList.isEmpty();
	}

	public boolean isRemaining() {
		return !this.isEmpty();
	}
	
	public CardDeck shuffle() {
		Collections.shuffle(this.cardList);
		return this;
	}
}
