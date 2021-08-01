package oriel.oriel_card_game.player.hit_point;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HitPoint {

	private final int value;
	
	public HitPoint takeDamage(int damage) {
		return new HitPoint(Math.max(this.value - damage, 0));
	}
	
	public boolean isZero() {
		return this.value == 0;
	}
}
