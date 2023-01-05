package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Shoe {
    private int cardsInDeck = 52;
    private List<Card> shoe;
    private int runningCount = 0;
    private int maxRunningCount = 0;
    private int minRunningCount = 0;
    private float trueCount;
    private float maxTrueCount;
    private float minTrueCount;
    private float approximateDeckSize;

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

        if (card.getRank().equals("2") || card.getRank().equals("3") || card.getRank().equals("4") || card.getRank().equals("5") || card.getRank().equals("6")) {
            runningCount++;
        } else if (card.getRank().equals("T") || card.getRank().equals("J") || card.getRank().equals("Q") || card.getRank().equals("K") || card.getRank().equals("A")) {
            runningCount--;
        }

        if (runningCount > maxRunningCount) {
            maxRunningCount = runningCount;
        }
        if (runningCount < minRunningCount) {
            minRunningCount = runningCount;
        }

        approximateDeckSize = (float) (shoe.size() / 52.0);
        trueCount = runningCount / approximateDeckSize;

        if (trueCount > maxTrueCount) {
            maxTrueCount = trueCount;
        }
        if (trueCount < minTrueCount) {
            minTrueCount = trueCount;
        }

        return card;
    }

    public float getApproximateDeckSize() {
        return approximateDeckSize;
    }

    public int getTrueCount() {
        return Math.round(trueCount);
    }

    public int getMaxTrueCount() {
        return Math.round(maxTrueCount);
    }

    public int getMinTrueCount() {
        return Math.round(minTrueCount);
    }

    public int getRunningCount() {
        return runningCount;
    }

    public int getMaxRunningCount() {
        return maxRunningCount;
    }

    public int getMinRunningCount() {
        return minRunningCount;
    }

    public int size() {
        return shoe.size();
    }
}
