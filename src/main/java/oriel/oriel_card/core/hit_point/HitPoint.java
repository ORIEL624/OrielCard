package oriel.oriel_card.core.hit_point;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HitPoint {

	private int value;
	
	public void takeDamage(int damage) {
		this.value = Math.max(this.value - damage, 0);
	}
	
	public boolean isZero() {
		return this.value == 0;
	}
}
