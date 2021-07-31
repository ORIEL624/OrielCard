package oriel.oriel_card;

import oriel.oriel_card.core.player.Player;

public class OrielCardGame {

	private final Player player1;

	private final Player player2;

	private Player currentPlayer;

	public OrielCardGame(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
		this.currentPlayer = player1;
	}

	public void start() {
		while (!this.isFinished()) {
			this.turn();
			this.nextPlayer();
		}

		this.showResult();
	}

	private boolean isFinished() {
		return this.player1.isDead() || this.player2.isDead();
	}

	private void turn() {
		this.currentPlayer.action(this.getOppositionPlayerOf());
	}

	private void nextPlayer() {
		this.currentPlayer = this.getOppositionPlayerOf();
	}

	private Player getOppositionPlayerOf() {
		return this.currentPlayer.equals(this.player1) ? this.player2 : this.player1;
	}

	private void showResult() {
		System.out.println((this.player1.isDead() ? this.player2 : this.player1) + "の勝利!");
	}
}
