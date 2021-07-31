package oriel.oriel_card.core.player;

import java.util.Optional;

import oriel.oriel_card.core.card.Card;

public interface AttackCardSelector {

	Optional<Card> select(Player self, Player enemy);

}
