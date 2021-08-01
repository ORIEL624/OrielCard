package oriel.oriel_card_game.card;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class Defence {

	private final Card attacker;
	
	private final Card defencer;
	
	public int getPenetrationDamage() {
		return Math.max(this.attacker.getAttackPower().getValue() - this.defencer.getDefencePower().getValue(), 0);
	}
	
	public boolean isDefencerDead() {
		return this.getPenetrationDamage() > 0;
	}
}
