package oriel.oriel_card_game.card;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import oriel.oriel_card_game.card.attack_power.AttackPower;
import oriel.oriel_card_game.card.defence_power.DefencePower;
import oriel.oriel_card_game.card.name.Name;

@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(exclude = "id")
public class Card {

	private final UUID id = UUID.randomUUID();
	
	@Getter
	private final Name name;

	@Getter
	private final AttackPower attackPower;

	@Getter
	private final DefencePower defencePower;

	public Defence defence(Card enemy) {
		return new Defence(enemy, this);
	}
}
