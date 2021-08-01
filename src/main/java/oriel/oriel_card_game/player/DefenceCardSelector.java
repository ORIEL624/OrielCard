package oriel.oriel_card_game.player;

import java.util.Optional;

import oriel.oriel_card_game.card.Card;

public interface DefenceCardSelector {

	public Optional<Card> select(Player self, Player enemy, Card attackCard);
}
