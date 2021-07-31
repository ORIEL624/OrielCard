package oriel.oriel_card.core.card;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(exclude = "id")
public class Card {

	private final UUID id = UUID.randomUUID();
	
	@Getter
	private final String name;

	@Getter
	private final int attackPower;

	@Getter
	private final int defencePower;

	public Attack attack(Card target) {
		return new Attack(this, target);
	}
}
