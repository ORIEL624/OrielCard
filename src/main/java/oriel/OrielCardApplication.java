package oriel;

import java.util.LinkedList;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import oriel.console_oriel_card_game.player.ConsoleAttackCardSelector;
import oriel.console_oriel_card_game.player.ConsoleDefenceCardSelector;
import oriel.console_oriel_card_game.player.ConsolePutCardSelector;
import oriel.oriel_card_game.OrielCardGame;
import oriel.oriel_card_game.card.Card;
import oriel.oriel_card_game.card.attack_power.AttackPower;
import oriel.oriel_card_game.card.defence_power.DefencePower;
import oriel.oriel_card_game.card.name.Name;
import oriel.oriel_card_game.player.AttackCardSelector;
import oriel.oriel_card_game.player.DefenceCardSelector;
import oriel.oriel_card_game.player.Player;
import oriel.oriel_card_game.player.PutCardSelector;
import oriel.oriel_card_game.player.card_deck.CardDeck;
import oriel.oriel_card_game.player.hand_card.HandCard;
import oriel.oriel_card_game.player.hit_point.HitPoint;

@SpringBootApplication
public class OrielCardApplication {

	public static void main(String[] args) {
		final OrielCardGame orielCardGame = new OrielCardGame(newPlayer("プレイヤー１"), newPlayer("プレイヤー２"));
		orielCardGame.start();
	}

	public static CardDeck newCardDeck() {
		
		final LinkedList<Card> cardList = new LinkedList<>();
		cardList.add(new Card(new Name("ドラゴン1"), new AttackPower(2300), new DefencePower(2000)));
		cardList.add(new Card(new Name("ドラゴン2"), new AttackPower(2300), new DefencePower(2000)));
		cardList.add(new Card(new Name("エルフ1"), new AttackPower(1000), new DefencePower(500)));
		cardList.add(new Card(new Name("エルフ2"), new AttackPower(1000), new DefencePower(500)));
		cardList.add(new Card(new Name("エルフ3"), new AttackPower(1000), new DefencePower(500)));
		cardList.add(new Card(new Name("エルフ4"), new AttackPower(1000), new DefencePower(500)));
		cardList.add(new Card(new Name("エルフ5"), new AttackPower(1000), new DefencePower(500)));
		cardList.add(new Card(new Name("ドワーフ1"), new AttackPower(500), new DefencePower(1000)));
		cardList.add(new Card(new Name("ドワーフ2"), new AttackPower(500), new DefencePower(1000)));
		cardList.add(new Card(new Name("ドワーフ3"), new AttackPower(500), new DefencePower(1000)));
		cardList.add(new Card(new Name("ドワーフ4"), new AttackPower(500), new DefencePower(1000)));
		cardList.add(new Card(new Name("ドワーフ5"), new AttackPower(500), new DefencePower(1000)));
		cardList.add(new Card(new Name("ドワーフ6"), new AttackPower(500), new DefencePower(1000)));
		cardList.add(new Card(new Name("ドワーフ7"), new AttackPower(500), new DefencePower(1000)));
		cardList.add(new Card(new Name("ドワーフ8"), new AttackPower(500), new DefencePower(1000)));
		cardList.add(new Card(new Name("ドワーフ9"), new AttackPower(500), new DefencePower(1000)));
		cardList.add(new Card(new Name("ドワーフ10"), new AttackPower(500), new DefencePower(1000)));
		
		return new CardDeck(cardList);
	}
	
	public static Player newPlayer(String name) {
		
		final HitPoint hitPoint = new HitPoint(5000);
		final CardDeck cardDeck = newCardDeck().shuffle();
		final HandCard handCard = new HandCard();
		{
			handCard.add(cardDeck.draw());
			handCard.add(cardDeck.draw());
			handCard.add(cardDeck.draw());
		}
		final PutCardSelector putCardSelector = new ConsolePutCardSelector();
		final AttackCardSelector attackCardSelector = new ConsoleAttackCardSelector();
		final DefenceCardSelector defenceCardSelector = new ConsoleDefenceCardSelector();
		
		return new Player(name, hitPoint, cardDeck, handCard, putCardSelector, attackCardSelector, defenceCardSelector);
	}
}
