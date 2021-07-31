package oriel.oriel_card.core.card;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Attack {

	private final Card attacker;
	
	private final Card defencer;
	
	public int getPenetrationDamage() {
		return Math.max(this.attacker.getAttackPower() - this.defencer.getDefencePower(), 0);
	}
	
	public boolean isDefencerDead() {
		return this.getPenetrationDamage() > 0;
	}
}
