package oriel.oriel_card_game.player;

import java.util.Optional;
import java.util.UUID;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import oriel.oriel_card_game.card.Card;
import oriel.oriel_card_game.card.Defence;
import oriel.oriel_card_game.player.battle_field.BattleField;
import oriel.oriel_card_game.player.card_deck.CardDeck;
import oriel.oriel_card_game.player.hand_card.HandCard;
import oriel.oriel_card_game.player.hit_point.HitPoint;
import oriel.oriel_card_game.player.name.Name;

@RequiredArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(of = { "name", "hitPoint" })
public class Player {

	@Getter
	private final UUID id = UUID.randomUUID();

	@Getter
	@NonNull
	private final Name name;

	@Getter
	@NonNull
	private HitPoint hitPoint = new HitPoint(8000);

	@Getter
	@NonNull
	private final CardDeck cardDeck;

	@Getter
	@NonNull
	private final HandCard handCard;

	@Getter
	@NonNull
	private final BattleField battleField = new BattleField();

	@NonNull
	@Setter
	private PutCardSelector putCardSelector;

	@NonNull
	@Setter
	private AttackCardSelector attackCardSelector;

	@NonNull
	@Setter
	private DefenceCardSelector defenceCardSelector;

	public void action(@NonNull Player enemy) {
		if (this.isDead()) {
			throw new AlreadyDeadException();
		}

		this.drawCard();
		this.putCardToBattleField(enemy);
		this.attack(enemy);
	}

	public boolean isDead() {
		return this.hitPoint.isZero() || this.cardDeck.isEmpty();
	}

	private void drawCard() {
		this.handCard.add(this.cardDeck.draw());
	}

	private void putCardToBattleField(Player enemy) {
		this.putCardSelector.select(this, enemy).ifPresent(this.battleField::put);
	}

	private void attack(Player enemy) {
		this.attackCardSelector.select(this, enemy).ifPresent(attackCard -> {
			enemy.receiveAttack(this, attackCard);
		});
	}

	private void receiveAttack(Player enemy, Card attackCard) {
		// 攻撃を受ける側の視点に切り替わっていることに注意.

		final Optional<Card> defencer = this.defenceCardSelector.select(this, enemy, attackCard);

		if (defencer.isPresent()) {
			this.defence(attackCard, defencer.get());
		} else {
			this.receiveAttackDirectly(attackCard);
		}
	}

	private void defence(Card attacker, Card defencer) {

		final Defence attack = defencer.defence(attacker);

		this.hitPoint = this.hitPoint.takeDamage(attack.getPenetrationDamage());

		if (attack.isDefencerDead()) {
			this.battleField.remove(defencer);
		}
	}

	private void receiveAttackDirectly(Card attacker) {
		this.hitPoint = this.hitPoint.takeDamage(attacker.getAttackPower().getValue());
	}
}
