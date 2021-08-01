package oriel;

import java.util.LinkedList;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import oriel.console.oriel_card_game.player.ConsoleAttackCardSelector;
import oriel.console.oriel_card_game.player.ConsoleDefenceCardSelector;
import oriel.console.oriel_card_game.player.ConsolePutCardSelector;
import oriel.oriel_card_game.OrielCardGame;
import oriel.oriel_card_game.card.Card;
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
		cardList.add(new Card("ドラゴン1", 2300, 2000));
		cardList.add(new Card("ドラゴン2", 2300, 2000));
		cardList.add(new Card("エルフ1", 1000, 500));
		cardList.add(new Card("エルフ2", 1000, 500));
		cardList.add(new Card("エルフ3", 1000, 500));
		cardList.add(new Card("エルフ4", 1000, 500));
		cardList.add(new Card("エルフ5", 1000, 500));
		cardList.add(new Card("ドワーフ1", 500, 1000));
		cardList.add(new Card("ドワーフ2", 500, 1000));
		cardList.add(new Card("ドワーフ3", 500, 1000));
		cardList.add(new Card("ドワーフ4", 500, 1000));
		cardList.add(new Card("ドワーフ5", 500, 1000));
		cardList.add(new Card("ドワーフ6", 500, 1000));
		cardList.add(new Card("ドワーフ7", 500, 1000));
		cardList.add(new Card("ドワーフ8", 500, 1000));
		cardList.add(new Card("ドワーフ9", 500, 1000));
		cardList.add(new Card("ドワーフ10", 500, 1000));
		
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
