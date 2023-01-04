package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Shoe {

    private int cardsInDeck = 52;

    private List<Card> shoe;

    public Shoe(int numberOfDecks) {
        shoe = new ArrayList<>();
        int[] decks = new int[numberOfDecks];

        for (int k = 0; k < numberOfDecks; k++) {
            Deck d = new Deck();
            for (int i = 0; i < cardsInDeck; i++) {
                shoe.add(d.getCard());
            }
        }
    }

    public String toString() {
        StringBuilder listOfCards = new StringBuilder();

        for (Card c : shoe) {
            listOfCards.append(c + "\n");
        }

        return listOfCards.toString();
    }

    public Card getRandomCard() {
        int random = ThreadLocalRandom.current().nextInt(0, shoe.size());
        Card card = shoe.get(random);
        shoe.remove(random);
        return card;
    }

    public int size() {
        return shoe.size();
    }
}
