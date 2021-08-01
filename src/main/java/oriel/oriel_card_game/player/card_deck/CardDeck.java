package oriel.oriel_card_game.player.card_deck;

import java.util.Collections;
import java.util.LinkedList;

import lombok.NonNull;
import lombok.ToString;
import oriel.oriel_card_game.card.Card;

@ToString
public class CardDeck {

	private final LinkedList<Card> cardList = new LinkedList<>();
	
	public void add(@NonNull Card card) {
		this.cardList.add(card);
	}

	public Card draw() {
		if (this.isEmpty()) {
			throw new EmptyCardDeckException();
		}
		
		return this.cardList.remove(0);
	}

	public boolean isEmpty() {
		return this.cardList.isEmpty();
	}

	public boolean isRemaining() {
		return !this.isEmpty();
	}
	
	public void shuffle() {
		Collections.shuffle(this.cardList);
	}
}
