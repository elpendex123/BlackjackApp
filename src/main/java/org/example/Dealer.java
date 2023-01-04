package org.example;

import java.util.List;

public class Dealer {
    private Hand firstTwoCards;
    private Hand hand;
    private boolean dealersTurn = false;

    public Dealer() {
        hand = new Hand();
    }

    public void addCard(Card card) {
        hand.addCard(card);
    }

    public void setDealersTurnOn() {
        dealersTurn = true;
    }

    public void setDealersTurnOff() {
        dealersTurn = false;
    }

    public String toString() {
        if (hand.numberOfCards() == 0) {
            return "Dealer doesn't have cards yet";
        }
        else if (hand.numberOfCards() == 1) {
            return "hidden: x, exposed: no card yet";
        }
        else if (hand.numberOfCards() == 2 && !dealersTurn) {
            return "hidden: x, exposed: " + hand.getSecondCard();
        }
        else if (hand.numberOfCards() == 2 && dealersTurn) {
            return "hidden: " + hand.getFirstCard() + ", exposed: " + hand.getSecondCard();
        }
        else {
            return hand.toString();
        }
    }
}
