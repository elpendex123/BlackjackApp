package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Deck {

    private ArrayList<String> rank = new ArrayList<>(Arrays.asList("A", "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K"));

    private ArrayList<String> suit = new ArrayList<>(Arrays.asList("S", "H", "D", "C"));

    private List<Card> deck = new ArrayList<>();

    public Deck() {
        for (int i = 0; i < suit.size(); i++) {
            for (int j = 0; j < rank.size(); j++) {
                deck.add(new Card(rank.get(j), suit.get(i)));
            }
        }
    }

    public Card getCard() {
        int random = ThreadLocalRandom.current().nextInt(0, deck.size());
        Card card = deck.get(random);
        deck.remove(random);
        return card;
    }

    public String toString() {
        StringBuilder listOfCards = new StringBuilder();

        for (Card c : deck) {
            listOfCards.append(c + "\n");
        }

        return listOfCards.toString();
    }
}
