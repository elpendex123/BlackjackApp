package org.example;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards;

    public Hand(Card first, Card second) {
        cards = new ArrayList<>();
        cards.add(first);
        cards.add(second);
    }

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public int numberOfCards() {
        return cards.size();
    }

    public Card getFirstCard() {
        return cards.get(0);
    }

    public Card getSecondCard() {
        return cards.get(1);
    }

    public String toString() {
        if (cards.size() == 2) {
            return "Starting hand: " + cards.get(0) + " - " + cards.get(1);
        }
        else {
            return "Have not dealt two cards yet";
        }
    }
}
