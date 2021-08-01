package oriel.oriel_card_game.player;

import java.util.Optional;

import oriel.oriel_card_game.card.Card;

public interface AttackCardSelector {

	Optional<Card> select(Player self, Player enemy);

}
