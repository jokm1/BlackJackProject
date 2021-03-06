package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	private List<Card> hand = new ArrayList<>();
	
	public Hand() {};
	
	public void addCard(Card card) {
		this.hand.add(card);
	}
	
	public void surrenderHand() {
		this.hand.clear();
	}

	public List<Card> getHand() {
		return this.hand;
	}
	
	public int getValueOfHand() {
		int value = 0;
		int aces = 0;
		for (Card card : hand) {
			value += card.getRank().getValue();
			if (card.getRank().getValue() == 11) {
				aces++;
			}
		}
		// Aces can have multiple values
		while (aces > 0) {
			if (value > 21) {
				value -= 10;
			}
			aces--;
		}
		return value;
	}

	@Override
	public String toString() {
		return "" + hand;
	}
}
