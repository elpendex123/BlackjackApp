package org.example;

public class Card {

    private String rank;

    private String suit;

    private int value;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;

        if (rank.equals("2") || rank.equals("3") || rank.equals("4") || rank.equals("5") || rank.equals("6")) {
            value = 1;
        }
        else if (rank.equals("7") || rank.equals("8") || rank.equals("9")) {
            value = 0;
        }
        else {
            value = -1;
        }
    }

    public String getRank() {
        return this.rank;
    }

    public String getSuti() {
        return this.suit;
    }
    public int getValue() {
        return value;
    }

    public String toString() {
        return this.rank + this.suit;
    }
}
