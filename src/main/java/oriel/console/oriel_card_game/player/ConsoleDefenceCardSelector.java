package oriel.console.oriel_card_game.player;

import java.util.Optional;
import java.util.Scanner;

import oriel.oriel_card_game.card.Card;
import oriel.oriel_card_game.player.DefenceCardSelector;
import oriel.oriel_card_game.player.Player;

public class ConsoleDefenceCardSelector implements DefenceCardSelector {

	private final Scanner scanner = new Scanner(System.in);

	@Override
	public Optional<Card> select(Player self, Player enemy, Card attackCard) {

		System.out.println("======================================");

		System.out.println("現在の操作プレイヤー：" + self);

		System.out.println("相手の配置済みカード。");
		if (enemy.getBattleField().isEmpty()) {
			System.out.println("なし");
		} else {
			for (int i = 0; i < enemy.getBattleField().getCardCount(); i++) {
				final Card card = enemy.getBattleField().get(i);
				System.out.println((i + 1) + ":" + card + "  ");
			}
		}

		System.out.println();
		
		System.out.println("相手の攻撃カード。");
		System.out.println(attackCard);

		System.out.println();

		System.out.println("自分の配置済みカード。");
		if (self.getBattleField().isEmpty()) {
			System.out.println("なし");
		} else {
			for (int i = 0; i < self.getBattleField().getCardCount(); i++) {
				final Card card = self.getBattleField().get(i);
				System.out.println((i + 1) + ":" + card + "  ");
			}
		}

		System.out.println();

		int cardIndex = -1;
		while (!(cardIndex >= 0 && cardIndex <= self.getBattleField().getCardCount())) {
			System.out.print("防御に使用するカードを選択してください(選択しない場合は0を入力してください)。:");
			cardIndex = scanner.nextInt();
		}

		System.out.println();

		return cardIndex <= 0 ? Optional.empty() : Optional.of(self.getBattleField().get(cardIndex - 1));
	}
}
